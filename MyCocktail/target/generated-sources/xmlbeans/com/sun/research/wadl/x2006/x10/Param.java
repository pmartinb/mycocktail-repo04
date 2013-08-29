/*
 * XML Type:  param
 * Namespace: http://research.sun.com/wadl/2006/10
 * Java type: com.sun.research.wadl.x2006.x10.Param
 *
 * Automatically generated - do not modify.
 */
package com.sun.research.wadl.x2006.x10;


/**
 * An XML param(@http://research.sun.com/wadl/2006/10).
 *
 * This is a complex type.
 */
public interface Param extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Param.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9B0D0777828EFC7E13E004DF95F57C39").resolveHandle("param4cdatype");
    
    /**
     * Gets a List of "option" elements
     */
    java.util.List<com.sun.research.wadl.x2006.x10.Option> getOptionList();
    
    /**
     * Gets array of all "option" elements
     * @deprecated
     */
    com.sun.research.wadl.x2006.x10.Option[] getOptionArray();
    
    /**
     * Gets ith "option" element
     */
    com.sun.research.wadl.x2006.x10.Option getOptionArray(int i);
    
    /**
     * Returns number of "option" element
     */
    int sizeOfOptionArray();
    
    /**
     * Sets array of all "option" element
     */
    void setOptionArray(com.sun.research.wadl.x2006.x10.Option[] optionArray);
    
    /**
     * Sets ith "option" element
     */
    void setOptionArray(int i, com.sun.research.wadl.x2006.x10.Option option);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "option" element
     */
    com.sun.research.wadl.x2006.x10.Option insertNewOption(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "option" element
     */
    com.sun.research.wadl.x2006.x10.Option addNewOption();
    
    /**
     * Removes the ith "option" element
     */
    void removeOption(int i);
    
    /**
     * Gets the "name" attribute
     */
    java.lang.String getName();
    
    /**
     * Gets (as xml) the "name" attribute
     */
    org.apache.xmlbeans.XmlString xgetName();
    
    /**
     * Sets the "name" attribute
     */
    void setName(java.lang.String name);
    
    /**
     * Sets (as xml) the "name" attribute
     */
    void xsetName(org.apache.xmlbeans.XmlString name);
    
    /**
     * Gets the "type" attribute
     */
    java.lang.String getType();
    
    /**
     * Gets (as xml) the "type" attribute
     */
    org.apache.xmlbeans.XmlString xgetType();
    
    /**
     * Sets the "type" attribute
     */
    void setType(java.lang.String type);
    
    /**
     * Sets (as xml) the "type" attribute
     */
    void xsetType(org.apache.xmlbeans.XmlString type);
    
    /**
     * Gets the "style" attribute
     */
    com.sun.research.wadl.x2006.x10.ParamStyle.Enum getStyle();
    
    /**
     * Gets (as xml) the "style" attribute
     */
    com.sun.research.wadl.x2006.x10.ParamStyle xgetStyle();
    
    /**
     * True if has "style" attribute
     */
    boolean isSetStyle();
    
    /**
     * Sets the "style" attribute
     */
    void setStyle(com.sun.research.wadl.x2006.x10.ParamStyle.Enum style);
    
    /**
     * Sets (as xml) the "style" attribute
     */
    void xsetStyle(com.sun.research.wadl.x2006.x10.ParamStyle style);
    
    /**
     * Unsets the "style" attribute
     */
    void unsetStyle();
    
    /**
     * Gets the "required" attribute
     */
    boolean getRequired();
    
    /**
     * Gets (as xml) the "required" attribute
     */
    org.apache.xmlbeans.XmlBoolean xgetRequired();
    
    /**
     * True if has "required" attribute
     */
    boolean isSetRequired();
    
    /**
     * Sets the "required" attribute
     */
    void setRequired(boolean required);
    
    /**
     * Sets (as xml) the "required" attribute
     */
    void xsetRequired(org.apache.xmlbeans.XmlBoolean required);
    
    /**
     * Unsets the "required" attribute
     */
    void unsetRequired();
    
    /**
     * Gets the "fixed" attribute
     */
    java.lang.String getFixed();
    
    /**
     * Gets (as xml) the "fixed" attribute
     */
    org.apache.xmlbeans.XmlString xgetFixed();
    
    /**
     * True if has "fixed" attribute
     */
    boolean isSetFixed();
    
    /**
     * Sets the "fixed" attribute
     */
    void setFixed(java.lang.String fixed);
    
    /**
     * Sets (as xml) the "fixed" attribute
     */
    void xsetFixed(org.apache.xmlbeans.XmlString fixed);
    
    /**
     * Unsets the "fixed" attribute
     */
    void unsetFixed();
    
    /**
     * Gets the "default" attribute
     */
    java.lang.String getDefault();
    
    /**
     * Gets (as xml) the "default" attribute
     */
    org.apache.xmlbeans.XmlString xgetDefault();
    
    /**
     * True if has "default" attribute
     */
    boolean isSetDefault();
    
    /**
     * Sets the "default" attribute
     */
    void setDefault(java.lang.String xdefault);
    
    /**
     * Sets (as xml) the "default" attribute
     */
    void xsetDefault(org.apache.xmlbeans.XmlString xdefault);
    
    /**
     * Unsets the "default" attribute
     */
    void unsetDefault();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.sun.research.wadl.x2006.x10.Param newInstance() {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Param newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.sun.research.wadl.x2006.x10.Param parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.sun.research.wadl.x2006.x10.Param parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.sun.research.wadl.x2006.x10.Param parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.sun.research.wadl.x2006.x10.Param parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.sun.research.wadl.x2006.x10.Param parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.sun.research.wadl.x2006.x10.Param) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
