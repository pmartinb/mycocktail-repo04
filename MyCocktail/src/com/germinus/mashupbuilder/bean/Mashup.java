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

package com.germinus.mashupbuilder.bean;

/**
 * Entity class which represents a MyCocktail mashup.
 * @author David del Pozo González
 */
public class Mashup {

    /**
     * The id of the mashup.
     */
    private Integer id;
    /**
     * The name of the mashup.
     */
    private String name;
    /**
     * The description of the mashup.
     */
    private String description;
    /**
     * The json which represents the mashup.
     */
    private String json;

    /**
     * Creates a new mashup.
     */
    public Mashup() {
    }

    /**
     * Creates a new mashup.
     * @param id the id of the mashup
     * @param name the name of the mashup
     * @param description the description of the mashup
     * @param json the json which represents the mashup
     */
    public Mashup(final Integer id, final String name, final String description,
        final String json) {
        this(name, description, json);
        this.id = id;
    }

    /**
     * Creates a new mashup.
     * @param name the name of the mashup
     * @param description the description of the mashup
     * @param json the json which represents the mashup
     */
    public Mashup(final String name, final String description,
        final String json) {
        this.name = name;
        this.description = description;
        this.json = json;
    }

    /**
     * Gets the id of the mashup.
     * @return the id
     */
    public final Integer getId() {
      return id;
    }

    /**
     * Sets the id of the mashup.
     * @param id the id to set
     */
    public final void setId(final Integer id) {
      this.id = id;
    }

    /**
     * Gets the description of the mashup.
     * @return the description
     */
    public final String getDescription() {
      return description;
    }

    /**
     * Sets the description of the mashup.
     * @param description the description to set
     */
    public final void setDescription(final String description) {
      this.description = description;
    }

    /**
     * Gets the json of the mashup.
     * @return the json which represents the mashup
     */
    public final String getJson() {
      return json;
    }

    /**
     * Sets the json of the mashup.
     * @param json the json which represents the mashup
     */
    public final void setJson(final String json) {
      this.json = json;
    }

    /**
     * Gets the name of the mashup.
     * @return the name
     */
    public final String getName() {
      return name;
    }

    /**
     * Sets the name of the mashup.
     * @param name the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }
}
