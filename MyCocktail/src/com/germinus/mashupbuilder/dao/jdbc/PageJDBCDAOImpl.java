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

import com.germinus.mashupbuilder.dao.factory.JDBCDAOFactory;
import com.germinus.mashupbuilder.bean.Page;
import com.germinus.mashupbuilder.dao.DAOException;
import com.germinus.mashupbuilder.dao.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements all the methods which are operations with a database
 * which uses the JDBC driver for the object <code>Page</code>.
 * @author David del Pozo González
 */
public class PageJDBCDAOImpl implements PageDAO {
    /**
     * Stores an object of <code>Page</code> type into the data database.
     * @param page the page to store.
     * @return returns the number of registers modified in the database or
     * 0 if the operation had no success.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    public final int save(final Page page) throws DAOException {
        String query = "INSERT INTO pages (name, description, json) VALUES (?, ?,?)";

        
        System.out.println("guardando mashup");
        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = JDBCDAOFactory.getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(query);
            if (page.getName() != null) {
                pstmt.setString(1, page.getName());
            } else {
                pstmt.setNull(1, Types.VARCHAR);
            }
            if (page.getDescription() != null) {
                pstmt.setString(2, page.getDescription());
            } else {
                pstmt.setNull(2, Types.VARCHAR);
            }
            if (page.getDescription() != null) {
                pstmt.setString(3, page.getJson());
            } else {
                pstmt.setNull(3, Types.VARCHAR);
            }
            result = pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            DBUtils.closeStatement(pstmt);
            DBUtils.closeConnection(con);
        }
        return result;
    }

    /**
     * Stores an object of <code>Page</code> type into the database.
     * @param page the page to store.
     * @return returns the identifier of the page stored.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    public final int saveAndGetId(final Page page) throws DAOException {
        String query = "INSERT INTO pages (name, description, json) VALUES (?, ?,?)";
        String query2 = "SELECT MAX(id) FROM pages ";

        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = JDBCDAOFactory.getConnection();
            con.setAutoCommit(false);

            pstmt = con.prepareStatement(query);
            if (page.getName() != null) {
                pstmt.setString(1, page.getName());
            } else {
                pstmt.setNull(1, Types.VARCHAR);
            }
            if (page.getDescription() != null) {
                pstmt.setString(2, page.getDescription());
            } else {
                pstmt.setNull(2, Types.VARCHAR);
            }
            if (page.getJson() != null) {
                pstmt.setString(3, page.getJson());
            } else {
                pstmt.setNull(3, Types.VARCHAR);
            }
            result = pstmt.executeUpdate();
            pstmt.close();


            boolean[] existingFields = new boolean[3];
            String[] values = new String[3];
            StringBuilder sb = new StringBuilder();
            sb.append(" WHERE 1=1 ");
            if (page.getName() != null) {
                sb.append(" and name = ? ");
                existingFields[0] = true;
                values[0] = page.getName();
            }
            if (page.getDescription() != null) {
                sb.append(" and description = ? ");
                existingFields[1] = true;
                values[1] = page.getDescription();
            }
            if (page.getJson() != null) {
                sb.append(" and json = ? ");
                existingFields[2] = true;
                values[2] = page.getJson();
            }

            pstmt = con.prepareStatement(query2 + sb.toString());
            for (int i = 0; i < existingFields.length; i++) {
                if (existingFields[i]) {
                    pstmt.setString(i + 1, values[i]);
                }
            }
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();

            con.commit();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            DBUtils.closeStatement(pstmt);
            DBUtils.closeConnection(con);
        }
        return result;
    }

    /**
     * Updates an object of <code>Page</code> type from the database.
     * @param page the page to update.
     * @return returns the number of registers modified in the database or
     * 0 if the operation had no success.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    public final int update(final Page page) throws DAOException {
        String query = "UPDATE pages SET name=? description=?, json=? WHERE id=?";

        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = JDBCDAOFactory.getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(query);
            if (page.getName() != null) {
                pstmt.setString(1, page.getName());
            } else {
                pstmt.setNull(1, Types.VARCHAR);
            }
            if (page.getDescription() != null) {
                pstmt.setString(2, page.getDescription());
            } else {
                pstmt.setNull(2, Types.VARCHAR);
            }
            if (page.getDescription() != null) {
                pstmt.setString(3, page.getJson());
            } else {
                pstmt.setNull(3, Types.VARCHAR);
            }
            pstmt.setInt(4, page.getId());
            result = pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            DBUtils.closeStatement(pstmt);
            DBUtils.closeConnection(con);
        }
        return result;
    }

    /**
     * Updates an object of <code>Page</code> type from the database, but
     * only update the property <code>json</code>.
     * @param page the page to update.
     * @return returns the number of registers modified in the database or
     * 0 if the operation had no success.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    public final int updateJson(final Page page) throws DAOException {
        String query = "UPDATE pages SET json=? WHERE id=?";

        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = JDBCDAOFactory.getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, page.getJson());
            pstmt.setInt(2, page.getId());
            result = pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            DBUtils.closeStatement(pstmt);
            DBUtils.closeConnection(con);
        }
        return result;
    }

    /**
     * Deletes an object of <code>Page</code> type from the database.
     * @param page the page to delete.
     * @return returns the number of registers modified in the database or
     * 0 if the operation had no success.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    public final int delete(final Page page) throws DAOException {
        String query = "DELETE FROM pages WHERE id=?";

        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = JDBCDAOFactory.getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(query);
            pstmt.setInt(3, page.getId());
            result = pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            DBUtils.closeStatement(pstmt);
            DBUtils.closeConnection(con);
        }
        return result;
    }

    /**
     * Searches the <code>Page</code> objects into the database according
     * with a given pattern.
     * @param page the pattern for the search.
     * @return the page retrieved in the search.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    public final Page find(final Page page) throws DAOException {
        String query = "SELECT id, name, description, json FROM pages WHERE id=?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Page pageFound = null;

        try {
            con = JDBCDAOFactory.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, page.getId());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                pageFound = new Page();
                pageFound.setId(rs.getInt("id"));
                pageFound.setName(rs.getString("name"));
                pageFound.setDescription(rs.getString("description"));
                pageFound.setJson(rs.getString("json"));
            }

            rs.close();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {

            DBUtils.closeStatement(pstmt);
            DBUtils.closeConnection(con);
        }

        return pageFound;
    }

    /**
     * Retrieves all the <code>Page</code> objects stored into the data
     * source.
     * @return a list with all the <code>Page</code> objects stored into
     * the database.
     * @throws com.germinus.pagebuilder.dao.DAOException if an database error
     * occurs.
     */
    public final List<Page> getAll() throws DAOException {
        String query = "SELECT id, name, description, json FROM pages";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Page> pageList = new ArrayList<Page>();

        try {
            con = JDBCDAOFactory.getConnection();
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Page page = new Page();
                page.setId(rs.getInt("id"));
                page.setName(rs.getString("name"));
                page.setDescription(rs.getString("description"));
                page.setJson(rs.getString("description"));

                pageList.add(page);
            }

            rs.close();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {
            DBUtils.closeStatement(pstmt);
            DBUtils.closeConnection(con);
        }

        return pageList;
    }
}
