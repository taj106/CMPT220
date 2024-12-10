import java.io.*;
import java.util.*;
import java.util.Scanner;



public class ATM {
    double balance;  //balance of account
    String[] transactionHistory;  //transaction history
    int transactionCount;  //track the number of transactions

    //initialize ATM with balance
    public ATM(double initialBalance) {
        balance = initialBalance;  //initialize provided balance
        transactionHistory = new String[10]; //store up to 10 transactions
        transactionCount = 0;  //initialize transaction count
    }

    //load balance from a file or return default balance (0.0) if file not found
    public static double loadBalance() {
        try (Scanner scanner = new Scanner(new File("atm_balance.txt"))) {
            if (scanner.hasNextLine()) {
                return Double.parseDouble(scanner.nextLine());  //read balance from file
            }
        } catch (FileNotFoundException e) {
            System.out.println("No balance file found. Starting with $0.00.");
        }
        return 0.0;  //default balance if file is not found
    }

    //save balance
    private void saveBalance() {
        try (FileWriter writer = new FileWriter("atm_balance.txt")) {
            writer.write(String.format("%.2f", balance));  // Write balance to file
        } catch (IOException e) {
            System.out.println("Error saving balance.");
        }
    }

    //transaction history from file
    public void loadTransactionHistory() {
        try (Scanner scanner = new Scanner(new File("transactions.txt"))) {
            int index = 0;
            while (scanner.hasNextLine() && index < transactionHistory.length) {
                transactionHistory[index] = scanner.nextLine();  //read each transaction line
                index++;
            }
            transactionCount = index;  //update transaction count
        } catch (FileNotFoundException e) {
            System.out.println("No transaction history found.");
        }
    }

    //deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposited: $" + amount);
            saveBalance();
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    //withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrew: $" + amount);
            saveBalance();
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    //add a transaction to the history
    private void addTransaction(String transaction) {
        if (transactionCount < transactionHistory.length) {
            transactionHistory[transactionCount] = transaction;  //add new transaction
            transactionCount++;
        } else {
            //shift to make space for the new transaction
            System.arraycopy(transactionHistory, 1, transactionHistory, 0, transactionHistory.length - 1);
            transactionHistory[transactionHistory.length - 1] = transaction;
        }
    }

    //display transaction history
    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactionHistory[i]);  //each transaction
        }
    }

    //check current balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);  //display balance
    }

    //method for user interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //load balance from and create an ATM instance
        ATM atm = new ATM(loadBalance());
        atm.loadTransactionHistory();  //load transaction history

        //main menu loop
        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = getValidChoice(scanner);

            if (choice == 1) {
                System.out.print("Enter deposit amount: $");
                double amount = getValidAmount(scanner);
                atm.deposit(amount);
            } else if (choice == 2) {
                System.out.print("Enter withdrawal amount: $");
                double amount = getValidAmount(scanner);
                atm.withdraw(amount);
            } else if (choice == 3) {
                atm.checkBalance();
            } else if (choice == 4) {
                atm.showTransactionHistory();
            } else if (choice == 5) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;  //exit the loop and the program
            }
        }

        scanner.close();
    }

    // validate menu choice input (1-5)
    public static int getValidChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > 5) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid choice. Please enter a number between 1 and 5: ");
            }
        }
        return choice;
    }

    //validate amount and make sure it is positive
    public static double getValidAmount(Scanner scanner) {
        double amount = -1;
        while (amount <= 0) {
            try {
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.print("Amount must be positive. Please enter a valid amount: $");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid amount: $");
            }
        }
        return amount;
    }
}
