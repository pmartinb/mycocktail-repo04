/*
 * An XML document type.
 * Localname: uri
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.UriDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults.impl;
/**
 * A document containing one uri(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public class UriDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.UriDocument
{
    private static final long serialVersionUID = 1L;
    
    public UriDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName URI$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "uri");
    
    
    /**
     * Gets the "uri" element
     */
    public java.lang.String getUri()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(URI$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "uri" element
     */
    public org.apache.xmlbeans.XmlString xgetUri()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(URI$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "uri" element
     */
    public void setUri(java.lang.String uri)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(URI$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(URI$0);
            }
            target.setStringValue(uri);
        }
    }
    
    /**
     * Sets (as xml) the "uri" element
     */
    public void xsetUri(org.apache.xmlbeans.XmlString uri)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(URI$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(URI$0);
            }
            target.set(uri);
        }
    }
}
