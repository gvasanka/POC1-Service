package org.asanka.dao;

/**
 * Created by asankav on 1/3/17.
 */
import org.asanka.model.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> getAllStudents();
    public Student getStudent(int id);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
}