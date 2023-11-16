import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BankLogic {
    private Scanner scan;
    private Bank bank;
    private int choice;
    private ArrayList<Bank> bankList = new ArrayList<>();
    public BankLogic(){
        bank = null;
        scan = new Scanner(System.in);
    }
    private void getBank(){
        int choiceB = 0;
        System.out.println("Which account do you want to access?\n");
        for (int i = 0; i < bankList.size(); i++){
            System.out.println(i + 1 + bankList.get(i).getInfo());
            choiceB = scan.nextInt();
        }
        bank = bankList.get(choiceB - 1);
    }
    public void start(){
        System.out.println("Welcome to our banking app!");
        System.out.println();
        System.out.println("Please create an account!");

        System.out.print("What would you like to name it: ");
        String tempName = scan.nextLine();
        scan.nextLine();
        System.out.println("What account do you want? Saving or checking");
        String tempType = scan.nextLine();
        System.out.println("It will start with 0 dollars");
        bank = new Bank(tempName, tempType, 0);
        bankList.add(bank);

        while (choice != 6) {
            printMenu();
            doStuff();
        }
        System.out.println("Goodbye!");
    }
    public void printMenu(){
        System.out.println("___________________________________");
        System.out.println("1. Create a new account");
        System.out.println("2. Withdraw from an account");
        System.out.println("3. Deposit into an account");
        System.out.println("4. View banks and info");
        System.out.println("5. Transfer from accounts");
        System.out.println("6. Exit");
        choice = scan.nextInt();
    }
    public void doStuff(){
        if (choice == 1) {
            System.out.println("What would you like to name it?");
            scan.nextLine();
            String tempName = scan.nextLine();
            System.out.println("What account do you want? Saving or checking");
            String tempType = scan.nextLine();
            System.out.println("It will start with 0 dollars");
            bank = new Bank(tempName, tempType, 0);
            bankList.add(bank);

            System.out.println("__________________________");
            System.out.println(bank.getInfo());
        }
        else if (choice == 2){
            System.out.println("How much do you want to withdraw?");
            double amt = scan.nextDouble();
            bank.withdraw(amt);
            System.out.println("You have " + bank.getBalance() + "$ in your account");
        }
        else if (choice == 3) {
            System.out.println("How much would you like to deposit?");
            double amt = scan.nextDouble();
            bank.deposit(amt);
            System.out.println("You have " + bank.getBalance() + "$ in your account");
        }
        else if (choice == 4)
    }
}
