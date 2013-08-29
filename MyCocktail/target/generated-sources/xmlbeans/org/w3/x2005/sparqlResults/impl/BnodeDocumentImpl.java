/*
 * An XML document type.
 * Localname: bnode
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.BnodeDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults.impl;
/**
 * A document containing one bnode(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public class BnodeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.BnodeDocument
{
    private static final long serialVersionUID = 1L;
    
    public BnodeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BNODE$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "bnode");
    
    
    /**
     * Gets the "bnode" element
     */
    public java.lang.String getBnode()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BNODE$0, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BNODE$0, 0);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BNODE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BNODE$0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(BNODE$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(BNODE$0);
            }
            target.set(bnode);
        }
    }
}
