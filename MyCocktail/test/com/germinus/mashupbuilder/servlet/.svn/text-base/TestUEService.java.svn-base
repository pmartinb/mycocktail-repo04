/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.germinus.mashupbuilder.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
public class TestUEService extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/javascript;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String cb = request.getParameter("callback");
            if(cb == null)
                cb = "service";
            out.println(cb+"({funds: [{id:1, name:'FP7', projects:" +
                                                        "[" +
                                                          "{id:1, name:'Romulus', participants:" +
                                                                                 "[" +
                                                                                   "{name:'Gesfor'," +
                                                                                    "url:'http://www.grupogesfor.com',"+
                                                                                    "icon: 'http://aftercheese.files.wordpress.com/2008/11/romulus_remus101.jpg',"+
                                                                                    "country:'Spain'," +
                                                                                    "start:'2005-05-05T13:24:53.281+02:00' ,"+
                                                                                    "end:'2009-05-05T13:24:53.281+02:00'},"+
                                                                                   "{name:'IMOLA', " +
                                                                                    "url:'http://www.imola.com',"+
                                                                                    "icon: 'http://aftercheese.files.wordpress.com/2008/11/romulus_remus101.jpg',"+
                                                                                    "country:'Italy',"+
                                                                                    "start:'2006-05-05T13:24:53.281+02:00' ,"+
                                                                                    "end:'2008-05-05T13:24:53.281+02:00'},"+
                                                                                    "{name:'Asset', " +
                                                                                    "icon: 'http://aftercheese.files.wordpress.com/2008/11/romulus_remus101.jpg',"+
                                                                                    "url:'http://www.assetdata.com',"+
                                                                                    "country:'Italy',"+
                                                                                    "start:'2006-05-05T13:24:53.281+02:00' ,"+
                                                                                    "end:'2008-05-05T13:24:53.281+02:00'},"+
                                                                                    "{name:'DERI', " +
                                                                                    "icon: 'http://aftercheese.files.wordpress.com/2008/11/romulus_remus101.jpg',"+
                                                                                    "url:'http://www.deri.org',"+
                                                                                    "country:'Italy',"+
                                                                                    "start:'2006-05-05T13:24:53.281+02:00' ,"+
                                                                                    "end:'2008-05-05T13:24:53.281+02:00'},"+
                                                                                    "{name:'Liferay', " +
                                                                                    "icon: 'http://aftercheese.files.wordpress.com/2008/11/romulus_remus101.jpg',"+
                                                                                    "url:'http://www.liferay.com',"+
                                                                                    "country:'Italy',"+
                                                                                    "start:'2006-05-05T13:24:53.281+02:00' ,"+
                                                                                    "end:'2008-05-05T13:24:53.281+02:00'}"+
                                                                                 "]},"   +
                                                          "{id:2, name:'SOA4All', participants:" +
                                                                                 "[" +
                                                                                   "{name:'Atos',country:'Spain'},"+
                                                                                   "{name:'BT',  country:'United Kingdom'}"+
                                                                                 "]}"   +
                                                        "]}," +
                                     "{id:2, name:'FP6', projects:[]}]})");
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
