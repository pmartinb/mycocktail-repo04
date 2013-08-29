/*
 * Copyright 2011 Logica
 * David del Pozo González (david.del.pozo--at--logica.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.logica.mycocktail.ssjs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.tools.shell.Global;
import org.mozilla.javascript.tools.shell.Main;

public class MyCocktailMashupServerExecutor {
    private final static String FIRST_PART_MASHUP_FUNCTION_INVOCATION = "globalMashupResult=null;executeMashup(";
    private final static String SECOND_PART_MASHUP_FUNCTION_INVOCATION = ");";
    private final static String MASHUP_RESULT = "globalMashupResult;";
    
    private final static String AFROUS_JS_PATH = "js/afrous/";
    
    private static int executionCounter = 0;
    
    private Context cx;
    private Global global;
    
    private ExecutorThread et;
    
    private static class MashupExecutionConfig {
        private enum Status { NEW, RUNNING, TERMINATED }
        private enum ResultStatus { ERROR, OK }
        
        MashupExecutionConfig() {
            status = Status.NEW;
        }
        
        private String jsonConfig;
        private Map<String,String> parameters;
        private String result;
        private Status status;
        private ResultStatus resultStatus;
    }
    
    private class ExecutorThread implements Runnable {
        private URL mycocktailInstallationURL;
        
        private MashupExecutionConfig mashupExecConfig;
        
        private ExecutorThread(URL mycocktailInstallationURL) {
            this.mycocktailInstallationURL = mycocktailInstallationURL;
        }
        
        private synchronized void setMashupExecutionConfig(MashupExecutionConfig mashupExecConfig) {
            this.mashupExecConfig = mashupExecConfig;
            notify();
        }
        
        public void run() {
            initJSRuntimeEnviroment(mycocktailInstallationURL);
            
            synchronized(this) {
                for(;;) {
                    while (mashupExecConfig == null || 
                        !MashupExecutionConfig.Status.NEW.equals(mashupExecConfig.status)) {
                        
                        try {
                            wait();
                        } catch(InterruptedException ie) {
                            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ie);
                        }
                    }

                    try {
                        mashupExecConfig.result = _executeMashup(mashupExecConfig.jsonConfig, mashupExecConfig.parameters);
                        mashupExecConfig.resultStatus = MashupExecutionConfig.ResultStatus.OK;
                    } catch(Exception e) {
                        Logger.getLogger(MyCocktailMashupServerExecutor.class.getName()).log(Level.WARNING, null, e);
                        mashupExecConfig.resultStatus = MashupExecutionConfig.ResultStatus.ERROR;
                    } finally {
                        mashupExecConfig.status = MashupExecutionConfig.Status.TERMINATED;
                    }
                    notify();
                }
            }
        }
        
        private synchronized MashupExecutionConfig getMashupResult() {
            while(!mashupExecConfig.status.equals(MashupExecutionConfig.Status.TERMINATED)) {
                try {
                    wait();
                } catch(InterruptedException ie) { 
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ie);
                }
            }
            MashupExecutionConfig mashupExecConfigAux = mashupExecConfig;
            mashupExecConfig = null;
            return mashupExecConfigAux;
        }
    }

    public MyCocktailMashupServerExecutor(String mycocktailInstallationURL) throws MalformedURLException {
        this(new URL(mycocktailInstallationURL));
    }
    
    public MyCocktailMashupServerExecutor(URL mycocktailInstallationURL) {
        et = new ExecutorThread(mycocktailInstallationURL);
        Thread t = new Thread(et, "MashupExecutorThread");
        t.start();
    }
    
    private void initJSRuntimeEnviroment(URL url) {
        cx = ContextFactory.getGlobal().enterContext();
        cx.setOptimizationLevel(-1);
        cx.setLanguageVersion(Context.VERSION_1_5);

        global = Main.getGlobal();
        global.init(cx);

        Main.processSource(cx, getFilePath("env.rhino.1.2.js"));
        
        String domain = url.getProtocol() + "://" + url.getAuthority();
        executeJsScript("Envjs.scriptTypes['text/javascript'] = true;");
        executeJsScript("window.location = '" + domain + "';");
        
        executeJsScript("var afrous = { baseURL : '" + url.toString() + "' };");
        Main.processSource(cx, getURLFromServer(url, "afrous-core.js"));
        Main.processSource(cx, getFilePath("afrous-core-mod.js"));
        Main.processSource(cx, getURLFromServer(url, "afrous-package.js"));
        Main.processSource(cx, getFilePath("afrous-stdlib-index.js"));
        Main.processSource(cx, getFilePath("mashup-execution.js"));
    }
    
    public String executeMashup(String mashupJsonConfig) 
            throws Exception {
        
        return executeMashup(mashupJsonConfig, null);
    }
    
     public String executeMashup(String mashupJsonConfig, Map<String,String> parametersMap)
            throws Exception {
        
        MashupExecutionConfig mashupExecConfig = new MashupExecutionConfig();
        mashupExecConfig.jsonConfig = mashupJsonConfig;
        mashupExecConfig.parameters = parametersMap;
        et.setMashupExecutionConfig(mashupExecConfig);
        MashupExecutionConfig mec =  et.getMashupResult();
        if(mec.resultStatus.equals(MashupExecutionConfig.ResultStatus.ERROR)) {
            throw new Exception("Error running the mashup: " + mec.result);
        }
        return mec.result;
    }
    
    private String _executeMashup(String mashupJsonConfig, Map<String,String> parametersMap) {
        long l1 = System.currentTimeMillis();
        String string = executeJsScript(generateMashupExecutionCode(mashupJsonConfig, parametersMap));
        while (string == null || string.isEmpty()) {
            if(System.currentTimeMillis() - l1 > 10000) {
                return "{error : 'Time for processing the mashup has exceed'}";
            }
            
            try { 
                Thread.sleep(100); 
            } catch (InterruptedException ie) { 
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ie);
            }
            string = executeJsScript(MASHUP_RESULT);
        }
        return string;
    }
    
    private String executeJsScript(String jsScript) {
        Object object = cx.evaluateString(global, jsScript, "js-execution-" + executionCounter++, 1, null);
        return object != null ? object.toString() : null;
    }

    private static String getFilePath(String fileName) {
        return MyCocktailMashupServerExecutor.class.getClassLoader().getResource("com/logica/mycocktail/ssjs/js/" + fileName).toString();
    }
    
    private static String getURLFromServer(URL url, String fileName) {
        return url.toString() + AFROUS_JS_PATH + fileName;
    }

    private static String generateMashupExecutionCode(String mashupConfig, Map<String,String> parametersMap) {
        StringBuilder sb = new StringBuilder();
        if (parametersMap != null) {
            sb.append(generateMashupParams(parametersMap));
        }
        sb.append(FIRST_PART_MASHUP_FUNCTION_INVOCATION);
        sb.append(mashupConfig);
        sb.append(SECOND_PART_MASHUP_FUNCTION_INVOCATION);
        return sb.toString();
    }
    
    private static String generateMashupParams(Map<String,String> parametersMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("var mashupParams = {");
        int i=0;
        Entry<String,String>[] entries = parametersMap.entrySet().toArray(new Entry[0]);
        if (entries.length > 0) {
            for (; i<entries.length-1; i++) {
                sb.append(entries[i].getKey()).append(":'").append(entries[i].getValue()).append("',");
            }
            sb.append(entries[i].getKey()).append(":'").append(entries[i].getValue()).append("'");
        }
        sb.append("};");
        return sb.toString();
    }
}
