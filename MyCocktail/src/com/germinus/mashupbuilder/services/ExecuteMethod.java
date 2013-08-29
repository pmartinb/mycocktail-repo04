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
package com.germinus.mashupbuilder.services;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the parameters needed to create the MyCocktail method
 * which performs the petition to reach a service.
 * @author David del Pozo González
 */
public class ExecuteMethod {
    /**
     * The URL where is published the service.
     */
    private String url;
    /**
     * The parameters accepted by the service.
     */
    private List<Parameter> parameters = new ArrayList<Parameter>();
    /**
     * The response type of the service.
     */
    private String responseType;
    /**
     * The HTTP Method for the request.
     */
    private String httpMethod;

    /**
     * Gets the URL where is published the service.
     * @return the url the URL where is published the service.
     */
    public final String getUrl() {
        return url;
    }

    /**
     * Sets the URL where is published the service.
     * @param url the URL where is published the service.
     */
    public final void setUrl(final String url) {
        this.url = url;
    }

    /**
     * Gets the parameters accepted by the service.
     * @return the parameters accepted by the service.
     */
    public final List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * Sets the parameters accepted by the service.
     * @param parameters the parameters accepted by the service.
     */
    public final void setParameters(final List<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * Gets the response type of the service.
     * @return the responseType the response type of the service.
     */
    public final String getResponseType() {
        return responseType;
    }

    /**
     * Sets the response type of the service.
     * @param responseType the response type of the service.
     */
    public final void setResponseType(final String responseType) {
        this.responseType = responseType;
    }

    /**
     * Sets the HTTP Method for the request.
     * @param httpMethod the HTTP method
     */
    public final void setHttpMethod(final String httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * Gets the HTTP Method for the request.
     * @return the HTTP Method
     */
    public final String getHttpMethod() {
        return httpMethod;
    }
}
