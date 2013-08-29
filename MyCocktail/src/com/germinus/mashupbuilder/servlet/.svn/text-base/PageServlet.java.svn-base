/*
 * Copyright 2010 David del Pozo González (dpozog--at--grupogesfor.com)
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

import com.germinus.mashupbuilder.controller.PageController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author David del Pozo González
 */
public class PageServlet extends HttpServlet {

    public enum Mode {
        LOAD("loadPages"),
        SAVE("savePage"),
        SHOW("showPage"),
        PREVIEW("preview");

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

        PageController pageController = new PageController();

        String pathInfo = request.getPathInfo();
        if (pathInfo!= null && pathInfo.length() > 0)
            pathInfo = pathInfo.substring(1);

        if(Mode.LOAD.getMode().equals(pathInfo)) {
            pageController.loadPages(request, response);
        } else if(Mode.SAVE.getMode().equals(pathInfo)) {
            pageController.savePage(request, response);
        } else if(Mode.SHOW.getMode().equals(pathInfo)) {
            pageController.showPages(request, response);
        } else if(Mode.PREVIEW.getMode().equals(pathInfo)) {
            pageController.pagePreview(request, response);
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
        return "Page Servlet";
    }
}
