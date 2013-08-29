/*
 * XML Type:  param
 * Namespace: http://research.sun.com/wadl/2006/10
 * Java type: com.sun.research.wadl.x2006.x10.Param
 *
 * Automatically generated - do not modify.
 */
package com.sun.research.wadl.x2006.x10.impl;
/**
 * An XML param(@http://research.sun.com/wadl/2006/10).
 *
 * This is a complex type.
 */
public class ParamImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.sun.research.wadl.x2006.x10.Param
{
    private static final long serialVersionUID = 1L;
    
    public ParamImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OPTION$0 = 
        new javax.xml.namespace.QName("http://research.sun.com/wadl/2006/10", "option");
    private static final javax.xml.namespace.QName NAME$2 = 
        new javax.xml.namespace.QName("", "name");
    private static final javax.xml.namespace.QName TYPE$4 = 
        new javax.xml.namespace.QName("", "type");
    private static final javax.xml.namespace.QName STYLE$6 = 
        new javax.xml.namespace.QName("", "style");
    private static final javax.xml.namespace.QName REQUIRED$8 = 
        new javax.xml.namespace.QName("", "required");
    private static final javax.xml.namespace.QName FIXED$10 = 
        new javax.xml.namespace.QName("", "fixed");
    private static final javax.xml.namespace.QName DEFAULT$12 = 
        new javax.xml.namespace.QName("", "default");
    
    
    /**
     * Gets a List of "option" elements
     */
    public java.util.List<com.sun.research.wadl.x2006.x10.Option> getOptionList()
    {
        final class OptionList extends java.util.AbstractList<com.sun.research.wadl.x2006.x10.Option>
        {
            public com.sun.research.wadl.x2006.x10.Option get(int i)
                { return ParamImpl.this.getOptionArray(i); }
            
            public com.sun.research.wadl.x2006.x10.Option set(int i, com.sun.research.wadl.x2006.x10.Option o)
            {
                com.sun.research.wadl.x2006.x10.Option old = ParamImpl.this.getOptionArray(i);
                ParamImpl.this.setOptionArray(i, o);
                return old;
            }
            
            public void add(int i, com.sun.research.wadl.x2006.x10.Option o)
                { ParamImpl.this.insertNewOption(i).set(o); }
            
            public com.sun.research.wadl.x2006.x10.Option remove(int i)
            {
                com.sun.research.wadl.x2006.x10.Option old = ParamImpl.this.getOptionArray(i);
                ParamImpl.this.removeOption(i);
                return old;
            }
            
            public int size()
                { return ParamImpl.this.sizeOfOptionArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new OptionList();
        }
    }
    
    /**
     * Gets array of all "option" elements
     * @deprecated
     */
    public com.sun.research.wadl.x2006.x10.Option[] getOptionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List<com.sun.research.wadl.x2006.x10.Option> targetList = new java.util.ArrayList<com.sun.research.wadl.x2006.x10.Option>();
            get_store().find_all_element_users(OPTION$0, targetList);
            com.sun.research.wadl.x2006.x10.Option[] result = new com.sun.research.wadl.x2006.x10.Option[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "option" element
     */
    public com.sun.research.wadl.x2006.x10.Option getOptionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Option target = null;
            target = (com.sun.research.wadl.x2006.x10.Option)get_store().find_element_user(OPTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "option" element
     */
    public int sizeOfOptionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OPTION$0);
        }
    }
    
