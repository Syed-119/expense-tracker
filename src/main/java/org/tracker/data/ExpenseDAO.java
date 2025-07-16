package org.tracker.data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



import java.io.FileReader;
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
    private static ArrayList<Expense> expenses;
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();


    public void addExpense(Expense expense) {
        try {
            ArrayList<Expense> expenses = getExpenses();
            expenses.add(expense);
            Writer writer = Files.newBufferedWriter(expenseFile,  StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            gson.toJson(expenses, writer);
            writer.close();

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

            Writer writer = Files.newBufferedWriter(expenseFile,  StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            gson.toJson(expenses, writer);
            writer.close();

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


            Writer writer = Files.newBufferedWriter(expenseFile,  StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            gson.toJson(expenses, writer);
            writer.close();
            return isDeleted;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
