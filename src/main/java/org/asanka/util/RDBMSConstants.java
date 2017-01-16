package org.asanka.util;

/**
 * Created by asankav on 12/30/16.
 */
public class RDBMSConstants {
    // Configuration properties
    protected static final String PROP_JNDI_LOOKUP_NAME = "dataSource";

    /**
     * Configuration name used to specify sql state code classes (i.e first two digits) for database
     * connectivity errors.
     * <p>
     * configuration is configured in broker.xml,
     * <ul>
     * <li>persistence/messageStore/</li>
     * <li>persistence/contextStore/</li>
     * </ul>
     * </p>
     */
    protected static final String STORE_UNAVAILABLE_SQL_STATE_CLASSES = "storeUnavailableSQLStateClasses";

    /**
     * Configuration name used to specify SQL state code classes (i.e first two
     * digits)
     * corresponding to various database server generated errors similar to
     * {@link java.sql.DataTruncation}, {@link java.sql.SQLDataException} (but driver didn't
     * differentiated and just choose set the sql state only)
     * <p>
     * configuration is configured in broker.xml,
     * <ul>
     * <li>persistence/messageStore/</li>
     * <li>persistence/contextStore/</li>
     * </ul>
     * </p>
     */
    protected static final String DATA_INTEGRITY_VIOLATION_SQL_STATE_CLASSES = "integrityViolationSQLStateClasses";

    /**
     * Configuration name used to specify SQL state code classes (i.e first two
     * digits)
     * corresponding to integrity violation errors.
     * <p>
     * configuration is configured in broker.xml,
     * <ul>
     * <li>persistence/messageStore/</li>
     * <li>persistence/contextStore/</li>
     * </ul>
     * </p>
     */
    protected static final String DATA_ERROR_SQL_STATE_CLASSES = "dataErrorSQLStateClasses";


    protected static final String TRANSACTION_ROLLBACK_ERROR_SQL_STATE_CLASSES = "transactionRollbackSQLStateClasses";

    // Message Store tables
    protected static final String CONTENT_TABLE = "MB_CONTENT";
    protected static final String METADATA_TABLE = "MB_METADATA";
    protected static final String QUEUES_TABLE = "MB_QUEUE_MAPPING";
    protected static final String EXPIRATION_TABLE = "MB_EXPIRATION_DATA";
    protected static final String MSG_STORE_STATUS_TABLE = "MB_MSG_STORE_STATUS";
    protected static final String RETAINED_METADATA_TABLE = "MB_RETAINED_METADATA";
    protected static final String RETAINED_CONTENT_TABLE = "MB_RETAINED_CONTENT";

    public static final String SOME_MESSAGE = "retrieving some message ";


    public static final String PS_SELECT_USERS_BY_ID =
            "SELECT " + "*"
                    + " FROM " + "Persons"
                         + " WHERE " + "PersonID" + "=?";

}
