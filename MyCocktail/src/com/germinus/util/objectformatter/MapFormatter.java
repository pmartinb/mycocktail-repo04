/*
 * Copyright 2010 David del Pozo González (dpozog--at--grupogesfor.com)
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class formats a JSON into a Map<String, Object>
 * @author David del Pozo González
 */
public class MapFormatter {
    /**
     * Converts a JSON into a Map.
     * @param jsonObject the JSON to convert
     * @return the Map with the information of the JSON
     */
    public Map<String, Object> processJson(String jsonObject) {
        jsonObject = removeFirstAndLastCurlyBrackets(jsonObject);

        String elems[] = getObjectElements(jsonObject);

        Map<String, Object> elements = new HashMap<String, Object>();
        for(String elem : elems) {
            String key     = null;
            String valueSt = null;

            int colonIndex = elem.indexOf(":");
            if (colonIndex == -1) {
                valueSt = elem;
            } else {
                valueSt = elem.substring(colonIndex+1, elem.length());
                key = elem.substring(0, colonIndex);
                if (key != null)
                    key = clean(key);
            }

            Object value = null;
            if (valueSt != null) {
                if (valueSt.indexOf("\"") == 0 && valueSt.lastIndexOf("\"") == valueSt.length()-1) {
                    value = clean(valueSt);
                } else if (valueSt.indexOf("[") == 0 && valueSt.lastIndexOf("]") == valueSt.length()-1) {
                    value = processArray(valueSt);
                } else if(valueSt.indexOf("{") == 0 && valueSt.lastIndexOf("}") == valueSt.length()-1) {
                    value = processJson(valueSt);
                } else {
                    value = valueSt;
                }
            }

            elements.put(key, value);
        }
        return elements;
    }

    private Object[] processArray(String jsonArray) {
        jsonArray = removeFirstAndLastSquareBrackets(jsonArray);
        if (jsonArray.length() == 0)
            return new Object[0];

        String items[] = getObjectElements(jsonArray);

        Object[] itemObjs = new Object[items.length];
        for (int i=0; i<items.length; i++) {
            String item = items[i];
            if (item != null) {
                if (item.indexOf("\"") == 0 && item.lastIndexOf("\"") == item.length()-1) {
                    itemObjs[i] = clean(item);
                } else if (item.indexOf("[") == 0 && item.lastIndexOf("]") == item.length()-1) {
                    itemObjs[i] = processArray(item);
                } else if(item.indexOf("{") == 0 && item.lastIndexOf("}") == item.length()-1) {
                    itemObjs[i] = processJson(item);
                } else {
                    itemObjs[i] = item;
                }
            }
        }

        return itemObjs;
    }

    private String removeFirstAndLastCurlyBrackets(String json) {
        int first = json.indexOf("{");
        int last  = json.lastIndexOf("}");
        return json.substring(first+1, last);
    }

    private String removeFirstAndLastSquareBrackets(String json) {
        int first = json.indexOf("[");
        int last  = json.lastIndexOf("]");
        return json.substring(first+1, last);
    }

    private String[] getObjectElements(String jsonObject) {
        char[] chars = jsonObject.toCharArray();

        int openCurlyBraces     = 0;
        int openSquareBraces    = 0;
        int openQuotation       = 0;
        int openQuotationDouble = 0;

        int lastCommaIndex = 0;

        List<String> elements = new ArrayList<String>();
        for(int index=0; index<chars.length; index++) {
            char c = chars[index];

            switch(c) {
                case '"':
                    if (openQuotationDouble==0)
                        openQuotationDouble = 1;
                    else
                        openQuotationDouble = 0;
                    break;
                case '\'':
                    if (openQuotation==0)
                        openQuotation = 1;
                    else
                        openQuotation = 0;
                    break;
                case '{':
                    if (openQuotation == 0 && openQuotationDouble == 0)
                        openCurlyBraces++;
                    break;
                case '}':
                    if (openQuotation == 0 && openQuotationDouble == 0)
                        openCurlyBraces--;
                    break;
                case '[':
                    if (openQuotation == 0 && openQuotationDouble == 0)
                        openSquareBraces++;
                    break;
                case ']':
                    if (openQuotation == 0 && openQuotationDouble == 0)
                        openSquareBraces--;
                    break;
                case ',':
                    if (openQuotation == 0 && openQuotationDouble == 0 &&
                        openCurlyBraces == 0 && openSquareBraces == 0) {
                        if(lastCommaIndex == 0)
                            elements.add(jsonObject.substring(0, index));
                        else
                            elements.add(jsonObject.substring(lastCommaIndex+1, index));
                        lastCommaIndex = index;
                    }
                    break;
            }
        }

        if(lastCommaIndex != 0)
            elements.add(jsonObject.substring(lastCommaIndex+1, jsonObject.length()));
        else
            elements.add(jsonObject);

        return elements.toArray(new String[0]);
    }

    private String clean(String string) {
        string = string.trim();
        return string.substring(1, string.length()-1);
    }

    public static void main(String... args) {
       String json = "{\"name\":\"\",\"description\":\"\","+
        "\"requires\":{\"Renderer.Widgets\":\"http://localhost:8084/MyCocktail/js/afrous/renderers/widgets.js\"},"+
        "\"params\":[],\"output\":\"${flickrwidget}\","+
        "\"actions\":[{\"type\":\"Renderer.Widgets.FlickrWidget\",\"name\":\"flickrwidget\",\"inputs\":{\"feedURL\":\"car\"}}]}";

       MapFormatter mapFormatter = new MapFormatter();
       Map<String,Object> jsonMap = mapFormatter.processJson(json);

       System.out.println("e");
    }
}
