/*
 * An XML document type.
 * Localname: results
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.ResultsDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults.impl;
/**
 * A document containing one results(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public class ResultsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.ResultsDocument
{
    private static final long serialVersionUID = 1L;
    
    public ResultsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RESULTS$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "results");
    
    
    /**
     * Gets the "results" element
     */
    public org.w3.x2005.sparqlResults.ResultsDocument.Results getResults()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.ResultsDocument.Results target = null;
            target = (org.w3.x2005.sparqlResults.ResultsDocument.Results)get_store().find_element_user(RESULTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "results" element
     */
    public void setResults(org.w3.x2005.sparqlResults.ResultsDocument.Results results)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.ResultsDocument.Results target = null;
            target = (org.w3.x2005.sparqlResults.ResultsDocument.Results)get_store().find_element_user(RESULTS$0, 0);
            if (target == null)
            {
                target = (org.w3.x2005.sparqlResults.ResultsDocument.Results)get_store().add_element_user(RESULTS$0);
            }
            target.set(results);
        }
    }
    
    /**
     * Appends and returns a new empty "results" element
     */
    public org.w3.x2005.sparqlResults.ResultsDocument.Results addNewResults()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.ResultsDocument.Results target = null;
            target = (org.w3.x2005.sparqlResults.ResultsDocument.Results)get_store().add_element_user(RESULTS$0);
            return target;
        }
    }
    /**
     * An XML results(@http://www.w3.org/2005/sparql-results#).
     *
     * This is a complex type.
     */
    public static class ResultsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.ResultsDocument.Results
    {
        private static final long serialVersionUID = 1L;
        
        public ResultsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName RESULT$0 = 
            new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "result");
        
        
        /**
         * Gets a List of "result" elements
         */
        public java.util.List<org.w3.x2005.sparqlResults.ResultDocument.Result> getResultList()
        {
            final class ResultList extends java.util.AbstractList<org.w3.x2005.sparqlResults.ResultDocument.Result>
            {
                public org.w3.x2005.sparqlResults.ResultDocument.Result get(int i)
                    { return ResultsImpl.this.getResultArray(i); }
                
                public org.w3.x2005.sparqlResults.ResultDocument.Result set(int i, org.w3.x2005.sparqlResults.ResultDocument.Result o)
                {
                    org.w3.x2005.sparqlResults.ResultDocument.Result old = ResultsImpl.this.getResultArray(i);
                    ResultsImpl.this.setResultArray(i, o);
                    return old;
                }
                
                public void add(int i, org.w3.x2005.sparqlResults.ResultDocument.Result o)
                    { ResultsImpl.this.insertNewResult(i).set(o); }
                
                public org.w3.x2005.sparqlResults.ResultDocument.Result remove(int i)
                {
                    org.w3.x2005.sparqlResults.ResultDocument.Result old = ResultsImpl.this.getResultArray(i);
                    ResultsImpl.this.removeResult(i);
                    return old;
                }
                
                public int size()
                    { return ResultsImpl.this.sizeOfResultArray(); }
                
            }
            
            synchronized (monitor())
            {
                check_orphaned();
                return new ResultList();
            }
        }
        
        /**
         * Gets array of all "result" elements
         * @deprecated
         */
        public org.w3.x2005.sparqlResults.ResultDocument.Result[] getResultArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List<org.w3.x2005.sparqlResults.ResultDocument.Result> targetList = new java.util.ArrayList<org.w3.x2005.sparqlResults.ResultDocument.Result>();
                get_store().find_all_element_users(RESULT$0, targetList);
                org.w3.x2005.sparqlResults.ResultDocument.Result[] result = new org.w3.x2005.sparqlResults.ResultDocument.Result[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "result" element
         */
        public org.w3.x2005.sparqlResults.ResultDocument.Result getResultArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.ResultDocument.Result target = null;
                target = (org.w3.x2005.sparqlResults.ResultDocument.Result)get_store().find_element_user(RESULT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "result" element
         */
        public int sizeOfResultArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(RESULT$0);
            }
        }
        
        /**
         * Sets array of all "result" element
         */
        public void setResultArray(org.w3.x2005.sparqlResults.ResultDocument.Result[] resultArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(resultArray, RESULT$0);
            }
        }
        
        /**
         * Sets ith "result" element
         */
        public void setResultArray(int i, org.w3.x2005.sparqlResults.ResultDocument.Result result)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.ResultDocument.Result target = null;
                target = (org.w3.x2005.sparqlResults.ResultDocument.Result)get_store().find_element_user(RESULT$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(result);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "result" element
         */
        public org.w3.x2005.sparqlResults.ResultDocument.Result insertNewResult(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.ResultDocument.Result target = null;
                target = (org.w3.x2005.sparqlResults.ResultDocument.Result)get_store().insert_element_user(RESULT$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "result" element
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
         * Removes the ith "result" element
         */
        public void removeResult(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(RESULT$0, i);
            }
        }
    }
}
