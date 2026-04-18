import java.util.*;


class Account {
    private int accountNumber;
    private String name;
    private double balance;

    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }
}


public class Main {
    private static HashMap<Integer, Account> accounts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Bank Account Management =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    viewBalance();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    private static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
            return;
        }

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Account acc = new Account(accNo, name, balance);
        accounts.put(accNo, acc);

        System.out.println("Account created successfully!");
    }

    private static void deposit() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = accounts.get(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        acc.deposit(amount);
    }

    private static void withdraw() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = accounts.get(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        acc.withdraw(amount);
    }

    private static void viewBalance() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = accounts.get(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
        } else {
            System.out.println("Account Holder: " + acc.getName());
            System.out.println("Balance: ₹" + acc.getBalance());
        }
    }
}
