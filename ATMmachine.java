import java.util.*;

class ATM {

    float Bal;
    int Pin = 8080;

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

    public void Menu() {
        System.out.println("Enter Your choice: ");
        System.out.println("1. Check A/C Balance ");
        System.out.println("2. Withdraw Money ");
        System.out.println("3. Deposit Money ");
        System.out.println("4. Exit ");

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
            return;
        } else {
            System.out.println("Enter Valid Choice");

        }
    }

    public void checkBalance() {
        System.out.println("Balance : " + Bal);
        Menu();
    }

    public void Withdraw() {
        System.out.println("Enter Amount to withdraw : ");
        Scanner sc = new Scanner(System.in);
        float amt = sc.nextFloat();

        if (amt > Bal) {
            System.out.println("Insufficient Balance!");
        } else {
            Bal = Bal - amt;
            System.out.println("Money Withdraw successfully");
        }
        Menu();
    }

    public void Deposit() {
        System.out.println("Enter Amount to Diposit : ");
        Scanner sc = new Scanner(System.in);
        float dep = sc.nextFloat();

        Bal = Bal + dep;

        System.out.println("Money Diposited successfully");
        Menu();
    }

}

public class ATMmachine {

    public static void main(String[] args) {

        ATM person1 = new ATM();

        person1.Checkpin();
    }
}