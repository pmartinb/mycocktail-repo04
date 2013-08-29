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

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cloudfoundry.caldecott.TunnelException;
import org.cloudfoundry.caldecott.client.HttpTunnelFactory;
import org.cloudfoundry.caldecott.client.TunnelHelper;
import org.cloudfoundry.caldecott.client.TunnelServer;
import org.cloudfoundry.client.lib.CloudCredentials;
import org.cloudfoundry.client.lib.CloudFoundryClient;
import org.cloudfoundry.client.lib.CloudFoundryException;
import org.cloudfoundry.client.lib.domain.CloudApplication;
import org.cloudfoundry.client.lib.domain.CloudService;
import org.cloudfoundry.client.lib.domain.CloudSpace;

import com.germinus.mashupbuilder.dao.DAOException;

/**
 * This class is a connection provider, this provider generates the connection
 * with the data provided in "conf/db.properties" file .
 * @author David del Pozo González
 */
public class StandardConnectorProvider implements ConnectorProvider {
	
	
	
	
	
	protected final Log logger = LogFactory.getLog(getClass());

	private static final String VCAP_TARGET = System.getProperty("vcap.target", "https://api.cloudfoundry.com");
	private static final String VCAP_EMAIL = System.getProperty("vcap.email", "pablo.martin@logica.com");
	private static final String VCAP_PASSWD = "pmartinb";//System.getProperty("vcap.passwd");
	private static final String VCAP_ORG = System.getProperty("vcap.org", "springdeveloper.com");
	private static final String VCAP_SPACE = System.getProperty("vcap.space", "test");
	private static final String VCAP_MYSQL_SERVICE = "mysql-caldecott-test";
	private static final String VCAP_POSTGRES_SERVICE = "postgres-caldecott-test";
	private static final String VCAP_MONGO_SERVICE = "mongo-caldecott-test";
	private static final String VCAP_REDIS_SERVICE = "redis-caldecott-test";
	private static final String VCAP_RABBIT_SERVICE = "rabbit-caldecott-test";
	public static final int LOCAL_PORT = 10000;
	public static final String LOCAL_HOST = "127.0.0.1";

	private CloudFoundryClient client;
	private String svc_username;
	private String svc_passwd;
	private String svc_dbname;
	private String svc_vhost;
	private TunnelServer tunnelServer;

	private DataSource ds;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    /**
     * The path to the database configuration file.
     */
    private static final String PROPERTIES_PATH = "conf/db.properties";
    /**
     * The properties file with the information about the connector provider.
     */
    private static Properties dbProperties = null;

