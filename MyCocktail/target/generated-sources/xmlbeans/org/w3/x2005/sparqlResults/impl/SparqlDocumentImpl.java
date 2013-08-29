/*
 * An XML document type.
 * Localname: sparql
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.SparqlDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults.impl;
/**
 * A document containing one sparql(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public class SparqlDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.SparqlDocument
{
    private static final long serialVersionUID = 1L;
    
    public SparqlDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SPARQL$0 = 
        new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "sparql");
    
    
    /**
     * Gets the "sparql" element
     */
    public org.w3.x2005.sparqlResults.SparqlDocument.Sparql getSparql()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.SparqlDocument.Sparql target = null;
            target = (org.w3.x2005.sparqlResults.SparqlDocument.Sparql)get_store().find_element_user(SPARQL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "sparql" element
     */
    public void setSparql(org.w3.x2005.sparqlResults.SparqlDocument.Sparql sparql)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.SparqlDocument.Sparql target = null;
            target = (org.w3.x2005.sparqlResults.SparqlDocument.Sparql)get_store().find_element_user(SPARQL$0, 0);
            if (target == null)
            {
                target = (org.w3.x2005.sparqlResults.SparqlDocument.Sparql)get_store().add_element_user(SPARQL$0);
            }
            target.set(sparql);
        }
    }
    
    /**
     * Appends and returns a new empty "sparql" element
     */
    public org.w3.x2005.sparqlResults.SparqlDocument.Sparql addNewSparql()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.w3.x2005.sparqlResults.SparqlDocument.Sparql target = null;
            target = (org.w3.x2005.sparqlResults.SparqlDocument.Sparql)get_store().add_element_user(SPARQL$0);
            return target;
        }
    }
    /**
     * An XML sparql(@http://www.w3.org/2005/sparql-results#).
     *
     * This is a complex type.
     */
    public static class SparqlImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements org.w3.x2005.sparqlResults.SparqlDocument.Sparql
    {
        private static final long serialVersionUID = 1L;
        
        public SparqlImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName HEAD$0 = 
            new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "head");
        private static final javax.xml.namespace.QName RESULTS$2 = 
            new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "results");
        private static final javax.xml.namespace.QName BOOLEAN$4 = 
            new javax.xml.namespace.QName("http://www.w3.org/2005/sparql-results#", "boolean");
        
        
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
         * Gets the "results" element
         */
        public org.w3.x2005.sparqlResults.ResultsDocument.Results getResults()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.w3.x2005.sparqlResults.ResultsDocument.Results target = null;
                target = (org.w3.x2005.sparqlResults.ResultsDocument.Results)get_store().find_element_user(RESULTS$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * True if has "results" element
         */
        public boolean isSetResults()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(RESULTS$2) != 0;
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
                target = (org.w3.x2005.sparqlResults.ResultsDocument.Results)get_store().find_element_user(RESULTS$2, 0);
                if (target == null)
                {
                    target = (org.w3.x2005.sparqlResults.ResultsDocument.Results)get_store().add_element_user(RESULTS$2);
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
                target = (org.w3.x2005.sparqlResults.ResultsDocument.Results)get_store().add_element_user(RESULTS$2);
                return target;
            }
        }
        
        /**
         * Unsets the "results" element
         */
        public void unsetResults()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(RESULTS$2, 0);
            }
        }
        
        /**
         * Gets the "boolean" element
         */
        public boolean getBoolean()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BOOLEAN$4, 0);
                if (target == null)
                {
                    return false;
                }
                return target.getBooleanValue();
            }
        }
        
        /**
         * Gets (as xml) the "boolean" element
         */
        public org.apache.xmlbeans.XmlBoolean xgetBoolean()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(BOOLEAN$4, 0);
                return target;
            }
        }
        
        /**
         * True if has "boolean" element
         */
        public boolean isSetBoolean()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(BOOLEAN$4) != 0;
            }
        }
        
        /**
         * Sets the "boolean" element
         */
        public void setBoolean(boolean xboolean)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BOOLEAN$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BOOLEAN$4);
                }
                target.setBooleanValue(xboolean);
            }
        }
        
        /**
         * Sets (as xml) the "boolean" element
         */
        public void xsetBoolean(org.apache.xmlbeans.XmlBoolean xboolean)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlBoolean target = null;
                target = (org.apache.xmlbeans.XmlBoolean)get_store().find_element_user(BOOLEAN$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlBoolean)get_store().add_element_user(BOOLEAN$4);
                }
                target.set(xboolean);
            }
        }
        
        /**
         * Unsets the "boolean" element
         */
        public void unsetBoolean()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(BOOLEAN$4, 0);
            }
        }
    }
}
