/*
 * An XML document type.
 * Localname: application
 * Namespace: http://research.sun.com/wadl/2006/10
 * Java type: com.sun.research.wadl.x2006.x10.ApplicationDocument
 *
 * Automatically generated - do not modify.
 */
package com.sun.research.wadl.x2006.x10.impl;
/**
 * A document containing one application(@http://research.sun.com/wadl/2006/10) element.
 *
 * This is a complex type.
 */
public class ApplicationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.sun.research.wadl.x2006.x10.ApplicationDocument
{
    private static final long serialVersionUID = 1L;
    
    public ApplicationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName APPLICATION$0 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "application");
    
    
    /**
     * Gets the "application" element
     */
    public com.sun.research.wadl.x2006.x10.Application getApplication()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Application target = null;
            target = (com.sun.research.wadl.x2006.x10.Application)get_store().find_element_user(APPLICATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "application" element
     */
    public void setApplication(com.sun.research.wadl.x2006.x10.Application application)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Application target = null;
            target = (com.sun.research.wadl.x2006.x10.Application)get_store().find_element_user(APPLICATION$0, 0);
            if (target == null)
            {
                target = (com.sun.research.wadl.x2006.x10.Application)get_store().add_element_user(APPLICATION$0);
            }
            target.set(application);
        }
    }
    
    /**
     * Appends and returns a new empty "application" element
     */
    public com.sun.research.wadl.x2006.x10.Application addNewApplication()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Application target = null;
            target = (com.sun.research.wadl.x2006.x10.Application)get_store().add_element_user(APPLICATION$0);
            return target;
        }
    }
}
