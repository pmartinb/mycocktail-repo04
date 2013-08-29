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
package com.germinus.mashupbuilder.controller;

import com.germinus.mashupbuilder.bean.Page;
import com.germinus.mashupbuilder.dao.DAOException;
import com.germinus.mashupbuilder.dao.factory.DAOFactory;
import com.germinus.mashupbuilder.dao.jdbc.PageDAO;
import com.germinus.util.objectformatter.JsonFormatter;
import com.germinus.util.objectformatter.XMLFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  This class is a controller of the operations performed over pages.
 * @author David del Pozo González
 */
public class PageController {
    /**
     * Indicates that the response should be JSON.
     */
    private static final String JSON = "1";

    /**
     * This method returns the list with all pages stored in MyCocktail database.
     * The request has these input parameters:
     * <ul>
     *   <li>
     *      callback: the name of the callback function for a JSONP petition.
     *   </li>
     * </ul>
     */
    public void loadPages(final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            boolean scriptTag = false;
            String cb = request.getParameter("callback");
            if (cb != null) {
                scriptTag = true;
                response.setContentType("text/javascript");
            } else {
                response.setContentType("application/x-json");
            }

            DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.FactoryType.JDBC);
            PageDAO pageDAO = (PageDAO) daoFactory.getDAO(Page.class);
            List<Page> pages = pageDAO.getAll();

            if (scriptTag) {
                out.write(cb + "(");
            }
            JsonFormatter jsFmt = new JsonFormatter();
            jsFmt.setRootElement("page");
            out.print(jsFmt.convert(pages));
            if (scriptTag) {
                out.write(");");
            }
        } catch (DAOException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
            reportError(out, Errors.DATABASE_ERROR);
        } finally {
            out.close();
        }
    }

    /**
     * This method returns a page stored in MyCocktail database.
     * The request has these input parameters:
     * <ul>
     *   <li>
     *      id: the id of the page to retrieve.
     *   </li>
     *   <li>
     *      json: this value should be "1" for JSON and JSONP format in the return,
     *            in other case the returning format will be "text/javascript".
     *   </li>
     *   <li>
     *      callback: the name of the callback function for a JSONP petition,
     *                requires that json parameter was "1".
     *   </li>
     * </ul>
     */
    public void showPages(final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            String id = request.getParameter("id");
            String json = request.getParameter("json");
            String callback = request.getParameter("callback");

            if (JSON.equals(json)) {
                response.setContentType("application/x-json");
            } else {
                response.setContentType("text/javascript");
            }

            if (id != null) {
                Integer intId = Integer.parseInt(id);

                Page pagePattern = new Page();
                pagePattern.setId(intId);

                DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.FactoryType.JDBC);
                PageDAO pageDAO = (PageDAO) daoFactory.getDAO(Page.class);
                Page pageFound = pageDAO.find(pagePattern);
                if (pageFound != null) {
                    StringBuilder sb = new StringBuilder();
                    if (callback != null) {
                        sb.append(callback).append("(");
                    } else if (!JSON.equals(json)) {
                        sb.append("romulus.pageEditor.app.register('");
                        sb.append(pageFound.getId()).append("', ");
                    }
                    sb.append(pageFound.getJson());
                    if (callback != null) {
                        sb.append(");");
                    } else if (!JSON.equals(json)) {
                        sb.append(");");
                    }

                    out.write(sb.toString());
                } else {
                    reportError(out, Errors.PAGE_NOT_FOUND);
                }
            } else {
                reportError(out, Errors.INSUFICIENTS_PARAMETERS);
            }
        } catch (NumberFormatException nbe) {
            Logger.getLogger(PageController.class.getName()).log(Level.WARNING, null, nbe);
            reportError(out, Errors.INSUFICIENTS_PARAMETERS);
        } catch (DAOException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
            reportError(out, Errors.DATABASE_ERROR);
        } finally {
            out.close();
        }
    }

    /**
     * This method saves or updates a page in MyCocktail database.
     * The request has these input parameters:
     * <ul>
     *   <li>
     *      id: the id of the page (only required for updates).
     *   </li>
     *   <li>
     *      name: the name of the page.
     *   </li>
     *   <li>
     *      description: the description of the pages.
     *   </li>
     *   <li>
     *      json: the JSON represenation of the page.
     *   </li>
     * </ul>
     */
    public void savePage(final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        try {
            String idSt = request.getParameter("id");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String json = request.getParameter("json");

            if ((json == null || json.equals(""))
                || ((idSt == null || idSt.equals("")) && (name == null || name.equals("")))) {
                reportError(out, Errors.INSUFICIENTS_PARAMETERS);
                return;
            }

            if (description == null) {
                description = "";
            }

            DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.FactoryType.JDBC);
            PageDAO pageDAO = (PageDAO) daoFactory.getDAO(Page.class);
            Page page = null;
            if (idSt != null) {
                int id = Integer.parseInt(idSt);
                page = new Page(id, name, description, json);
                pageDAO.updateJson(page);
            } else {
                page = new Page(name, description, json);
                int id = pageDAO.saveAndGetId(page);
                page.setId(id);
            }
            out.write(XMLFormatter.toXML(page));
        } catch (NumberFormatException nbe) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, nbe);
            reportError(out, Errors.INSUFICIENTS_PARAMETERS);
        } catch (DAOException ex) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, ex);
            reportError(out, Errors.DATABASE_ERROR);
        } finally {
            out.close();
        }
    }

    public void pagePreview(final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {

        String page = request.getParameter("page");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(page);
        out.close();
    }

    /**
     * Printh a error.
     * @param writer the writer in which reports the error.
     * @param error the error to show.
     * @throws IOException if an I/O error occurs
     */
    private void reportError(final Writer writer, final String error) throws IOException {
        writer.write("<error>" + error + "</error>");
    }
}
