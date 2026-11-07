package com.sms;

import com.sms.model.Student;
import com.sms.service.StudentService;
import com.sms.util.InputUtil;

import java.util.ArrayList;
import com.sms.exception.StudentNotFoundException;

public class Main {

    private static final StudentService service = new StudentService();

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();

            choice = InputUtil.readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Exiting Student Management System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();

        } while (choice != 6);
    }

    private static void displayMenu() {

        System.out.println("=================================");
        System.out.println("     STUDENT MANAGEMENT SYSTEM");
        System.out.println("=================================");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.println("=================================");
    }

    private static void addStudent() {

        System.out.println("\n--- Add Student ---");

        int id = InputUtil.readStudentId("Enter Student ID: ");
        String name = InputUtil.readString("Enter Name: ");
        int age = InputUtil.readAge("Enter Age: ");
        String course = InputUtil.readString("Enter Course: ");
        String email = InputUtil.readEmail("Enter Email: ");

        boolean added = service.addStudent(
                id,
                name,
                age,
                course,
                email
        );

        if (added) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Student ID already exists.");
        }
    }

    private static void viewAllStudents() {

        System.out.println("\n--- All Students ---");

        ArrayList<Student> students = service.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println(
                "========================================================================================"
                );

        System.out.printf(
                "%-10s %-20s %-8s %-15s %-30s%n",
                "ID",
                "Name",
                "Age",
                "Course",
                "Email"
        );

        System.out.println(
                "========================================================================================"
        );

        for (Student student : students) {

            System.out.printf(
                    "%-10d %-20s %-8d %-15s %-30s%n",
                    student.getStudentId(),
                    student.getName(),
                    student.getAge(),
                    student.getCourse(),
                    student.getEmail()
            );
        }

        System.out.println(
                "========================================================================================"
        );

        System.out.println("Total Students: " + students.size());
    }
    private static void searchStudent() {

        System.out.println("\n--- Search Student ---");

        int id = InputUtil.readStudentId("Enter Student ID: ");

        try {

            Student student = service.searchStudent(id);

            System.out.println("\nStudent Found:");
            System.out.println(student);

        } catch (StudentNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void updateStudent() {

        System.out.println("\n--- Update Student ---");

        int id = InputUtil.readStudentId("Enter Student ID: ");

        try {

            Student student = service.searchStudent(id);

            System.out.println("\nCurrent Details:");
            System.out.println(student);

            System.out.println("\nEnter New Details:");

            String name = InputUtil.readString("Enter Name: ");
            int age = InputUtil.readAge("Enter Age: ");
            String course = InputUtil.readString("Enter Course: ");
            String email = InputUtil.readEmail("Enter Email: ");

            service.updateStudent(id, name, age, course, email);

            System.out.println("Student updated successfully.");

        } catch (StudentNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void deleteStudent() {

        System.out.println("\n--- Delete Student ---");

        int id = InputUtil.readStudentId("Enter Student ID: ");
        try {

            Student student = service.searchStudent(id);

            System.out.println("\nStudent Details:");
            System.out.println(student);

            String confirmation = InputUtil.readString("Are you sure you want to delete? (yes/no): ");

            if (confirmation.equalsIgnoreCase("yes")) {

                service.deleteStudent(id);

                System.out.println("Student deleted successfully.");

            } else {
                System.out.println("Delete operation cancelled.");
            }

        } catch (StudentNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }
}