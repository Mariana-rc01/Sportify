package com.group11.sportify.views.components;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Class that handles the input from the user.
 */
public class Input {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Gets the input from the user.
     * 
     * @param type The type of the input.
     * @return The input from the user.
     */
    public Object getInput(Class<?> type) {
        if (type == Integer.class) {
            return getInt();
        } else if (type == String.class) {
            return getString();
        } else if (type == Double.class) {
            return getDouble();
        } else if (type == LocalDateTime.class) {
            return getDateTime();
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type.getSimpleName());
        }
    }

    /**
     * Gets string input from the user.
     * 
     * @return The input from the user.
     */
    public String getString() {
        while (true) {
            System.out.print("|> ");
            if (scanner.hasNextLine()) {
                String choice = scanner.nextLine();
                return choice;
            } else {
                scanner.next();
            }
        }
    }

    /**
     * Gets integer input from the user.
     * 
     * @return The input from the user.
     */
    public int getInt() {
        while (true) {
            System.out.print("|> ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } else {
                scanner.next();
            }
        }
    }

    /**
     * Gets double input from the user.
     * 
     * @return The input from the user.
     */
    public double getDouble() {
        while (true) {
            System.out.print("|> ");
            if (scanner.hasNextDouble()) {
                double choice = scanner.nextDouble();
                scanner.nextLine();
                return choice;
            } else {
                scanner.next();
            }
        }
    }

    /**
     * Gets date and time input from the user.
     * 
     * @return The input from the user.
     */
    public LocalDateTime getDateTime() {
        System.out.println("Please enter the date and time in the following format: yyyy-MM-dd HH:mm");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        while (true) {
            System.out.print("|> ");
            if (scanner.hasNextLine()) {
                String choice = scanner.nextLine();
                try {
                    return LocalDateTime.parse(choice, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please use the following format: yyyy-MM-dd HH:mm");
                }
            } else {
                scanner.next();
            }
        }
    }

    public int getFutureTime() {
        while (true) {
            System.out.print("|> ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 0) {
                    return choice;
                } else {
                    System.out.println("Time can only move forward, not backward.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
