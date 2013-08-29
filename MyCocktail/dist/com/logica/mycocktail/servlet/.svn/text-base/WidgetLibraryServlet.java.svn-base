package com.logica.mycocktail.servlet;

import com.germinus.mashupbuilder.widget.W3CWidgetExporter;
import com.logica.mycocktail.widgetlibrary.WidgetLibrary;
import com.logica.mycocktail.widgetlibrary.WookieImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WidgetLibraryServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        Map<String,String> paramMap = transformRequestParamMap(request.getParameterMap());
        String page = request.getParameter("page");
        
        File file = new File(System.getProperty("java.io.tmpdir"),"widgetmap.wgt");
        FileOutputStream out = new FileOutputStream(file);
        W3CWidgetExporter.generateWgt(page, paramMap, out);
        
        WidgetLibrary widgetLibrary = new WookieImpl();
        widgetLibrary.publish(file);
    }
    
    private Map<String,String> transformRequestParamMap(Map<String,String[]> paramMap) {
        Map<String,String> map = new HashMap<String, String>();
        for (Map.Entry<String,String[]> entry : paramMap.entrySet()) {
            String value = null;
            String[] array = entry.getValue();
            if (array != null && array.length > 0) {
                value = array[0];
            }
            map.put(entry.getKey(), value);
        }
        return map;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
