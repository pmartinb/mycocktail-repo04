/*
 * Copyright 2009 David del Pozo González (dpozog--at--grupogesfor.com)
 * Informática Gesfor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.germinus.util.objectformatter;

import com.germinus.util.ArraysUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.germinus.util.CollectionsUtil;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class formats an object to JSON format.
 * @author David del Pozo González
 */
public class JsonFormatter {
    /**
     * The root element of the JSON.
     */
    private String rootElement = null;

    /**
     * The root element for the JSON.
     * @param rootElementName element for the JSON
     */
    public void setRootElement(String rootElementName) {
        this.rootElement = rootElementName;
    }

    /**
     * Convers an object into JSON format.
     * @param object the object to convert
     * @return the String with the JSON representation of the object.
     */
    public String convert(Object object) {
        if (object == null) {
            return createObject(keyValue("object", "null"));
        }
        
        String json = null;
        
        Class clazz = object.getClass();
        if (JsonFormatter.ReflexionUtils.implementsInterface(clazz, CharSequence.class)) {
            json = createObject(keyStringValue("string", object.toString()));
        } else if (JsonFormatter.ReflexionUtils.isPrimitive(clazz)) {
            if(clazz.equals(Character.class)) {
                json = createObject(keyStringValue("char", object.toString()));
            } else if(clazz.equals(Boolean.class)) {
                json = createObject(keyValue("boolean", object.toString()));
            } else /* byte, short, int, long, float, double */ {
                json = createObject(keyValue("number", object.toString()));
            }
        } else {
            json = objectToJSON(object);
        }

        if (rootElement != null) {
            json = "{\"" + rootElement + "\":" + json + "}";
        }
        
        return json;
    }

