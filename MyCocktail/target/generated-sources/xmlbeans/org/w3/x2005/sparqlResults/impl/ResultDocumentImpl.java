/*
 * An XML document type.
 * Localname: result
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.ResultDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults.impl;
/**
 * A document containing one result(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public class ResultDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.ResultDocument
{
    private static final long serialVersionUID = 1L;
    
    public ResultDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESULT$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "result");
    
    
    /**
     * Gets the "result" element
     */
    public org.w3.x2005.sparqlResults.ResultDocument.Result getResult()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.ResultDocument.Result target = null;
            target = (org.w3.x2005.sparqlResults.ResultDocument.Result)get_store().find_element_user(RESULT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "result" element
     */
    public void setResult(org.w3.x2005.sparqlResults.ResultDocument.Result result)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.ResultDocument.Result target = null;
            target = (org.w3.x2005.sparqlResults.ResultDocument.Result)get_store().find_element_user(RESULT$0, 0);
            if (target == null)
            {
                target = (org.w3.x2005.sparqlResults.ResultDocument.Result)get_store().add_element_user(RESULT$0);
            }
            target.set(result);
        }
    }
    
    /**
     * Appends and returns a new empty "result" element
     */
    public org.w3.x2005.sparqlResults.ResultDocument.Result addNewResult()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.ResultDocument.Result target = null;
            target = (org.w3.x2005.sparqlResults.ResultDocument.Result)get_store().add_element_user(RESULT$0);
            return target;
        }
    }
    /**
     * An XML result(@http://www.w3.org/2005/sparql-results#).
     *
     * This is a complex type.
     */
    public static class ResultImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.ResultDocument.Result
    {
        private static final long serialVersionUID = 1L;
        
        public ResultImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName BINDING$0 = 
            new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "binding");
        private static final javax.xml.namespace.QName INDEX$2 = 
            new javax.xml.namespace.QName("", "index");
        
        
        /**
         * Gets a List of "binding" elements
         */
        public java.util.List<org.w3.x2005.sparqlResults.BindingDocument.Binding> getBindingList()
        {
            final class BindingList extends java.util.AbstractList<org.w3.x2005.sparqlResults.BindingDocument.Binding>
            {
                public org.w3.x2005.sparqlResults.BindingDocument.Binding get(int i)
                    { return ResultImpl.this.getBindingArray(i); }
                
                public org.w3.x2005.sparqlResults.BindingDocument.Binding set(int i, org.w3.x2005.sparqlResults.BindingDocument.Binding o)
                {
                    org.w3.x2005.sparqlResults.BindingDocument.Binding old = ResultImpl.this.getBindingArray(i);
                    ResultImpl.this.setBindingArray(i, o);
                    return old;
                }
                
                public void add(int i, org.w3.x2005.sparqlResults.BindingDocument.Binding o)
                    { ResultImpl.this.insertNewBinding(i).set(o); }
                
                public org.w3.x2005.sparqlResults.BindingDocument.Binding remove(int i)
                {
                    org.w3.x2005.sparqlResults.BindingDocument.Binding old = ResultImpl.this.getBindingArray(i);
                    ResultImpl.this.removeBinding(i);
                    return old;
                }
                
                public int size()
                    { return ResultImpl.this.sizeOfBindingArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new BindingList();
            }
        }
        
        /**
         * Gets array of all "binding" elements
         * @deprecated
         */
        public org.w3.x2005.sparqlResults.BindingDocument.Binding[] getBindingArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.w3.x2005.sparqlResults.BindingDocument.Binding> targetList = new java.util.ArrayList<org.w3.x2005.sparqlResults.BindingDocument.Binding>();
                get_store().find_all_element_users(BINDING$0, targetList);
                org.w3.x2005.sparqlResults.BindingDocument.Binding[] result = new org.w3.x2005.sparqlResults.BindingDocument.Binding[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "binding" element
         */
        public org.w3.x2005.sparqlResults.BindingDocument.Binding getBindingArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.BindingDocument.Binding target = null;
                target = (org.w3.x2005.sparqlResults.BindingDocument.Binding)get_store().find_element_user(BINDING$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "binding" element
         */
        public int sizeOfBindingArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(BINDING$0);
            }
        }
        
        /**
         * Sets array of all "binding" element
         */
        public void setBindingArray(org.w3.x2005.sparqlResults.BindingDocument.Binding[] bindingArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(bindingArray, BINDING$0);
            }
        }
        
        /**
         * Sets ith "binding" element
         */
        public void setBindingArray(int i, org.w3.x2005.sparqlResults.BindingDocument.Binding binding)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.BindingDocument.Binding target = null;
                target = (org.w3.x2005.sparqlResults.BindingDocument.Binding)get_store().find_element_user(BINDING$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(binding);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "binding" element
         */
        public org.w3.x2005.sparqlResults.BindingDocument.Binding insertNewBinding(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.BindingDocument.Binding target = null;
                target = (org.w3.x2005.sparqlResults.BindingDocument.Binding)get_store().insert_element_user(BINDING$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "binding" element
         */
        public org.w3.x2005.sparqlResults.BindingDocument.Binding addNewBinding()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.BindingDocument.Binding target = null;
                target = (org.w3.x2005.sparqlResults.BindingDocument.Binding)get_store().add_element_user(BINDING$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "binding" element
         */
        public void removeBinding(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(BINDING$0, i);
            }
        }
        
        /**
         * Gets the "index" attribute
         */
        public java.math.BigInteger getIndex()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(INDEX$2);
                if (target == null)
                {
                    return null;
                }
                return target.getBigIntegerValue();
            }
        }
        
        /**
         * Gets (as xml) the "index" attribute
         */
        public org.apache.xmlbeans.XmlPositiveInteger xgetIndex()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlPositiveInteger target = null;
                target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().find_attribute_user(INDEX$2);
                return target;
            }
        }
        
        /**
         * True if has "index" attribute
         */
        public boolean isSetIndex()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(INDEX$2) != null;
            }
        }
        
        /**
         * Sets the "index" attribute
         */
        public void setIndex(java.math.BigInteger index)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(INDEX$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(INDEX$2);
                }
                target.setBigIntegerValue(index);
            }
        }
        
        /**
         * Sets (as xml) the "index" attribute
         */
        public void xsetIndex(org.apache.xmlbeans.XmlPositiveInteger index)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlPositiveInteger target = null;
                target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().find_attribute_user(INDEX$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlPositiveInteger)get_store().add_attribute_user(INDEX$2);
                }
                target.set(index);
            }
        }
        
        /**
         * Unsets the "index" attribute
         */
        public void unsetIndex()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(INDEX$2);
            }
        }
    }
}
