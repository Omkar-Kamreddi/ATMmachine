import java.util.*;

class ATM {

    private float Bal;
    private int Pin = 8080;
    // arraylist arraylist to maintain transaction history
    private List<String> transactionHistory = new ArrayList<>();

    // checking pin from user
    public void Checkpin() {

        Scanner sc = new Scanner(System.in);
        int temp;
        do {
            System.out.println("Enter Your Pin : ");
            temp = sc.nextInt();

            if (temp != Pin) {
                System.out.println("Please Try Again!");
            } else {
                System.out.println("Login Successful!");
            }

        } while (temp != Pin);

        if (temp == Pin) {
            Menu();
        } else {
            System.out.println("Enter Valid Pin!");
        }

    }

    // menu function called if pin correct
    public void Menu() {
        System.out.println("Enter Your choice: ");
        System.out.println("1. Check A/C Balance ");
        System.out.println("2. Withdraw Money ");
        System.out.println("3. Deposit Money ");
        System.out.println("4. View Transaction History ");
        System.out.println("5. Change Pin ");
        System.out.println("6. Exit ");

        Scanner sc = new Scanner(System.in);
        int op;

        op = sc.nextInt();

        if (op == 1) {
            checkBalance();
        } else if (op == 2) {
            Withdraw();
        } else if (op == 3) {
            Deposit();
        } else if (op == 4) {
            viewTransactionHistory();
        } else if (op == 5) {
            changePin();
        } else if (op == 6) {
            return;
        } else {
            System.out.println("Enter Valid Choice");

        }
    }

    // checkBalance function for current balance check
    public void checkBalance() {
        System.out.println("Balance : " + Bal);
        Menu();
    }

    // withdraw function for withdraw amount from current balance
    public void Withdraw() {
        System.out.println("Enter Amount to withdraw : ");
        Scanner sc = new Scanner(System.in);
        float amt = sc.nextFloat();

        // transaction added into arraylist
        transactionHistory.add("Withdrawn: " + amt);

        if (amt > Bal) {
            System.out.println("Insufficient Balance!");
        } else {
            Bal = Bal - amt;
            System.out.println("Money Withdraw successfully");
        }
        Menu();
    }

    // Deposit function to add amount into current balance
    public void Deposit() {
        System.out.println("Enter Amount to Diposit : ");
        Scanner sc = new Scanner(System.in);
        float dep = sc.nextFloat();

        Bal = Bal + dep;

        // transaction added into arraylist
        transactionHistory.add("Deposited: " + dep);
        System.out.println("Money Diposited successfully");
        Menu();
    }

    // viewTransactionHistory function for view transaction details
    public void viewTransactionHistory() {

        if (transactionHistory.isEmpty()) {

            System.out.println("No transactions yet.");

        } else {

            for (String transaction : transactionHistory) {

                System.out.println(transaction);
            }
        }
        Menu();
    }

    // changePin function to change initial pin
    public void changePin() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter current PIN: ");
        int currentPin = sc.nextInt();

        if (currentPin == Pin) {
            System.out.println("Enter new PIN: ");
            int newPin = sc.nextInt();

            Pin = newPin;

            System.out.println("PIN changed successfully!");

        } else {

            System.out.println("Incorrect current PIN!");

        }
        Menu();
    }
}

public class ATMmachine {

    public static void main(String[] args) {

        ATM person1 = new ATM();

        person1.Checkpin();
    }
}