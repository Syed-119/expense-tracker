package org.tracker.presentation;

import org.tracker.data.Expense;
import org.tracker.service.ExpenseService;
import org.tracker.service.InputsHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private ExpenseService expenseService = new ExpenseService();
    private InputsHelper inputsHelper = new InputsHelper();

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
            int choice = inputsHelper.choicePrompt();
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
        int id = inputsHelper.idPrompt();
        String description = inputsHelper.descriptionPrompt();
        double amount = inputsHelper.amountPrompt();
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
        int id = inputsHelper.idPrompt();
        String description = inputsHelper.descriptionPrompt();
        double amount = inputsHelper.amountPrompt();
        LocalDate expenseDate = LocalDate.now();
        Expense expense = new Expense(description, amount, expenseDate, id);
        expenseService.updateExpense(expense);
        System.out.print("Expense updated successfully ID:"+expense.getId());
    }

    private void deleteExpesne() {
        boolean isDeleted;
        int id = inputsHelper.idPrompt();
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
        int month = inputsHelper.monthPrompt();
        monthlyExpensesSummary = expenseService.getMonthlyExpensesAmount(expenses, month);
        if (monthlyExpensesSummary == 0) {
            System.out.println("No expenses found");
        } else {
            System.out.println("Total monthly expenses amount: "+monthlyExpensesSummary);
        }
    }

}
