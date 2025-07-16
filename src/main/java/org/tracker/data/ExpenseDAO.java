package org.tracker.data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;





public class ExpenseDAO {
    private static final Path expenseFile = Paths.get("expenses.json");
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();


    private void writeExpenses(ArrayList<Expense> expenses) throws IOException {
        Writer writer = Files.newBufferedWriter(expenseFile,  StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        gson.toJson(expenses, writer);
        writer.close();
    }


    public void addExpense(Expense expense) {
        try {
            ArrayList<Expense> expenses = getExpenses();
            expenses.add(expense);
            writeExpenses(expenses);

            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Expense> getExpenses() {
        ArrayList<Expense> expenses =  new ArrayList<>();
        try {
            boolean exists = Files.exists(expenseFile) && Files.size(expenseFile) > 0;
            if (exists) {
                Reader reader = new FileReader(expenseFile.toFile(), StandardCharsets.UTF_8);
                Type listType = new TypeToken<ArrayList<Expense>>() {}.getType();

                expenses = gson.fromJson(reader, listType);
                if (expenses == null) {
                    expenses = new ArrayList<>();
                }
                reader.close();

            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return expenses;

    }

    public void updateExpense(Expense expense) {
        try {
            ArrayList<Expense> expenses = getExpenses();
            for (Expense e : expenses) {
                if (e.getId() == expense.getId()) {
                    e.setAmount(expense.getAmount());
                    e.setDate(expense.getDate());
                    e.setDescription(expense.getDescription());
                }
            }

            writeExpenses(expenses);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean deleteExpense(int id) {
        boolean isDeleted = false;
        try {
            ArrayList<Expense> expenses = getExpenses();
            for (Expense e : expenses) {
                if (e.getId() == id) {
                    expenses.remove(e);
                    isDeleted = true;
                }
            }

            writeExpenses(expenses);
            return isDeleted;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public double getAllExpensesSummary(ArrayList<Expense> expenses) {
        double allExpensesSummary = 0;
        for (Expense e : expenses) {
            allExpensesSummary += e.getAmount();
        }
        return allExpensesSummary;
    }

    public double getMonthlyExpensesSummary(ArrayList<Expense> expenses, int month) {
        double monthlyExpensesSummary = 0;
        for (Expense e : expenses) {
            int expenseMonth = e.getDate().getMonthValue();
            if (expenseMonth == month) {
                monthlyExpensesSummary += e.getAmount();
            }
        }
        return monthlyExpensesSummary;
    }


}
