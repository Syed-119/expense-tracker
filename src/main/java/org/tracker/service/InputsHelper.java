package org.tracker.service;

import java.util.Scanner;

public class InputsHelper {
    private Scanner scanner = new Scanner(System.in);

    public int idPrompt(){
        String id;
        while (true){
            System.out.print("Enter expense id : ");
            id = scanner.next();
            if (id == null || id.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a number.");
                continue;
            }
                try {
                    return Integer.parseInt(id.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Thats not a valid whole number. Please enter a valid number.");
                }
            }
        }

    public String descriptionPrompt() {
        String description;
        while (true){
            System.out.print("Enter expense description : ");
            description = scanner.next();
            if (description != null || !description.trim().isEmpty()) {
                return description.trim();

            }
            System.out.println("Input cannot be empty. Please enter a valid description.");
        }

    }

    public double amountPrompt() {
        String amount;
        while (true){
            System.out.print("Enter expense amount : ");
            amount = scanner.next();
            if (amount == null || amount.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a number.");
                continue;
            }
            try {
                return Double.parseDouble(amount.trim());
            } catch (NumberFormatException e) {
                System.out.println("Thats not a valid number. Please enter a valid number.");
            }
        }
    }

    public int monthPrompt() {
        String month;
        while (true){
            System.out.print("Enter the Month number (e.g. 1-12): ");
            month = scanner.next();
            if (month == null || month.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a number.");
                continue;
            }
            try {
                return Integer.parseInt(month.trim());
            } catch (NumberFormatException e) {
                System.out.println("Thats not a valid number. Please enter a valid number.");
            }
        }
    }

    public int choicePrompt(){
        String id;
        while (true){
            System.out.print("Enter your choice : ");
            id = scanner.next();
            if (id == null || id.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a number.");
                continue;
            }
            try {
                return Integer.parseInt(id.trim());
            } catch (NumberFormatException e) {
                System.out.println("Thats not a valid whole number. Please enter a valid number.");
            }
        }
    }



}
