package org.asanka.controller;

import org.apache.log4j.Logger;
import org.asanka.model.User;
import org.asanka.util.RDBMSConnection;
import org.asanka.util.RDBMSConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by asankav on 12/29/16.
 */
public class UserControllerImpl {
    private static final Logger logger = Logger.getLogger(UserControllerImpl.class);

    public User getUserByName(String userName){

        return new User(userName);
    }

    public User getUserById(int id){
        RDBMSConnection rdbmsConnection= null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        User user=null;

        try {

            rdbmsConnection=new RDBMSConnection();
            connection = rdbmsConnection.tempConnection();

            preparedStatement=connection.prepareStatement(RDBMSConstants.PS_SELECT_USERS_BY_ID);
            preparedStatement.setInt(1,id);

            resultSet = preparedStatement.executeQuery() ;

            if(resultSet.next()){
                user=new User();
                user.setPersonId(resultSet.getInt("PersonID"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setAddress(resultSet.getString("Address"));
                user.setCity(resultSet.getString("City"));

                return user;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(resultSet, RDBMSConstants.SOME_MESSAGE);
            close(preparedStatement, RDBMSConstants.SOME_MESSAGE);
            close(connection, RDBMSConstants.SOME_MESSAGE);

        }
        return user;

    }

    /**
     * closes the result set resources
     *
     * @param resultSet ResultSet
     * @param task      task that was done by the closed result set.
     */
    protected void close(ResultSet resultSet, String task) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error("Closing result set failed after " + task, e);
            }
        }
    }

    /**
     * close the prepared statement resource
     *
     * @param preparedStatement PreparedStatement
     * @param task              task that was done by the closed prepared statement.
     */
    protected void close(PreparedStatement preparedStatement, String task) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error("Closing prepared statement failed after " + task, e);
            }
        }
    }

    /**
     * Closes the provided connection. on failure log the error;
     *
     * @param connection Connection
     * @param task       task that was done before closing
     */
    protected void close(Connection connection, String task) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error("Failed to close connection after " + task, e);
        }
    }

}
