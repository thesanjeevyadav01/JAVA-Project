
import java.util.Scanner;

class Account {

    // Class Variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    // Class Constructor
    public Account(String customerName, String customerId, int balance) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.balance = balance;
    }

    // Depositing Money
    public void depositMoney(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    // Withdrawing Money
    public void withdrawMoney(int amount) {
        if (amount <= balance) {
            balance -= amount;
            previousTransaction = -amount;
        } else {
            System.out.println("Insufficient Amount");
        }
    }

    // Previous Transaction
    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No Transaction Occurred");
        }
    }

    // Function to calculate interest of current fund after a number of years
    public void calculateInterest(int years) {
        double interestRate = 0.02;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The Current interest Rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    // Showing the main Menu
    public void showMenu() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName + "...!");
        System.out.println("Your ID is: " + customerId);
        System.out.println("\n");
        System.out.println("What would you like to do?");
        System.out.println("1 : Check Your Balance.");
        System.out.println("2 : Deposit Your Amount");
        System.out.println("3 : Withdraw Your Amount");
        System.out.println("4 : View Previous Transaction");
        System.out.println("5 : Calculate Your Interest");
        System.out.println("6 : Exit");

        do {
            System.out.println();
            System.out.println("Enter An Option: ");
            option = scanner.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    System.out.println("==============================");
                    System.out.println("Balance = Rs" + balance);
                    System.out.println("==============================");
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Enter An Amount to Deposit:");
                    int amount = scanner.nextInt();
                    depositMoney(amount);
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Enter An Amount to Withdraw:");
                    int amount2 = scanner.nextInt();
                    withdrawMoney(amount2);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("==============================");
                    getPreviousTransaction();
                    System.out.println("==============================");
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Enter How many years of interest:");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("==============================");
                    break;

                default:
                    System.out.println("Error: invalid option. Please enter 1, 2, 3, 4, 5, or 6.");
                    break;
            }
        } while (option != 6);
        System.out.println("Thank you for banking with us...!");
        scanner.close();
    }
}

public class OneBank {

    public static void main(String[] args) {
        Account sanjeev = new Account("Sanjeev Yadav", "10000001", 10000);
        sanjeev.showMenu();
    }
}
