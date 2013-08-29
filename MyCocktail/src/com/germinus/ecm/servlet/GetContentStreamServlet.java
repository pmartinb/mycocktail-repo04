package com.germinus.ecm.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import org.apache.abdera.model.Element;
import org.apache.abdera.model.Entry;
import org.apache.abdera.model.Feed;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.germinus.ecm.bean.ConfigFileHandler;
import com.germinus.ecm.bean.ECMRepository;

public class GetContentStreamServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

            response.setContentType("text/javascript; charset=UTF-8");
            PrintWriter out = response.getWriter();

            String callback = request.getParameter("callback");
            if (callback == null || callback.length() == 0 || callback == "") {
                    out.write("Callback not specified");
                    return;
            }
            String index = "";
            int indexAux = callback.indexOf("_");
            if (indexAux > -1) {
                    indexAux++;
                    index = callback.substring(indexAux);
            }
            String undefined = "undefined";
            String query = request.getParameter("q");
            if (query.compareTo(undefined) == 0) {
                    out.write(callback + "('" + index
                                    + "', null, 500, 'query not specified', 500)");
                    return;
            }
            String contentType = request.getParameter("contType");
            if (contentType.compareTo(undefined) == 0) {
                    out.write(callback + "('" + index
                                    + "', null, 500, 'contType not specified', 500)");
                    return;
            }
            String user = "admin";
            String pwd = "admin";


            ConfigFileHandler cfh = new ConfigFileHandler(
                            "repositoriesNum.properties", "repositories", "repositoryInfo",
                            "repositoryCapabilities", "uriTemplates", "contentTypes",
                            "metainfo");
            String filePath = getServletContext().getRealPath("WEB-INF") + "/";

            int repositories = cfh.getNumberOfRepositories(filePath);

            // JSONObject resultsByContent = new JSONObject();
            JSONArray resultsByContent = new JSONArray();
            JSONObject resultsByContentType = new JSONObject();
            String contentTypeName = new String();
            String ticket = "";
            String urlLoginService = "";
            String queryGetContent = "";

            JSONObject jsonType = new JSONObject();

            // Search by repository
            for (int repo = 1; repo < repositories + 1; repo++) {
                ECMRepository ecm = new ECMRepository(user, pwd);

                JSONObject repoConfig = cfh.getRepositoryConfig(filePath, repo);
                JSONObject uriTemplates = repoConfig.getJSONObject("uriTemplates");
                String urlQueryService = uriTemplates.getString("query");
                int pos = urlQueryService.indexOf("{q}");
                urlQueryService = urlQueryService.substring(0, pos);

                JSONObject repoInfo = repoConfig.getJSONObject("repositoryInfo");
                String rootFolderId = repoInfo.getString("rootFolderId");


                // TICKET (ALFRESCO)
                urlLoginService = urlQueryService.substring(0, urlQueryService.indexOf("/cmis/query"));
                urlLoginService += "/api/login?u=" + user + "&pw=" + pwd + "&format=json";
                System.out.println(urlLoginService);
                ticket = ecm.getTicket(urlLoginService);
                ticket = "&alf_ticket=" + ticket;


                JSONObject metadataList = repoConfig.getJSONObject("metainfo").getJSONObject("metainfo-ctype0");
                JSONArray metadata = metadataList.getJSONArray("propertyStringDefinition");

                //String urlService = "http://"+ request.getServerName() +":"+ request.getServerPort()+"/alfresco/service/cmis/query?q=";
                String sQuery = "SELECT cmis:objectId FROM " + contentType + " WHERE iptc:name='"+query+"' AND IN_TREE('"+rootFolderId+"')";
                try {
                    sQuery = URLEncoder.encode(sQuery, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    System.err.println("[query] Error "+ e.getMessage());
                }

                urlQueryService += sQuery;
//System.out.println(urlQueryService);
                Feed feedResp = ecm.getFeed(urlQueryService);

                List<Entry> contents = feedResp.getEntries();
//System.out.println(feedResp.toString());
                Entry content = null;
                String objectId = null;

                //if (contents.size()!=0){
                if (!contents.isEmpty()){

                    // Obtenemos el resultado, el primero del resulset (solo tiene que haber uno o ningún resultado por consulta)
                    content = contents.get(0);

                    // Obtenemos las propiedades definidas en este metadato
                    Element propiedades = content.getExtensions().get(1);

                    // Obtenemos texto del ID referencia al objeto
                    objectId = propiedades.getFirstChild().getFirstChild().getFirstChild().getText();
                    objectId = objectId.substring(objectId.lastIndexOf("/")+1);

                    queryGetContent = urlQueryService.substring(0, urlQueryService.indexOf("/query"));
                    //queryGetContent += "/i/"+ objectId +"/content"+ticket;
                    queryGetContent += "/i/"+ objectId +"/content";

                    queryGetContent = queryGetContent.replace("http://", "http://"+"user"+":"+"user"+"@");
                    resultsByContent.add(queryGetContent);

                }

            }

            jsonType.put("Resultados: ", resultsByContent);

            String resp = callback + "('" + index + "', "  + jsonType.toString() + ", 200, null, 200)";
            out.println(resp);

            out.close();

	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GetContentStreamServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
