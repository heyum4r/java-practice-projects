import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BankManager manager = new BankManager();

        while (true) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("(1) Create Account");
            System.out.println("(2) Perform Transaction");
            System.out.println("(3) Exit");
            System.out.print("Enter choice: ");

            int choice = scan.nextInt();
            scan.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.println("\n--- Account Creation ---");
                    System.out.print("Enter your name: ");
                    String name = scan.nextLine();
                    manager.accountCreation(name);
                    break;

                case 2:
                    System.out.println("\n--- Operations ---");
                    System.out.println("(1) Deposit");
                    System.out.println("(2) Withdraw");
                    System.out.println("(3) Transfer");
                    System.out.println("(4) Check Balance");
                    System.out.print("Enter operation choice: ");

                    int op = scan.nextInt();
                    scan.nextLine(); // Clear buffer

                    System.out.print("Enter your Account Number: ");
                    String accNum = scan.nextLine();
                    BankAccount currentAcc = manager.findAccount(accNum);

                    if (currentAcc == null) {
                        System.out.println("Error: Account not found!");
                        break;
                    }

                    switch (op) {
                        case 1:
                            System.out.print("Enter Deposit Amount: ");
                            double depAmount = scan.nextDouble();
                            manager.deposit(currentAcc, depAmount);
                            break;

                        case 2:
                            System.out.print("Enter Withdraw Amount: ");
                            double wAmount = scan.nextDouble();
                            manager.withdraw(currentAcc, wAmount);
                            break;

                        case 3:
                            System.out.print("Enter Destination Account Number: ");
                            String destAccNum = scan.nextLine();
                            BankAccount destAcc = manager.findAccount(destAccNum);

                            if (destAcc == null) {
                                System.out.println("Error: Destination account not found!");
                            } else {
                                System.out.print("Enter Transfer Amount: ");
                                double tAmount = scan.nextDouble();
                                manager.transfer(currentAcc, destAcc, tAmount);
                            }
                            break;

                        case 4:
                            manager.checkBalance(currentAcc);
                            break;

                        default:
                            System.out.println("Invalid operation choice.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting System. Goodbye!");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid main menu choice.");
            }
        }
    }
}