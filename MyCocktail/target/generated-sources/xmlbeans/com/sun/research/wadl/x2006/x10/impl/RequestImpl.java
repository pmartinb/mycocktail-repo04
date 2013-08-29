/*
 * XML Type:  request
 * Namespace: http://research.sun.com/wadl/2006/10
 * Java type: com.sun.research.wadl.x2006.x10.Request
 *
 * Automatically generated - do not modify.
 */
package com.sun.research.wadl.x2006.x10.impl;
/**
 * An XML request(@http://research.sun.com/wadl/2006/10).
 *
 * This is a complex type.
 */
public class RequestImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.sun.research.wadl.x2006.x10.Request
{
    private static final long serialVersionUID = 1L;
    
    public RequestImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PARAM$0 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "param");
    
    
    /**
     * Gets a List of "param" elements
     */
    public java.util.List<com.sun.research.wadl.x2006.x10.Param> getParamList()
    {
        final class ParamList extends java.util.AbstractList<com.sun.research.wadl.x2006.x10.Param>
        {
            public com.sun.research.wadl.x2006.x10.Param get(int i)
                { return RequestImpl.this.getParamArray(i); }
            
            public com.sun.research.wadl.x2006.x10.Param set(int i, com.sun.research.wadl.x2006.x10.Param o)
            {
                com.sun.research.wadl.x2006.x10.Param old = RequestImpl.this.getParamArray(i);
                RequestImpl.this.setParamArray(i, o);
                return old;
            }
            
            public void add(int i, com.sun.research.wadl.x2006.x10.Param o)
                { RequestImpl.this.insertNewParam(i).set(o); }
            
            public com.sun.research.wadl.x2006.x10.Param remove(int i)
            {
                com.sun.research.wadl.x2006.x10.Param old = RequestImpl.this.getParamArray(i);
                RequestImpl.this.removeParam(i);
                return old;
            }
            
            public int size()
                { return RequestImpl.this.sizeOfParamArray(); }
            
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
}
