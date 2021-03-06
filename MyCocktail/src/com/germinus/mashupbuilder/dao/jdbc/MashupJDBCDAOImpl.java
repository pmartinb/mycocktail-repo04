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

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.germinus.mashupbuilder.bean.Mashup;
import com.germinus.mashupbuilder.dao.DAOException;
import com.germinus.mashupbuilder.dao.DBUtils;
import com.germinus.mashupbuilder.dao.factory.JDBCDAOFactory;

/**
 * This class implements all the methods which are operations with a database
 * which uses the JDBC driver for the object <code>Mashup</code>.
 * @author David del Pozo González
 */
public class MashupJDBCDAOImpl implements MashupDAO {
    /**
     * Stores an object of <code>Mashup</code> type into the data database.
     * @param mashup the mashup to store.
     * @return returns the number of registers modified in the database or
     * 0 if the operation had no success.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    public final int save(final Mashup mashup) throws DAOException {
        String query = "INSERT INTO mashups (name, description, json) VALUES (?, ?,?)";

        System.out.println("guardando mashup ....");
        
        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = JDBCDAOFactory.getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(query);
            if (mashup.getName() != null) {
                pstmt.setString(1, mashup.getName());
            } else {
                pstmt.setNull(1, Types.VARCHAR);
            }
            if (mashup.getDescription() != null) {
                pstmt.setString(2, mashup.getDescription());
            } else {
                pstmt.setNull(2, Types.VARCHAR);
            }
            if (mashup.getDescription() != null) {
                pstmt.setString(3, mashup.getJson());
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
     * Stores an object of <code>Mashup</code> type into the database.
     * @param mashup the mashup to store.
     * @return returns the identifier of the mashup stored.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    public final int saveAndGetId(final Mashup mashup) throws DAOException {
    	System.out.println("comorr?");
    	String query = "INSERT INTO mashups (name, description, json) VALUES (?, ?,?)";
    	String query2 = "SELECT MAX(id) FROM mashups ";
    	int result = 0;
    	Connection con = null;
    	PreparedStatement pstmt = null;

    	try {

    		if (!existsMashupsTable()){
    			createMashupTable();

    		}


    		con = JDBCDAOFactory.getConnection();
    		con.setAutoCommit(false);

    		pstmt = con.prepareStatement(query);
    		if (mashup.getName() != null) {
    			pstmt.setString(1, mashup.getName());
    		} else {
    			pstmt.setNull(1, Types.VARCHAR);
    		}
    		if (mashup.getDescription() != null) {
    			pstmt.setString(2, mashup.getDescription());
    		} else {
    			pstmt.setNull(2, Types.VARCHAR);
    		}
    		if (mashup.getJson() != null) {
    			pstmt.setString(3, mashup.getJson());
    		} else {
    			pstmt.setNull(3, Types.VARCHAR);
    		}
    		result = pstmt.executeUpdate();
    		pstmt.close();


    		boolean[] existingFields = new boolean[3];
    		String[] values = new String[3];
    		StringBuilder sb = new StringBuilder();
    		sb.append(" WHERE 1=1 ");
    		if (mashup.getName() != null) {
    			sb.append(" and name = ? ");
    			existingFields[0] = true;
    			values[0] = mashup.getName();
    		}
    		if (mashup.getDescription() != null) {
    			sb.append(" and description = ? ");
    			existingFields[1] = true;
    			values[1] = mashup.getDescription();
    		}
    		if (mashup.getJson() != null) {
    			sb.append(" and json = ? ");
    			existingFields[2] = true;
    			values[2] = mashup.getJson();
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

    private boolean existsMashupsTable(){

    	boolean exists = true;
    	Connection con;
    	try {
    		con = JDBCDAOFactory.getConnection();
    		ResultSet rs = null;
    		con = JDBCDAOFactory.getConnection();
    		System.out.println(JDBCDAOFactory.getConnection().toString());
    		if(JDBCDAOFactory.getConnection().toString().contains("mysql")){
    			DatabaseMetaData metadata = con.getMetaData();
    			rs = metadata.getTables(null, null, "mashups", null);
    			if(!rs.next()){
    				System.out.println("NORR");
    				exists = false;
    			}
    		}
    		con.close();
    	} catch (DAOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	System.out.println("existe -> "+exists);
    	return exists;
    }

    /**
     * Updates an object of <code>Mashup</code> type from the database.
     * @param mashup the mashup to update.
     * @return returns the number of registers modified in the database or
     * 0 if the operation had no success.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    public final int update(final Mashup mashup) throws DAOException {
        String query = "UPDATE mashups SET name=? description=?, json=? WHERE id=?";

        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = JDBCDAOFactory.getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(query);
            if (mashup.getName() != null) {
                pstmt.setString(1, mashup.getName());
            } else {
                pstmt.setNull(1, Types.VARCHAR);
            }
            if (mashup.getDescription() != null) {
                pstmt.setString(2, mashup.getDescription());
            } else {
                pstmt.setNull(2, Types.VARCHAR);
            }
            if (mashup.getDescription() != null) {
                pstmt.setString(3, mashup.getJson());
            } else {
                pstmt.setNull(3, Types.VARCHAR);
            }
            pstmt.setInt(4, mashup.getId());
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
     * Updates an object of <code>Mashup</code> type from the database, but
     * only update the property <code>json</code>.
     * @param mashup the mashup to update.
     * @return returns the number of registers modified in the database or
     * 0 if the operation had no success.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    public final int updateJson(final Mashup mashup) throws DAOException {
        String query = "UPDATE mashups SET json=? WHERE id=?";

        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = JDBCDAOFactory.getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, mashup.getJson());
            pstmt.setInt(2, mashup.getId());
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
     * Deletes an object of <code>Mashup</code> type from the database.
     * @param mashup the mashup to delete.
     * @return returns the number of registers modified in the database or
     * 0 if the operation had no success.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    public final int delete(final Mashup mashup) throws DAOException {
        String query = "DELETE FROM mashups WHERE id=?";

        int result = 0;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = JDBCDAOFactory.getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(query);
            pstmt.setInt(3, mashup.getId());
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
     * Searches the <code>Mashup</code> objects into the database according
     * with a given pattern.
     * @param mashup the pattern for the search.
     * @return the mashup retrieved in the search.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    public final Mashup find(final Mashup mashup) throws DAOException {
        String query = "SELECT id, name, description, json FROM mashups WHERE id=?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Mashup mashupFound = null;

        try {
            con = JDBCDAOFactory.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, mashup.getId());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                mashupFound = new Mashup();
                mashupFound.setId(rs.getInt("id"));
                mashupFound.setName(rs.getString("name"));
                mashupFound.setDescription(rs.getString("description"));
                mashupFound.setJson(rs.getString("json"));
            }

            rs.close();
        } catch (SQLException ex) {
            throw new DAOException(ex);
        } finally {

            DBUtils.closeStatement(pstmt);
            DBUtils.closeConnection(con);
        }

        return mashupFound;
    }

    /**
     * Retrieves all the <code>Mashup</code> objects stored into the data
     * source.
     * @return a list with all the <code>Mashup</code> objects stored into
     * the database.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    public final List<Mashup> getAll() throws DAOException {
    	String query = "SELECT id, name, description, json FROM mashups";

    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;

    	List<Mashup> mashupList = new ArrayList<Mashup>();

    	try {
    		con = JDBCDAOFactory.getConnection();
    		
    		System.out.println("existe?");
    		if (!existsMashupsTable()){
    			createMashupTable();

    		}



    		pstmt = con.prepareStatement(query);
    		rs = pstmt.executeQuery();
    		while (rs.next()) {
    			Mashup mashup = new Mashup();
    			mashup.setId(rs.getInt("id"));
    			mashup.setName(rs.getString("name"));
    			mashup.setDescription(rs.getString("description"));
    			mashup.setJson(rs.getString("description"));

    			mashupList.add(mashup);
    		}

    		rs.close();
    	} catch (SQLException ex) {
    		throw new DAOException(ex);
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		DBUtils.closeStatement(pstmt);
    		DBUtils.closeConnection(con);
    	}

    	return mashupList;
    }

    private void createMashupTable() {
    	
    	
    	
    	//CloudEnvironment environment = new CloudEnvironment();
    	//MongoDbFactory mongo = new MongoServiceCreator().createService(environment.getService("my-mongo",MongoServiceInfo.class))

    	
    	String query =  "CREATE TABLE mashups ("+
    			"id int AUTO_INCREMENT not null,"+
    			"name varchar(255),"+
    			"description varchar(255),"+
    			"json TEXT,"+
    			"primary key(id)"+ 
    			");";

    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	try {
    		con = JDBCDAOFactory.getConnection();

    		pstmt = con.prepareStatement(query);
    		pstmt.execute();
    		con.close();
    	} catch (DAOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

    }
}
