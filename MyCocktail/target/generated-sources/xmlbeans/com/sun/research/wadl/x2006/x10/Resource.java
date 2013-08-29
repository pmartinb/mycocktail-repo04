/*
 * XML Type:  resource
 * Namespace: http://research.sun.com/wadl/2006/10
 * Java type: com.sun.research.wadl.x2006.x10.Resource
 *
 * Automatically generated - do not modify.
 */
package com.sun.research.wadl.x2006.x10;


/**
 * An XML resource(@http://research.sun.com/wadl/2006/10).
 *
 * This is a complex type.
 */
public interface Resource extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Resource.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B0D0777828EFC7E13E004DF95F57C39").resolveHandle("resourcec307type");
    
    /**
     * Gets a List of "param" elements
     */
    java.util.List<com.sun.research.wadl.x2006.x10.Param> getParamList();
    
    /**
     * Gets array of all "param" elements
     * @deprecated
     */
    com.sun.research.wadl.x2006.x10.Param[] getParamArray();
    
    /**
     * Gets ith "param" element
     */
    com.sun.research.wadl.x2006.x10.Param getParamArray(int i);
    
    /**
     * Returns number of "param" element
     */
    int sizeOfParamArray();
    
    /**
     * Sets array of all "param" element
     */
    void setParamArray(com.sun.research.wadl.x2006.x10.Param[] paramArray);
    
    /**
     * Sets ith "param" element
     */
    void setParamArray(int i, com.sun.research.wadl.x2006.x10.Param param);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "param" element
     */
    com.sun.research.wadl.x2006.x10.Param insertNewParam(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "param" element
     */
    com.sun.research.wadl.x2006.x10.Param addNewParam();
    
    /**
     * Removes the ith "param" element
     */
    void removeParam(int i);
    
    /**
     * Gets a List of "method" elements
     */
    java.util.List<com.sun.research.wadl.x2006.x10.Method> getMethodList();
    
    /**
     * Gets array of all "method" elements
     * @deprecated
     */
    com.sun.research.wadl.x2006.x10.Method[] getMethodArray();
    
    /**
     * Gets ith "method" element
     */
    com.sun.research.wadl.x2006.x10.Method getMethodArray(int i);
    
    /**
     * Returns number of "method" element
     */
    int sizeOfMethodArray();
    
    /**
     * Sets array of all "method" element
     */
    void setMethodArray(com.sun.research.wadl.x2006.x10.Method[] methodArray);
    
    /**
     * Sets ith "method" element
     */
    void setMethodArray(int i, com.sun.research.wadl.x2006.x10.Method method);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "method" element
     */
    com.sun.research.wadl.x2006.x10.Method insertNewMethod(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "method" element
     */
    com.sun.research.wadl.x2006.x10.Method addNewMethod();
    
    /**
     * Removes the ith "method" element
     */
    void removeMethod(int i);
    
    /**
     * Gets a List of "resource" elements
     */
    java.util.List<com.sun.research.wadl.x2006.x10.Resource> getResourceList();
    
    /**
     * Gets array of all "resource" elements
     * @deprecated
     */
    com.sun.research.wadl.x2006.x10.Resource[] getResourceArray();
    
    /**
     * Gets ith "resource" element
     */
    com.sun.research.wadl.x2006.x10.Resource getResourceArray(int i);
    
    /**
     * Returns number of "resource" element
     */
    int sizeOfResourceArray();
    
    /**
     * Sets array of all "resource" element
     */
    void setResourceArray(com.sun.research.wadl.x2006.x10.Resource[] resourceArray);
    
    /**
     * Sets ith "resource" element
     */
    void setResourceArray(int i, com.sun.research.wadl.x2006.x10.Resource resource);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "resource" element
     */
    com.sun.research.wadl.x2006.x10.Resource insertNewResource(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "resource" element
     */
    com.sun.research.wadl.x2006.x10.Resource addNewResource();
    
    /**
     * Removes the ith "resource" element
     */
    void removeResource(int i);
    
    /**
     * Gets the "path" attribute
     */
    java.lang.String getPath();
    
    /**
     * Gets (as xml) the "path" attribute
     */
    org.apache.xmlbeans.XmlString xgetPath();
    
    /**
     * True if has "path" attribute
     */
    boolean isSetPath();
    
    /**
     * Sets the "path" attribute
     */
    void setPath(java.lang.String path);
    
    /**
     * Sets (as xml) the "path" attribute
     */
    void xsetPath(org.apache.xmlbeans.XmlString path);
    
    /**
     * Unsets the "path" attribute
     */
    void unsetPath();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.sun.research.wadl.x2006.x10.Resource newInstance() {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.sun.research.wadl.x2006.x10.Resource parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.sun.research.wadl.x2006.x10.Resource parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Resource parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.sun.research.wadl.x2006.x10.Resource parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.sun.research.wadl.x2006.x10.Resource parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.sun.research.wadl.x2006.x10.Resource) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
