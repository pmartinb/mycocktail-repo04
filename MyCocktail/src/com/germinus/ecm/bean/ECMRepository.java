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

package com.germinus.ecm.bean;

import org.apache.abdera.Abdera;
import org.apache.abdera.model.Document;
import org.apache.abdera.model.Feed;
import org.apache.abdera.model.Entry;
import org.apache.abdera.protocol.Response.ResponseType;
import org.apache.abdera.protocol.client.AbderaClient;
import org.apache.abdera.protocol.client.ClientResponse;
import org.apache.abdera.protocol.client.RequestOptions;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.methods.RequestEntity;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import java.util.List;
import java.util.ArrayList;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.nio.CharBuffer;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;


/**
 * This class represents a Content Management System in MyCocktail application,
 * it can be used to make operation with the data from a CMS Repository
 * (Content Management System).  
 * ECMRepository class can be used to retrieved data from CMIS Services.
 */
public class ECMRepository {

	private String username;
	private String password;
	private AbderaClient client;

	public ECMRepository(String username, String password) {
		this.username = username;
		this.password = password;
		startClientHTTP();
	}
	
	public ECMRepository() {
	}

	
	private AbderaClient startClientHTTP()
	{
		Abdera abdera = new Abdera();
		client = new AbderaClient(abdera);
		return client;
	}
	
	public RequestOptions createRequestOptions() {
		RequestOptions requestOptions = new RequestOptions();
		String creds = username + ":" + password;
		String authorization = "Basic "
				+ new String(Base64.encodeBase64(creds.getBytes()));
		requestOptions.setAuthorization(authorization);
		return requestOptions;
	}
	
	public RequestOptions createRequestOptions(String contentType) {
		RequestOptions requestOptions = new RequestOptions();
		String creds = username + ":" + password;
		String authorization = "Basic "
				+ new String(Base64.encodeBase64(creds.getBytes()));
		requestOptions.setAuthorization(authorization);
		if (contentType.compareTo("undefined")!=0) {
			requestOptions.setContentType(contentType);
		}

		return requestOptions;
	}

	public ClientResponse postRequest(String urlService, RequestEntity requestEntity, RequestOptions requestOptions){
		ClientResponse response = null;
		
		try {
			response = client.post(urlService, requestEntity, requestOptions);
			return response;	
		}catch (Exception e) {
			System.err.println("[postRequest] Error: "+ e.getMessage());
		}
		
		return response;
	}
	
	public ClientResponse getRequest(String urlService, RequestOptions requestOptions) {
		ClientResponse response = null;
		
		try {
			response = client.get(urlService, requestOptions);
		} catch (Exception e) {
			System.err.println("[getRequest] Error: "+ e.getMessage());
		}
		
		return response;
	}
	
	
	public Feed getFeed(String urlService) {
		RequestOptions requestOptions = this.createRequestOptions("application/atom+xml");
		
		ClientResponse cResp = this.getRequest(urlService, requestOptions);
		
		if (cResp.getType() == ResponseType.SUCCESS) {
			String type = cResp.getContentType().getParameter("type");
			if (type.matches("feed")) {
				Document<Feed> doc = cResp.getDocument();
				Feed feed = doc.getRoot();
				return feed;
			}
                } else {
                        String msg = "[getFeed] RespType: " + cResp.getType() + " RespStatus: " + cResp.getStatus();
                        System.out.println(msg);
                }
		return null;
	}
	
	public Entry getEntry(String urlService) {
		RequestOptions requestOptions = this.createRequestOptions();
		ClientResponse cResp = this.getRequest(urlService, requestOptions);
		Entry entry = null;
		if (cResp.getType() == ResponseType.SUCCESS) {
			String type = cResp.getContentType().getParameter("type");
			if (type.matches("entry")) {
				Document<Entry> doc = cResp.getDocument();
				entry = doc.getRoot();
			}
        } else {
    		String msg = "[getEntry] RespType: " + cResp.getType() + " RespStatus: " + cResp.getStatus();
    		System.out.println(msg);
        }
		return entry;
	}
	

	public List<Entry> getTypes(Feed feed, String[] exclTypes) {
		List<Entry> entries = feed.getEntries();
		List<Entry> typesList = new ArrayList<Entry>();
		Entry entry; 
		CharSequence seq;
		boolean ok;
	   
		for (int i=0; i<entries.size(); i++) {
			entry = entries.get(i);
			ok = true;
			for (int j=0; j<exclTypes.length; j++) {
				seq = CharBuffer.wrap(exclTypes[j]);
				if (entry.getContent().contains(seq)) {
					ok = false;
				}
			}
			if (ok) {
				typesList.add(entry);
			}
		}
		
		return typesList;
	}

	
	public Feed query(String urlService, String contentType, String node, String param, JSONArray metadata, String ticket) {
		String querySQL = "SELECT * FROM "+ contentType +" WHERE IN_TREE('"+ node +"')";

		String whereClause = "";
		String metadataName = "";
		boolean queryable = false;
		JSONObject metadataDef = new JSONObject();

		int size = metadata.size();
		List<String> metadataQueryable = new ArrayList<String>();
		for (int i=0; i<size; i++) {
			metadataDef = metadata.getJSONObject(i);			
			queryable = metadataDef.getBoolean("queryable");
			if (queryable) {
				metadataName = metadataDef.getString("id");
				metadataQueryable.add(metadataName);
			}
		}

		size = metadataQueryable.size();
		for (int i=0; i<metadataQueryable.size(); i++) {
                    if (i>0 && i<size-1) {
                        //whereClause += " OR "+ metadataQueryable.get(i) +" LIKE '%"+ param +"%'";
                        whereClause += " OR "+ metadataQueryable.get(i) +" = '"+ param +"'";
                    } else if (i==0) {
                        //whereClause += " AND ("+ metadataQueryable.get(i) +" LIKE '%"+ param +"%'";
                        whereClause += " AND ("+ metadataQueryable.get(i) +" = '"+ param +"'";
                    } else if (i==size-1) {
                        //whereClause += " OR "+ metadataQueryable.get(i) +" LIKE '%"+ param +"%')";
                        whereClause += " OR "+ metadataQueryable.get(i) +" = '"+ param +"')";
                    }
		}
		querySQL += whereClause;

		try {
			querySQL = URLEncoder.encode(querySQL, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("[query] Error "+ e.getMessage());
		}
		urlService += querySQL;
		//urlService += "&maxItems=100" + ticket;
                urlService += "&maxItems=100";
System.out.println(urlService);
		Feed feed = this.getFeed(urlService);

		return feed;
	}

	public String getTicket(String urlLoginService) {
		String ticket = new String();

		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(urlLoginService);
		JSONObject json = new JSONObject();
		
	    try {
	        int statusCode = client.executeMethod(method);

	        if (statusCode != HttpStatus.SC_OK) {
	        	System.err.println("Method failed: " + method.getStatusLine());
	        }

	        ticket = method.getResponseBodyAsString();
	        json = JSONObject.fromObject(ticket);

	    } catch (HttpException e) {
	    	System.err.println("[getTicket] Fatal protocol violation: " + e.getMessage());
	    	e.printStackTrace();
	    } catch (IOException e) {
	        System.err.println("[getTicket] Fatal transport error: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        method.releaseConnection();
	    }  

	    ticket = json.getJSONObject("data").getString("ticket");
		return ticket;
	}
	
}
