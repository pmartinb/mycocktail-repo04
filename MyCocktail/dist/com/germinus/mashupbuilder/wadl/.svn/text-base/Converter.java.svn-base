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
package com.germinus.mashupbuilder.wadl;

import com.germinus.mashupbuilder.services.ExecuteMethod;
import com.germinus.mashupbuilder.services.Parameter;
import com.germinus.mashupbuilder.services.UnitAction;
import com.germinus.mashupbuilder.services.UnitActionPackage;
import com.sun.research.wadl.x2006.x10.Application;
import com.sun.research.wadl.x2006.x10.Method;
import com.sun.research.wadl.x2006.x10.Option;
import com.sun.research.wadl.x2006.x10.Param;
import com.sun.research.wadl.x2006.x10.Representation;
import com.sun.research.wadl.x2006.x10.Request;
import com.sun.research.wadl.x2006.x10.Resource;
import com.sun.research.wadl.x2006.x10.Resources;
import com.sun.research.wadl.x2006.x10.Response;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

/**
 * This class converts the WADL XMLBeans objects into a
 * <code>UnitActionPackage</code> object.
 * @author David del Pozo González
 */
final class Converter {

    /**
     * Creates a new instance of <code>Converter</code>.
     */
    private Converter() {
    }

    /**
     * Converts the <code>Application</code> XMLBean into a <code>UnitActionPackage</code> object.
     * @param application  the <code>Application</code> XMLBean to convert.
     * @return the converted <code>UnitActionPackage</code> object.
     */
    public static UnitActionPackage convertWADLtoUnitActionPackage(final Application application) {
        Resources resources = application.getResources();
        String baseURL = resources.getBase();
        if (!baseURL.endsWith("/")) {
            baseURL += "/";
        }
        List<Resource> resourceList = resources.getResourceList();

        List<UnitAction> unitActionList = new ArrayList<UnitAction>();
        for (Resource resource : resourceList) {
            unitActionList.addAll(convertResourceToUnitAction(resource));
        }

        UnitActionPackage unitActionPackage = new UnitActionPackage();
        unitActionPackage.setBaseURL(baseURL);
        unitActionPackage.setUnitActions(unitActionList);
        return unitActionPackage;
    }

    /**
     * Converts the <code>Resource</code> XMLBean into a list of <code>UnitAction</code> objects.
     * @param resource the <code>Resource</code> XMLBean to convert.
     * @return a list of <code>UnitAction</code> objects.
     */
    private static List<UnitAction> convertResourceToUnitAction(final Resource resource) {
        return convertResourceToUnitAction(resource, "");
    }

    /**
     * Converts the <code>Resource</code> XMLBean into a list of <code>UnitAction</code> objects.
     * @param resource the <code>Resource</code> XMLBean to convert.
     * @param parentPath the parent path to the resource.
     * @return a list of <code>UnitAction</code> objects.
     */
    private static List<UnitAction> convertResourceToUnitAction(final Resource resource,
        final String parentPath) {
        String path = resource.getPath();
        if (path == null) {
            path = "";
        } else if (!path.startsWith("/") && !parentPath.equals("")) {
            path = "/" + path;
        }
        path = (parentPath + path).replace("//", "/");

        //Resource can contain another Resource or a Method
        List<Resource> resourceList = resource.getResourceList();
        List<UnitAction> unitActionList = new ArrayList<UnitAction>();
        if (resourceList != null && resourceList.size() > 0) {
            for (Resource res : resourceList) {
                unitActionList.addAll(convertResourceToUnitAction(res, path));
            }
        } else {
            List<Method> methodList = resource.getMethodList();
            if (methodList != null && methodList.size() > 0) {
                for (Method method : methodList) {
                    unitActionList.add(convertMethodToUnitAction(method, resource, path));
                }
            }
        }
        return unitActionList;
    }

    /**
     * Converts the <code>Method</code> and <code>Resource</code> XMLBean into a
     * <code>UnitAction</code> object.
     * @param method the <code>Method</code> XMLBean to convert.
     * @param resource the <code>Resource</code> XMLBean to convert.
     * @param path the parent path to the resource.
     * @return a <code>UnitAction</code> object.
     */
    private static UnitAction convertMethodToUnitAction(final Method method,
        final Resource resource, final String path) {
        String id = method.getId();
        String methodName = method.getName();
        Request request = method.getRequest();

        List<Parameter> parameters = new ArrayList<Parameter>();
        if (request != null) {
            List<Param> params = request.getParamList();
            if (params != null) {
                for (Param param : params) {
                    Parameter parameter = convertParameter(param);
                    parameter.setStyle(Parameter.ParameterStyle.QUERY);
                    parameters.add(parameter);
                }
            }
        }
        List<Param> params = resource.getParamList();
        if (params != null) {
            for (Param param : params) {
                Parameter parameter = convertParameter(param);
                parameter.setStyle(Parameter.ParameterStyle.TEMPLATE);
                parameters.add(parameter);
            }
        }

        ExecuteMethod executeMethod = new ExecuteMethod();
        executeMethod.setParameters(parameters);
        executeMethod.setUrl(path);
        executeMethod.setHttpMethod(methodName);

        Response response = method.getResponse();
        if (response != null) {
            Representation representation = response.getRepresentation();
            if (representation != null) {
                String mediaType = representation.getMediaType();
                executeMethod.setResponseType(mediaType);
            }
        }

        UnitAction unitAction = new UnitAction();
        unitAction.setType(id);
        unitAction.setLabel(id);
        unitAction.setDescription(id);
        unitAction.setInputs(parameters);
        unitAction.setExecuteMethod(executeMethod);

        return unitAction;
    }

    /**
     * Converts the <code>Param</code> XMLBean into a <code>Parameter</code> object.
     * @param param the <code>Param</code> XMLBean to convert.
     * @return a <code>Parameter</code> object.
     */
    private static Parameter convertParameter(final Param param) {
        //Extracting
        String name = param.getName();
        Boolean required = param.getRequired();
//      ParamStyle.Enum style = param.getStyle();
        String type = param.getType();
        String fixed = param.getFixed();
        String defaultValue = param.getDefault();
        List<Option> paramOps = param.getOptionList();
        type = convertType(type);

        //Filling
        Parameter parameter = new Parameter();
        parameter.setLabel(name);
        parameter.setName(name);
        parameter.setType(type);
        parameter.setRequired(required);
        if (fixed != null) {
            parameter.setDefaultValue(fixed);
            parameter.setFixed(true);
        } else {
            parameter.setDefaultValue(defaultValue);
        }
        if (paramOps != null && paramOps.size() > 0) {
            Set<String> options = new HashSet<String>();
            for (Option op : paramOps) {
                options.add(op.getValue());
            }
            parameter.setOptions(options);
        }
        return parameter;
    }

    /**
     * Converts the WADL format into a format for UnitAction.
     * @param type the wadl type.
     * @return the format for UnitAction
     */
    private static String convertType(final String type) {
        String convertedType = null;
        if ("xsd:int".equals(type)) {
            convertedType = "Integer";
        } else {
            convertedType = "String";
        }
        return convertedType;
    }
}
