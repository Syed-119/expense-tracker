package org.tracker.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Expense {

    private int id;
    private LocalDate date;
    private String description;
    private double amount;

    public Expense(String description, double amount, LocalDate date, int id) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id + '\'' +
                " amount=£" + amount +
                " date=" + date +
                " description=" + description +
                '}';
    }


}
