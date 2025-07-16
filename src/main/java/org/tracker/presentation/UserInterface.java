package org.tracker.presentation;

import org.tracker.data.Expense;
import org.tracker.service.ExpenseService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private ExpenseService expenseService = new ExpenseService();

    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true)
        {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Update an Expense");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addExpense();
                    break;
                    case 2:
                        viewExpenses();
                        break;
                        case 3:
                            updateExpense();
                            break;
                            case 4:
                                System.exit(0);
            }

        }
    }

    private void addExpense() {
        System.out.print("Enter Expense ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Expense Description: ");
        String description = scanner.next();
        System.out.print("Enter Expense Amount: ");
        int amount = scanner.nextInt();
        LocalDate expenseDate = LocalDate.now();
        Expense expense = new Expense(description, amount, expenseDate, id);
        expenseService.addExpense(expense);
        System.out.print("Expense added successfully ID:"+expense.getId());
    }

    private void viewExpenses() {
        ArrayList<Expense> expenses = expenseService.getAllExpenses();
        if (expenses.size() > 0) {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
        else {
            System.out.println("No expenses found");
        }

    }

    private void updateExpense() {
        System.out.print("Enter Expense ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter New Expense Description: ");
        String description = scanner.next();
        System.out.print("Enter New Expense Amount: ");
        int amount = scanner.nextInt();
        LocalDate expenseDate = LocalDate.now();
        Expense expense = new Expense(description, amount, expenseDate, id);
        expenseService.updateExpense(expense);
        System.out.print("Expense updated successfully ID:"+expense.getId());
    }

}
