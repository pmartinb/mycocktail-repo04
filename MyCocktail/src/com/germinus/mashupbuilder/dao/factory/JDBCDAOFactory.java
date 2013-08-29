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
import com.germinus.mashupbuilder.dao.connection.ConnectorProvider;
import java.sql.Connection;
import java.util.Properties;
import java.io.IOException;

/**
 * Factory which provides the connection and DAOs for a database which is
 * accessible with JDBC.
 * @author David del Pozo González
 */
public final class JDBCDAOFactory extends DAOFactory {

    /**
     * Creates a new instance of <code>JDBCDAOFactory</code>.
     */
    JDBCDAOFactory() {
    }

    /**
     * The path to the database configuration file.
     */
    private static final String PROPERTIES_PATH = "conf/db.properties";
    /**
     * The properties file with the configuration.
     */
    private static Properties dbProperties = null;
    /**
     * The connection provider to the JDBC data store.
     */
    private static ConnectorProvider connectionProvider = null;
    /**
     * The package where the DAOs (which implements JDBC) are.
     */
    public static final String DAO_PCKG = "com.germinus.mashupbuilder.dao.jdbc";

    /**
     * Loads the configuration of the database from the configuration file.
     * @throws IOException if an file input/ouput error occurs.
     */
    private static void loadProperties() throws IOException {
        dbProperties = new Properties();
        System.out.println(java.lang.System.getenv("VCAP_SERVICES"));
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPP"+JDBCDAOFactory.class.getClassLoader().getResource(PROPERTIES_PATH).getPath());
        dbProperties.load(
            JDBCDAOFactory.class.getClassLoader().getResourceAsStream(PROPERTIES_PATH));
    }

    /**
     * Retrieves the connection to the database.
     * @return the connection to the database
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    public static Connection getConnection() throws DAOException {
        return getConnectionProvider().getConnection();
    }

    /**
     * Retrieves a conection provider which can provide the connection to the
     * database.
     * @return the conection provider for the database.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    public static ConnectorProvider getConnectionProvider() throws DAOException {
        if (connectionProvider == null) {
            try {
                if (dbProperties == null) {
                    loadProperties();
                }

                String provicerClassName =
                    dbProperties.getProperty("connectorProvider",
                    "com.germinus.mashupbuilder.dao.connection.StandardConnectorProvider");
                Class provicerClass = Class.forName(provicerClassName);
                connectionProvider = (ConnectorProvider) provicerClass.newInstance();
            } catch (InstantiationException ex) {
                throw new DAOException("The Connection Provider cannot be instantiated", ex);
            } catch (IllegalAccessException ex) {
                throw new DAOException("The Connection Provider cannot be instantiated", ex);
            } catch (ClassNotFoundException ex) {
                throw new DAOException("The Connection Provider cannot be instantiated", ex);
            } catch (IOException ex) {
                throw new DAOException("Database configuration file is not found", ex);
            }
        }
        return connectionProvider;
    }

    /**
     * Retrieves the implementation of a DAO.
     * @return the connection to the database
     */
    public DAO getDAO(Class<?> clazz) throws DAOException {
        try {
            String name = clazz.getSimpleName();
            Class<DAO> daoClass = (Class<DAO>) Class.forName(DAO_PCKG + "." + name + "JDBCDAOImpl");
            return daoClass.newInstance();
        } catch (Exception ex) {
            throw new DAOException("No DAO implementation for selected class", ex);
        }
    }
}
