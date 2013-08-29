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

package com.germinus.mashupbuilder.bean;

/**
 * Entity class which represents a page created with MyCocktail Editor.
 * @author David del Pozo González
 */
public class Page {
    /**
     * The id of the page.
     */
    private Integer id;
    /**
     * The name of the page.
     */
    private String name;
    /**
     * The description of the page.
     */
    private String description;
    /**
     * The json which represents the page.
     */
    private String json;

    /**
     * Creates a new page.
     */
    public Page() {
    }

    /**
     * Creates a new page.
     * @param id the id of the page
     * @param name the name of the page
     * @param description the description of the page
     * @param json the json which represents the page
     */
    public Page(final Integer id, final String name, final String description,
        final String json) {
        this(name, description, json);
        this.id = id;
    }

    /**
     * Creates a new page.
     * @param name the name of the page
     * @param description the description of the page
     * @param json the json which represents the page
     */
    public Page(final String name, final String description,
        final String json) {
        this.name = name;
        this.description = description;
        this.json = json;
    }

    /**
     * Gets the id of the page.
     * @return the id
     */
    public final Integer getId() {
      return id;
    }

    /**
     * Sets the id of the page.
     * @param id the id to set
     */
    public final void setId(final Integer id) {
      this.id = id;
    }

    /**
     * Gets the description of the page.
     * @return the description
     */
    public final String getDescription() {
      return description;
    }

    /**
     * Sets the description of the page.
     * @param description the description to set
     */
    public final void setDescription(final String description) {
      this.description = description;
    }

    /**
     * Gets the json of the page.
     * @return the json which represents the page
     */
    public final String getJson() {
      return json;
    }

    /**
     * Sets the json of the page.
     * @param json the json which represents the page
     */
    public final void setJson(final String json) {
      this.json = json;
    }

    /**
     * Gets the name of the page.
     * @return the name
     */
    public final String getName() {
      return name;
    }

    /**
     * Sets the name of the page.
     * @param name the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }
}
