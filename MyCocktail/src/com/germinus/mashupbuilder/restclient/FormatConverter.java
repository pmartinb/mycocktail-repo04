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
package com.germinus.mashupbuilder.restclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/**
 * Class which converts between JSON and XML and vice versa.
 * @author David del Pozo González
 */
public final class FormatConverter {

    /**
     * Creates a new instance of <code>FormatConverter</code>.
     */
    private FormatConverter() {
    }

    /**
     * Formats supported by this converter.
     */
    public enum Format {
        /**
         * Represents JSON format.
         */
        JSON("JSON"),
        /**
         * Represents XML format.
         */
        XML("XML");
        /**
         * The text which indetified the format.
         */
        private String format;

        /**
         * Creates a instance of a format.
         * @param formatName format the text which indetified the format.
         */
        Format(final String formatName) {
            this.format = formatName;
        }
    }

    /**
     * Converts to JSON.
     * @param message the message to convert
     * @param originFormat the format of the given message to convert
     * @return the JSON message
     */
    public static String toJson(final String message, final Format originFormat) {
        String formattedMessage = null;
        if (originFormat == Format.XML) {
            try {
                formattedMessage = XML.toJSONObject(message).toString();
            } catch (JSONException ex) {
                Logger.getLogger(FormatConverter.class.getName()).log(Level.WARNING, null, ex);
                formattedMessage = "{error:'Proxy Error: Error parsing XML'}";
            }
        }
        return formattedMessage;
    }

    /**
     * Converts to XML.
     * @param message the message to convert
     * @param originFormat the format of the given message to convert
     * @return the XML message
     */
    public static String toXML(final String message, final Format originFormat) {
        String formatedMessage = null;
        if (originFormat == Format.JSON) {
            try {
                formatedMessage = XML.toString(new JSONObject(message));
            } catch (JSONException ex) {
                Logger.getLogger(FormatConverter.class.getName()).log(Level.WARNING, null, ex);
                formatedMessage = "<error>Proxy Error: Error parsing XML<error>";
            }
        }
        return formatedMessage;
    }
}
