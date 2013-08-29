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
package com.germinus.mashupbuilder.dao.jdbc;

import com.germinus.mashupbuilder.bean.Page;
import com.germinus.mashupbuilder.dao.DAO;
import com.germinus.mashupbuilder.dao.DAOException;
import java.util.List;

/**
 * This interface provides all the methods which are operations with the data
 * source for the object <code>Page</code>.
 * @author David del Pozo González
 */
public interface PageDAO extends DAO {
    /**
     * Stores an object of <code>Page</code> type into the data source.
     * @param page the page to store.
     * @return returns the number of registers modified in the data source or
     * 0 if the operation had no success.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    int save(Page page) throws DAOException;

    /**
     * Stores an object of <code>Page</code> type into the data source.
     * @param page the page to store.
     * @return returns the identifier of the page stored.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    int saveAndGetId(Page page) throws DAOException;

    /**
     * Updates an object of <code>Page</code> type from the data source.
     * @param page the page to update.
     * @return returns the number of registers modified in the data source or
     * 0 if the operation had no success.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    int update(Page page) throws DAOException;

    /**
     * Updates an object of <code>Page</code> type from the data source, but
     * only update the property <code>json</code>.
     * @param page the page to update.
     * @return returns the number of registers modified in the data source or
     * 0 if the operation had no success.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    int updateJson(Page page) throws DAOException;

    /**
     * Deletes an object of <code>Page</code> type from the data source.
     * @param page the page to delete.
     * @return returns the number of registers modified in the data source or
     * 0 if the operation had no success.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    int delete(Page page) throws DAOException;

    /**
     * Searches the <code>Page</code> objects into the data source according
     * with a given pattern.
     * @param page the pattern for the search.
     * @return the page retrieved in the search.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    Page find(Page page) throws DAOException;

    /**
     * Retrieves all the <code>Page</code> objects stored into the data
     * source.
     * @return a list with all the <code>Page</code> objects stored into
     * the data source.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    List<Page> getAll() throws DAOException;
}
