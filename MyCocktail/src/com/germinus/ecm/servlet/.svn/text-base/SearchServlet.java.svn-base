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
import java.util.List;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Element;
import com.germinus.ecm.bean.ECMRepository;
import com.germinus.ecm.bean.ConfigFileHandler;


/**
 * Servlet implementation class for Servlet: SearchServlet
 *
 */
 public class SearchServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
       String undefined = "undefined";
       String query = request.getParameter("q");
       if (query.compareTo(undefined)==0) {
    	   out.write(callback + "('" + index + "', null, 500, 'query not specified', 500)");
    	   return;
       }
       /*String contType = request.getParameter("contType");
       if (contType.compareTo(undefined)==0) {
    	   out.write(callback + "('" + index + "', null, 500, 'contType not specified', 500)");
    	   return;
       }*/
       String user = request.getParameter("user");
       if (user.compareTo(undefined)==0) {
    	   out.write(callback + "('" + index + "', null, 500, 'user not specified', 500)");
    	   return;
       }
       String pwd = request.getParameter("pwd");
       if (pwd.compareTo(undefined)==0) {
    	   out.write(callback + "('" + index + "', null, 500, 'password not specified', 500)");
    	   return;
       }
       
       ConfigFileHandler cfh = new ConfigFileHandler("repositoriesNum.properties","repositories",
				"repositoryInfo", "repositoryCapabilities", "uriTemplates", "contentTypes", "metainfo");
       //String filePath = getServletContext().getRealPath("WEB-INF/classes") +"/";    
       String filePath = getServletContext().getRealPath("WEB-INF") +"/";


       int repositories = cfh.getNumberOfRepositories(filePath);

       //JSONObject resultsByContent = new JSONObject();
       JSONArray resultsByContent = new JSONArray();
       JSONObject resultsByContentType = new JSONObject();
       String contentTypeName = new String();
       String ticket = "";
       String urlLoginService = "";
       
       // Search by repository
       for (int repo=1; repo<repositories+1; repo++) {
            ECMRepository ecm = new ECMRepository(user, pwd);
    	   
            JSONObject repoConfig = cfh.getRepositoryConfig(filePath, repo);
            JSONObject uriTemplates = repoConfig.getJSONObject("uriTemplates");
            String urlQueryService = uriTemplates.getString("query");
	    int pos = urlQueryService.indexOf("{q}");
	    urlQueryService = urlQueryService.substring(0, pos);
	       
            JSONObject repoInfo = repoConfig.getJSONObject("repositoryInfo");
	    String rootFolderId = repoInfo.getString("rootFolderId");     
	    JSONObject contentTypes = repoConfig.getJSONObject("contentTypes");
	       
	    String contentType = "";
	    JSONObject jsonType = new JSONObject();

	    // TICKET (ALFRESCO)
	    urlLoginService = urlQueryService.substring(0, urlQueryService.indexOf("/cmis/query"));
	    urlLoginService += "/api/login?u="+ user +"&pw="+ pwd +"&format=json";
	    //System.out.println(urlLoginService);
	    ticket = ecm.getTicket(urlLoginService);
	    ticket = "&alf_ticket="+ ticket;
	    //
	       
	    // Search by content
	    for (int i=1; i<contentTypes.size(); i++) {
                resultsByContent = new JSONArray();
	    	contentType = contentTypes.getString("ctype"+ String.valueOf(i));
	    	contentType = contentType.substring(2);

	    	JSONObject metadataList = repoConfig.getJSONObject("metainfo").getJSONObject("metainfo-ctype"+ String.valueOf(i));
	    	JSONArray metadata = metadataList.getJSONArray("propertyStringDefinition");

                ecm = new ECMRepository(user, pwd);
	    	Feed feedResp = ecm.query(urlQueryService, contentType, rootFolderId, query, metadata, ticket);
System.out.println(feedResp.toString());
	    	List<Entry> contents = feedResp.getEntries();
	    	Entry content = null;

	    	for (int j=0; j<contents.size(); j++) {
	    	   jsonType = new JSONObject();
	    	   content = contents.get(j);
                   jsonType.put("myCocktailName", content.getTitle());
	           List<Element> extensions = content.getExtensions();
	           for (int k=1; k<extensions.size(); k++) {
                       Element sibling = extensions.get(k).getFirstChild();
                       Iterator<Element> it = sibling.iterator();
                       while (it.hasNext()) {
                           Element e = it.next();
                           List<QName> attributes = e.getAttributes();
                           String attribute = "";
                           String value = "";
                           //for (int m=0; m<attributes.size(); m++) {
                           int m=0;
                               attribute = e.getAttributeValue(attributes.get(m));
                               String[] atts = attribute.split(":");
                               if (!atts[0].equals("cmis")) {
                                   if (!atts[1].isEmpty()) {
                                       attribute = atts[1];
                                       List<Element> values = e.getElements();
                                       for (int l=0; l<values.size(); l++) {
                                           value = values.get(l).getText();
                                           jsonType.put(attribute, value);
                                       }
                                   }
                               }
                           //}
                       }
                   }
                    resultsByContent.add(jsonType);
                }

	    	contentTypeName = contentType.substring(contentType.indexOf(":")+1);
	    	resultsByContentType.put(contentTypeName, resultsByContent);
	    }
       }
       
       String resp = callback + "('" + index + "', "+ resultsByContentType.toString() +", 200, null, 200)";
       out.println(resp);
       
       out.close();
   }
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
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
