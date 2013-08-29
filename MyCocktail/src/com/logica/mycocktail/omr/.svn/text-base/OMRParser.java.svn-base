package com.logica.mycocktail.omr;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.XmlException;
import org.w3.x2005.sparqlResults.BindingDocument;
import org.w3.x2005.sparqlResults.ResultDocument;
import org.w3.x2005.sparqlResults.ResultsDocument;
import org.w3.x2005.sparqlResults.SparqlDocument;

public class OMRParser {
    private static final String DESCRIPTION_URL = "descriptionUrl";
    private static final String NAME = "name";
    private static final String SERVICE = "service";
    private static final String TYPE = "type";
    private static final String XML_FRAGMENT = "<xml-fragment>";
    
    public List<OMRService> parse(String string) throws XmlException, IOException {
        return parse(SparqlDocument.Factory.parse(string));
    }
    
    public List<OMRService> parse(URL url) throws XmlException, IOException {
        return parse(SparqlDocument.Factory.parse(url));
    }
    
    public List<OMRService> parse(InputStream is) throws XmlException, IOException {
        return parse(SparqlDocument.Factory.parse(is));
    }
    
    public List<OMRService> parse(File file) throws XmlException, IOException {
        return parse(SparqlDocument.Factory.parse(file));
    }
    
    public List<OMRService> parse(SparqlDocument sparqlDocument) throws XmlException {
        List<OMRService> omrServices = new ArrayList<OMRService>();
        
        SparqlDocument.Sparql sparql = sparqlDocument.getSparql();
        ResultsDocument.Results results = sparql.getResults();
        for(ResultDocument.Result result : results.getResultList()) {
            OMRService omrs = new OMRService();
            for(BindingDocument.Binding binding : result.getBindingList()) {
                if(SERVICE.equals(binding.getName())) {
                    omrs.setService(binding.getUri());
                } else if(NAME.equals(binding.getName())) {
                    if(binding.getLiteral() != null) {
                        String name = binding.getLiteral().toString();
                        name = name.substring(XML_FRAGMENT.length(), name.length() - XML_FRAGMENT.length() - 1);
                        omrs.setName(name);
                    }
                } else if(DESCRIPTION_URL.equals(binding.getName())) {
                    omrs.setDescriptionUrl(binding.getUri());
                } else if(TYPE.equals(binding.getName())) {
                    omrs.setType(binding.getUri());
                }
            }
            omrServices.add(omrs);
        }
        
        return omrServices;
    }
}
