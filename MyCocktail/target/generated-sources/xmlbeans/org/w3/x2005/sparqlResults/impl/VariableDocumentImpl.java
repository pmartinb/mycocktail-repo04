/*
 * An XML document type.
 * Localname: variable
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.VariableDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults.impl;
/**
 * A document containing one variable(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public class VariableDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.VariableDocument
{
    private static final long serialVersionUID = 1L;
    
    public VariableDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VARIABLE$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "variable");
    
    
    /**
     * Gets the "variable" element
     */
    public org.w3.x2005.sparqlResults.VariableDocument.Variable getVariable()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.VariableDocument.Variable target = null;
            target = (org.w3.x2005.sparqlResults.VariableDocument.Variable)get_store().find_element_user(VARIABLE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "variable" element
     */
    public void setVariable(org.w3.x2005.sparqlResults.VariableDocument.Variable variable)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.VariableDocument.Variable target = null;
            target = (org.w3.x2005.sparqlResults.VariableDocument.Variable)get_store().find_element_user(VARIABLE$0, 0);
            if (target == null)
            {
                target = (org.w3.x2005.sparqlResults.VariableDocument.Variable)get_store().add_element_user(VARIABLE$0);
            }
            target.set(variable);
        }
    }
    
    /**
     * Appends and returns a new empty "variable" element
     */
    public org.w3.x2005.sparqlResults.VariableDocument.Variable addNewVariable()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.VariableDocument.Variable target = null;
            target = (org.w3.x2005.sparqlResults.VariableDocument.Variable)get_store().add_element_user(VARIABLE$0);
            return target;
        }
    }
    /**
     * An XML variable(@http://www.w3.org/2005/sparql-results#).
     *
     * This is a complex type.
     */
    public static class VariableImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.VariableDocument.Variable
    {
        private static final long serialVersionUID = 1L;
        
        public VariableImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAME$0 = 
            new javax.xml.namespace.QName("", "name");
        
        
        /**
         * Gets the "name" attribute
         */
        public java.lang.String getName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$0);
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
                target = (org.apache.xmlbeans.XmlNMTOKEN)get_store().find_attribute_user(NAME$0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$0);
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
                target = (org.apache.xmlbeans.XmlNMTOKEN)get_store().find_attribute_user(NAME$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlNMTOKEN)get_store().add_attribute_user(NAME$0);
                }
                target.set(name);
            }
        }
    }
}
