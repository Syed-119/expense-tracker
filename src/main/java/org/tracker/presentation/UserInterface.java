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
            System.out.println("4. Delete an Expense");
            System.out.println("5. View All Expenses Amount Summary");
            System.out.println("6. View Monthly Expense Amount Summary");
            System.out.println("7. Exit");
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
                                deleteExpesne();
                                break;
                                case 5:
                                    getAllExpensesSummary();
                                    break;
                                    case 6:
                                        getMonthlyExpensesSummary();
                                        break;
                                        case 7:
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

    private void deleteExpesne() {
        boolean isDeleted;
        System.out.print("Enter Expense ID: ");
        int id = scanner.nextInt();
        isDeleted = expenseService.deleteExpense(id);
        if (isDeleted) {
            System.out.print("Expense deleted successfully ID:"+id);
        } else {
            System.out.println("Expense not found");
        }

    }

    private void getAllExpensesSummary(){
        double allExpensesSummary;
        ArrayList<Expense> expenses = expenseService.getAllExpenses();
        allExpensesSummary = expenseService.getAllExpensesAmount(expenses);
        if (allExpensesSummary == 0) {
            System.out.println("No expenses found");
        } else {
            System.out.println("Total expenses amount: "+allExpensesSummary);
        }
    }

    private void getMonthlyExpensesSummary(){
        double monthlyExpensesSummary;
        ArrayList<Expense> expenses = expenseService.getAllExpenses();
        System.out.print("Enter the Month number (e.g. 1-12): ");
        int month = scanner.nextInt();
        monthlyExpensesSummary = expenseService.getMonthlyExpensesAmount(expenses, month);
        if (monthlyExpensesSummary == 0) {
            System.out.println("No expenses found");
        } else {
            System.out.println("Total monthly expenses amount: "+monthlyExpensesSummary);
        }
    }

}
