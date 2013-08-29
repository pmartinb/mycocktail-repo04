/*
 * An XML document type.
 * Localname: head
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.HeadDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults.impl;
/**
 * A document containing one head(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public class HeadDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.HeadDocument
{
    private static final long serialVersionUID = 1L;
    
    public HeadDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName HEAD$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "head");
    
    
    /**
     * Gets the "head" element
     */
    public org.w3.x2005.sparqlResults.HeadDocument.Head getHead()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.HeadDocument.Head target = null;
            target = (org.w3.x2005.sparqlResults.HeadDocument.Head)get_store().find_element_user(HEAD$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "head" element
     */
    public void setHead(org.w3.x2005.sparqlResults.HeadDocument.Head head)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.HeadDocument.Head target = null;
            target = (org.w3.x2005.sparqlResults.HeadDocument.Head)get_store().find_element_user(HEAD$0, 0);
            if (target == null)
            {
                target = (org.w3.x2005.sparqlResults.HeadDocument.Head)get_store().add_element_user(HEAD$0);
            }
            target.set(head);
        }
    }
    
    /**
     * Appends and returns a new empty "head" element
     */
    public org.w3.x2005.sparqlResults.HeadDocument.Head addNewHead()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.HeadDocument.Head target = null;
            target = (org.w3.x2005.sparqlResults.HeadDocument.Head)get_store().add_element_user(HEAD$0);
            return target;
        }
    }
    /**
     * An XML head(@http://www.w3.org/2005/sparql-results#).
     *
     * This is a complex type.
     */
    public static class HeadImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.HeadDocument.Head
    {
        private static final long serialVersionUID = 1L;
        
        public HeadImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName VARIABLE$0 = 
            new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "variable");
        private static final javax.xml.namespace.QName LINK$2 = 
            new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "link");
        
        
        /**
         * Gets a List of "variable" elements
         */
        public java.util.List<org.w3.x2005.sparqlResults.VariableDocument.Variable> getVariableList()
        {
            final class VariableList extends java.util.AbstractList<org.w3.x2005.sparqlResults.VariableDocument.Variable>
            {
                public org.w3.x2005.sparqlResults.VariableDocument.Variable get(int i)
                    { return HeadImpl.this.getVariableArray(i); }
                
                public org.w3.x2005.sparqlResults.VariableDocument.Variable set(int i, org.w3.x2005.sparqlResults.VariableDocument.Variable o)
                {
                    org.w3.x2005.sparqlResults.VariableDocument.Variable old = HeadImpl.this.getVariableArray(i);
                    HeadImpl.this.setVariableArray(i, o);
                    return old;
                }
                
                public void add(int i, org.w3.x2005.sparqlResults.VariableDocument.Variable o)
                    { HeadImpl.this.insertNewVariable(i).set(o); }
                
                public org.w3.x2005.sparqlResults.VariableDocument.Variable remove(int i)
                {
                    org.w3.x2005.sparqlResults.VariableDocument.Variable old = HeadImpl.this.getVariableArray(i);
                    HeadImpl.this.removeVariable(i);
                    return old;
                }
                
                public int size()
                    { return HeadImpl.this.sizeOfVariableArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new VariableList();
            }
        }
        
        /**
         * Gets array of all "variable" elements
         * @deprecated
         */
        public org.w3.x2005.sparqlResults.VariableDocument.Variable[] getVariableArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.w3.x2005.sparqlResults.VariableDocument.Variable> targetList = new java.util.ArrayList<org.w3.x2005.sparqlResults.VariableDocument.Variable>();
                get_store().find_all_element_users(VARIABLE$0, targetList);
                org.w3.x2005.sparqlResults.VariableDocument.Variable[] result = new org.w3.x2005.sparqlResults.VariableDocument.Variable[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "variable" element
         */
        public org.w3.x2005.sparqlResults.VariableDocument.Variable getVariableArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.VariableDocument.Variable target = null;
                target = (org.w3.x2005.sparqlResults.VariableDocument.Variable)get_store().find_element_user(VARIABLE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "variable" element
         */
        public int sizeOfVariableArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(VARIABLE$0);
            }
        }
        
        /**
         * Sets array of all "variable" element
         */
        public void setVariableArray(org.w3.x2005.sparqlResults.VariableDocument.Variable[] variableArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(variableArray, VARIABLE$0);
            }
        }
        
        /**
         * Sets ith "variable" element
         */
        public void setVariableArray(int i, org.w3.x2005.sparqlResults.VariableDocument.Variable variable)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.VariableDocument.Variable target = null;
                target = (org.w3.x2005.sparqlResults.VariableDocument.Variable)get_store().find_element_user(VARIABLE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(variable);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "variable" element
         */
        public org.w3.x2005.sparqlResults.VariableDocument.Variable insertNewVariable(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.VariableDocument.Variable target = null;
                target = (org.w3.x2005.sparqlResults.VariableDocument.Variable)get_store().insert_element_user(VARIABLE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "variable" element
         */
        public org.w3.x2005.sparqlResults.VariableDocument.Variable addNewVariable()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.VariableDocument.Variable target = null;
                target = (org.w3.x2005.sparqlResults.VariableDocument.Variable)get_store().add_element_user(VARIABLE$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "variable" element
         */
        public void removeVariable(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(VARIABLE$0, i);
            }
        }
        
        /**
         * Gets a List of "link" elements
         */
        public java.util.List<org.w3.x2005.sparqlResults.LinkDocument.Link> getLinkList()
        {
            final class LinkList extends java.util.AbstractList<org.w3.x2005.sparqlResults.LinkDocument.Link>
            {
                public org.w3.x2005.sparqlResults.LinkDocument.Link get(int i)
                    { return HeadImpl.this.getLinkArray(i); }
                
                public org.w3.x2005.sparqlResults.LinkDocument.Link set(int i, org.w3.x2005.sparqlResults.LinkDocument.Link o)
                {
                    org.w3.x2005.sparqlResults.LinkDocument.Link old = HeadImpl.this.getLinkArray(i);
                    HeadImpl.this.setLinkArray(i, o);
                    return old;
                }
                
                public void add(int i, org.w3.x2005.sparqlResults.LinkDocument.Link o)
                    { HeadImpl.this.insertNewLink(i).set(o); }
                
                public org.w3.x2005.sparqlResults.LinkDocument.Link remove(int i)
                {
                    org.w3.x2005.sparqlResults.LinkDocument.Link old = HeadImpl.this.getLinkArray(i);
                    HeadImpl.this.removeLink(i);
                    return old;
                }
                
                public int size()
                    { return HeadImpl.this.sizeOfLinkArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new LinkList();
            }
        }
        
        /**
         * Gets array of all "link" elements
         * @deprecated
         */
        public org.w3.x2005.sparqlResults.LinkDocument.Link[] getLinkArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.w3.x2005.sparqlResults.LinkDocument.Link> targetList = new java.util.ArrayList<org.w3.x2005.sparqlResults.LinkDocument.Link>();
                get_store().find_all_element_users(LINK$2, targetList);
                org.w3.x2005.sparqlResults.LinkDocument.Link[] result = new org.w3.x2005.sparqlResults.LinkDocument.Link[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "link" element
         */
        public org.w3.x2005.sparqlResults.LinkDocument.Link getLinkArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.LinkDocument.Link target = null;
                target = (org.w3.x2005.sparqlResults.LinkDocument.Link)get_store().find_element_user(LINK$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "link" element
         */
        public int sizeOfLinkArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(LINK$2);
            }
        }
        
        /**
         * Sets array of all "link" element
         */
        public void setLinkArray(org.w3.x2005.sparqlResults.LinkDocument.Link[] linkArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(linkArray, LINK$2);
            }
        }
        
        /**
         * Sets ith "link" element
         */
        public void setLinkArray(int i, org.w3.x2005.sparqlResults.LinkDocument.Link link)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.LinkDocument.Link target = null;
                target = (org.w3.x2005.sparqlResults.LinkDocument.Link)get_store().find_element_user(LINK$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(link);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "link" element
         */
        public org.w3.x2005.sparqlResults.LinkDocument.Link insertNewLink(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.LinkDocument.Link target = null;
                target = (org.w3.x2005.sparqlResults.LinkDocument.Link)get_store().insert_element_user(LINK$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "link" element
         */
        public org.w3.x2005.sparqlResults.LinkDocument.Link addNewLink()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.LinkDocument.Link target = null;
                target = (org.w3.x2005.sparqlResults.LinkDocument.Link)get_store().add_element_user(LINK$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "link" element
         */
        public void removeLink(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(LINK$2, i);
            }
        }
    }
}
