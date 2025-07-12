package org.tracker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Expense {

    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }


}
