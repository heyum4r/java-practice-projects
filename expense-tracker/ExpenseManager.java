import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class ExpenseManager {

    private ArrayList<Expense> expenseBook = new ArrayList<>();

    // save file
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("expense.txt"))) {
            for (Expense e : expenseBook) {
                String line = e.getAmount() + "," + e.getCategory() + "," + e.getDescription() + "," + e.getDate();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data saved successfully to local storage.");

        } catch (IOException e) {
            System.out.println("An error occured!" + e.getMessage());

        }

    }

    // read file
    public void readFile() {
        File file = new File("expense.txt");

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    double amount = Double.parseDouble(parts[0]);
                    String category = parts[1];
                    String description = parts[2];
                    String date = parts[3];

                    Expense prevExpense = new Expense(amount, category, description, date);
                    expenseBook.add(prevExpense);
                }
            }
            System.out.println("Previous expenses loaded successfully!");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }

    public void addExpense(double amount, String category, String description, String date) {
        Expense addExpense = new Expense(amount, category, description, date);
        expenseBook.add(addExpense);
        System.out.println("Expense added successfully!");
    }

    public void totalExpenses() {
        double sum = 0.0;
        for (Expense e : expenseBook) {
            sum += e.getAmount();
        }
        System.out.println("-------------TOTAL SPENDING SUMMARY----------------\n");
        System.out.println("Total Amount Spent Across All Time: " + sum + "\n");
        System.out.println("-------------------------------------------------------\n");
    }

    // Monthly history report
    public void monthlyReport(String monthYear) {
        double totalMonthlySpend = 0.0;
        boolean found = false;

        System.out.println("\n--- Monthly Expense Report (" + monthYear + ") ---");
        System.out.printf("%-12s | %-15s | %-10s | %-12s\n", "Category", "Description", "Amount", "Date");
        System.out.println("---------------------------------------------------------");

        for (Expense e : expenseBook) {
            if (e.getDate().startsWith(monthYear)) {
                System.out.printf("%-12s | %-15s | ₹%-9.2f | %-12s\n",
                        e.getCategory(), e.getDescription(), e.getAmount(), e.getDate());

                totalMonthlySpend += e.getAmount();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses recorded for this month.");
        } else {
            System.out.println("---------------------------------------------------------");
            System.out.printf("Total Spent for %s: ₹%.2f\n", monthYear, totalMonthlySpend);
        }
    }

    // All expense history
    public void allHistory() {
        System.out.println("----------All History---------\n");
        System.out.printf("%-12s | %-12s | %-20s |  %-10s%n", "Date", "Category", "Description", "Amount");
        System.out.println("-----------------------------------------------------------------------");

        double total = 0.0;

        for (Expense e : expenseBook) {
            System.out.printf("%-12s | %-12s | %-20s | ₹%-10.2f%n",
                    e.getDate(),
                    e.getCategory(),
                    e.getDescription(),
                    e.getAmount());
            total += e.getAmount();
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("Total Spending: ₹%.2f%n", total);
        System.out.println("=======================================================");
    }

}
