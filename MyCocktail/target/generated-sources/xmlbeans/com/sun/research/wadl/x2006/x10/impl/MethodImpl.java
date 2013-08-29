/*
 * XML Type:  method
 * Namespace: http://research.sun.com/wadl/2006/10
 * Java type: com.sun.research.wadl.x2006.x10.Method
 *
 * Automatically generated - do not modify.
 */
package com.sun.research.wadl.x2006.x10.impl;
/**
 * An XML method(@http://research.sun.com/wadl/2006/10).
 *
 * This is a complex type.
 */
public class MethodImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.sun.research.wadl.x2006.x10.Method
{
    private static final long serialVersionUID = 1L;
    
    public MethodImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REQUEST$0 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "request");
    private static final javax.xml.namespace.QName RESPONSE$2 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "response");
    private static final javax.xml.namespace.QName NAME$4 = 
        new javax.xml.namespace.QName("", "name");
    private static final javax.xml.namespace.QName ID$6 = 
        new javax.xml.namespace.QName("", "id");
    
    
    /**
     * Gets the "request" element
     */
    public com.sun.research.wadl.x2006.x10.Request getRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Request target = null;
            target = (com.sun.research.wadl.x2006.x10.Request)get_store().find_element_user(REQUEST$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "request" element
     */
    public void setRequest(com.sun.research.wadl.x2006.x10.Request request)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Request target = null;
            target = (com.sun.research.wadl.x2006.x10.Request)get_store().find_element_user(REQUEST$0, 0);
            if (target == null)
            {
                target = (com.sun.research.wadl.x2006.x10.Request)get_store().add_element_user(REQUEST$0);
            }
            target.set(request);
        }
    }
    
    /**
     * Appends and returns a new empty "request" element
     */
    public com.sun.research.wadl.x2006.x10.Request addNewRequest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Request target = null;
            target = (com.sun.research.wadl.x2006.x10.Request)get_store().add_element_user(REQUEST$0);
            return target;
        }
    }
    
    /**
     * Gets the "response" element
     */
    public com.sun.research.wadl.x2006.x10.Response getResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Response target = null;
            target = (com.sun.research.wadl.x2006.x10.Response)get_store().find_element_user(RESPONSE$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "response" element
     */
    public void setResponse(com.sun.research.wadl.x2006.x10.Response response)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Response target = null;
            target = (com.sun.research.wadl.x2006.x10.Response)get_store().find_element_user(RESPONSE$2, 0);
            if (target == null)
            {
                target = (com.sun.research.wadl.x2006.x10.Response)get_store().add_element_user(RESPONSE$2);
            }
            target.set(response);
        }
    }
    
    /**
     * Appends and returns a new empty "response" element
     */
    public com.sun.research.wadl.x2006.x10.Response addNewResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Response target = null;
            target = (com.sun.research.wadl.x2006.x10.Response)get_store().add_element_user(RESPONSE$2);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$4);
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
    public com.sun.research.wadl.x2006.x10.Method2 xgetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Method2 target = null;
            target = (com.sun.research.wadl.x2006.x10.Method2)get_store().find_attribute_user(NAME$4);
            return target;
        }
    }
    
    /**
     * True if has "name" attribute
     */
    public boolean isSetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(NAME$4) != null;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$4);
            }
            target.setStringValue(name);
        }
    }
    
    /**
     * Sets (as xml) the "name" attribute
     */
    public void xsetName(com.sun.research.wadl.x2006.x10.Method2 name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Method2 target = null;
            target = (com.sun.research.wadl.x2006.x10.Method2)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                target = (com.sun.research.wadl.x2006.x10.Method2)get_store().add_attribute_user(NAME$4);
            }
            target.set(name);
        }
    }
    
    /**
     * Unsets the "name" attribute
     */
    public void unsetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(NAME$4);
        }
    }
    
    /**
     * Gets the "id" attribute
     */
    public java.lang.String getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$6);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" attribute
     */
    public org.apache.xmlbeans.XmlString xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$6);
            return target;
        }
    }
    
    /**
     * True if has "id" attribute
     */
    public boolean isSetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(ID$6) != null;
        }
    }
    
    /**
     * Sets the "id" attribute
     */
    public void setId(java.lang.String id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$6);
            }
            target.setStringValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" attribute
     */
    public void xsetId(org.apache.xmlbeans.XmlString id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$6);
            }
            target.set(id);
        }
    }
    
    /**
     * Unsets the "id" attribute
     */
    public void unsetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(ID$6);
        }
    }
}
