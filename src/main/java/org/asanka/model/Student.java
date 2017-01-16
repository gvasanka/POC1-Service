package org.asanka.model;

/**
 * Created by asankav on 1/3/17.
 */
public class Student {
    private int id;
    private String name;
    private int rollNo;

    public Student(int id) {
        this.id = id;
    }

    public Student(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
