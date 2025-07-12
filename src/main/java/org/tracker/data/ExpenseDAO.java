package org.tracker.data;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.simple.parser.JSONParser;

public class ExpenseDAO {
    private static final Path expenseFile = Paths.get("expenses.json");
    private static ArrayList<Expense> expenses;

    public void addExpense(Expense expense) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(expenseFile);
            gson.toJson(expense, writer);
            writer.close();
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Expense> getExpenses() {
        if (expenseFile.toFile().exists()){
            try {
                FileReader reader = new FileReader(expenseFile.toFile());
                Type type = new TypeToken<ArrayList<Expense>>(){}.getType();
                Gson gson = new Gson();
                expenses = gson.fromJson(reader, type);
                for (Expense expense : expenses) {
                    System.out.println(expense);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
