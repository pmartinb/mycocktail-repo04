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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.List;
import java.util.ArrayList;
import net.sf.json.JSONObject;
import org.apache.abdera.model.Service;
import org.apache.abdera.model.Workspace;
import org.apache.abdera.model.Element;


/**
 * This class can be used to make operations with configuration files.
 * These configuration files will store information about CMS repositories.
 */
public class ConfigFileHandler {

	//private String filesPath;
	private String reposNumberFile;
	private String reposNumberProp; 
	private String repoInfo;
	private String repoCapabilities;
	private String templates;
	private String types;
	private String metainfo;
	
	public ConfigFileHandler(String repoNumberFile, String repoNumberTag, String repoInfoTag, String repoCapabilitiesTag, String templatesTag, String typesTag, String metainfoTag) {
		this.repoInfo = repoInfoTag;
		this.repoCapabilities = repoCapabilitiesTag;
		this.templates = templatesTag;
		this.types = typesTag;
		this.reposNumberFile = repoNumberFile;
		this.reposNumberProp = repoNumberTag;
		this.metainfo = metainfoTag;
	}
	
	public Properties openConfigFile(String configFile) {
		Properties props = new Properties();
		
		try {
			props.load(new FileInputStream(new File(configFile)));
		} catch (IOException e) {
			System.err.println("[openConfigFile] Error reading file: " + e.getMessage());
		}
		
		return props;
	}
	
	// TODO: This method needs changes.
	public int getNumberOfRepositories(String filePath) {
		Properties props = this.openConfigFile(filePath+reposNumberFile);
		return Integer.valueOf(props.getProperty(reposNumberProp));
	}
	
