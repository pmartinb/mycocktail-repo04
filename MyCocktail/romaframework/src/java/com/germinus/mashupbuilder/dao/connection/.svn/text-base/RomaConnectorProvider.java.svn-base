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
package com.germinus.mashupbuilder.dao.connection;

import java.sql.Connection;
import org.romaframework.aspect.persistence.PersistenceAspect;
import org.romaframework.aspect.persistence.jdbc.JDBCDatasource;
import org.romaframework.core.Roma;

/**
 * This class is a connection provider for a database of an application build
 * with Roma Metaframework.
 * @author David del Pozo González
 */
public class RomaConnectorProvider implements ConnectorProvider {
    /**
     * Retrieves a database connection configured in an application
     * build with Roma Metaframework.
     * @return a database connection configured in an application
     * build with Roma Metaframework.
     */
    public final Connection getConnection() {
        return ((JDBCDatasource) Roma.component(PersistenceAspect.class)).getConnection();
    }
}
