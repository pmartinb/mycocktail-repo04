/*
 * An XML document type.
 * Localname: sparql
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.SparqlDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults;


/**
 * A document containing one sparql(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public interface SparqlDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(SparqlDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B0D0777828EFC7E13E004DF95F57C39").resolveHandle("sparqlac97doctype");
    
    /**
     * Gets the "sparql" element
     */
    org.w3.x2005.sparqlResults.SparqlDocument.Sparql getSparql();
    
    /**
     * Sets the "sparql" element
     */
    void setSparql(org.w3.x2005.sparqlResults.SparqlDocument.Sparql sparql);
    
    /**
     * Appends and returns a new empty "sparql" element
     */
    org.w3.x2005.sparqlResults.SparqlDocument.Sparql addNewSparql();
    
    /**
     * An XML sparql(@http://www.w3.org/2005/sparql-results#).
     *
     * This is a complex type.
     */
    public interface Sparql extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Sparql.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B0D0777828EFC7E13E004DF95F57C39").resolveHandle("sparql4f1celemtype");
        
        /**
         * Gets the "head" element
         */
        org.w3.x2005.sparqlResults.HeadDocument.Head getHead();
        
        /**
         * Sets the "head" element
         */
        void setHead(org.w3.x2005.sparqlResults.HeadDocument.Head head);
        
        /**
         * Appends and returns a new empty "head" element
         */
        org.w3.x2005.sparqlResults.HeadDocument.Head addNewHead();
        
        /**
         * Gets the "results" element
         */
        org.w3.x2005.sparqlResults.ResultsDocument.Results getResults();
        
        /**
         * True if has "results" element
         */
        boolean isSetResults();
        
        /**
         * Sets the "results" element
         */
        void setResults(org.w3.x2005.sparqlResults.ResultsDocument.Results results);
        
        /**
         * Appends and returns a new empty "results" element
         */
        org.w3.x2005.sparqlResults.ResultsDocument.Results addNewResults();
        
        /**
         * Unsets the "results" element
         */
        void unsetResults();
        
        /**
         * Gets the "boolean" element
         */
        boolean getBoolean();
        
        /**
         * Gets (as xml) the "boolean" element
         */
        org.apache.xmlbeans.XmlBoolean xgetBoolean();
        
        /**
         * True if has "boolean" element
         */
        boolean isSetBoolean();
        
        /**
         * Sets the "boolean" element
         */
        void setBoolean(boolean xboolean);
        
        /**
         * Sets (as xml) the "boolean" element
         */
        void xsetBoolean(org.apache.xmlbeans.XmlBoolean xboolean);
        
        /**
         * Unsets the "boolean" element
         */
        void unsetBoolean();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.w3.x2005.sparqlResults.SparqlDocument.Sparql newInstance() {
              return (org.w3.x2005.sparqlResults.SparqlDocument.Sparql) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.w3.x2005.sparqlResults.SparqlDocument.Sparql newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.w3.x2005.sparqlResults.SparqlDocument.Sparql) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.w3.x2005.sparqlResults.SparqlDocument newInstance() {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.w3.x2005.sparqlResults.SparqlDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.w3.x2005.sparqlResults.SparqlDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
