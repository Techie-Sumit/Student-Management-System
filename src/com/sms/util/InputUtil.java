package com.sms.util;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    // Read integer input
    public static int readInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Read String input
    public static String readString(String message) {

        while (true) {
            System.out.print(message);

            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    // Read age with validation
    public static int readAge(String message) {

        while (true) {

            int age = readInt(message);

            if (age > 0 && age <= 100) {
                return age;
            }

            System.out.println("Please enter a valid age between 1 and 100.");
        }
    }

    // Read valid Student ID
    public static int readStudentId(String message) {

        while (true) {

            int id = readInt(message);

            if (id > 0) {
                return id;
            }

            System.out.println("Student ID must be greater than 0.");
        }
    }


    // Read valid email
    public static String readEmail(String message) {

        while (true) {

            String email = readString(message);

            if  (email.contains("@") &&
                email.contains(".") &&
                email.indexOf('@') > 0 &&
                email.lastIndexOf('.') > email.indexOf('@')) {

                return email;
            }

            System.out.println("Please enter a valid email address.");
        }
    }
}