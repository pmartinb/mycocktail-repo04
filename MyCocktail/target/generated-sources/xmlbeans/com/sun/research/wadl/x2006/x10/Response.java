/*
 * XML Type:  response
 * Namespace: http://research.sun.com/wadl/2006/10
 * Java type: com.sun.research.wadl.x2006.x10.Response
 *
 * Automatically generated - do not modify.
 */
package com.sun.research.wadl.x2006.x10;


/**
 * An XML response(@http://research.sun.com/wadl/2006/10).
 *
 * This is a complex type.
 */
public interface Response extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Response.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B0D0777828EFC7E13E004DF95F57C39").resolveHandle("responsea6b4type");
    
    /**
     * Gets the "representation" element
     */
    com.sun.research.wadl.x2006.x10.Representation getRepresentation();
    
    /**
     * Sets the "representation" element
     */
    void setRepresentation(com.sun.research.wadl.x2006.x10.Representation representation);
    
    /**
     * Appends and returns a new empty "representation" element
     */
    com.sun.research.wadl.x2006.x10.Representation addNewRepresentation();
    
    /**
     * Gets the "fault" element
     */
    com.sun.research.wadl.x2006.x10.Fault getFault();
    
    /**
     * Sets the "fault" element
     */
    void setFault(com.sun.research.wadl.x2006.x10.Fault fault);
    
    /**
     * Appends and returns a new empty "fault" element
     */
    com.sun.research.wadl.x2006.x10.Fault addNewFault();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.sun.research.wadl.x2006.x10.Response newInstance() {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Response newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.sun.research.wadl.x2006.x10.Response parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.sun.research.wadl.x2006.x10.Response parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Response parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.sun.research.wadl.x2006.x10.Response parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.sun.research.wadl.x2006.x10.Response parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.sun.research.wadl.x2006.x10.Response) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
