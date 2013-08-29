/*
 * XML Type:  resource
 * Namespace: http://research.sun.com/wadl/2006/10
 * Java type: com.sun.research.wadl.x2006.x10.Resource
 *
 * Automatically generated - do not modify.
 */
package com.sun.research.wadl.x2006.x10.impl;
/**
 * An XML resource(@http://research.sun.com/wadl/2006/10).
 *
 * This is a complex type.
 */
public class ResourceImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.sun.research.wadl.x2006.x10.Resource
{
    private static final long serialVersionUID = 1L;
    
    public ResourceImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PARAM$0 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "param");
    private static final javax.xml.namespace.QName METHOD$2 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "method");
    private static final javax.xml.namespace.QName RESOURCE$4 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "resource");
    private static final javax.xml.namespace.QName PATH$6 = 
        new javax.xml.namespace.QName("", "path");
    
    
    /**
     * Gets a List of "param" elements
     */
    public java.util.List<com.sun.research.wadl.x2006.x10.Param> getParamList()
    {
        final class ParamList extends java.util.AbstractList<com.sun.research.wadl.x2006.x10.Param>
        {
            public com.sun.research.wadl.x2006.x10.Param get(int i)
                { return ResourceImpl.this.getParamArray(i); }
            
            public com.sun.research.wadl.x2006.x10.Param set(int i, com.sun.research.wadl.x2006.x10.Param o)
            {
                com.sun.research.wadl.x2006.x10.Param old = ResourceImpl.this.getParamArray(i);
                ResourceImpl.this.setParamArray(i, o);
                return old;
            }
            
            public void add(int i, com.sun.research.wadl.x2006.x10.Param o)
                { ResourceImpl.this.insertNewParam(i).set(o); }
            
            public com.sun.research.wadl.x2006.x10.Param remove(int i)
            {
                com.sun.research.wadl.x2006.x10.Param old = ResourceImpl.this.getParamArray(i);
                ResourceImpl.this.removeParam(i);
                return old;
            }
            
            public int size()
                { return ResourceImpl.this.sizeOfParamArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new ParamList();
        }
    }
    
    /**
     * Gets array of all "param" elements
     * @deprecated
     */
    public com.sun.research.wadl.x2006.x10.Param[] getParamArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<com.sun.research.wadl.x2006.x10.Param> targetList = new java.util.ArrayList<com.sun.research.wadl.x2006.x10.Param>();
            get_store().find_all_element_users(PARAM$0, targetList);
            com.sun.research.wadl.x2006.x10.Param[] result = new com.sun.research.wadl.x2006.x10.Param[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "param" element
     */
    public com.sun.research.wadl.x2006.x10.Param getParamArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Param target = null;
            target = (com.sun.research.wadl.x2006.x10.Param)get_store().find_element_user(PARAM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "param" element
     */
    public int sizeOfParamArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(PARAM$0);
        }
    }
    
    /**
     * Sets array of all "param" element
     */
    public void setParamArray(com.sun.research.wadl.x2006.x10.Param[] paramArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(paramArray, PARAM$0);
        }
    }
    
    /**
     * Sets ith "param" element
     */
    public void setParamArray(int i, com.sun.research.wadl.x2006.x10.Param param)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Param target = null;
            target = (com.sun.research.wadl.x2006.x10.Param)get_store().find_element_user(PARAM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(param);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "param" element
     */
    public com.sun.research.wadl.x2006.x10.Param insertNewParam(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Param target = null;
            target = (com.sun.research.wadl.x2006.x10.Param)get_store().insert_element_user(PARAM$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "param" element
     */
    public com.sun.research.wadl.x2006.x10.Param addNewParam()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Param target = null;
            target = (com.sun.research.wadl.x2006.x10.Param)get_store().add_element_user(PARAM$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "param" element
     */
    public void removeParam(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(PARAM$0, i);
        }
    }
    
    /**
     * Gets a List of "method" elements
     */
    public java.util.List<com.sun.research.wadl.x2006.x10.Method> getMethodList()
    {
        final class MethodList extends java.util.AbstractList<com.sun.research.wadl.x2006.x10.Method>
        {
            public com.sun.research.wadl.x2006.x10.Method get(int i)
                { return ResourceImpl.this.getMethodArray(i); }
            
            public com.sun.research.wadl.x2006.x10.Method set(int i, com.sun.research.wadl.x2006.x10.Method o)
            {
                com.sun.research.wadl.x2006.x10.Method old = ResourceImpl.this.getMethodArray(i);
                ResourceImpl.this.setMethodArray(i, o);
                return old;
            }
            
            public void add(int i, com.sun.research.wadl.x2006.x10.Method o)
                { ResourceImpl.this.insertNewMethod(i).set(o); }
            
            public com.sun.research.wadl.x2006.x10.Method remove(int i)
            {
                com.sun.research.wadl.x2006.x10.Method old = ResourceImpl.this.getMethodArray(i);
                ResourceImpl.this.removeMethod(i);
                return old;
            }
            
            public int size()
                { return ResourceImpl.this.sizeOfMethodArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new MethodList();
        }
    }
    
    /**
     * Gets array of all "method" elements
     * @deprecated
     */
    public com.sun.research.wadl.x2006.x10.Method[] getMethodArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<com.sun.research.wadl.x2006.x10.Method> targetList = new java.util.ArrayList<com.sun.research.wadl.x2006.x10.Method>();
            get_store().find_all_element_users(METHOD$2, targetList);
            com.sun.research.wadl.x2006.x10.Method[] result = new com.sun.research.wadl.x2006.x10.Method[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "method" element
     */
    public com.sun.research.wadl.x2006.x10.Method getMethodArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Method target = null;
            target = (com.sun.research.wadl.x2006.x10.Method)get_store().find_element_user(METHOD$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "method" element
     */
    public int sizeOfMethodArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(METHOD$2);
        }
    }
    
    /**
     * Sets array of all "method" element
     */
    public void setMethodArray(com.sun.research.wadl.x2006.x10.Method[] methodArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(methodArray, METHOD$2);
        }
    }
    
    /**
     * Sets ith "method" element
     */
    public void setMethodArray(int i, com.sun.research.wadl.x2006.x10.Method method)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Method target = null;
            target = (com.sun.research.wadl.x2006.x10.Method)get_store().find_element_user(METHOD$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(method);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "method" element
     */
    public com.sun.research.wadl.x2006.x10.Method insertNewMethod(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Method target = null;
            target = (com.sun.research.wadl.x2006.x10.Method)get_store().insert_element_user(METHOD$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "method" element
     */
    public com.sun.research.wadl.x2006.x10.Method addNewMethod()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Method target = null;
            target = (com.sun.research.wadl.x2006.x10.Method)get_store().add_element_user(METHOD$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "method" element
     */
    public void removeMethod(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(METHOD$2, i);
        }
    }
    
    /**
     * Gets a List of "resource" elements
     */
    public java.util.List<com.sun.research.wadl.x2006.x10.Resource> getResourceList()
    {
        final class ResourceList extends java.util.AbstractList<com.sun.research.wadl.x2006.x10.Resource>
        {
            public com.sun.research.wadl.x2006.x10.Resource get(int i)
                { return ResourceImpl.this.getResourceArray(i); }
            
            public com.sun.research.wadl.x2006.x10.Resource set(int i, com.sun.research.wadl.x2006.x10.Resource o)
            {
                com.sun.research.wadl.x2006.x10.Resource old = ResourceImpl.this.getResourceArray(i);
                ResourceImpl.this.setResourceArray(i, o);
                return old;
            }
            
            public void add(int i, com.sun.research.wadl.x2006.x10.Resource o)
                { ResourceImpl.this.insertNewResource(i).set(o); }
            
            public com.sun.research.wadl.x2006.x10.Resource remove(int i)
            {
                com.sun.research.wadl.x2006.x10.Resource old = ResourceImpl.this.getResourceArray(i);
                ResourceImpl.this.removeResource(i);
                return old;
            }
            
            public int size()
                { return ResourceImpl.this.sizeOfResourceArray(); }
            
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
            get_store().find_all_element_users(RESOURCE$4, targetList);
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
            target = (com.sun.research.wadl.x2006.x10.Resource)get_store().find_element_user(RESOURCE$4, i);
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
            return get_store().count_elements(RESOURCE$4);
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
            arraySetterHelper(resourceArray, RESOURCE$4);
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
            target = (com.sun.research.wadl.x2006.x10.Resource)get_store().find_element_user(RESOURCE$4, i);
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
            target = (com.sun.research.wadl.x2006.x10.Resource)get_store().insert_element_user(RESOURCE$4, i);
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
            target = (com.sun.research.wadl.x2006.x10.Resource)get_store().add_element_user(RESOURCE$4);
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
            get_store().remove_element(RESOURCE$4, i);
        }
    }
    
    /**
     * Gets the "path" attribute
     */
    public java.lang.String getPath()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PATH$6);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "path" attribute
     */
    public org.apache.xmlbeans.XmlString xgetPath()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PATH$6);
            return target;
        }
    }
    
    /**
     * True if has "path" attribute
     */
    public boolean isSetPath()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(PATH$6) != null;
        }
    }
    
    /**
     * Sets the "path" attribute
     */
    public void setPath(java.lang.String path)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PATH$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PATH$6);
            }
            target.setStringValue(path);
        }
    }
    
    /**
     * Sets (as xml) the "path" attribute
     */
    public void xsetPath(org.apache.xmlbeans.XmlString path)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PATH$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PATH$6);
            }
            target.set(path);
        }
    }
    
    /**
     * Unsets the "path" attribute
     */
    public void unsetPath()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(PATH$6);
        }
    }
}
