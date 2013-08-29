/*
 * An XML document type.
 * Localname: binding
 * Namespace: http://www.w3.org/2005/sparql-results#
 * Java type: org.w3.x2005.sparqlResults.BindingDocument
 *
 * Automatically generated - do not modify.
 */
package org.w3.x2005.sparqlResults;


/**
 * A document containing one binding(@http://www.w3.org/2005/sparql-results#) element.
 *
 * This is a complex type.
 */
public interface BindingDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(BindingDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B0D0777828EFC7E13E004DF95F57C39").resolveHandle("bindinge50ddoctype");
    
    /**
     * Gets the "binding" element
     */
    org.w3.x2005.sparqlResults.BindingDocument.Binding getBinding();
    
    /**
     * Sets the "binding" element
     */
    void setBinding(org.w3.x2005.sparqlResults.BindingDocument.Binding binding);
    
    /**
     * Appends and returns a new empty "binding" element
     */
    org.w3.x2005.sparqlResults.BindingDocument.Binding addNewBinding();
    
    /**
     * An XML binding(@http://www.w3.org/2005/sparql-results#).
     *
     * This is a complex type.
     */
    public interface Binding extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Binding.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B0D0777828EFC7E13E004DF95F57C39").resolveHandle("binding3e3celemtype");
        
        /**
         * Gets the "uri" element
         */
        java.lang.String getUri();
        
        /**
         * Gets (as xml) the "uri" element
         */
        org.apache.xmlbeans.XmlString xgetUri();
        
        /**
         * True if has "uri" element
         */
        boolean isSetUri();
        
        /**
         * Sets the "uri" element
         */
        void setUri(java.lang.String uri);
        
        /**
         * Sets (as xml) the "uri" element
         */
        void xsetUri(org.apache.xmlbeans.XmlString uri);
        
        /**
         * Unsets the "uri" element
         */
        void unsetUri();
        
        /**
         * Gets the "bnode" element
         */
        java.lang.String getBnode();
        
        /**
         * Gets (as xml) the "bnode" element
         */
        org.apache.xmlbeans.XmlString xgetBnode();
        
        /**
         * True if has "bnode" element
         */
        boolean isSetBnode();
        
        /**
         * Sets the "bnode" element
         */
        void setBnode(java.lang.String bnode);
        
        /**
         * Sets (as xml) the "bnode" element
         */
        void xsetBnode(org.apache.xmlbeans.XmlString bnode);
        
        /**
         * Unsets the "bnode" element
         */
        void unsetBnode();
        
        /**
         * Gets the "literal" element
         */
        org.w3.x2005.sparqlResults.LiteralDocument.Literal getLiteral();
        
        /**
         * True if has "literal" element
         */
        boolean isSetLiteral();
        
        /**
         * Sets the "literal" element
         */
        void setLiteral(org.w3.x2005.sparqlResults.LiteralDocument.Literal literal);
        
        /**
         * Appends and returns a new empty "literal" element
         */
        org.w3.x2005.sparqlResults.LiteralDocument.Literal addNewLiteral();
        
        /**
         * Unsets the "literal" element
         */
        void unsetLiteral();
        
        /**
         * Gets the "name" attribute
         */
        java.lang.String getName();
        
        /**
         * Gets (as xml) the "name" attribute
         */
        org.apache.xmlbeans.XmlNMTOKEN xgetName();
        
        /**
         * Sets the "name" attribute
         */
        void setName(java.lang.String name);
        
        /**
         * Sets (as xml) the "name" attribute
         */
        void xsetName(org.apache.xmlbeans.XmlNMTOKEN name);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static org.w3.x2005.sparqlResults.BindingDocument.Binding newInstance() {
              return (org.w3.x2005.sparqlResults.BindingDocument.Binding) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static org.w3.x2005.sparqlResults.BindingDocument.Binding newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (org.w3.x2005.sparqlResults.BindingDocument.Binding) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.w3.x2005.sparqlResults.BindingDocument newInstance() {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.w3.x2005.sparqlResults.BindingDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.w3.x2005.sparqlResults.BindingDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.w3.x2005.sparqlResults.BindingDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.w3.x2005.sparqlResults.BindingDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.w3.x2005.sparqlResults.BindingDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.w3.x2005.sparqlResults.BindingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
