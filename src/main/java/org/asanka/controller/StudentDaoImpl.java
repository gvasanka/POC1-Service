package org.asanka.controller;

/**
 * Created by asankav on 1/3/17.
 */
import org.asanka.dao.StudentDao;
import org.asanka.model.Student;
import org.asanka.model.User;
import org.asanka.util.RDBMSConnection;
import org.asanka.util.RDBMSConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    //list is working as a database
    List<Student> students;

    public StudentDaoImpl(){

    }
    @Override
    public void deleteStudent(Student student) {

    }

    //retrive list of students from the database
    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudent(int id) {
        RDBMSConnection rdbmsConnection= null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Student student=null;

        try {

            rdbmsConnection=new RDBMSConnection();
            connection = rdbmsConnection.tempConnection();

            preparedStatement=connection.prepareStatement(RDBMSConstants.PS_SELECT_USERS_BY_ID);
            preparedStatement.setInt(1,id);

            resultSet = preparedStatement.executeQuery() ;

            if(resultSet.next()){
                student=new Student(id);


                return student;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
        return student;
    }

    @Override
    public void updateStudent(Student student) {

    }
}
