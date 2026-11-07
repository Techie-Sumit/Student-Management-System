package com.sms.model;

public class Student {

    private int studentId;
    private String name;
    private int age;
    private String course;
    private String email;

    // Constructor
    public Student(int studentId, String name, int age, String course, String email) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }

    // Getter and Setter for Student ID
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for Age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter for Course
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Getter and Setter for Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Display student details
    @Override
    public String toString() {
        return "Student ID : " + studentId +
               "\nName       : " + name +
               "\nAge        : " + age +
               "\nCourse     : " + course +
               "\nEmail      : " + email;
    }
}