    /**
     * Converts an array into json array.
     * @param array to convert in json array.
     * @return the json array.
     */
    private String arrayToJSON(Object[] array) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if (array.length > 0) {
            List<String> list = new ArrayList<String>();
            for (Object ob : array) {
                list.add(objectToJSON(ob));
            }

            sb.append(CollectionsUtil.join(list, ","));
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Converts an map into json array.
     * @param map map to convert in json array.
     * @return the json object.
     */
    private String mapToJSON(Map map) {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        Set<Entry> entrySet = map.entrySet();
        List<String> list = new ArrayList<String>();
        for (Entry e : entrySet) {
            list.add(keyValue(e.getKey().toString(), objectToJSON(e.getValue())));
        }
        sb.append(CollectionsUtil.join(list, ","));
        sb.append("}");

        return sb.toString();
    }

    /**
     * Converts an array into json array.
     * @param object to convert in json.
     * @return the json.
     */
    private String objectToJSON(Object object) {
        if (object == null) {
            return null;
        }
        
        StringBuilder sb = new StringBuilder();
        Class clazz = object.getClass();

        if (object instanceof Collection || object instanceof Object[]) {
            Object[] array = null;
            if (object instanceof Collection) {
                array = ((Collection) object).toArray();
            } else {
                array = (Object[]) object;
            }

            sb.append(arrayToJSON(array));
        } else if (object instanceof Map) {
            sb.append(mapToJSON((Map)object));
        } else if (JsonFormatter.ReflexionUtils.implementsInterface(clazz, CharSequence.class)) {
            sb.append("\"").append(object).append("\"");
        } else if (JsonFormatter.ReflexionUtils.isPrimitive(clazz)) {
            sb.append(object);
        } else {
            Method[] methods = JsonFormatter.ReflexionUtils.getGetMethods(clazz);
            if (methods.length == 0) {
                return null;
            }

            sb.append("{");
            List<String> list = new ArrayList<String>();
            for (int i=0; i<methods.length; i++) {
                String propertyName = JsonFormatter.ReflexionUtils.getPropertyName(methods[i]);
                String value = fieldToJson(object, methods[i]);
                if (value != null) {
                    list.add(keyValue(propertyName, value));
                }
            }
            sb.append(CollectionsUtil.join(list, ","));
            sb.append("}");
        }

        return sb.toString();
    }

    /**
     * Convers a field of an object into json format.
     * @param object the object to extract the field
     * @param method the method to extract the value
     * @param list the list in which puts the field in json format.
     */
    private String fieldToJson(Object object, Method method) {
        String fieldJson = null;
        try {
            if (method != null) {
                Object returnedValue = method.invoke(object, new Object[0]);
                if (returnedValue != null) {
                    fieldJson = objectToJSON(returnedValue);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fieldJson;
    }

    private static String keyValue(String name, String value) {
        return new StringBuilder().append("\"").append(name)
                .append("\"").append(":").append(value).toString();
    }

    private static String keyStringValue(String name, String value) {
        return new StringBuilder().append("\"").append(name)
                .append("\"").append(":\"").append(value).append("\"").toString();
    }
    
    private static String createObject(String... properties) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(ArraysUtil.join(properties, ","));
        sb.append("}");
        return sb.toString();
    }
    
    public static class StringUtils {
        private StringUtils() {
        }

         /**
         * Puts the first letter of a String into upper case.
         * @param string the string to convert.
         * @return a String with the first letter of a String into upper case.
         */
        public static String toUpperCaseFirstLetter(String string) {
            String returnString = null;
            if (string == null || string.isEmpty()) {
                returnString = string;
            } else {
                char[] characters = string.toCharArray();
                characters[0] = Character.toUpperCase(characters[0]);
                returnString = new String(characters);
            }
            return returnString;
        }
        
        /**
     * Puts the first letter of a String into lower case.
     * @param string the string to convert.
     * @return a String with the first letter of a String into lower case.
     */
    public static String toLowerCaseFirstLetter(String string) {
        String returnString = null;
        if (string == null || string.isEmpty()) {
            returnString = string;
        } else {
            char[] characters = string.toCharArray();
            characters[0] = Character.toLowerCase(characters[0]);
            returnString = new String(characters);
        }
        return returnString;
    }
    }

    public static class ReflexionUtils {
        private ReflexionUtils() {
        }

        /**
         * Returns <code>true</code> if the class passed as first argument implements
         * the interface passed as second argument, <code>false</code> in other case.
         * @param clazz the class to check.
         * @param interfaceClass the interface to test if it is implemented.
         * @return <code>true</code> if the class passed as first argument implements
         * the interface passed as second argument, <code>false</code> in other case.
         */
        public static boolean implementsInterface(Class clazz, Class interfaceClass) {
            for(Class interf : clazz.getInterfaces()) {
                if(interf.equals(interfaceClass)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Returns <code>true</code> if the class passed as first argument extends
         * the class passed as second argument, <code>false</code> in other case.
         * Only check if the class is directly extended by the class, this method
         * does not test the entire hierarchy.
         * @param clazz the class to check.
         * @param interfaceClass the interface to test if it is implemented.
         * @return <code>true</code> if the class passed as first argument extends
         * the class passed as second argument, <code>false</code> in other case.
         */
        public static boolean extendsClass(Class clazz, Class superClass) {
            if(superClass.equals(clazz.getSuperclass())) {
                return true;
            }
            return false;
        }

        /**
         * Returns <code>true</code> if the class passed as first argument is
         * primitive or a wrapper classes of them: int, Integer, char, Character,
         * boolean, Boolean, byte, Byte, etc. It returns <code>false</code> in other
         * case.
         * @param clazz the class to check.
         * @return <code>true</code> if the class passed as first argument is
         * primitive or a wrapper classes of them, <code>false</code> in other case.
         */
        public static boolean isPrimitive(Class clazz) {
            if (JsonFormatter.ReflexionUtils.extendsClass(clazz, Number.class) ||
                clazz.equals(Boolean.class) ||
                clazz.equals(Character.class)) {
                return true;
            }
            return false;
        }

        /**
         * Returns a Method from the name of the methond and a Class.
         * @param clazz the Class to extract the method.
         * @param name the name of the method.
         * @return the Method.
         */
        public static Method getMethod(final Class clazz, final String name) {
            Method method = null;
            for (Method m : clazz.getMethods()) {
                if (m.getName().equals(name)) {
                    method = m;
                    break;
                }
            }
            return method;
        }

        public static Method[] getGetMethods(Class clazz) {
            if (clazz == null) {
                return new Method[0];
            }

            List<Method> list = new ArrayList<Method>();
            for (Method method : clazz.getMethods()) {
                String name = method.getName();
                if (method.getParameterTypes().length == 0 
                    && !name.equals("getClass")
                    && name.length() > 3 
                    && name.startsWith("get")) {
                    list.add(method);
                }
            }

            return list.toArray(new Method[0]);
        }
        
        public static String getPropertyName(Method method) {
            String name = method.getName();
            if (method.getParameterTypes().length == 0
                && name.length() > 3 
                && name.startsWith("get")) {
                return JsonFormatter.StringUtils.toLowerCaseFirstLetter(name.substring(3));
            }
            return null;
        }
    }
}



