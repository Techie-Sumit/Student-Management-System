package com.sms.repository;

import com.sms.model.Student;

import java.io.*;
import java.util.ArrayList;

public class StudentRepository {

    private ArrayList<Student> students;

    private static final String FILE_PATH = "data/students.txt";

    public StudentRepository() {
        students = new ArrayList<>();
        loadStudentsFromFile();
    }

    // Add student
    public void addStudent(Student student) {

        students.add(student);

        saveStudentsToFile();
    }

    // Get all students
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    // Search student by ID
    public Student findStudentById(int studentId) {

        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }

    // Delete student
    public boolean deleteStudent(int studentId) {

        Student student = findStudentById(studentId);

        if (student != null) {

            students.remove(student);

            saveStudentsToFile();

            return true;
        }

        return false;
    }

    // Save all students to file
    public void saveStudentsToFile() {

        File file = new File(FILE_PATH);

            File parentDirectory = file.getParentFile();

        if (parentDirectory != null) {
            parentDirectory.mkdirs();
        }

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(file))) {

            for (Student student : students) {

                writer.write(
                        student.getStudentId() + "," +
                        student.getName() + "," +
                        student.getAge() + "," +
                        student.getCourse() + "," +
                        student.getEmail()
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println("Error while saving student data: "+ e.getMessage());
        }
    }

    // Load students from file
    private void loadStudentsFromFile() {

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length != 5) {
                    System.out.println("Skipping invalid student record: " + line);
                    continue;
                }

                try {

                    int studentId = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String course = data[3];
                    String email = data[4];

                    Student student = new Student(studentId, name, age, course, email);

                    students.add(student);

                } catch (NumberFormatException e) {

                    System.out.println("Skipping invalid student record: " + line);
                }
            }

        } catch (IOException e) {

            System.out.println("Error while loading student data: "+ e.getMessage());
        }
    }
}