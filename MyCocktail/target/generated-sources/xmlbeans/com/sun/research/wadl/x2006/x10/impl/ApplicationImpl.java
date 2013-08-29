/*
 * XML Type:  application
 * Namespace: http://research.sun.com/wadl/2006/10
 * Java type: com.sun.research.wadl.x2006.x10.Application
 *
 * Automatically generated - do not modify.
 */
package com.sun.research.wadl.x2006.x10.impl;
/**
 * An XML application(@http://research.sun.com/wadl/2006/10).
 *
 * This is a complex type.
 */
public class ApplicationImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.sun.research.wadl.x2006.x10.Application
{
    private static final long serialVersionUID = 1L;
    
    public ApplicationImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCES$0 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "resources");
    private static final javax.xml.namespace.QName SCHEMALOCATION$2 = 
        new javax.xml.namespace.QName("", "schemaLocation");
    
    
    /**
     * Gets the "resources" element
     */
    public com.sun.research.wadl.x2006.x10.Resources getResources()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Resources target = null;
            target = (com.sun.research.wadl.x2006.x10.Resources)get_store().find_element_user(RESOURCES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "resources" element
     */
    public void setResources(com.sun.research.wadl.x2006.x10.Resources resources)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Resources target = null;
            target = (com.sun.research.wadl.x2006.x10.Resources)get_store().find_element_user(RESOURCES$0, 0);
            if (target == null)
            {
                target = (com.sun.research.wadl.x2006.x10.Resources)get_store().add_element_user(RESOURCES$0);
            }
            target.set(resources);
        }
    }
    
    /**
     * Appends and returns a new empty "resources" element
     */
    public com.sun.research.wadl.x2006.x10.Resources addNewResources()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Resources target = null;
            target = (com.sun.research.wadl.x2006.x10.Resources)get_store().add_element_user(RESOURCES$0);
            return target;
        }
    }
    
    /**
     * Gets the "schemaLocation" attribute
     */
    public java.lang.String getSchemaLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SCHEMALOCATION$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "schemaLocation" attribute
     */
    public org.apache.xmlbeans.XmlString xgetSchemaLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SCHEMALOCATION$2);
            return target;
        }
    }
    
    /**
     * True if has "schemaLocation" attribute
     */
    public boolean isSetSchemaLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(SCHEMALOCATION$2) != null;
        }
    }
    
    /**
     * Sets the "schemaLocation" attribute
     */
    public void setSchemaLocation(java.lang.String schemaLocation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SCHEMALOCATION$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SCHEMALOCATION$2);
            }
            target.setStringValue(schemaLocation);
        }
    }
    
    /**
     * Sets (as xml) the "schemaLocation" attribute
     */
    public void xsetSchemaLocation(org.apache.xmlbeans.XmlString schemaLocation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SCHEMALOCATION$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SCHEMALOCATION$2);
            }
            target.set(schemaLocation);
        }
    }
    
    /**
     * Unsets the "schemaLocation" attribute
     */
    public void unsetSchemaLocation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(SCHEMALOCATION$2);
        }
    }
}
