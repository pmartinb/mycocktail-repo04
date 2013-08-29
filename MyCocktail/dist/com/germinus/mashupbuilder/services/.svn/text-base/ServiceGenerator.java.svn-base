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

import com.germinus.util.CollectionsUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * This class generates a service for MyCocktail. It creates the JavaScript code
 * which is needed by MyCocktail to show a new service and to retrieve data from
 * the service.
 * @author David del Pozo González
 */
public class ServiceGenerator {
    /**
     * Represents json format.
     */
    private static final List<String> JSON = Arrays.asList("text/json", "application/json");
    /**
     * Represents xml format.
     */
    private static final List<String> XML = Arrays.asList("text/xml", "application/xml", "application/rss+xml", 
        "application/atom+xml", "application/rdf+xml");
    /**
     * Represents javascript format.
     */
    private static final List<String> JAVASCRIPT = Arrays.asList("text/javascript", "application/javascript");
    /**
     * The type of service.
     */
    private String serviceType;

    /**
     * Generates the JavaScript code which is needed by MyCocktail to show a
     * new service and to retrieve data from the service.
     * @param unitActionPackage the object of <code>UnitActionPackage</code>
     * type which contains the service information.
     * @return the JavaScript code as string
     */
    public final String generateUnitActionPackage(final UnitActionPackage unitActionPackage) {
        if (serviceType == null) {
            serviceType = "";
        } else {
            serviceType += ".";
        }

        StringBuilder service = new StringBuilder();
        service.append("(function() {").append("\n");
        service.append("  var service = new afrous.UnitActionPackage('Services.")
            .append(serviceType).append(unitActionPackage.getName()).append("', {").append("\n");
        service.append("  label : '").append(unitActionPackage.getName()).append("',").append("\n");
        service.append("  icon : '").append(unitActionPackage.getIcon()).append( "'").append("\n");
        service.append("});").append("\n\n");

        service.append("var baseURL = '").append(unitActionPackage.getBaseURL()).append("';")
            .append("\n").append("\n");

        List<UnitAction> unitActionList = unitActionPackage.getUnitActions();
        for (UnitAction unitAction : unitActionList) {
            service.append(generateUnitAction(unitAction));
        }
        service.append("afrous.packages.register(service, '")
            .append(unitActionPackage.getLibraryURL()).append("');").append("\n");
        service.append("})();");
        return service.toString();
    }

    /**
     * Generates the JavaScript code of a given UnitAction.
     * @param unitAction the UnitAction which is taken for generating the JavaScript
     * @return the JavaScript code
     */
    private String generateUnitAction(final UnitAction unitAction) {
        ExecuteMethod executeMethod = unitAction.getExecuteMethod();
        String stExecute = generateExecMethod(executeMethod);
        String inputs = generateInputs(unitAction.getInputs());

        StringBuilder sb = new StringBuilder();
        sb.append("service.register(new afrous.UnitAction({").append("\n");
        sb.append("  type:\"").append(unitAction.getType()).append("\",").append("\n");
        sb.append("  label:\"").append(unitAction.getLabel()).append("\",").append("\n");
        sb.append("  description:\"").append(unitAction.getDescription()).append("\",").append("\n");
        sb.append("  inputs:").append(inputs).append(",").append("\n");
        sb.append("  execute:").append(stExecute);
        sb.append("}));").append("\n");
        return sb.toString();
    }

    /**
     * Generates the JavaScript code of given parameters.
     * @param parameters the parameters which are taken for generating the JavaScript
     * @return the JavaScript code
     */
    private String generateInputs(final List<Parameter> parameters) {
        List<String> jsonObjects = new ArrayList<String>();
        for (Parameter parameter : parameters) {
            if (!parameter.isFixed()) {
                List<String> jsonParams = new ArrayList<String>();
                jsonParams.add("label:\"" + parameter.getLabel() + "\"");
                jsonParams.add("name:\"" + parameter.getName() + "\"");
                jsonParams.add("type:\"" + parameter.getType() + "\"");
                Set<String> options = parameter.getOptions();
                if (options != null && options.size() > 0) {
                    List<String> array = new ArrayList<String>();
                    for (String op : options) {
                        array.add("\"" + op + "\"");
                    }
                    jsonParams.add("options:[" + CollectionsUtil.join(array, ",") + "]");
                }
                jsonObjects.add("{" + CollectionsUtil.join(jsonParams, ",") + "}");
            }
        }
        return "[" + CollectionsUtil.join(jsonObjects, ",") + "]";
    }

    /**
     * Generates the JavaScript code of a given ExecuteMethod.
     * @param execMethod the ExecuteMethod which is taken for generating the JavaScript
     * @return the JavaScript code
     */
    private String generateExecMethod(final ExecuteMethod execMethod) {
        List<Parameter> parameters = execMethod.getParameters();
        String responseType = execMethod.getResponseType();
        String url = execMethod.getUrl();
        String httpMethod = execMethod.getHttpMethod();

        StringBuilder execute = new StringBuilder();
        execute.append("  function(request, callback) {").append("\n");
        execute.append("    var params = [];").append("\n");
        for (Parameter param : parameters) {
            execute.append("    var ").append(param.getName()).append(" = request.params['")
                .append(param.getName()).append("'] || '").append(param.getDefaultValue()).append("';").append("\n");
            if (param.isRequired()) {
                execute.append("    if(!").append(param.getName()).append(") return;");
            }
        }
        for (Parameter param : parameters) {
            if (Parameter.ParameterStyle.TEMPLATE == param.getStyle()) {
                url = url.replace("{" + param.getName() + "}", "'+" + param.getName() + "+'");
            } else if (Parameter.ParameterStyle.QUERY == param.getStyle()) {
                execute.append("    params.push('").append(param.getName()).append("='+encodeURIComponent(")
                    .append(param.getName()).append("));").append("\n");
            }
        }
        execute.append("    var url = baseURL + '").append(url).append("' + '?' + params.join('&');").append("\n");
        if (!JAVASCRIPT.contains(responseType)) {
            String format = null;
            if (JSON.contains(responseType)) {
                format = "json";
            } else /*if (XML.contains(responseType))*/ {
                format = "xml";
            }
            execute.append("    var proxy      = afrous.config.JSONP_PROXY_URL+'?responseFormat=")
                .append(format).append("&method=").append(httpMethod).append("&url=';").append("\n");
            execute.append("    var urlEncoded = afrous.url.urlEncode(url);").append("\n");
            execute.append("    url = proxy + urlEncoded;").append("\n");
        }
        execute.append("    afrous.ajax.jsonp.invoke(url, callback);").append("\n");
        execute.append("  }").append("\n");
        return execute.toString();
    }

    /**
     * Returns the type of service.
     * @return the type of service
     */
    public final String getServiceType() {
        return serviceType;
    }

    /**
     * Sets the type of service.
     * @param serviceType the type of service to set
     */
    public final void setServiceType(final String serviceType) {
        this.serviceType = serviceType;
    }
}
