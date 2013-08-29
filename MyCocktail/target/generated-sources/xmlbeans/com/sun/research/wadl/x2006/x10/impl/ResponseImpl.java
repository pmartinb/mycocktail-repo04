/*
 * XML Type:  response
 * Namespace: http://research.sun.com/wadl/2006/10
 * Java type: com.sun.research.wadl.x2006.x10.Response
 *
 * Automatically generated - do not modify.
 */
package com.sun.research.wadl.x2006.x10.impl;
/**
 * An XML response(@http://research.sun.com/wadl/2006/10).
 *
 * This is a complex type.
 */
public class ResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.sun.research.wadl.x2006.x10.Response
{
    private static final long serialVersionUID = 1L;
    
    public ResponseImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REPRESENTATION$0 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "representation");
    private static final javax.xml.namespace.QName FAULT$2 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "fault");
    
    
    /**
     * Gets the "representation" element
     */
    public com.sun.research.wadl.x2006.x10.Representation getRepresentation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Representation target = null;
            target = (com.sun.research.wadl.x2006.x10.Representation)get_store().find_element_user(REPRESENTATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "representation" element
     */
    public void setRepresentation(com.sun.research.wadl.x2006.x10.Representation representation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Representation target = null;
            target = (com.sun.research.wadl.x2006.x10.Representation)get_store().find_element_user(REPRESENTATION$0, 0);
            if (target == null)
            {
                target = (com.sun.research.wadl.x2006.x10.Representation)get_store().add_element_user(REPRESENTATION$0);
            }
            target.set(representation);
        }
    }
    
    /**
     * Appends and returns a new empty "representation" element
     */
    public com.sun.research.wadl.x2006.x10.Representation addNewRepresentation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Representation target = null;
            target = (com.sun.research.wadl.x2006.x10.Representation)get_store().add_element_user(REPRESENTATION$0);
            return target;
        }
    }
    
    /**
     * Gets the "fault" element
     */
    public com.sun.research.wadl.x2006.x10.Fault getFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Fault target = null;
            target = (com.sun.research.wadl.x2006.x10.Fault)get_store().find_element_user(FAULT$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "fault" element
     */
    public void setFault(com.sun.research.wadl.x2006.x10.Fault fault)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Fault target = null;
            target = (com.sun.research.wadl.x2006.x10.Fault)get_store().find_element_user(FAULT$2, 0);
            if (target == null)
            {
                target = (com.sun.research.wadl.x2006.x10.Fault)get_store().add_element_user(FAULT$2);
            }
            target.set(fault);
        }
    }
    
    /**
     * Appends and returns a new empty "fault" element
     */
    public com.sun.research.wadl.x2006.x10.Fault addNewFault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Fault target = null;
            target = (com.sun.research.wadl.x2006.x10.Fault)get_store().add_element_user(FAULT$2);
            return target;
        }
    }
}
