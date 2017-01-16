package org.asanka.util;

/**
 * Created by asankav on 12/30/16.
 */
public abstract class DBConnection {
    ConfigurationProperties connectionProperties;

    /**
     * Initialize database connection
     *
     * @param connectionProperties ConfigurationProperties
     * @throws Exception
     */
    public void initialize(ConfigurationProperties connectionProperties) throws Exception {

        this.connectionProperties = connectionProperties;

    }

    /**
     * Close database connection
     */
    public abstract void close();

    /**
     * return instance of connection
     *
     * @return instance
     */
    public abstract Object getConnection();
}
