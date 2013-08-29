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

import com.germinus.mashupbuilder.dao.DAOException;
import java.sql.Connection;

/**
 * This interface has the method to get a dabase connection.
 * @author David del Pozo González
 */
public interface ConnectorProvider {
    /**
     * Retrives a database connection.
     * @return a database connection
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    Connection getConnection() throws DAOException;
}
