/*
 * Copyright 2009 David del Pozo González (dpozog--at--grupogesfor.com)
 * Informática Gesfor
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
package com.germinus.mashupbuilder.servlet;

import com.germinus.mashupbuilder.restclient.FormatConverter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import com.germinus.mashupbuilder.restclient.FormatConverter.Format;
import com.germinus.mashupbuilder.restclient.RESTClient;
import com.germinus.mashupbuilder.restclient.RESTClient.HTTP_METHOD;

/**
 * Servlet which acts like a JSONP Proxy. This servlet performs a GET request to
 * the given URL as parameter and converts the response to JSONP format. The
 * response format accepted are JSON and XML, these format are converted to JSONP.
 * @author David del Pozo González
 */
public class JSONPProxyServlet extends HttpServlet {
    /**
     * A hashmap with all supported formats.
     */
    private final static HashMap<String, Format> allowedResponseFormats = new HashMap<String, Format>();

    static {
        allowedResponseFormats.put("JSON", Format.JSON);
        allowedResponseFormats.put("XML", Format.XML);
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

        response.setContentType("text/javascript;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String paramResponseFormat = request.getParameter("responseFormat");
            String callback = request.getParameter("callback");
            String paramUrl = request.getParameter("url");
            String httpMethodParam = request.getParameter("method");
            HTTP_METHOD httpMethod = HTTP_METHOD.GET;
            if (httpMethodParam != null) {
                if ("POST".equalsIgnoreCase(httpMethodParam)) {
                    httpMethod = HTTP_METHOD.POST;
                } else if ("PUT".equalsIgnoreCase(httpMethodParam)) {
                    httpMethod = HTTP_METHOD.PUT;
                } else if ("DELETE".equalsIgnoreCase(httpMethodParam)) {
                    httpMethod = HTTP_METHOD.DELETE;
                }
            }

            //Parameters validation
            Format responseFormat = null;
            if (paramResponseFormat == null) {
                responseFormat = Format.JSON;
            } else {
                responseFormat = allowedResponseFormats.get(paramResponseFormat.toUpperCase());
            }
            if (responseFormat == null) {
                out.print(callback + ("({error:'Response format not valid'})"));
            } else {
                paramUrl = paramUrl.replace(" ",  "+")
                                   .replace("{",  "%7B")
                                   .replace("}",  "%7D")
                                   .replace("\"", "%22")
                                   .replace("[",  "%5B")
                                   .replace("]",  "%5D")
                                   .replace(";",  "%3B")
                                   .replace("|",  "%7C");

                Logger.getLogger(FormatConverter.class.getName()).
                    log(Level.INFO, "Request to: {0}", paramUrl);

                String resp = RESTClient.request(paramUrl, httpMethod, responseFormat, Format.JSON);

                if (callback != null) {
                    resp = callback + "(" + resp + ")";
                } else {
                    Logger.getLogger(FormatConverter.class.getName()).log(Level.INFO, "Callback function not specified");
                }
                out.write(resp);
            }
        } catch(Exception e) {
            Logger.getLogger(FormatConverter.class.getName()).log(Level.INFO, null, e);
        } finally {
            out.close();
        }
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
        return "Short description";
    }
}
