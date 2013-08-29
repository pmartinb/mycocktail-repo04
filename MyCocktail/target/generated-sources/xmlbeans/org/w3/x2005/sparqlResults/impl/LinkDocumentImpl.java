/*
 * An XML document type.
 * Localname: link
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.LinkDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults.impl;
/**
 * A document containing one link(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public class LinkDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.LinkDocument
{
    private static final long serialVersionUID = 1L;
    
    public LinkDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LINK$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "link");
    
    
    /**
     * Gets the "link" element
     */
    public org.w3.x2005.sparqlResults.LinkDocument.Link getLink()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.LinkDocument.Link target = null;
            target = (org.w3.x2005.sparqlResults.LinkDocument.Link)get_store().find_element_user(LINK$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "link" element
     */
    public void setLink(org.w3.x2005.sparqlResults.LinkDocument.Link link)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.LinkDocument.Link target = null;
            target = (org.w3.x2005.sparqlResults.LinkDocument.Link)get_store().find_element_user(LINK$0, 0);
            if (target == null)
            {
                target = (org.w3.x2005.sparqlResults.LinkDocument.Link)get_store().add_element_user(LINK$0);
            }
            target.set(link);
        }
    }
    
    /**
     * Appends and returns a new empty "link" element
     */
    public org.w3.x2005.sparqlResults.LinkDocument.Link addNewLink()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.LinkDocument.Link target = null;
            target = (org.w3.x2005.sparqlResults.LinkDocument.Link)get_store().add_element_user(LINK$0);
            return target;
        }
    }
    /**
     * An XML link(@http://www.w3.org/2005/sparql-results#).
     *
     * This is a complex type.
     */
    public static class LinkImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.LinkDocument.Link
    {
        private static final long serialVersionUID = 1L;
        
        public LinkImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName HREF$0 = 
            new javax.xml.namespace.QName("", "href");
        
        
        /**
         * Gets the "href" attribute
         */
        public java.lang.String getHref()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HREF$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "href" attribute
         */
        public org.w3.x2005.sparqlResults.URIReference xgetHref()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.URIReference target = null;
                target = (org.w3.x2005.sparqlResults.URIReference)get_store().find_attribute_user(HREF$0);
                return target;
            }
        }
        
        /**
         * Sets the "href" attribute
         */
        public void setHref(java.lang.String href)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(HREF$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(HREF$0);
                }
                target.setStringValue(href);
            }
        }
        
        /**
         * Sets (as xml) the "href" attribute
         */
        public void xsetHref(org.w3.x2005.sparqlResults.URIReference href)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.URIReference target = null;
                target = (org.w3.x2005.sparqlResults.URIReference)get_store().find_attribute_user(HREF$0);
                if (target == null)
                {
                    target = (org.w3.x2005.sparqlResults.URIReference)get_store().add_attribute_user(HREF$0);
                }
                target.set(href);
            }
        }
    }
}
