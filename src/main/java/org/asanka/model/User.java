package org.asanka.model;

import org.asanka.util.RDBMSConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by asankav on 12/29/16.
 */
public class User {
    private String lastName;
    private String firstName;
    private int personId;
    private String address;
    private String city;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getPersonId() {
        return personId;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public User() {
    }

    public User(String userName) {
        userName=userName;
    }

//    public User(int id){
//
//        try {
//
//            RDBMSConnection dbConnection=new RDBMSConnection();
////            Class.forName("com.mysql.jdbc.Driver") ;
////            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poc1", "root", "root") ;
//            Connection connection = dbConnection.getDataSource().getConnection();
//
//            Statement stmt=connection.createStatement();
//            String query = "select * from Persons where PersonID="+id;
//            ResultSet rs = stmt.executeQuery(query) ;
//
//             if(rs.next()){
//                 this.personId =rs.getInt("PersonID");
//                 this.lastName =rs.getString("FirstName")+" "+rs.getString("LastName");
//
//                 dbConnection.getDataSource().getConnection().close();
//             }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//    }




}
