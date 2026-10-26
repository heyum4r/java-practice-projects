<<<<<<< HEAD
public class Main {
    public static void main(String[] arg) {
        System.out.println("Hello Main file");
=======
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {

        ExpenseManager manager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);

        
        manager.readFile();

        while (true) {

            System.out.println("------------WELCOME TO EXPENSE TRACKER--------------");
            System.out.println("1.Add New Expense \n2.View Total Expenses \n3.View Monthly Report \n4.All History \n5.Exit");
            System.out.println("--------------------------\n");

            System.out.println("Enter your choice (1-4): ");
            int input = scanner.nextInt();
            scanner.nextLine(); // buffer

            switch (input) {
                case 1:
                    double amount = 0.0;
                    while (true) {
                        System.out.println("Enter Amount: ");

                        if (scanner.hasNextDouble()) {
                            amount = scanner.nextDouble();
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter a valid number.");
                            scanner.next();
                        }
                    }
                    scanner.nextLine();

                    String category;
                    while (true) {
                        System.out.println("Enter Category: ");
                        if (scanner.hasNextLine()) {
                            category = scanner.nextLine();
                            break;

                        } else {
                            System.out.println("Invalid input! Please enter a valid Category.");
                            scanner.next();
                        }
                    }

                    String description;
                    while (true) {
                        System.out.println("Enter Description: ");
                        if (scanner.hasNextLine()) {
                            description = scanner.nextLine();
                            break;

                        } else {
                            System.out.println("Invalid input! Description can't be number.");
                            scanner.next();
                        }
                    }

                    String validDateStr = null;
                    while (true) {
                        try {
                            System.out.print("Enter date (YYYY-MM-DD): ");
                            String date = scanner.nextLine();
                            LocalDate.parse(date);
                            validDateStr = date;
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println(
                                    "Invalid format or date! Please make sure to use YYYY-MM-DD (e.g., 2026-06-12).");
                        }
                    }
                    manager.addExpense(amount, category, description, validDateStr);

                    manager.saveToFile();
                    break;
                case 2:
                    manager.totalExpenses();
                    break;
                case 3:
                    System.out.print("Enter month and year to report (e.g., 2026-06): ");
                    String targetMonthYear = scanner.nextLine().trim();
                    manager.monthlyReport(targetMonthYear);
                    break;
                case 4:
                    manager.allHistory();
                   
                    break;
                case 5:
                    System.out.println("program closed...");
                    return;
                default:
                    System.out.println("Enter a valid Number between (1-5).");
                    break;
            }

        }
>>>>>>> 336b76f (expense tracker)

    }
}
