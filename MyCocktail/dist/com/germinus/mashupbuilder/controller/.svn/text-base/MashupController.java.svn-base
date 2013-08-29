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

import com.germinus.mashupbuilder.bean.Mashup;
import com.germinus.mashupbuilder.dao.DAOException;
import com.germinus.mashupbuilder.dao.factory.DAOFactory;
import com.germinus.mashupbuilder.dao.jdbc.MashupDAO;
import com.germinus.mashupbuilder.widget.W3CWidgetExporter;
import com.logica.mycocktail.util.Utils;
import com.germinus.util.objectformatter.JsonFormatter;
import com.germinus.util.objectformatter.XMLFormatter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * This class is a controller of the operations performed over mashups.
 * @author David del Pozo González
 */
public class MashupController {
    /**
     * Indicates that the response should be JSON.
     */
    private static final String JSON = "1";
    /**
     * The maximu size for the uploaded file.
     */
    private static final int MAX_FILE_SIZE = 100000;
    /**
     * The size of the buffer to process the uploaded file.
     */
    private static final int BUFFER_SIZE = 4096;

    /**
     * This method returns the list with all mashups stored in MyCocktail database.
     * The request has these input parameters:
     * <ul>
     *   <li>
     *      callback: the name of the callback function for a JSONP petition.
     *   </li>
     * </ul>
     */
    public void loadMashups(final HttpServletRequest request,
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
            MashupDAO mashupDAO = (MashupDAO) daoFactory.getDAO(Mashup.class);
            List<Mashup> mashups = mashupDAO.getAll();

            if (scriptTag) {
                out.write(cb + "(");
            }
            JsonFormatter jsFmt = new JsonFormatter();
            jsFmt.setRootElement("mashup");
            out.print(jsFmt.convert(mashups));
            if (scriptTag) {
                out.write(");");
            }
        } catch (DAOException ex) {
            Logger.getLogger(MashupController.class.getName()).log(Level.SEVERE, null, ex);
            reportError(out, Errors.DATABASE_ERROR);
        } finally {
            out.close();
        }
    }

    /**
     * This method returns a mashup stored in MyCocktail database.
     * The request has these input parameters:
     * <ul>
     *   <li>
     *      id: the id of the mashup to retrieve.
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
    public void showMashups(final HttpServletRequest request,
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

                Mashup mashupPattern = new Mashup();
                mashupPattern.setId(intId);

                DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.FactoryType.JDBC);
                MashupDAO mashupDAO = (MashupDAO) daoFactory.getDAO(Mashup.class);
                Mashup mashupFound = mashupDAO.find(mashupPattern);
                if (mashupFound != null) {
                    StringBuilder sb = new StringBuilder();
                    if (callback != null) {
                        sb.append(callback).append("(");
                    } else if (!JSON.equals(json)) {
                        sb.append("afrous.processes.register('");
                        sb.append(mashupFound.getId()).append("', ");
                    }
                    sb.append(mashupFound.getJson());
                    if (callback != null) {
                        sb.append(");");
                    } else if (!JSON.equals(json)) {
                        sb.append(");");
                    }

                    out.write(sb.toString());
                } else {
                    reportError(out, Errors.MASHUP_NOT_FOUND);
                }
            } else {
                reportError(out, Errors.INSUFICIENTS_PARAMETERS);
            }
        } catch (NumberFormatException nbe) {
            Logger.getLogger(MashupController.class.getName()).log(Level.WARNING, null, nbe);
            reportError(out, Errors.INSUFICIENTS_PARAMETERS);
        } catch (DAOException ex) {
            Logger.getLogger(MashupController.class.getName()).log(Level.SEVERE, null, ex);
            reportError(out, Errors.DATABASE_ERROR);
        } finally {
            out.close();
        }
    }

    /**
     * This method saves or updates a mashup in MyCocktail database.
     * The request has these input parameters:
     * <ul>
     *   <li>
     *      id: the id of the mashup (only required for updates).
     *   </li>
     *   <li>
     *      name: the name of the mashup.
     *   </li>
     *   <li>
     *      description: the description of the mashups.
     *   </li>
     *   <li>
     *      json: the JSON represenation of the mashup.
     *   </li>
     * </ul>
     */
    public void saveMashup(final HttpServletRequest request,
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
            MashupDAO mashupDAO = (MashupDAO) daoFactory.getDAO(Mashup.class);
            Mashup mashup = null;
            if (idSt != null) {
                int id = Integer.parseInt(idSt);
                mashup = new Mashup(id, name, description, json);
                mashupDAO.updateJson(mashup);
            } else {
                mashup = new Mashup(name, description, json);
                int id = mashupDAO.saveAndGetId(mashup);
                mashup.setId(id);
            }
            out.write(XMLFormatter.toXML(mashup));
        } catch (NumberFormatException nbe) {
            Logger.getLogger(MashupController.class.getName()).log(Level.SEVERE, null, nbe);
            reportError(out, Errors.INSUFICIENTS_PARAMETERS);
        } catch (DAOException ex) {
            Logger.getLogger(MashupController.class.getName()).log(Level.SEVERE, null, ex);
            reportError(out, Errors.DATABASE_ERROR);
        } finally {
            out.close();
        }
    }

    public void openMashupJsonFromLocal(final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.print("<input type='text' id='json' value='");

            DiskFileItemFactory factory = new DiskFileItemFactory();

            factory.setSizeThreshold(BUFFER_SIZE);
            factory.setRepository(new File("/tmp"));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(MAX_FILE_SIZE);

            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    InputStream uploadedStream = item.getInputStream();
                    InputStreamReader isr = new InputStreamReader(uploadedStream);
                    char[] buffer = new char[BUFFER_SIZE];
                    int len = 0;
                    while ((len = isr.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }
                    isr.close();
                    uploadedStream.close();
                }
            }

            out.print("' />");
        } catch (FileUploadException ex) {
            Logger.getLogger(MashupController.class.getName()).log(Level.SEVERE, null, ex);
            reportError(out, Errors.UPLOAD_ERROR);
        } finally {
            out.close();
        }
    }

    /**
     * This method returns the mashups to store in local disk of the user.
     * The request has these input parameters:
     * <ul>
     *   <li>
     *      json: the JSON represenation of the mashup.
     *   </li>
     * </ul>
     * @author David del Pozo González
     */
    public void saveMashupJsonToLocal(final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/x-json");
        PrintWriter out = response.getWriter();
        try {
            String json = request.getParameter("json");
            if (json == null) {
                json = "";
            }

            out.write(json);
        } finally {
            out.close();
        }
    }

    public void mashupPreview(final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {

        String page = request.getParameter("page");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(page);
        out.close();
    }
    
    
    public void exportToW3CWidget(final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {
        
        Map<String,String> paramMap = transformRequestParamMap(request.getParameterMap());
        String page = request.getParameter("page");
        
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment; filename=\"widget.wgt\"");
        
        OutputStream out = response.getOutputStream();
        W3CWidgetExporter.generateWgt(page, paramMap, out);
        out.close();
    }
    
    private Map<String,String> transformRequestParamMap(Map<String,String[]> paramMap) {
        Map<String,String> map = new HashMap<String, String>();
        for (Entry<String,String[]> entry : paramMap.entrySet()) {
            String value = null;
            String[] array = entry.getValue();
            if (array != null && array.length > 0) {
                value = array[0];
            }
            map.put(entry.getKey(), value);
        }
        return map;
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
