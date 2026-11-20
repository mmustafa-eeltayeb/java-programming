import java.util.Scanner;

public class ATMSimulation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Constants
        final int CORRECT_PIN = 1234;
        final int MAX_ATTEMPTS = 3;
        final int MAX_TRANSACTIONS = 100;

        // Authentication variables
        int attempts = 0;
        boolean loggedIn = false;

        System.out.println("===== ATM SIMULATION =====");

        // PIN authentication
        while (attempts < MAX_ATTEMPTS && !loggedIn) {
            System.out.print("Enter your PIN: ");
            int enteredPin = input.nextInt();

            attempts++;

            if (enteredPin == CORRECT_PIN) {
                loggedIn = true;
                System.out.println("Login successful. Welcome!\n");
            } else {
                System.out.println("Incorrect PIN.");

                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("Attempts remaining: "
                            + (MAX_ATTEMPTS - attempts));
                }
            }
        }

        // Continue only if the user enters the correct PIN
        if (loggedIn) {
            // Initial balance
            double balance = 0.0;

            // Array to store transaction history
            String[] transactions = new String[MAX_TRANSACTIONS];
            int transactionCount = 0;

            int choice = 0;

            // Main ATM menu
            while (choice != 5) {
                System.out.println("\n========== ATM MENU ==========");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. View Transaction History");
                System.out.println("5. Exit");

                System.out.print("Choose an option: ");
                choice = input.nextInt();

                // Option 1: Check balance
                if (choice == 1) {
                    System.out.printf(
                            "Your current balance is: $%.2f%n",
                            balance
                    );

                // Option 2: Deposit money
                } else if (choice == 2) {

                    if (transactionCount < transactions.length) {
                        System.out.print("Enter deposit amount: $");
                        double amount = input.nextDouble();

                        if (amount > 0) {
                            balance = balance + amount;

                            transactions[transactionCount] =
                                    String.format("Deposit: +$%.2f", amount);

                            transactionCount++;

                            System.out.printf(
                                    "Deposit successful. New balance: $%.2f%n",
                                    balance
                            );

                        } else {
                            System.out.println(
                                    "Error: Deposit amount must be greater than zero."
                            );
                        }

                    } else {
                        System.out.println(
                                "Transaction history is full. No more transactions can be recorded."
                        );
                    }

                // Option 3: Withdraw money
                } else if (choice == 3) {

                    if (transactionCount < transactions.length) {
                        System.out.print("Enter withdrawal amount: $");
                        double amount = input.nextDouble();

                        if (amount <= 0) {
                            System.out.println(
                                    "Error: Withdrawal amount must be greater than zero."
                            );

                        } else if (amount <= balance) {
                            balance = balance - amount;

                            transactions[transactionCount] =
                                    String.format("Withdrawal: -$%.2f", amount);

                            transactionCount++;

                            System.out.printf(
                                    "Withdrawal successful. New balance: $%.2f%n",
                                    balance
                            );

                        } else {
                            System.out.println(
                                    "Error: Insufficient balance. Withdrawal denied."
                            );
                        }

                    } else {
                        System.out.println(
                                "Transaction history is full. No more transactions can be recorded."
                        );
                    }

                // Option 4: View transaction history
                } else if (choice == 4) {
                    System.out.println("\n===== TRANSACTION HISTORY =====");

                    if (transactionCount == 0) {
                        System.out.println("No transactions recorded yet.");

                    } else {
                        for (int i = 0; i < transactionCount; i++) {
                            System.out.println(
                                    (i + 1) + ". " + transactions[i]
                            );
                        }
                    }

                // Option 5: Exit
                } else if (choice == 5) {
                    System.out.println(
                            "Thank you for using the ATM. Goodbye!"
                    );

                // Invalid menu option
                } else {
                    System.out.println(
                            "Invalid option. Please choose a number from 1 to 5."
                    );
                }
            }

        } else {
            System.out.println(
                    "Your account is locked because you entered the wrong PIN three times."
            );
        }

        input.close();
    }
}