package com.mycompany.amper_tla02;

import java.util.HashMap;
import java.util.Scanner;

public class Amper_TLA02 {

    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();
        Scanner myObj = new Scanner(System.in);

        scores.put("John", 85);
        scores.put("Alice", 82);
        scores.put("Mark", 78);
        scores.put("Sophia", 95);
        scores.put("Emma", 88);

        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Check Student's Score");
            System.out.println("2. Update Student's Score");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");
            String input = myObj.nextLine().trim();

            switch (input) {
                case "1" -> {
                    printStudentList(scores);
                    System.out.print("\nEnter student's name to find their score: ");
                    String studentName = myObj.nextLine();
                    if (scores.containsKey(studentName)) {
                        System.out.println(studentName + "'s score is: " + scores.get(studentName));
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case "2" -> {
                    boolean continueUpdate = true;
                    while (continueUpdate) {
                        printStudentList(scores);
                        System.out.print("\nEnter student's name to update their score: ");
                        String updateName = myObj.nextLine();
                        if (scores.containsKey(updateName)) {
                            System.out.print("Enter the new score: ");
                            int newScore;
                            try {
                                newScore = Integer.parseInt(myObj.nextLine());
                                scores.put(updateName, newScore);
                                System.out.println("\n" + updateName + "'s score updated successfully!");
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid score. Please enter a valid integer value.");
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                        System.out.print("\nWould you like to continue updating? [yes/no]: ");
                        String choice = myObj.nextLine().trim().toLowerCase();
                        if (!choice.equals("yes")) {
                            continueUpdate = false;
                        }
                    }
                }
                case "3" -> {
                    running = false;
                    System.out.println("\nClosing program...");
                }
                default ->
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private static void printStudentList(HashMap<String, Integer> scores) {
        System.out.println("\nList of students:");
        for (String name : scores.keySet()) {
            System.out.println(name);
        }
    }
}
