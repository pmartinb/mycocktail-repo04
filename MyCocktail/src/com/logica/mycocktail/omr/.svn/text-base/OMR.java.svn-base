package com.logica.mycocktail.omr;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.XmlException;

public class OMR {
    private static final String OMELETTE_PROPERTIES_PATH = "conf/omelette.properties";
    
    private static String OMR_SERVER_URL;
    private static String USER;
    private static String PASS;
    
    private static final OMRParser omrParser = new OMRParser();
    
    //TODO Singleton
    public OMR() {
        
    }
    
    static {
        try {
            Properties properties = new Properties();
            properties.load(OMR.class.getClassLoader().getResourceAsStream(OMELETTE_PROPERTIES_PATH));
            
            OMR_SERVER_URL  = properties.getProperty("omelette.omr.url");
            USER = properties.getProperty("omelette.omr.user");
            PASS = properties.getProperty("omelette.omr.pass");
        } catch (IOException ex) {
            Logger.getLogger(OMR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<OMRService> searchServicesByQuery(String query) throws XmlException, IOException {
        HTTPBasicAuthFilter authFilter = new HTTPBasicAuthFilter(USER,PASS); 
        
        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);        
        client.addFilter(authFilter);
        
        WebResource webResource = client.resource(OMR_SERVER_URL);
        String string = webResource.get(String.class);
        
        System.out.println(string);
        
        return omrParser.parse(string);
    }
}
