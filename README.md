# Student Management System

A simple **console-based Student Management System developed using Core Java**. The application allows users to manage student records through a menu-driven interface and stores the records permanently using Java file handling.

## Features

* Add a new student
* View all student records
* Search for a student using Student ID
* Update student details
* Delete a student record
* Prevent duplicate Student IDs
* Validate Student ID, age, and email input
* Handle invalid user input
* Store student records permanently in a text file
* Load previously saved records when the application starts
* Handle missing students using a custom exception
* Skip invalid records while reading stored data

## Student Information

Each student record contains:

* Student ID
* Name
* Age
* Course
* Email

## Project Structure

```text
StudentManagementSystem/
│
├── src/
│   └── com/
│       └── sms/
│           ├── Main.java
│           │
│           ├── model/
│           │   └── Student.java
│           │
│           ├── repository/
│           │   └── StudentRepository.java
│           │
│           ├── service/
│           │   └── StudentService.java
│           │
│           ├── util/
│           │   └── InputUtil.java
│           │
│           └── exception/
│               └── StudentNotFoundException.java
│
├── data/
│   └── students.txt
│
├── out/
│   └── Compiled class files
│
└── README.md
```

## Description of Classes

### `Main.java`

The main class of the application. It displays the menu, accepts the user's choice, and connects the user interface with the service layer.

### `Student.java`

The model class that represents a student. It stores:

* Student ID
* Name
* Age
* Course
* Email

The fields are kept private and accessed using getter and setter methods, following the concept of **encapsulation**.

### `StudentService.java`

Contains the main application logic for:

* Adding students
* Searching students
* Updating students
* Deleting students
* Preventing duplicate Student IDs

It acts as an intermediate layer between `Main` and `StudentRepository`.

### `StudentRepository.java`

Responsible for managing student records and file operations. It:

* Stores student objects in an `ArrayList`
* Searches students by ID
* Deletes student records
* Saves student records to `students.txt`
* Loads saved records when the application starts

### `InputUtil.java`

Provides reusable methods for accepting and validating user input.

It validates:

* Integer input
* Student ID
* Age
* Empty strings
* Email addresses

### `StudentNotFoundException.java`

A user-defined exception that is thrown when a student with the specified Student ID does not exist.

## Core Java Concepts Used

The project demonstrates several Core Java concepts, including:

* Classes and Objects
* Constructors
* Encapsulation
* Methods
* Packages
* `ArrayList`
* Loops and Conditional Statements
* Exception Handling
* User-Defined Exception
* File Handling
* `BufferedReader`
* `BufferedWriter`
* Try-with-resources
* String Handling
* Input Validation
* Method Overriding using `toString()`

## Data Storage

Student records are stored in:

```text
data/students.txt
```

A record is stored in the following format:

```text
101,Rahul Kumar,20,BCA,rahul@gmail.com
```

When the application is started again, the saved student records are automatically loaded from the file.

## How to Compile

Open the terminal in the root directory of the project and run:

```powershell
javac -d out src\com\sms\model\Student.java src\com\sms\exception\StudentNotFoundException.java src\com\sms\repository\StudentRepository.java src\com\sms\service\StudentService.java src\com\sms\util\InputUtil.java src\com\sms\Main.java
```

## How to Run

After successful compilation, run:

```powershell
java -cp out com.sms.Main
```

## Main Menu

```text
=================================
     STUDENT MANAGEMENT SYSTEM
=================================
1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit
=================================
```

## Example Operations

The user can:

1. Add a student by entering ID, name, age, course, and email.
2. View all stored student records in tabular format.
3. Search for a particular student using Student ID.
4. Update the details of an existing student.
5. Delete a student after confirmation.
6. Exit the application safely.

## Input Validation

The application includes validation to prevent incorrect input.

Examples include:

* Student ID must be greater than `0`.
* Age must be between `1` and `100`.
* Empty values are not accepted.
* Invalid numeric input does not terminate the program.
* Basic email-format validation is performed.
* Duplicate Student IDs are not allowed.

## Exception Handling

The application uses exception handling to prevent unexpected program termination.

A custom exception:

```java
StudentNotFoundException
```

is used when the requested student does not exist.

## Conclusion

The Student Management System is a menu-driven Core Java application that provides the essential operations required to manage student records. It combines object-oriented programming, collections, validation, exception handling, and file handling in a structured package-based design. Student records remain available even after the application is closed because the data is stored permanently in a text file.
