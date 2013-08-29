/**
 * Copyright 2010 Informática Gesfor
 * @author José María Jiménez Torrejón (jmjimenezt--at--grupogesfor.com)
 * 
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


package com.germinus.ecm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import com.germinus.ecm.bean.ConfigFileHandler;

/**
 * Servlet implementation class for Servlet: getRepoList
 *
 */
 public class GetRepoListServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GetRepoListServlet() {
		super();
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/javascript; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String callback = request.getParameter("callback"); 
		if (callback == null || callback.length() == 0 || callback == ""){
			out.write("Callback not specified");
			return;
		}
		String index="";
		int indexAux = callback.indexOf("_");
		if (indexAux>-1){
			indexAux++;
			index = callback.substring(indexAux);
		}
		
		ConfigFileHandler cfh = new ConfigFileHandler("repositoriesNum.properties","repositories",
				"repositoryInfo", "repositoryCapabilities", "uriTemplates", "contentTypes", "metainfo");
		//String filePath = getServletContext().getRealPath("/WEB-INF/classes") +"/";
		String filePath = getServletContext().getRealPath("/WEB-INF") +"/";
        
		int repoSize = cfh.getNumberOfRepositories(filePath);
		JSONArray repositories = new JSONArray();
		for (int i=1; i<repoSize+1; i++) {
			repositories.add(cfh.getRepositoryConfig(filePath, i));
		}
		
		String resp = callback + "('" + index + "', "+ repositories.toString() +", 200, null, 200)";
		
		out.println(resp);
		out.close();

	}
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}   	  	    
}
