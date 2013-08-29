package com.logica.mycocktail.controller;

import com.germinus.mashupbuilder.bean.Mashup;
import com.germinus.mashupbuilder.dao.DAOException;
import com.germinus.mashupbuilder.dao.factory.DAOFactory;
import com.germinus.mashupbuilder.dao.jdbc.MashupDAO;
import com.sun.research.wadl.x2006.x10.ApplicationDocument;
import com.sun.research.wadl.x2006.x10.Application;
import com.sun.research.wadl.x2006.x10.Resources;
import com.sun.research.wadl.x2006.x10.Resource;
import com.sun.research.wadl.x2006.x10.Method;
import com.sun.research.wadl.x2006.x10.Param;
import com.sun.research.wadl.x2006.x10.ParamStyle;
import com.sun.research.wadl.x2006.x10.Representation;
import com.sun.research.wadl.x2006.x10.Request;
import com.sun.research.wadl.x2006.x10.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.XmlOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WADLGenerator {    
    public static String generateWADLForMashupRESTService(String myCocktailPath, int mashupId) throws DAOException, IOException {
        Mashup mashup = getMashup(mashupId);
        
        ApplicationDocument applicationDocument = ApplicationDocument.Factory.newInstance();
        Application application = applicationDocument.addNewApplication();
        Resources resources = application.addNewResources();
        resources.setBase(myCocktailPath);
        
        Resource resource = resources.addNewResource();
        resource.setPath("RESTService/mashupId="+mashupId);
        
        addResource(resource, "json",  "format=json",  mashup, "application/json");
        addResource(resource, "xml",   "format=xml",   mashup, "application/xml");
        addResource(resource, "jsonp", "format=jsonp", mashup, "application/javascript");
        
        return applicationDocument.xmlText(new XmlOptions().setSavePrettyPrint());
    }
    
    public static String generateWADLForMashupRESTServiceJSON(String myCocktailPath, int mashupId) throws DAOException, IOException {
        Mashup mashup = getMashup(mashupId);
        
        ApplicationDocument applicationDocument = ApplicationDocument.Factory.newInstance();
        Application application = applicationDocument.addNewApplication();
        Resources resources = application.addNewResources();
        resources.setBase(myCocktailPath);
        
        Resource resource = resources.addNewResource();
        resource.setPath("RESTService/mashupId="+mashupId);
        
        addMethod(resource.addNewMethod(), "json", mashup, "application/json");
        
        return applicationDocument.xmlText(new XmlOptions().setSavePrettyPrint());
    }
    
    private static void addResource(Resource resource, String format, String path, Mashup mashup, String mediaType) {
        Resource resource3 = resource.addNewResource();
        resource3.setPath(path);
        addMethod(resource3.addNewMethod(), format, mashup, mediaType);
    }
    
    private static void addMethod(Method method, String format, Mashup mashup, String mediaType) {
        method.setName(mashup.getName());
        method.setId("mashup"+mashup.getId().toString()+format);
        addParametersToWADL(method.addNewRequest(),  mashup.getJson());
        addResponse        (method.addNewResponse(), mediaType);
    }
    
    private static void addParametersToWADL(Request request, String mashupJson) {
        try {
            JSONObject jsonObject = new JSONObject(mashupJson);
            JSONArray jsonArray = jsonObject.getJSONArray("params");
            for(int i=0; i<jsonArray.length(); i++) {
                try {
                    String paramName    = jsonArray.getJSONObject(i).getString("name");
                    String paramDefault = jsonArray.getJSONObject(i).getString("default");
                    Param param = request.addNewParam();
                    param.setName(paramName);
                    param.setDefault(paramDefault);
                    param.setStyle(ParamStyle.Enum.forString("query"));
                    param.setType("xs:string");
                } catch (JSONException ex) {
                    Logger.getLogger(WADLGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(WADLGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void addResponse(Response response, String mediaType) {
        Representation representation = response.addNewRepresentation();
        representation.setMediaType(mediaType);
    }
    
    private static Mashup getMashup(int mashupId) throws DAOException {
        Mashup mashupPattern = new Mashup();
        mashupPattern.setId(mashupId);
        
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.FactoryType.JDBC);
        MashupDAO mashupDAO = (MashupDAO) daoFactory.getDAO(Mashup.class);
        return mashupDAO.find(mashupPattern);
    }
    
    public static void main(String[] args) throws IOException, DAOException {
        System.out.println(generateWADLForMashupRESTService("http://localhost:8084/MyCocktail/", 84));
    }
}
