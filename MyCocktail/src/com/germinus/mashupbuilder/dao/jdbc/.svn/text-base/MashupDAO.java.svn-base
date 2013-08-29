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
package com.germinus.mashupbuilder.dao.jdbc;

import com.germinus.mashupbuilder.bean.Mashup;
import com.germinus.mashupbuilder.dao.DAO;
import com.germinus.mashupbuilder.dao.DAOException;
import java.util.List;

/**
 * This interface provides all the methods which are operations with the data
 * source for the object <code>Mashup</code>.
 * @author David del Pozo González
 */
public interface MashupDAO extends DAO {
    /**
     * Stores an object of <code>Mashup</code> type into the data source.
     * @param mashup the mashup to store.
     * @return returns the number of registers modified in the data source or
     * 0 if the operation had no success.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    int save(Mashup mashup) throws DAOException;

    /**
     * Stores an object of <code>Mashup</code> type into the data source.
     * @param mashup the mashup to store.
     * @return returns the identifier of the mashup stored.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    int saveAndGetId(Mashup mashup) throws DAOException;

    /**
     * Updates an object of <code>Mashup</code> type from the data source.
     * @param mashup the mashup to update.
     * @return returns the number of registers modified in the data source or
     * 0 if the operation had no success.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    int update(Mashup mashup) throws DAOException;

    /**
     * Updates an object of <code>Mashup</code> type from the data source, but
     * only update the property <code>json</code>.
     * @param mashup the mashup to update.
     * @return returns the number of registers modified in the data source or
     * 0 if the operation had no success.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    int updateJson(Mashup mashup) throws DAOException;

    /**
     * Deletes an object of <code>Mashup</code> type from the data source.
     * @param mashup the mashup to delete.
     * @return returns the number of registers modified in the data source or
     * 0 if the operation had no success.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    int delete(Mashup mashup) throws DAOException;

    /**
     * Searches the <code>Mashup</code> objects into the data source according
     * with a given pattern.
     * @param mashup the pattern for the search.
     * @return the mashup retrieved in the search.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    Mashup find(Mashup mashup) throws DAOException;

    /**
     * Retrieves all the <code>Mashup</code> objects stored into the data
     * source.
     * @return a list with all the <code>Mashup</code> objects stored into
     * the data source.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    List<Mashup> getAll() throws DAOException;
}
