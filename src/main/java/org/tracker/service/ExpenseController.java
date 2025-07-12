package org.tracker.service;

import org.tracker.data.Expense;
import org.tracker.presentation.UserInterface;

public class ExpenseController {
    private Expense expense;
    private UserInterface userInterface;

    public ExpenseController(Expense expense, UserInterface userInterface) {
        this.expense = expense;
        this.userInterface = userInterface;
    }

    public void setAmount(double amount) {
        expense.setAmount(amount);
    }
    public void setDescription(String description) {
        expense.setDescription(description);
    }
    public Double getAmount() {
        return expense.getAmount();
    }
    public String getDescription() {
        return expense.getDescription();
    }

}
