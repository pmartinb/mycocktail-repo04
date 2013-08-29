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
package com.germinus.mashupbuilder.dao.factory;

import com.germinus.mashupbuilder.dao.DAO;
import com.germinus.mashupbuilder.dao.DAOException;

/**
 * Factory which provides the connection and DAOs for a database which is
 * accessible with JDBC.
 * @author David del Pozo González
 */
public abstract class DAOFactory {
    // List of DAO types supported by the factory
    public enum FactoryType {
        JDBC;
    }

    /**
     * Retrieves the implementation of a DAO.
     * @return the connection to the database
     */
    public abstract DAO getDAO(Class<?> clazz) throws DAOException;

    /**
     * Returns a factory of DAOs.
     * @param whichFactory the type of DAO factory.
     * @return a factory of DAOs.
     */
    public static DAOFactory getDAOFactory(FactoryType whichFactory) {
        
        switch (whichFactory) {
            case JDBC:
                return new JDBCDAOFactory();
            default:
                return null;
        }
    }
}
