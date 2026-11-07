package com.sms.service;

import com.sms.exception.StudentNotFoundException;
import com.sms.model.Student;
import com.sms.repository.StudentRepository;

import java.util.ArrayList;

public class StudentService {

    private StudentRepository repository;

    public StudentService() {
        repository = new StudentRepository();
    }

    // Add student
    public boolean addStudent(int studentId, String name, int age, String course, String email) {

        Student existingStudent = repository.findStudentById(studentId);

        if (existingStudent != null) {
            return false;
        }

        Student student = new Student(studentId, name, age, course, email);

        repository.addStudent(student);

        return true;
    }

    // Get all students
    public ArrayList<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    // Search student
    public Student searchStudent(int studentId)
            throws StudentNotFoundException {

        Student student = repository.findStudentById(studentId);

        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
        }

        return student;
    }

    // Update student
    public void updateStudent(int studentId, String name, int age, String course, String email)
            throws StudentNotFoundException {

        Student student = searchStudent(studentId);

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setEmail(email);

        repository.saveStudentsToFile();
    }

    // Delete student
    public void deleteStudent(int studentId)throws StudentNotFoundException {

        searchStudent(studentId);

        repository.deleteStudent(studentId);
    }
}