package org.tracker.service;

import org.tracker.data.Expense;
import org.tracker.data.ExpenseDAO;

import java.time.LocalDate;
import java.util.ArrayList;


public class ExpenseService {
    private ExpenseDAO expenseDAO =  new ExpenseDAO();

    public void addExpense(int id, LocalDate expenseDate, String description, double amount){
        Expense newExpense = new Expense(description, amount, expenseDate, id);
        expenseDAO.addExpense(newExpense);

    }

    public ArrayList<Expense> getAllExpenses(){
        return expenseDAO.getExpenses();
    }


}
