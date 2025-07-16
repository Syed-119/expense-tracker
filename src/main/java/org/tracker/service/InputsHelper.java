package org.tracker.service;

import java.util.Scanner;

public class InputsHelper {
    private Scanner scanner = new Scanner(System.in);

    public int idPrompt(){
        String idInput;
        while (true){
            System.out.print("Enter expense id : ");
            idInput = scanner.next();
            if (idInput == null || idInput.trim().isEmpty()) {
                System.out.println("Input cannot be empty or less than 0. Please enter a number.");
                continue;
            }
                try {
                    int id = Integer.parseInt(idInput.trim());
                     if (id<0){
                         System.out.println("Input cannot be less than 0. Please enter a number.");
                         continue;
                     }
                    return id;
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
        String amountInput;
        while (true){
            System.out.print("Enter expense amount : ");
            amountInput = scanner.next();
            if (amountInput == null || amountInput.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a number.");
                continue;
            }
            try {
                double amount = Double.parseDouble(amountInput.trim());
                if (amount<0){
                    System.out.println("Input cannot be less than 0. Please enter a number.");
                    continue;
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("Thats not a valid number. Please enter a valid number.");
            }
        }
    }

    public int monthPrompt() {
        String monthInput;
        while (true){
            System.out.print("Enter the Month number (e.g. 1-12): ");
            monthInput = scanner.next();
            if (monthInput == null || monthInput.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a number.");
                continue;
            }
            try {
                int month = Integer.parseInt(monthInput.trim());
                if (month<0){
                    System.out.println("Input cannot be less than 0. Please enter a number.");
                    continue;
                }
                return month;
            } catch (NumberFormatException e) {
                System.out.println("Thats not a valid number. Please enter a valid number.");
            }
        }
    }

    public int choicePrompt(){
        String choiceInput;
        while (true){
            System.out.print("Enter your choice : ");
            choiceInput = scanner.next();
            if (choiceInput == null || choiceInput.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a number.");
                continue;
            }
            try {
                int choice = Integer.parseInt(choiceInput.trim());
                if (choice<0){
                    System.out.println("Input cannot be less than 0. Please enter a number.");
                    continue;
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Thats not a valid whole number. Please enter a valid number.");
            }
        }
    }



}
