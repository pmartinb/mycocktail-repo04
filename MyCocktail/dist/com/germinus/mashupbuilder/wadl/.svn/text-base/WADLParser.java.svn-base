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

import com.germinus.mashupbuilder.services.UnitActionPackage;
import com.sun.research.wadl.x2006.x10.Application;
import com.sun.research.wadl.x2006.x10.ApplicationDocument;
import org.apache.xmlbeans.XmlException;

/**
 * This class converts the WADL into an object of <code>UnitActionPackage</code>
 * type.
 * @author David del Pozo González
 */
public final class WADLParser {

    /**
     * Creates a new instance of <code>WADLParser</code>.
     */
    private WADLParser() {
    }

    /**
     * Converts the WADL into an object of <code>UnitActionPackage</code>
     * type.
     * @param wadl the WADL as String
     * @return the <code>UnitActionPackage</code>
     * @throws XmlException if an error ocurrs.
     */
    public static UnitActionPackage parseWADL(final String wadl) throws XmlException {
        ApplicationDocument applicationDocument = ApplicationDocument.Factory.parse(wadl);
        Application application = applicationDocument.getApplication();
        return Converter.convertWADLtoUnitActionPackage(application);
    }
}
