import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int totalAccounts = 0;
    static String[] names = new String[100];
    static String[] accountNumbers = new String[100];
    static double[] balances = new double[100];

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();

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
                    checkBalance();
                    break;
                case 5:
                    searchAccount();
                    break;
                case 6:
                    viewAllAccounts();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }


    public static void showMenu() {
        System.out.println("\n===== MINI BANK SYSTEM =====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Search Account");
        System.out.println("6. View All Accounts");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void createAccount() {
        System.out.print("Enter account holder name: ");
        scanner.nextLine(); // flush
        String name = scanner.nextLine();

        String accNumber = "ACC" + String.format("%03d", totalAccounts + 1);

        names[totalAccounts] = name;
        accountNumbers[totalAccounts] = accNumber;
        balances[totalAccounts] = 0.0;

        totalAccounts++;

        System.out.println("Account created successfully!");
        System.out.println("Your account number is: " + accNumber);
    }


    public static int findAccount(String accNumber) {
        for (int i = 0; i < totalAccounts; i++) {
            if (accountNumbers[i].equals(accNumber)) {
                return i;
            }
        }
        return -1;
    }

    public static void deposit() {
        System.out.print("Enter account number: ");
        scanner.nextLine();
        String accNumber = scanner.nextLine();

        int index = findAccount(accNumber);

        if (index == -1) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        balances[index] += amount;
        System.out.println("Deposit successful! New balance: " + balances[index]);
    }

    public static void withdraw() {
        System.out.print("Enter account number: ");
        scanner.nextLine();
        String accNumber = scanner.nextLine();

        int index = findAccount(accNumber);

        if (index == -1) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        if (amount > balances[index]) {
            System.out.println("Insufficient balance.");
            return;
        }

        balances[index] -= amount;
        System.out.println("Withdrawal successful! New balance: " + balances[index]);
    }

    public static void checkBalance(){
        System.out.print("Enter Account Number: ");
        scanner.nextLine();
        String accNumber = scanner.nextLine();

        int index = findAccount(accNumber);
        if(index == -1) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Account Number: " + accountNumbers[index]);
        System.out.println("Name: " + names[index]);
        System.out.println("Balance: " + balances[index]);
    }

    public static void searchAccount() {
        System.out.print("Enter Account Number: ");
        scanner.nextLine();
        String accNumber = scanner.nextLine();

        int index = findAccount(accNumber);
        if(index == -1) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Account Number: " + accountNumbers[index]);
        System.out.println("Name: " + names[index]);
        System.out.println("Balance: " + balances[index]);
    }

    public static void viewAllAccounts() {
        if(totalAccounts == 0) {
            System.out.println("No accounts found.");
            return;
        }
        for(int i = 0; i<totalAccounts; i++) {
            System.out.println("Account Number: " + accountNumbers[i]);
            System.out.println("Name: " + names[i]);
            System.out.println("Balance: " + balances[i]);
            System.out.println("--------------------");
        }
    }

}