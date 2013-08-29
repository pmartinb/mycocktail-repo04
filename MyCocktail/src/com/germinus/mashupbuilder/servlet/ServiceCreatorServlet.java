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
import com.germinus.mashupbuilder.restclient.FormatConverter.Format;
import com.germinus.mashupbuilder.restclient.RESTClient;
import com.germinus.mashupbuilder.restclient.RESTClient.HTTP_METHOD;
import com.germinus.mashupbuilder.services.ServiceGenerator;
import com.germinus.mashupbuilder.services.UnitActionPackage;
import com.germinus.mashupbuilder.wadl.WADLParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.xmlbeans.XmlException;

/**
 * This class creates a MyCocktail service from WADL file. This servlet returns
 * text/javascript as content type, this javascript code is the implementation
 * of a service for MyCocktail.
 * The servlet retrieves the parameters:
 * <ul>
 *   <li>
 *      wadl: this parameter should be the URL where is published the WADL file
 *      in XML format.
 *   </li>
 *   <li>
 *      serviceName: the name which will appear in MyCocktail for this service.
 *   </li>
 *   <li>
 *      category: the category of the service in MyCocktail.
 *   </li>
 * </ul>
 * @author David del Pozo González
 */
public class ServiceCreatorServlet extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected final void processRequest(final HttpServletRequest request,
        final HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/javascript;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String wadlURLParam = request.getParameter("wadl");
            if (wadlURLParam == null) {
                out.print("Required param \"wadl\" not found, "
                    + "this param shoud be the URL where the WADL is published");
                return;
            }

            String serviceName = request.getParameter("serviceName");
            if (serviceName == null) {
                serviceName = "WADL Service";
            }

            String category = request.getParameter("category");
            if (category == null) {
                category = "WADL";
            }

            try {
                new URL(wadlURLParam);

                String wadl = RESTClient.request(wadlURLParam, HTTP_METHOD.GET,
                    Format.XML, Format.XML);

                UnitActionPackage unitActionPackage = WADLParser.parseWADL(wadl);
                unitActionPackage.setName(serviceName);
                String libraryURL = request.getRequestURL().toString() + "?wadl="
                    + wadlURLParam + "&serviceName=" + serviceName + "&category=" + category;
                unitActionPackage.setLibraryURL(libraryURL);

                ServiceGenerator serviceGenerator = new ServiceGenerator();
                serviceGenerator.setServiceType(category);
                out.println(serviceGenerator.generateUnitActionPackage(unitActionPackage));
            } catch (XmlException ex) {
                Logger.getLogger(ServiceCreatorServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.print("Malformed WADL");
            } catch (MalformedURLException mue) {
                Logger.getLogger(FormatConverter.class.getName()).log(Level.INFO, null, mue);
                out.print("Required param \"wadl\" is not correct: Malformed URL");
            }
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
