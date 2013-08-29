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

import java.util.Set;

/**
 * This class represent a parameter to send like an HTTP request paramenter
 * with MyCocktail.
 * @author David del Pozo González
 */
public class Parameter {
    /**
     * Represents the parameters styles.
     */
    public enum ParameterStyle {
        /**
         * Represents QUERY parameter style.
         */
        QUERY,
        /**
         * Represents TEMPLATE parameter style.
         */
        TEMPLATE
    };
    /**
     * The label of the parameter.
     */
    private String label;
    /**
     * The name of the parameter.
     */
    private String name;
    /**
     * The type of the parameter.
     */
    private String type;
    /**
     * The possible input options for the parameter.
     */
    private Set<String> options = null;
    /**
     * The default value of the parameter.
     */
    private String defaultValue;
    /**
     * Indicates if the parameter is mandatory or not.
     */
    private boolean required;
    /**
     * Indicates if the parameter is fixed.
     */
    private boolean fixed;
    /**
     * The parameter style.
     */
    private ParameterStyle style;

    /**
     * Creates a <code>Parameter</code> instance.
     */
    public Parameter() {
    }

    /**
     * Creates a <code>Parameter</code> instance.
     * @param name the name to set.
     */
    public Parameter(final String name) {
        this(name, name, "String");
    }

    /**
     * Creates a <code>Parameter</code> instance.
     * @param name the name to set.
     * @param type the type to set.
     */
    public Parameter(final String name, final String type) {
        this(name, name, type);
    }

    /**
     * Creates a <code>Parameter</code> instance.
     * @param label the label to set.
     * @param name the name to set.
     * @param type the type to set.
     */
    public Parameter(final String label, final String name, final String type) {
        this.label = label;
        this.name = name;
        this.type = type;
    }

    /**
     * Returns the label of the parameter.
     * @return the label of the parameter.
     */
    public final String getLabel() {
        return label;
    }

    /**
     * Sets the label of the parameter.
     * @param label the label to set.
     */
    public final void setLabel(final String label) {
        this.label = label;
    }

    /**
     * Returns the name of the parameter.
     * @return the name of the parameter.
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the name of the parameter.
     * @param name the name to set.
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns the type of the parameter.
     * @return the type of the parameter.
     */
    public final String getType() {
        return type;
    }

    /**
     * Sets the type of the parameter.
     * @param type the type to set.
     */
    public final void setType(final String type) {
        this.type = type;
    }

    /**
     * Returns the possible input options for the parameter.
     * @return the possible input options for the parameter.
     */
    public final Set<String> getOptions() {
        return options;
    }

    /**
     * Sets the possible input options for the parameter.
     * @param options the options to set.
     */
    public final void setOptions(final Set<String> options) {
        this.options = options;
    }

    /**
     * Returns the default value of the parameter.
     * @return the defaultValue of the parameter.
     */
    public final String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the default value of the parameter.
     * @param defaultValue the defaultValue to set.
     */
    public final void setDefaultValue(final String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * Returns <code>true</code> if the paramenter is mandatory or
     * <code>false</code> in other case.
     * @return <code>true</code> if the paramenter is mandatory or
     * <code>false</code> in other case.
     */
    public final boolean isRequired() {
        return required;
    }

    /**
     * Sets if the parameter is mandatory or not.
     * @param required the value to set.
     */
    public final void setRequired(final boolean required) {
        this.required = required;
    }

    /**
     * Returns the parameter style.
     * @return the parameter style
     */
    public final ParameterStyle getStyle() {
        return style;
    }

    /**
     * Sets the parameter style.
     * @param style the parameter style to set
     */
    public final void setStyle(final ParameterStyle style) {
        this.style = style;
    }

    /**
     * Indicates if the parameter is fixed.
     * @return returns <code>true></code> if the parameter is fixed or
     * <code>false</code> in case it is not fixed.
     */
    public final boolean isFixed() {
        return fixed;
    }

    /**
     * Sets if the parameter is fixed.
     * @param fixed <code>true></code> if the parameter is fixed or
     * <code>false</code> in case it is not fixed.
     */
    public final void setFixed(final boolean fixed) {
        this.fixed = fixed;
    }
}