	// TODO: This method needs changes.
	private int addRepository(String file, String propertyName) {
		Properties numberOfRepositoriesFile = new Properties();
		try {
			numberOfRepositoriesFile.load(new FileInputStream(new File(file)));
		} catch (IOException e) {
			System.out.println("[addRepository] Error reading file: " + e.getMessage());
		}
		int n = Integer.parseInt(numberOfRepositoriesFile.getProperty(propertyName));
		n++;
		numberOfRepositoriesFile.setProperty(propertyName, String.valueOf(n));
		
		// Saving the configuration
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File (file));
		} catch (IOException e) {
			System.out.println("[addRepository] Error creating file: "+ e.getMessage());
		}
		
		String comments = "Number of ECM Repositories";
		try {
			numberOfRepositoriesFile.store(out, comments);
		} catch (IOException e) {
			System.out.println("[addRepository] Error storing properties file: "+ e.getMessage());
		}
		
		return n;
	}
	

	// TODO: This method needs changes.
	public JSONObject getRepositoryInfo(Service ecmInfo){
		JSONObject response = new JSONObject();
		
		Workspace ws = ecmInfo.getWorkspace("Main Repository");
		   
		List<Element> list = ws.getExtensions();
		Element e;
		List<List<Element>> info = new ArrayList<List<Element>>();
		for (int i=0; i<list.size(); i++) {
			e = list.get(i);
			List<Element> cmisPropsECM = e.getElements();
			if (!cmisPropsECM.isEmpty()) {
				info.add(cmisPropsECM);
			}
		}
		   
		// repositoryInfo
		List<Element> repoInfo = info.get(0);
		JSONObject repositoryInfo = new JSONObject();
		repositoryInfo.put("repositoryId", repoInfo.get(0).getText());
		repositoryInfo.put("repositoryName", repoInfo.get(1).getText());
		repositoryInfo.put("repositoryDescription", repoInfo.get(2).getText());
		repositoryInfo.put("vendorName", repoInfo.get(3).getText());
		repositoryInfo.put("productName", repoInfo.get(4).getText());
		repositoryInfo.put("productVersion", repoInfo.get(5).getText());
		repositoryInfo.put("rootFolderId", repoInfo.get(6).getText());
		repositoryInfo.put("cmisVersionSupported", repoInfo.get(8).getText());
		repositoryInfo.put("cmisSpecificationTitle", repoInfo.get(9).getText());
		   
		// repositoryCapabilities
		JSONObject repositoryCapabilities = new JSONObject();
		List<Element> repoCapabilities = repoInfo.get(7).getElements();
		repositoryCapabilities.put("ACL", repoCapabilities.get(0).getText());
		repositoryCapabilities.put("AllVersionsSearchable", repoCapabilities.get(1).getText());
		repositoryCapabilities.put("Changes", repoCapabilities.get(2).getText());
		repositoryCapabilities.put("ContentStreamUpdatability", repoCapabilities.get(3).getText());
		repositoryCapabilities.put("ContentStreamUpdatability", repoCapabilities.get(4).getText());
		repositoryCapabilities.put("GetDescendants", repoCapabilities.get(5).getText());
		repositoryCapabilities.put("GetDescendants", repoCapabilities.get(6).getText());
		repositoryCapabilities.put("Multifiling", repoCapabilities.get(7).getText());
		repositoryCapabilities.put("PWCSearchable", repoCapabilities.get(8).getText());
		repositoryCapabilities.put("Query", repoCapabilities.get(9).getText());
		repositoryCapabilities.put("Renditions", repoCapabilities.get(10).getText());
		repositoryCapabilities.put("Unfiling", repoCapabilities.get(11).getText());
		repositoryCapabilities.put("VersionSpecificFiling", repoCapabilities.get(12).getText());
		repositoryCapabilities.put("Join", repoCapabilities.get(13).getText());

		// uriTemplates
		List<Element> props = new ArrayList<Element>();
		JSONObject uriTemplate = new JSONObject();
		for (int i=1; i<info.size(); i++) {
			props = info.get(i);
			uriTemplate.put(props.get(1).getText(), props.get(0).getText());
		}
		
		response.put(this.repoInfo, repositoryInfo);
		response.put(this.repoCapabilities, repositoryCapabilities);
		response.put(this.templates, uriTemplate);
		
		return response;
	}
	

	public String setRepositoryConfig(String filePath, JSONObject repoInfo, JSONObject contentTypes, JSONObject metainfo) {
		int numberOfRepo = this.addRepository(filePath + reposNumberFile, reposNumberProp);
		
		String file = "repo"+ String.valueOf(numberOfRepo) +".properties";
		file = filePath + file;
		
		Properties propsFile = new Properties();
		
		propsFile.put(this.repoInfo, repoInfo.getJSONObject(this.repoInfo).toString());
		propsFile.put(this.repoCapabilities, repoInfo.getJSONObject(this.repoCapabilities).toString());
		propsFile.put(this.templates, repoInfo.getJSONObject(this.templates).toString());
		propsFile.put(this.types, contentTypes.toString());
		propsFile.put("metainfo", metainfo.toString());
		
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File (file));
		} catch (IOException ex) {
			System.out.println("[setRepositoryConfig] Error creating file: "+ ex.getMessage());
		}
		
		String comments = "ECM Repositories Configuration";
		try {
			propsFile.store(out, comments);
		} catch (IOException ex) {
			System.out.println("[setRepositoryConfig] Error storing properties file: "+ ex.getMessage());
		}

		return "ECM Repository added.";
	}
	
	public JSONObject getRepositoryConfig(String filePath, int repoNumber) {
		Properties props = this.openConfigFile(filePath+"repo"+ repoNumber +".properties");
		
		JSONObject response = new JSONObject();
		JSONObject repositoryInfo = new JSONObject();
		JSONObject repositoryCapabilities = new JSONObject();
		JSONObject uriTemplates = new JSONObject();
		JSONObject contentTypes = new JSONObject();
		JSONObject metaInfo = new JSONObject();
		try {
			repositoryInfo = JSONObject.fromObject(props.getProperty(repoInfo));
			repositoryCapabilities = JSONObject.fromObject(props.getProperty(repoCapabilities));
			uriTemplates = JSONObject.fromObject(props.getProperty(templates));
			contentTypes = JSONObject.fromObject(props.getProperty(types));
			metaInfo = JSONObject.fromObject(props.getProperty(this.metainfo));
		} catch (Exception e) {
			System.out.println("[getRepositoryConfig] "+ e.getMessage());
		}
		
		response.put(repoInfo, repositoryInfo);
		response.put(repoCapabilities, repositoryCapabilities);
		response.put(templates, uriTemplates);
		response.put(types, contentTypes);
		response.put(metainfo, metaInfo);
		
		response.put("myCocktailName", "ECM Repository "+repoNumber);
		
		return response;
	}
	
}
