/*
 * An XML document type.
 * Localname: literal
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.LiteralDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults.impl;
/**
 * A document containing one literal(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public class LiteralDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.LiteralDocument
{
    private static final long serialVersionUID = 1L;
    
    public LiteralDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LITERAL$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "literal");
    
    
    /**
     * Gets the "literal" element
     */
    public org.w3.x2005.sparqlResults.LiteralDocument.Literal getLiteral()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.LiteralDocument.Literal target = null;
            target = (org.w3.x2005.sparqlResults.LiteralDocument.Literal)get_store().find_element_user(LITERAL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "literal" element
     */
    public void setLiteral(org.w3.x2005.sparqlResults.LiteralDocument.Literal literal)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.LiteralDocument.Literal target = null;
            target = (org.w3.x2005.sparqlResults.LiteralDocument.Literal)get_store().find_element_user(LITERAL$0, 0);
            if (target == null)
            {
                target = (org.w3.x2005.sparqlResults.LiteralDocument.Literal)get_store().add_element_user(LITERAL$0);
            }
            target.set(literal);
        }
    }
    
    /**
     * Appends and returns a new empty "literal" element
     */
    public org.w3.x2005.sparqlResults.LiteralDocument.Literal addNewLiteral()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.LiteralDocument.Literal target = null;
            target = (org.w3.x2005.sparqlResults.LiteralDocument.Literal)get_store().add_element_user(LITERAL$0);
            return target;
        }
    }
    /**
     * An XML literal(@http://www.w3.org/2005/sparql-results#).
     *
     * This is a complex type.
     */
    public static class LiteralImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.LiteralDocument.Literal
    {
        private static final long serialVersionUID = 1L;
        
        public LiteralImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName DATATYPE$0 = 
            new javax.xml.namespace.QName("", "datatype");
        private static final javax.xml.namespace.QName LANG$2 = 
            new javax.xml.namespace.QName("http://www.w3.org/XML/1998/namespace", "lang");
        
        
        /**
         * Gets the "datatype" attribute
         */
        public java.lang.String getDatatype()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DATATYPE$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "datatype" attribute
         */
        public org.w3.x2005.sparqlResults.URIReference xgetDatatype()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.URIReference target = null;
                target = (org.w3.x2005.sparqlResults.URIReference)get_store().find_attribute_user(DATATYPE$0);
                return target;
            }
        }
        
        /**
         * True if has "datatype" attribute
         */
        public boolean isSetDatatype()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(DATATYPE$0) != null;
            }
        }
        
        /**
         * Sets the "datatype" attribute
         */
        public void setDatatype(java.lang.String datatype)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DATATYPE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DATATYPE$0);
                }
                target.setStringValue(datatype);
            }
        }
        
        /**
         * Sets (as xml) the "datatype" attribute
         */
        public void xsetDatatype(org.w3.x2005.sparqlResults.URIReference datatype)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.URIReference target = null;
                target = (org.w3.x2005.sparqlResults.URIReference)get_store().find_attribute_user(DATATYPE$0);
                if (target == null)
                {
                    target = (org.w3.x2005.sparqlResults.URIReference)get_store().add_attribute_user(DATATYPE$0);
                }
                target.set(datatype);
            }
        }
        
        /**
         * Unsets the "datatype" attribute
         */
        public void unsetDatatype()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(DATATYPE$0);
            }
        }
        
        /**
         * Gets the "lang" attribute
         */
        public java.lang.String getLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANG$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "lang" attribute
         */
        public org.apache.xmlbeans.XmlLanguage xgetLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLanguage target = null;
                target = (org.apache.xmlbeans.XmlLanguage)get_store().find_attribute_user(LANG$2);
                return target;
            }
        }
        
        /**
         * True if has "lang" attribute
         */
        public boolean isSetLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(LANG$2) != null;
            }
        }
        
        /**
         * Sets the "lang" attribute
         */
        public void setLang(java.lang.String lang)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(LANG$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(LANG$2);
                }
                target.setStringValue(lang);
            }
        }
        
        /**
         * Sets (as xml) the "lang" attribute
         */
        public void xsetLang(org.apache.xmlbeans.XmlLanguage lang)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLanguage target = null;
                target = (org.apache.xmlbeans.XmlLanguage)get_store().find_attribute_user(LANG$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlLanguage)get_store().add_attribute_user(LANG$2);
                }
                target.set(lang);
            }
        }
        
        /**
         * Unsets the "lang" attribute
         */
        public void unsetLang()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(LANG$2);
            }
        }
    }
}
