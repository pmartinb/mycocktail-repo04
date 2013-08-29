/*
 * An XML document type.
 * Localname: binding
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.BindingDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults.impl;
/**
 * A document containing one binding(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public class BindingDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.BindingDocument
{
    private static final long serialVersionUID = 1L;
    
    public BindingDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BINDING$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "binding");
    
    
    /**
     * Gets the "binding" element
     */
    public org.w3.x2005.sparqlResults.BindingDocument.Binding getBinding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.BindingDocument.Binding target = null;
            target = (org.w3.x2005.sparqlResults.BindingDocument.Binding)get_store().find_element_user(BINDING$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "binding" element
     */
    public void setBinding(org.w3.x2005.sparqlResults.BindingDocument.Binding binding)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.BindingDocument.Binding target = null;
            target = (org.w3.x2005.sparqlResults.BindingDocument.Binding)get_store().find_element_user(BINDING$0, 0);
            if (target == null)
            {
                target = (org.w3.x2005.sparqlResults.BindingDocument.Binding)get_store().add_element_user(BINDING$0);
            }
            target.set(binding);
        }
    }
    
    /**
     * Appends and returns a new empty "binding" element
     */
    public org.w3.x2005.sparqlResults.BindingDocument.Binding addNewBinding()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.BindingDocument.Binding target = null;
            target = (org.w3.x2005.sparqlResults.BindingDocument.Binding)get_store().add_element_user(BINDING$0);
            return target;
        }
    }
    /**
     * An XML binding(@http://www.w3.org/2005/sparql-results#).
     *
     * This is a complex type.
     */
    public static class BindingImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.BindingDocument.Binding
    {
        private static final long serialVersionUID = 1L;
        
        public BindingImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName URI$0 = 
            new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "uri");
        private static final javax.xml.namespace.QName BNODE$2 = 
            new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "bnode");
        private static final javax.xml.namespace.QName LITERAL$4 = 
            new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "literal");
        private static final javax.xml.namespace.QName NAME$6 = 
            new javax.xml.namespace.QName("", "name");
        
        
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
         * True if has "uri" element
         */
        public boolean isSetUri()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(URI$0) != 0;
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
        
        /**
         * Unsets the "uri" element
         */
        public void unsetUri()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(URI$0, 0);
            }
        }
        
        /**
         * Gets the "bnode" element
         */
        public java.lang.String getBnode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BNODE$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "bnode" element
         */
        public org.apache.xmlbeans.XmlString xgetBnode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BNODE$2, 0);
                return target;
            }
        }
        
        /**
         * True if has "bnode" element
         */
        public boolean isSetBnode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(BNODE$2) != 0;
            }
        }
        
        /**
         * Sets the "bnode" element
         */
        public void setBnode(java.lang.String bnode)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BNODE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BNODE$2);
                }
                target.setStringValue(bnode);
            }
        }
        
        /**
         * Sets (as xml) the "bnode" element
         */
        public void xsetBnode(org.apache.xmlbeans.XmlString bnode)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BNODE$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(BNODE$2);
                }
                target.set(bnode);
            }
        }
        
        /**
         * Unsets the "bnode" element
         */
        public void unsetBnode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(BNODE$2, 0);
            }
        }
        
        /**
         * Gets the "literal" element
         */
        public org.w3.x2005.sparqlResults.LiteralDocument.Literal getLiteral()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.LiteralDocument.Literal target = null;
                target = (org.w3.x2005.sparqlResults.LiteralDocument.Literal)get_store().find_element_user(LITERAL$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "literal" element
         */
        public boolean isSetLiteral()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(LITERAL$4) != 0;
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
                target = (org.w3.x2005.sparqlResults.LiteralDocument.Literal)get_store().find_element_user(LITERAL$4, 0);
                if (target == null)
                {
                    target = (org.w3.x2005.sparqlResults.LiteralDocument.Literal)get_store().add_element_user(LITERAL$4);
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
                target = (org.w3.x2005.sparqlResults.LiteralDocument.Literal)get_store().add_element_user(LITERAL$4);
                return target;
            }
        }
        
        /**
         * Unsets the "literal" element
         */
        public void unsetLiteral()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(LITERAL$4, 0);
            }
        }
        
        /**
         * Gets the "name" attribute
         */
        public java.lang.String getName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$6);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "name" attribute
         */
        public org.apache.xmlbeans.XmlNMTOKEN xgetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlNMTOKEN target = null;
                target = (org.apache.xmlbeans.XmlNMTOKEN)get_store().find_attribute_user(NAME$6);
                return target;
            }
        }
        
        /**
         * Sets the "name" attribute
         */
        public void setName(java.lang.String name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$6);
                }
                target.setStringValue(name);
            }
        }
        
        /**
         * Sets (as xml) the "name" attribute
         */
        public void xsetName(org.apache.xmlbeans.XmlNMTOKEN name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlNMTOKEN target = null;
                target = (org.apache.xmlbeans.XmlNMTOKEN)get_store().find_attribute_user(NAME$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlNMTOKEN)get_store().add_attribute_user(NAME$6);
                }
                target.set(name);
            }
        }
    }
}