    /**
     * Load the propertis from configuration file.
     */
    private void loadProperties() {
        try {
            dbProperties = new Properties();
            dbProperties.load(
                StandardConnectorProvider.class.getClassLoader()
                .getResourceAsStream(PROPERTIES_PATH));
        } catch (IOException ex) {
            Logger.getLogger(StandardConnectorProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retrieves a database connection configured in "conf/db.properties" file.
     * @return a database connection.
     * @throws com.germinus.mashupbuilder.dao.DAOException if an database error
     * occurs.
     */
    public final Connection getConnection() throws DAOException {
    	System.out.println(java.lang.System.getenv("VCAP_SERVICES"));
        if (dbProperties == null) {
            loadProperties();
        }

        String driver = dbProperties.getProperty("driver");
        String url    = dbProperties.getProperty("url");
        String user   = dbProperties.getProperty("user");
        String passwd = dbProperties.getProperty("password");

        
        System.out.println("driver "+driver+" url "+url+" user "+user+" passwd "+passwd);
        
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, passwd);
        } catch (ClassNotFoundException ex) {
            throw new DAOException("The JDBC Driver is not found", ex);
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
        return con;
        /*
        CloudEnvironment environment= new CloudEnvironment();
        //MongoServiceInfo service = environment.getServiceInfo("monguerdb",MongoServiceInfo.class);
        //System.out.println("monguer available at host: " + service.getHost() + " and port: " + service.getPort()+" user "+service.getUserName()+ " password "+service.getPassword());
        MysqlServiceInfo mservice= environment.getServiceInfo("mysculo",MysqlServiceInfo.class);
        System.out.println("mservice "+mservice);
        System.out.println("mysql available at host: " + mservice.getHost() + " and port: " + mservice.getPort()+" user "+mservice.getUserName()+ " password "+mservice.getPassword());
        
        
        
        
        
        */
        
        
        /*
        
        System.out.println("1");
        client = clientInit();
		try {
			checkForCaldecottServerApp();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println("Running tests on " + VCAP_TARGET + " on behalf of " + VCAP_EMAIL);
		if (VCAP_PASSWD == null) {
			System.out.println();
			System.out.println("System property vcap.passwd must be specified, supply -Dvcap.passwd=<password>");
		}
		
        
        long start = System.currentTimeMillis();
		logger.info("MySQL:");
		System.out.println("k1");
		createService(VCAP_MYSQL_SERVICE, "mysql", "5.1");
		int tunnelPort = LOCAL_PORT;
		createTunnelServer(VCAP_MYSQL_SERVICE, tunnelPort);
		ds = new SimpleDriverDataSource();
		String url = "jdbc:mysql://"+ LOCAL_HOST + ":" + tunnelPort + "/" + svc_dbname + "?rewriteBatchedStatements=true";
		
		((SimpleDriverDataSource)ds).setDriverClass(com.mysql.jdbc.Driver.class);
		((SimpleDriverDataSource)ds).setUrl(url);
		((SimpleDriverDataSource)ds).setUsername(svc_username);
		((SimpleDriverDataSource)ds).setPassword(svc_passwd);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		
		org.springframework.dao.DataAccessException r;
		
		jdbcTemplate.execute("create table records (id smallint, " +
				"name varchar(100), address varchar(100), city varchar(100), country varchar(100), " +
				"age smallint)");
		
		
		Connection con = DataSourceUtils.getConnection(ds);
		IDatabaseConnection dbUnitCon = null;
		dbUnitCon = new DatabaseConnection(con);
		dbUnitCon.getConfig().setProperty(DatabaseConfig.FEATURE_BATCHED_STATEMENTS, Boolean.TRUE);
		dbUnitCon.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
		IDataSet dataSet = null;
		try {
			dataSet = new XmlDataSet(new FileInputStream("data/load.xml"));
		} catch (IOException e) {
			System.out.println(e);
		} catch (DataSetException e) {
			System.out.println(e);
		}
		try {
			try {
				DatabaseOperation.CLEAN_INSERT.execute(dbUnitCon, dataSet);
			} catch (DatabaseUnitException e) {
				System.out.println(e);
			} catch (SQLException e) {
				System.out.println(e);
			}
		} finally {
			DataSourceUtils.releaseConnection(con, ds);
		}

		int count = jdbcTemplate.queryForInt("select count(*) from records");
		//Assert.assertEquals("Did not load the data correctly", 200, count);

		stopTunnelServer();
		removeService(VCAP_MYSQL_SERVICE);
		logger.info("Time elapsed: " + (System.currentTimeMillis() - start) / 1000.0d + " sec"); 
        
        return con;
        */
        
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        
        
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, passwd);
        } catch (ClassNotFoundException ex) {
            throw new DAOException("The JDBC Driver is not found", ex);
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
        return con;
    }
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void createService(String dbSvcName, String dbType, String dbVersion) {
		try {
			System.out.println("getting service "+dbSvcName);
			client.getService(dbSvcName);
			System.out.println("k2");
			client.deleteService(dbSvcName);
			
			System.out.println("k3");
			
			
		} catch (Exception ignore) {}
		client.stopApplication(TunnelHelper.getTunnelAppName());
		System.out.println("k4");
		CloudService cloudSvc = new CloudService();
		System.out.println("k5");
		cloudSvc.setName(dbSvcName);
		cloudSvc.setVersion(dbVersion);
		System.out.println("k6");
		// for v1
		cloudSvc.setVendor(dbType);
		cloudSvc.setTier("free");
		// for v2
		cloudSvc.setType(dbType);
		//cloudSvc.setPlan("D100");
		//cloudSvc.setProvider("core");
		// create service
		client.createService(cloudSvc);
		client.bindService(TunnelHelper.getTunnelAppName(), dbSvcName);
		client.startApplication(TunnelHelper.getTunnelAppName());
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {}
	}
    
    
    
    
    
    
    
    
    
	private void createTunnelServer(String dbSvcName, int tunnelPort) {
		logger.info("Starting tunnel on " + LOCAL_HOST +" port " + tunnelPort);
		InetSocketAddress local = new InetSocketAddress(LOCAL_HOST, tunnelPort);
		String url = TunnelHelper.getTunnelUri(client);
		Map<String, String> info = TunnelHelper.getTunnelServiceInfo(client, dbSvcName);
		String host = info.get("hostname");
		int port = Integer.valueOf(info.get("port"));
		String auth = TunnelHelper.getTunnelAuth(client);
		svc_username = info.get("username");
		svc_passwd = info.get("password");
		svc_dbname = info.get("db") != null ? info.get("db") : info.get("name");
		svc_vhost = info.get("vhost");
		System.out.println("user "+svc_username+" pass "+svc_passwd+" deb name "+svc_dbname+" svc_vhost "+svc_vhost);
		tunnelServer = new TunnelServer(local, new HttpTunnelFactory(url, host, port, auth));
		tunnelServer.start();
	}
    
    
    
	private void stopTunnelServer() {
		tunnelServer.stop();
	}
    
	private void removeService(String dbSvcName) {
		client.stopApplication(TunnelHelper.getTunnelAppName());
		client.unbindService(TunnelHelper.getTunnelAppName(), dbSvcName);
		client.startApplication(TunnelHelper.getTunnelAppName());
		client.deleteService(dbSvcName);
	}
	
	private static CloudFoundryClient clientInit() {
		URL vcapUrl = null;
		try {
			vcapUrl = new URL(VCAP_TARGET);
			 System.out.println("2");
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		System.out.println("obteniendo cliente target "+VCAP_TARGET+" email "+VCAP_EMAIL+" pass "+VCAP_PASSWD);
		CloudCredentials cred = new CloudCredentials(VCAP_EMAIL, VCAP_PASSWD);
		System.out.println("credenciales "+cred.getEmail()+" pass "+cred.getPassword()+" url "+vcapUrl);
		
		CloudFoundryClient client = new CloudFoundryClient(new CloudCredentials(VCAP_EMAIL, VCAP_PASSWD), vcapUrl);
		 System.out.println("3"+VCAP_PASSWD);
		client.login();
		 System.out.println("4");
		String version = client.getCloudInfo().getVersion();
		 System.out.println("5");
		if (Float.valueOf(version) >= 2.0) {
			client = new CloudFoundryClient(new CloudCredentials(VCAP_EMAIL, VCAP_PASSWD), vcapUrl, getSpace(client));
			 System.out.println("6");
			client.login();
		}
		return client;
	}
	
	private void checkForCaldecottServerApp() throws Exception {
		System.out.println("5-");
		CloudApplication app =  null;
		try {
			try {
				app = client.getApplication(TunnelHelper.getTunnelAppName());
				System.out.println("6");
			} catch (CloudFoundryException ignore) {}
			if (app == null) {
				TunnelHelper.deployTunnelApp(client);
				app = client.getApplication(TunnelHelper.getTunnelAppName());
			}
		} catch (Exception e) {
			logger.error("Error deploying Caldecott app", e);
			throw new TunnelException("Error deploying Caldecott app", e);
		}
	}
	
	private static CloudSpace getSpace(CloudFoundryClient client) {
		List<CloudSpace> spaces = client.getSpaces();
		CloudSpace useSpace = null;
		for (CloudSpace space : spaces) {
			if (space.getOrganization().getName().equals(VCAP_ORG) && space.getName().equals(VCAP_SPACE)) {
				useSpace = space;
				break;
			}
		}
		return useSpace;
	}
	
	
}
