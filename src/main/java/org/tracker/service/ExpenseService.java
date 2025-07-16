package org.tracker.service;

import org.tracker.data.Expense;
import org.tracker.data.ExpenseDAO;
import java.util.ArrayList;


public class ExpenseService {
    private ExpenseDAO expenseDAO =  new ExpenseDAO();

    public void addExpense(Expense expense){
        Expense newExpense = new Expense(expense.getDescription(), expense.getAmount(), expense.getDate(), expense.getId());
        expenseDAO.addExpense(newExpense);

    }

    public ArrayList<Expense> getAllExpenses(){
        return expenseDAO.getExpenses();
    }

    public void updateExpense(Expense expense){
        Expense newExpense = new Expense(expense.getDescription(), expense.getAmount(), expense.getDate(), expense.getId());
        expenseDAO.updateExpense(newExpense);
    }

    public boolean deleteExpense(int id){
        return expenseDAO.deleteExpense(id);
    }

    public double getAllExpensesAmount(ArrayList<Expense> expenses){
        return expenseDAO.getAllExpensesSummary(expenses);
    }

    public double getMonthlyExpensesAmount(ArrayList<Expense> expenses, int month){
        return expenseDAO.getMonthlyExpensesSummary(expenses, month);
    }

    public <T> boolean checkForNullValues(T input){
        return input != null;
    }


}