    /**
     * Sets array of all "option" element
     */
    public void setOptionArray(com.sun.research.wadl.x2006.x10.Option[] optionArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(optionArray, OPTION$0);
        }
    }
    
    /**
     * Sets ith "option" element
     */
    public void setOptionArray(int i, com.sun.research.wadl.x2006.x10.Option option)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Option target = null;
            target = (com.sun.research.wadl.x2006.x10.Option)get_store().find_element_user(OPTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(option);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "option" element
     */
    public com.sun.research.wadl.x2006.x10.Option insertNewOption(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Option target = null;
            target = (com.sun.research.wadl.x2006.x10.Option)get_store().insert_element_user(OPTION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "option" element
     */
    public com.sun.research.wadl.x2006.x10.Option addNewOption()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.Option target = null;
            target = (com.sun.research.wadl.x2006.x10.Option)get_store().add_element_user(OPTION$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "option" element
     */
    public void removeOption(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OPTION$0, i);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
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
    public org.apache.xmlbeans.XmlString xgetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$2);
            }
            target.setStringValue(name);
        }
    }
    
    /**
     * Sets (as xml) the "name" attribute
     */
    public void xsetName(org.apache.xmlbeans.XmlString name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$2);
            }
            target.set(name);
        }
    }
    
    /**
     * Gets the "type" attribute
     */
    public java.lang.String getType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "type" attribute
     */
    public org.apache.xmlbeans.XmlString xgetType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TYPE$4);
            return target;
        }
    }
    
    /**
     * Sets the "type" attribute
     */
    public void setType(java.lang.String type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TYPE$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TYPE$4);
            }
            target.setStringValue(type);
        }
    }
    
    /**
     * Sets (as xml) the "type" attribute
     */
    public void xsetType(org.apache.xmlbeans.XmlString type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TYPE$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TYPE$4);
            }
            target.set(type);
        }
    }
    
    /**
     * Gets the "style" attribute
     */
    public com.sun.research.wadl.x2006.x10.ParamStyle.Enum getStyle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STYLE$6);
            if (target == null)
            {
                return null;
            }
            return (com.sun.research.wadl.x2006.x10.ParamStyle.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "style" attribute
     */
    public com.sun.research.wadl.x2006.x10.ParamStyle xgetStyle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.ParamStyle target = null;
            target = (com.sun.research.wadl.x2006.x10.ParamStyle)get_store().find_attribute_user(STYLE$6);
            return target;
        }
    }
    
    /**
     * True if has "style" attribute
     */
    public boolean isSetStyle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(STYLE$6) != null;
        }
    }
    
    /**
     * Sets the "style" attribute
     */
    public void setStyle(com.sun.research.wadl.x2006.x10.ParamStyle.Enum style)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(STYLE$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(STYLE$6);
            }
            target.setEnumValue(style);
        }
    }
    
    /**
     * Sets (as xml) the "style" attribute
     */
    public void xsetStyle(com.sun.research.wadl.x2006.x10.ParamStyle style)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.sun.research.wadl.x2006.x10.ParamStyle target = null;
            target = (com.sun.research.wadl.x2006.x10.ParamStyle)get_store().find_attribute_user(STYLE$6);
            if (target == null)
            {
                target = (com.sun.research.wadl.x2006.x10.ParamStyle)get_store().add_attribute_user(STYLE$6);
            }
            target.set(style);
        }
    }
    
    /**
     * Unsets the "style" attribute
     */
    public void unsetStyle()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(STYLE$6);
        }
    }
    
    /**
     * Gets the "required" attribute
     */
    public boolean getRequired()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REQUIRED$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(REQUIRED$8);
            }
            if (target == null)
            {
                return false;
            }
            return target.getBooleanValue();
        }
    }
    
    /**
     * Gets (as xml) the "required" attribute
     */
    public org.apache.xmlbeans.XmlBoolean xgetRequired()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(REQUIRED$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_default_attribute_value(REQUIRED$8);
            }
            return target;
        }
    }
    
    /**
     * True if has "required" attribute
     */
    public boolean isSetRequired()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(REQUIRED$8) != null;
        }
    }
    
    /**
     * Sets the "required" attribute
     */
    public void setRequired(boolean required)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REQUIRED$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REQUIRED$8);
            }
            target.setBooleanValue(required);
        }
    }
    
    /**
     * Sets (as xml) the "required" attribute
     */
    public void xsetRequired(org.apache.xmlbeans.XmlBoolean required)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlBoolean target = null;
            target = (org.apache.xmlbeans.XmlBoolean)get_store().find_attribute_user(REQUIRED$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlBoolean)get_store().add_attribute_user(REQUIRED$8);
            }
            target.set(required);
        }
    }
    
    /**
     * Unsets the "required" attribute
     */
    public void unsetRequired()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(REQUIRED$8);
        }
    }
    
    /**
     * Gets the "fixed" attribute
     */
    public java.lang.String getFixed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FIXED$10);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "fixed" attribute
     */
    public org.apache.xmlbeans.XmlString xgetFixed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(FIXED$10);
            return target;
        }
    }
    
    /**
     * True if has "fixed" attribute
     */
    public boolean isSetFixed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(FIXED$10) != null;
        }
    }
    
    /**
     * Sets the "fixed" attribute
     */
    public void setFixed(java.lang.String fixed)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FIXED$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(FIXED$10);
            }
            target.setStringValue(fixed);
        }
    }
    
    /**
     * Sets (as xml) the "fixed" attribute
     */
    public void xsetFixed(org.apache.xmlbeans.XmlString fixed)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(FIXED$10);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(FIXED$10);
            }
            target.set(fixed);
        }
    }
    
    /**
     * Unsets the "fixed" attribute
     */
    public void unsetFixed()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(FIXED$10);
        }
    }
    
    /**
     * Gets the "default" attribute
     */
    public java.lang.String getDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULT$12);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "default" attribute
     */
    public org.apache.xmlbeans.XmlString xgetDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DEFAULT$12);
            return target;
        }
    }
    
    /**
     * True if has "default" attribute
     */
    public boolean isSetDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(DEFAULT$12) != null;
        }
    }
    
    /**
     * Sets the "default" attribute
     */
    public void setDefault(java.lang.String xdefault)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DEFAULT$12);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DEFAULT$12);
            }
            target.setStringValue(xdefault);
        }
    }
    
    /**
     * Sets (as xml) the "default" attribute
     */
    public void xsetDefault(org.apache.xmlbeans.XmlString xdefault)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(DEFAULT$12);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(DEFAULT$12);
            }
            target.set(xdefault);
        }
    }
    
    /**
     * Unsets the "default" attribute
     */
    public void unsetDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(DEFAULT$12);
        }
    }
}
