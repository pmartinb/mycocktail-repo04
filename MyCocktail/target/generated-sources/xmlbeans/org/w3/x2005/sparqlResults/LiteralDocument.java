/*
 * An XML document type.
 * Localname: literal
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.LiteralDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults;


/**
 * A document containing one literal(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public interface LiteralDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LiteralDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B0D0777828EFC7E13E004DF95F57C39").resolveHandle("literalb7a3doctype");
    
    /**
     * Gets the "literal" element
     */
    org.w3.x2005.sparqlResults.LiteralDocument.Literal getLiteral();
    
    /**
     * Sets the "literal" element
     */
    void setLiteral(org.w3.x2005.sparqlResults.LiteralDocument.Literal literal);
    
    /**
     * Appends and returns a new empty "literal" element
     */
    org.w3.x2005.sparqlResults.LiteralDocument.Literal addNewLiteral();
    
    /**
     * An XML literal(@http://www.w3.org/2005/sparql-results#).
     *
     * This is a complex type.
     */
    public interface Literal extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Literal.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B0D0777828EFC7E13E004DF95F57C39").resolveHandle("literal1fe8elemtype");
        
        /**
         * Gets the "datatype" attribute
         */
        java.lang.String getDatatype();
        
        /**
         * Gets (as xml) the "datatype" attribute
         */
        org.w3.x2005.sparqlResults.URIReference xgetDatatype();
        
        /**
         * True if has "datatype" attribute
         */
        boolean isSetDatatype();
        
        /**
         * Sets the "datatype" attribute
         */
        void setDatatype(java.lang.String datatype);
        
        /**
         * Sets (as xml) the "datatype" attribute
         */
        void xsetDatatype(org.w3.x2005.sparqlResults.URIReference datatype);
        
        /**
         * Unsets the "datatype" attribute
         */
        void unsetDatatype();
        
        /**
         * Gets the "lang" attribute
         */
        java.lang.String getLang();
        
        /**
         * Gets (as xml) the "lang" attribute
         */
        org.apache.xmlbeans.XmlLanguage xgetLang();
        
        /**
         * True if has "lang" attribute
         */
        boolean isSetLang();
        
        /**
         * Sets the "lang" attribute
         */
        void setLang(java.lang.String lang);
        
        /**
         * Sets (as xml) the "lang" attribute
         */
        void xsetLang(org.apache.xmlbeans.XmlLanguage lang);
        
        /**
         * Unsets the "lang" attribute
         */
        void unsetLang();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.w3.x2005.sparqlResults.LiteralDocument.Literal newInstance() {
              return (org.w3.x2005.sparqlResults.LiteralDocument.Literal) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.w3.x2005.sparqlResults.LiteralDocument.Literal newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.w3.x2005.sparqlResults.LiteralDocument.Literal) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.w3.x2005.sparqlResults.LiteralDocument newInstance() {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.w3.x2005.sparqlResults.LiteralDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.w3.x2005.sparqlResults.LiteralDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
