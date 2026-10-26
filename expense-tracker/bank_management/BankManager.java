import java.util.ArrayList;
import java.util.Random;

public class BankManager {
    private Random random = new Random();
    private ArrayList<BankAccount> accountDetailsArr = new ArrayList<>();

    // Create a new account and store it
    public void accountCreation(String userName) {
        int assignAccountNum = random.nextInt(900000) + 100000;
        String accountNumber = String.valueOf(assignAccountNum);

        // Create a NEW instance for each account
        BankAccount newAccount = new BankAccount(userName, accountNumber, 0.0);
        accountDetailsArr.add(newAccount);

        System.out.println("Account created successfully!");
        System.out.println(newAccount);
    }

    // Crucial Helper: Finds and returns the matching account object
    public BankAccount findAccount(String accountNumber) {
        for (BankAccount acc : accountDetailsArr) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc; // Found match
            }
        }
        return null; // Not found
    }

    // Deposit
    public void deposit(BankAccount account, double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Successfully deposited $" + amount + ". New Balance: $" + account.getBalance());
        } else {
            System.out.println("Error: Deposit amount must be greater than 0.");
        }
    }

    // Withdraw
    public void withdraw(BankAccount account, double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be greater than 0.");
        } else if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Successfully withdrew $" + amount + ". Remaining Balance: $" + account.getBalance());
        } else {
            System.out.println("Error: Insufficient funds!");
        }
    }

    // Transfer between sender and receiver
    public void transfer(BankAccount sender, BankAccount receiver, double amount) {
        if (amount <= 0) {
            System.out.println("Error: Transfer amount must be greater than 0.");
        } else if (sender.getBalance() >= amount) {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
            System.out.println("Successfully transferred $" + amount + " to " + receiver.getName());
        } else {
            System.out.println("Error: Insufficient funds to transfer!");
        }
    }

    // Check Balance
    public void checkBalance(BankAccount account) {
        System.out.println("Account Holder: " + account.getName());
        System.out.println("Current Balance: $" + account.getBalance());
    }
}