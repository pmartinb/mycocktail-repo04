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

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.germinus.mashupbuilder.restclient.FormatConverter.Format;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is a client of REST Services.
 * @author David del Pozo González
 */
public final class RESTClient {
    /**
     * Error explanation.
     */
    private static final String ERROR = "The request did not accomplished successfully";

    /**
     * Creates a new instance of <code>RESTClient</code>.
     */
    private RESTClient() {
    }

    /**
     * Contains the representations of HTTP methods.
     */
    public enum HTTP_METHOD {
        /**
         * Represents get HTTP method.
         */
        GET,
        /**
         * Represents put HTTP method.
         */
        PUT,
        /**
         * Represents post HTTP method.
         */
        POST,
        /**
         * Represents delete HTTP method.
         */
        DELETE
    }

    /**
     * @param url the URL to invoke in the request.
     * @param method the HTTP method.
     * @return the response.
     */
    public static String request(final String url, final HTTP_METHOD method) {
        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource(url);
        String response = null;
        switch (method) {
            case POST:
                response = webResource.post(String.class);
                break;
            case PUT:
                response = webResource.put(String.class);
                break;
            case DELETE:
                response = webResource.delete(String.class);
                break;
            case GET:
            default:
                response = webResource.get(String.class);
                break;
        }
        return response;
    }

    /**
     * Makes a request with the specified HTTP method.
     * @param url the URL to invoke in the request.
     * @param method the HTTP method.
     * @param responseType the response type of the request.
     * @return the response.
     */
    public static String request(final String url, final HTTP_METHOD method,
        final Format responseType) {
        return request(url, method, responseType, responseType);
    }

    /**
     * Makes a request with the specified HTTP method.
     * @param url the URL to invoke in the request.
     * @param method the HTTP method.
     * @param responseType the response type of the request.
     * @param finalFormat the format in which the responseType is converted.
     * @return the response.
     */
    public static String request(final String url, final HTTP_METHOD method,
        final Format responseType, final Format finalFormat) {

        String response = null;
        try {
            response = request(url, method);

            if (responseType != finalFormat) {
                switch (finalFormat) {
                    case XML:
                        response = FormatConverter.toXML(response, responseType);
                        break;
                    case JSON:
                    default:
                        response = FormatConverter.toJson(response, responseType);
                        break;
                }
            }
        } catch (UniformInterfaceException e) {
            Logger.getLogger(RESTClient.class.getName()).log(Level.INFO, null, e);
            switch (finalFormat) {
                case XML:
                    response = "<error>" + ERROR + "</error>";
                    break;
                case JSON:
                default:
                    response = "{error:\"" + ERROR + "\"}";
                    break;
            }
        }
        return response;
    }
}
