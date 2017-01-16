package org.asanka.util;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by asankav on 12/29/16.
 */
public class RDBMSConnection extends DBConnection{
    private static final Logger logger = Logger.getLogger(RDBMSConnection.class);
    private DataSource datasource;

    @Override
    public void initialize(ConfigurationProperties connectionProperties) throws Exception {

        super.initialize(connectionProperties);

        Connection connection = null;
        String jndiLookupName = "";
        String dataSourceUserName = "";
        try {
            // try to get the lookup name. If error empty string will be returned
            jndiLookupName = connectionProperties.getProperty(RDBMSConstants.PROP_JNDI_LOOKUP_NAME);
            datasource = InitialContext.doLookup(jndiLookupName);

            // TODO: C5-migration
//            if (datasource instanceof org.apache.tomcat.jdbc.pool.DataSource) {
//                org.apache.tomcat.jdbc.pool.DataSource tcDataSource =
//                        (org.apache.tomcat.jdbc.pool.DataSource) datasource;
//                if (StringUtils.isNotBlank(tcDataSource.getUsername())) {
//                    dataSourceUserName = tcDataSource.getUsername();
//                }
//            }

            connection = datasource.getConnection();
            logger.info("JDBC connection established with jndi config " + jndiLookupName);
        } catch (SQLException e) {
            throw new Exception("Connecting to database failed with jndi lookup : " +
                    jndiLookupName  /* + ". data source username : " +
                                     dataSourceUserName + ". SQL Error message : " +
                                     e.getMessage()*/, e);
        } catch (NamingException e) {
            throw new Exception("Couldn't look up jndi entry for " +
                    "\"" + jndiLookupName + "\"", e);
        } finally {
            String task = "Initialising database";
            close(connection, task);
        }
    }

    /**
     * connection pooled data source object is returned. Connections to database can be created
     * using the data source.
     *
     * @return DataSource
     */
    public DataSource getDataSource() {
        return datasource;
    }

    @Override
    public void close() {
        // nothing to do.
    }

    @Override
    public Object getConnection() {
        return this;
    }

    /**
     * Closes the provided connection. on failure log the error;
     *
     * @param connection Connection
     * @param task       task that was done before closing
     */
    private void close(Connection connection, String task) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Failed to close connection after " + task, e);
            }
        }
    }

    public Connection tempConnection(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver") ;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poc1", "root", "root") ;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;
    }


}
