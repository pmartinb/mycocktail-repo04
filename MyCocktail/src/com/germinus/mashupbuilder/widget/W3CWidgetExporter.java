/*
 * Copyright 2011 Informática Gesfor
 * David del Pozo González (dpozog--at--grupogesfor.com)
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
package com.germinus.mashupbuilder.widget;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.IOUtils;

/**
 * Utility class for generating a .wgt (W3C Widget)
 */
public class W3CWidgetExporter {
    /**
     * The path to the widget default values file.
     */
    private static final String W3C_WIDGET_PROPERTIES_PATH = "conf/w3c-widget.properties";
    private static final String W3C_WIDGET_IMAGE_PATH = "../../images/mycocktail-logo-transparent.gif";
    private static Properties properties;
    
    /**
     * Generates a .wgt file.
     * @param indexHtmlContent the content of the index.html file
     * @param os the OutputStream to write the file
     * @throws IOException if an IO error occurs
     */
    public static void generateWgt(String indexHtmlContent, OutputStream os) throws IOException {
        WidgetConfig wc = new WidgetConfig();
        wc.setAuthorName (properties.getProperty("widget.default.author"));
        wc.setAuthorUrl  (properties.getProperty("widget.default.authorURL"));
        wc.setAuthorEmail(properties.getProperty("widget.default.authorEmail"));
        wc.setDescription(properties.getProperty("widget.default.description"));
        wc.setLicense    (properties.getProperty("widget.default.license"));
        wc.setName       (properties.getProperty("widget.default.name"));
        wc.setVersion    (properties.getProperty("widget.default.version"));
        wc.setWidth      (Integer.parseInt(properties.getProperty("widget.default.width")));
        wc.setHeight     (Integer.parseInt(properties.getProperty("widget.default.height")));
        
        generateWgt(indexHtmlContent, wc, os);
    }
    
    /**
     * Generates a .wgt file.
     * @param indexHtmlContent the content of the index.html file
     * @param configParams the configuration to include in the config.html
     * @param os the OutputStream to write the file
     * @throws IOException if an IO error occurs
     */
    public static void generateWgt(String indexHtmlContent, Map<String,String> configParams, OutputStream os) throws IOException {
        WidgetConfig wc = new WidgetConfig();
        wc.setAuthorName (fixParameter(configParams, "author"));
        wc.setAuthorUrl  (fixParameter(configParams, "authorURL"));
        wc.setAuthorEmail(fixParameter(configParams, "authorEmail"));
        wc.setDescription(fixParameter(configParams, "description"));
        wc.setLicense    (fixParameter(configParams, "license"));
        wc.setName       (fixParameter(configParams, "name"));
        wc.setVersion    (fixParameter(configParams, "version"));
        wc.setWidth      (fixIntegerParameter(configParams, "width"));
        wc.setHeight     (fixIntegerParameter(configParams, "height"));
        
        generateWgt(indexHtmlContent, wc, os);
    }
    
    /**
     * Generates a .wgt file.
     * @param indexHtmlContent the content of the index.html file
     * @param wConfig the configuration to include in the config.html
     * @param os the OutputStream to write the file
     * @throws IOException if an IO error occurs
     */
    public static void generateWgt(String indexHtmlContent, WidgetConfig wConfig, OutputStream os) throws IOException {
        generateWgt(indexHtmlContent, generateConfigXML(wConfig), os);
    }
    
    /**
     * Generates a .wgt file.
     * @param indexHtmlContent the content of the index.html file
     * @param wConfig the content of the config.xml file
     * @param os the OutputStream to write the file
     * @throws IOException if an IO error occurs
     */
    public static void generateWgt(String indexHtmlContent, String configXmlContent, OutputStream os) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(os);
            
        //index.html
        zos.putNextEntry(new ZipEntry("index.html"));
        zos.write(indexHtmlContent.getBytes());

        //config.xml
        zos.putNextEntry(new ZipEntry("config.xml"));
        zos.write(configXmlContent.getBytes());
        
        //icon.gif
        InputStream is = W3CWidgetExporter.class.getClassLoader().getResourceAsStream(W3C_WIDGET_IMAGE_PATH);
        zos.putNextEntry(new ZipEntry("icon.gif"));
        IOUtils.copy(is, zos);
            
        zos.close();
    }
    
    public static String generateConfigXML(WidgetConfig wConfig) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<widget xmlns=\"http://www.w3.org/ns/widgets\""); 
        sb.append(" version=\"").append(wConfig.getVersion()).append("\"");
        sb.append(" height=\"").append(wConfig.getHeight()).append("\"");
        sb.append(" width=\"").append(wConfig.getWidth()).append("\">");
        sb.append("<name>").append(wConfig.getName()).append("</name>");
        sb.append("<description>").append(wConfig.getDescription()).append("</description>");
        sb.append("<icon src=\"icon.gif\"/>");
        sb.append("<content src=\"index.html\"/>");
        sb.append("<author href=\"").append(wConfig.getAuthorUrl()).append("\"");
        sb.append(" email=\"").append(wConfig.getAuthorEmail()).append("\">").append(wConfig.getAuthorName()).append("</author>");
        sb.append("<license>").append(wConfig.getLicense()).append("</license>");
        sb.append("</widget>");
        return sb.toString();
    }
    
    private synchronized static Properties getProperties() throws IOException {
        if (properties == null) {
            properties = new Properties();
            properties.load(W3CWidgetExporter.class.getClassLoader().getResourceAsStream(W3C_WIDGET_PROPERTIES_PATH));
        }
        return properties;
    }
    
        
    private static String fixParameter(Map<String,String> map, String paramName) throws IOException {
        String parameter = map.get(paramName);
        if (parameter == null || parameter.trim().length() == 0) {
            parameter = W3CWidgetExporter.getProperties().getProperty("widget.default." + paramName);
        }
        return parameter;
    }
    
    private static Integer fixIntegerParameter(Map<String,String> map, String paramName) throws IOException {
        String parameter = map.get(paramName);
        if (parameter == null || parameter.trim().length() == 0) {
            parameter = W3CWidgetExporter.getProperties().getProperty("widget.default." + paramName);
        }
        
        int intParameter = 0;
        try {
            intParameter = Integer.parseInt(parameter);
        } catch(NumberFormatException nbe) {
            intParameter = Integer.parseInt(W3CWidgetExporter.getProperties().getProperty("widget.default." + paramName));
        }
        
        return intParameter;
    }
}
