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
package com.logica.mycocktail.servlet;

import com.germinus.mashupbuilder.dao.DAOException;
import com.germinus.mashupbuilder.restclient.FormatConverter;
import com.germinus.mashupbuilder.restclient.FormatConverter.Format;
import com.logica.mycocktail.controller.ServiceController;
import com.logica.mycocktail.controller.WADLGenerator;
import com.logica.mycocktail.util.Utils;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author David del Pozo González
 */
public class RESTServiceServlet extends HttpServlet {
    /**
     * A map with all supported service formats.
     */
    private final static Set<String> allowedResponseFormats = new HashSet<String>();

    static {
        Collections.addAll(allowedResponseFormats, "JSON", "XML", "JSONP");
    }

    public enum Mode {
        EXECUTE("execute");

        private String mode;

        Mode(String mode) {
            this.mode = mode;
        }

        public String getMode() {
            return mode;
        }
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */      
    protected final void processRequest(final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {
        
        String myCocktailPath = Utils.getMyCocktailPath(request);
        ServiceController serviceController = ServiceController.getInstance(myCocktailPath);
        
        Integer mashupId = null;
        String mashupFormat = null;
        String callbackFunction = "callback";
        
        String pathInfo = request.getPathInfo();
        if (pathInfo!= null && pathInfo.length() > 0) {
            pathInfo = pathInfo.substring(1);
            mashupId         = getMashupId(pathInfo);
            mashupFormat     = getMashupFormat(pathInfo);
            callbackFunction = getCallbackFunction(request, pathInfo);
        }
            
        if (mashupId != null) {
            Enumeration<String> en = request.getParameterNames();
            Map<String,String> mashupParams = new HashMap<String,String>();
            while(en.hasMoreElements()) {
                String key = en.nextElement();
                mashupParams.put(key, request.getParameter(key));
            }
            
            String json = serviceController.executeMashup(mashupId, mashupParams);
            StringBuilder result = new StringBuilder();
            if("JSON".equalsIgnoreCase(mashupFormat)) {
                response.setContentType("text/javascript;charset=UTF-8");
                result.append(json);
            } else if("XML".equalsIgnoreCase(mashupFormat)) {
                response.setContentType("text/xml;charset=UTF-8");
                result.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                result.append("<results>");
                result.append(FormatConverter.toXML(json, Format.JSON));
                result.append("</results>");
            } else if("JSONP".equalsIgnoreCase(mashupFormat)) {
                response.setContentType("text/javascript;charset=UTF-8");
                result.append(callbackFunction);
                result.append("(");
                result.append(json);
                result.append(");");
            }
            response.getWriter().print(result);
            return;
        } 
        
        Integer wadlId = getWadlId(pathInfo);
        if (wadlId != null) {
            try {
                response.setContentType("text/xml;charset=UTF-8");
                response.getWriter().print(WADLGenerator.generateWADLForMashupRESTService(myCocktailPath, wadlId));
                return;
            } catch (DAOException ex) {
                Logger.getLogger(RESTServiceServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        printError(response);
    }
    
    private Integer getMashupId(String pathInfo) {
        String[] params = pathInfo.split("/");
        for (String param : params) {
            String[] array = param.split("mashupId=");
            if(array.length == 2) {
                try {
                    return Integer.valueOf(array[1]);
                } catch(NumberFormatException nfe) { }
            } 
        }
        return null;
    }
    
    private Integer getWadlId(String pathInfo) {
        String[] params = pathInfo.split("/");
        for (String param : params) {
            String[] array = param.split("wadlId=");
            if(array.length == 2) {
                try {
                    return Integer.valueOf(array[1]);
                } catch(NumberFormatException nfe) { }
            } 
        }
        return null;
    }
    
    private String getMashupFormat(String pathInfo) {
        String mashupFormat   = "JSON";
        String mashupFormatSt = null;
        
        String[] params = pathInfo.split("/");
        for (String param : params) {
            String[] array = param.split("format=");
            if(array.length == 2) {
                mashupFormatSt = array[1];
            } 
        }
        if (mashupFormatSt != null) {
            if(allowedResponseFormats.contains(mashupFormatSt.toUpperCase())) {
                mashupFormat = mashupFormatSt.toUpperCase();                
            }
        }
        return mashupFormat;
    }
    
    private String getCallbackFunction(HttpServletRequest request, String pathInfo) {
        String mashupFormat = null;
        
        String[] params = pathInfo.split("/");
        for (String param : params) {
            String[] array = param.split("callback=");
            if(array.length == 2) {
                mashupFormat = array[1];
            } 
        }
        
        if(mashupFormat == null) {
            mashupFormat = request.getParameter("callback");
        }
        
        if(mashupFormat == null) {
            mashupFormat = "callback";
        }

        return mashupFormat;
    }
    
    private void printError(HttpServletResponse response) throws IOException {
        response.getWriter().print("The request cannot be processes due to a bad configuration of input parameters");
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected final void doGet(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected final void doPost(final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public final String getServletInfo() {
        return "Mashup Servlet";
    }
}
