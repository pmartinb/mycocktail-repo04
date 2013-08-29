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

import com.germinus.util.UtilReflexion;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * This class formats an object to XML format.
 * @author David del Pozo González
 */
public final class XMLFormatter {

    /**
     * Creates a new instance of <code>XMLFormatter</code>.
     */
    private XMLFormatter() {
    }

    /**
     * Convers an object into XML format.
     * @param object the object to convert
     * @return the String with the XML representation of the object.
     */
    public static String toXML(final Object object) {
        String xml = null;
        if (object instanceof Collection || object instanceof Object[]) {
            Object[] list = null;
            if (object instanceof Collection) {
                list = ((Collection) object).toArray();
            } else {
                list = (Object[]) object;
            }

            xml = toXmlArray(list);
        } else {
            xml = toXmlObject(object);
        }
        return xml;
    }

    /**
     * Converts an array into XML format.
     * @param list the array of objects.
     * @return the XML
     */
    private static String toXmlArray(final Object[] list) {
        StringBuilder sb = new StringBuilder();

        if (list.length > 0) {
            for (Object ob : list) {
                String st = toXML(ob);
                if (st != null) {
                    sb.append(st);
                }
            }

            String name = list[0].getClass().getSimpleName();
            if (!name.endsWith("s")) {
                if (name.endsWith("ss") || name.endsWith("sh")) {
                    name += "es";
                } else {
                    name += "s";
                }
            }
//            sb.insert(0, "<"  + name + ">");
//            sb.append(   "</" + name + ">");
        }

        return sb.toString();
    }

    /**
     * Converts a Java object to XML reperesentation.
     * @param object the object to convert
     * @return the resultant xml
     */
    private static String toXmlObject(final Object object) {
        StringBuilder sb = new StringBuilder();
        Class clazz = object.getClass();
        String name = clazz.getSimpleName();
        sb.append("<").append(name).append(">");
        if (UtilReflexion.implementsInterface(clazz, CharSequence.class) ||
                    UtilReflexion.implementsInterface(clazz, Number.class) ||
                    clazz.equals(Boolean.class) || 
                    clazz.equals(Character.class)) {
            sb.append(object);
        } else {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                String st = getElement(clazz, object, field);
                if (st != null) {
                    sb.append(st);
                }
            }
        }
        sb.append("</").append(name).append(">");
        return sb.toString();
    }

    /**
     * Convers a field of an object into XML format.
     * @param clazz the class of the object
     * @param object the object to extract the field
     * @param field the field to extract the value
     * @return the field in XML format.
     */
    private static String getElement(final Class<?> clazz, final Object object, final Field field) {
        StringBuilder sb = new StringBuilder();
        try {
            String name = field.getName();
            Method method = clazz.getMethod("get" + toUpperCaseFirstLetter(name));
            if (method != null) {
                Class returnType = method.getReturnType();
                Object returnedValue = method.invoke(object, new Object[0]);
                if (returnedValue != null) {
                    String value = returnedValue.toString();
                    sb.append("<").append(name).append(">");
                    if (UtilReflexion.implementsInterface(returnType, CharSequence.class) ||
                        UtilReflexion.implementsInterface(returnType, Number.class) ||
                        returnType.equals(Boolean.class) || 
                        returnType.equals(Character.class)) {

                        sb.append("<![CDATA[");
                        sb.append(value);
                        sb.append("]]>");
                    } else {
                        sb.append(toXML(returnedValue));
                    }
                    sb.append("</").append(name).append(">");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getClass()+" "+ex.getMessage());
        }
        return sb.toString();
    }

    /**
     * Puts the first letter of a String into upper case.
     * @param string the string to convert.
     * @return a String with the first letter of a String into upper case.
     */
    private static String toUpperCaseFirstLetter(final String string) {
        String returnString = null;
        if (string.length() < 1) {
            returnString = string;
        } else {
            char[] characters = string.toCharArray();
            characters[0] = Character.toUpperCase(characters[0]);

            returnString = new String(characters);
        }
        return returnString;
    }
}
