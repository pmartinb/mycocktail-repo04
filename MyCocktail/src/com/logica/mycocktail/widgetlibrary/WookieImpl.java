package com.logica.mycocktail.widgetlibrary;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;

public class WookieImpl implements WidgetLibrary {
    private static final String OMELETTE_PROPERTIES_PATH = "conf/omelette.properties";
    private static String WOOKIE_URL;
    private static String WOOKIE_USER;
    private static String WOOKIE_PASS;
    private static final String WIDGET_PARAM_NAME = "file";
    
    static {
        try {
            Properties properties = new Properties();
            properties.load(WookieImpl.class.getClassLoader().getResourceAsStream(OMELETTE_PROPERTIES_PATH));
            
            WOOKIE_URL  = properties.getProperty("omelette.wookie.url");
            WOOKIE_USER = properties.getProperty("omelette.wookie.user");
            WOOKIE_PASS = properties.getProperty("omelette.wookie.pass");
        } catch (IOException ex) {
            Logger.getLogger(WookieImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void publish(File widget) {
        HTTPBasicAuthFilter authFilter = new HTTPBasicAuthFilter(WOOKIE_USER,WOOKIE_PASS); 
        
        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);        
        client.addFilter(authFilter);
        client.addFilter(new LoggingFilter()); 
        
        WebResource webResource = client.resource(WOOKIE_URL);
        
        FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
        formDataMultiPart.bodyPart(new FileDataBodyPart(WIDGET_PARAM_NAME, widget, MediaType.APPLICATION_OCTET_STREAM_TYPE));
                
        String string = webResource.type(MediaType.MULTIPART_FORM_DATA).post(String.class, formDataMultiPart);
        // Parse respose for searching errors.
        System.out.println(string);
    }
}
