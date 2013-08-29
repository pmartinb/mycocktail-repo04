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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Service;
import org.apache.abdera.protocol.client.ClientResponse;
import org.apache.abdera.protocol.client.RequestOptions;
import net.sf.json.JSONObject;
import com.germinus.ecm.bean.ConfigFileHandler;
import com.germinus.ecm.bean.ECMRepository;
import com.germinus.ecm.bean.AtomToJSON;

/**
 * Servlet implementation class for Servlet: AddNewRepoServlet
 *
 */
 public class AddNewRepoServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AddNewRepoServlet() {
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
                String undefined = "undefined";
                String user = request.getParameter("user");
                if (user.compareTo(undefined)==0) {
                    out.write(callback + "('" + index + "', null, 500, 'User not specified', 500)");
                    return;
                }
                String password = request.getParameter("pwd");
                if (password.compareTo(undefined)==0) {
                    out.write(callback + "('" + index + "', null, 500, 'Password not specified', 500)");
                    return;
                }
                String urlRepositoryInfo = request.getParameter("repoInfo");
                if (urlRepositoryInfo.compareTo(undefined)==0) {
                    out.write(callback + "('" + index + "', null, 500, 'RespositoryInfo URL not specified', 500)");
                    return;
                }

                ECMRepository ecm = new ECMRepository(user, password);
                ConfigFileHandler cfh = new ConfigFileHandler("repositoriesNum.properties","repositories","repositoryInfo", "repositoryCapabilities", "uriTemplates", "contentTypes", "metainfo");
                //String filePath = getServletContext().getRealPath("/WEB-INF/classes") +"/";
                String filePath = getServletContext().getRealPath("/WEB-INF") +"/";
    
                // getting Repository Info
                RequestOptions requestOptions = ecm.createRequestOptions();
                ClientResponse cResp = ecm.getRequest(urlRepositoryInfo, requestOptions);
                Document<Service> doc = cResp.getDocument();
                Service ecmInfo = doc.getRoot();
                JSONObject ecmInfoJSON = cfh.getRepositoryInfo(ecmInfo);

                // ADD: getting cmis:folder type

                // getting getTypes uri
                JSONObject uriTemplates = JSONObject.fromObject(ecmInfoJSON.get("uriTemplates"));
                String urlService = uriTemplates.get("typebyid").toString();
                CharSequence target = "{id}";
		CharSequence replacement = "cmis:document";
		urlService = urlService.replace(target, replacement);
		urlService += "/children";

                /*// getFolderTypes
                String urlFolderTypeService = uriTemplates.getString("typebyid").toString();
                target = "{id}";
		replacement = "cmis:folder";
		urlFolderTypeService = urlFolderTypeService.replace(target, replacement);
		urlFolderTypeService += "/children";
                //System.out.println("urlFolderTypeService: "+ urlFolderTypeService);*/

		// getting Content Types
		JSONObject contentTypes = new JSONObject();
		//String[] exclTypes = {":wcm:",":inwf:",":fm:",":bpm:",":lnk:",":cm:",":imap:",":wca:",":ia:"};
                String[] exclTypes = {":wcm:",":inwf:",":fm:",":bpm:",":lnk:",":cm:",":imap:",":wca:",":ia:",":trx:",":rma:",":dl:",":ws:"};
                Feed feed = ecm.getFeed(urlService);
		List<Entry> typesList = ecm.getTypes(feed, exclTypes);
		Entry type;
		for (int i=0; i<typesList.size(); i++) {
			type = typesList.get(i);
			contentTypes.put("ctype" + String.valueOf(i), type.getContent());
		}
                
                /*// getting Folder Content Types
                Feed feedFolder = ecm.getFeed(urlFolderTypeService);
                typesList = ecm.getTypes(feedFolder, exclTypes);
                System.out.println("typesList: "+ typesList);
                for (int i=0; i<typesList.size(); i++) {
			type = typesList.get(i);
			contentTypes.put("ctype" + String.valueOf(contentTypes.size()), type.getContent());
		}*/


		// getting Metadata Content Types
		String getTypeDefURL = uriTemplates.get("typebyid").toString();
		
		JSONObject metadataTypes = new JSONObject();
		ECMRepository repo = new ECMRepository(user, password);
		for (int i=0; i<contentTypes.size(); i++) {
			urlService = getTypeDefURL;
			String typeName = contentTypes.getString("ctype"+ String.valueOf(i));
			replacement = typeName;
			urlService = urlService.replace(target, replacement);
			urlService += "?includeInheritedProperties=true";

			Entry entry = repo.getEntry(urlService);
			AtomToJSON atom2json = new AtomToJSON();
			JSONObject json = atom2json.entry2JSON(entry);
			
			JSONObject typeTag = json.getJSONObject("type");
		    metadataTypes.put("metainfo-ctype"+ String.valueOf(i), typeTag.toString());
		}
		
		String msg = "'"+ cfh.setRepositoryConfig(filePath, ecmInfoJSON, contentTypes, metadataTypes) +"'";
		String resp = callback + "('" + index + "', "+ msg +", 200, null, 200)";
		out.println(resp);
		out.close();
	}
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}   	  	    
}
