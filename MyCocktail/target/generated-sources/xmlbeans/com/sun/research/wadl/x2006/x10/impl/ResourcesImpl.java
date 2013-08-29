/*
 * XML Type:  resources
 * Namespace: http://research.sun.com/wadl/2006/10
 * Java type: com.sun.research.wadl.x2006.x10.Resources
 *
 * Automatically generated - do not modify.
 */
package com.sun.research.wadl.x2006.x10.impl;
/**
 * An XML resources(@http://research.sun.com/wadl/2006/10).
 *
 * This is a complex type.
 */
public class ResourcesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.sun.research.wadl.x2006.x10.Resources
{
    private static final long serialVersionUID = 1L;
    
    public ResourcesImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESOURCE$0 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "resource");
    private static final javax.xml.namespace.QName BASE$2 = 
        new javax.xml.namespace.QName("", "base");
    
    
    /**
     * Gets a List of "resource" elements
     */
    public java.util.List<com.sun.research.wadl.x2006.x10.Resource> getResourceList()
    {
        final class ResourceList extends java.util.AbstractList<com.sun.research.wadl.x2006.x10.Resource>
        {
            public com.sun.research.wadl.x2006.x10.Resource get(int i)
                { return ResourcesImpl.this.getResourceArray(i); }
            
            public com.sun.research.wadl.x2006.x10.Resource set(int i, com.sun.research.wadl.x2006.x10.Resource o)
            {
                com.sun.research.wadl.x2006.x10.Resource old = ResourcesImpl.this.getResourceArray(i);
                ResourcesImpl.this.setResourceArray(i, o);
                return old;
            }
            
            public void add(int i, com.sun.research.wadl.x2006.x10.Resource o)
                { ResourcesImpl.this.insertNewResource(i).set(o); }
            
            public com.sun.research.wadl.x2006.x10.Resource remove(int i)
            {
                com.sun.research.wadl.x2006.x10.Resource old = ResourcesImpl.this.getResourceArray(i);
                ResourcesImpl.this.removeResource(i);
                return old;
            }
            
            public int size()
                { return ResourcesImpl.this.sizeOfResourceArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new ResourceList();
        }
    }
    
    /**
     * Gets array of all "resource" elements
     * @deprecated
     */
    public com.sun.research.wadl.x2006.x10.Resource[] getResourceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<com.sun.research.wadl.x2006.x10.Resource> targetList = new java.util.ArrayList<com.sun.research.wadl.x2006.x10.Resource>();
            get_store().find_all_element_users(RESOURCE$0, targetList);
            com.sun.research.wadl.x2006.x10.Resource[] result = new com.sun.research.wadl.x2006.x10.Resource[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "resource" element
     */
    public com.sun.research.wadl.x2006.x10.Resource getResourceArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Resource target = null;
            target = (com.sun.research.wadl.x2006.x10.Resource)get_store().find_element_user(RESOURCE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "resource" element
     */
    public int sizeOfResourceArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RESOURCE$0);
        }
    }
    
    /**
     * Sets array of all "resource" element
     */
    public void setResourceArray(com.sun.research.wadl.x2006.x10.Resource[] resourceArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(resourceArray, RESOURCE$0);
        }
    }
    
    /**
     * Sets ith "resource" element
     */
    public void setResourceArray(int i, com.sun.research.wadl.x2006.x10.Resource resource)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Resource target = null;
            target = (com.sun.research.wadl.x2006.x10.Resource)get_store().find_element_user(RESOURCE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(resource);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "resource" element
     */
    public com.sun.research.wadl.x2006.x10.Resource insertNewResource(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Resource target = null;
            target = (com.sun.research.wadl.x2006.x10.Resource)get_store().insert_element_user(RESOURCE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "resource" element
     */
    public com.sun.research.wadl.x2006.x10.Resource addNewResource()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Resource target = null;
            target = (com.sun.research.wadl.x2006.x10.Resource)get_store().add_element_user(RESOURCE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "resource" element
     */
    public void removeResource(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RESOURCE$0, i);
        }
    }
    
    /**
     * Gets the "base" attribute
     */
    public java.lang.String getBase()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BASE$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "base" attribute
     */
    public org.apache.xmlbeans.XmlString xgetBase()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(BASE$2);
            return target;
        }
    }
    
    /**
     * True if has "base" attribute
     */
    public boolean isSetBase()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(BASE$2) != null;
        }
    }
    
    /**
     * Sets the "base" attribute
     */
    public void setBase(java.lang.String base)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BASE$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(BASE$2);
            }
            target.setStringValue(base);
        }
    }
    
    /**
     * Sets (as xml) the "base" attribute
     */
    public void xsetBase(org.apache.xmlbeans.XmlString base)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(BASE$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(BASE$2);
            }
            target.set(base);
        }
    }
    
    /**
     * Unsets the "base" attribute
     */
    public void unsetBase()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(BASE$2);
        }
    }
}
