import java.util.ArrayList;
import java.util.Scanner;
public class BankLogic {
    private Scanner scan;
    private Bank bank;
    private Bank bank2;
    private int choice;
    private ArrayList<Bank> bankList = new ArrayList<>();
    public BankLogic(){
        bank = null;
        scan = new Scanner(System.in);
    }
    private void getBank(){
        int choiceB = 0;
        for (int i = 0; i < bankList.size(); i++) {
            System.out.println("_____________");
            System.out.println(i + 1 + ". " + bankList.get(i).getInfo());
        }
        choiceB = (int) scan.nextDouble();

        bankList.get(choiceB - 1);
    }
    public void start(){
        System.out.println("Welcome to our banking app!");
        System.out.println();
        System.out.println("Please create an account!");

        System.out.println("What would you like to name it: ");
        String tempName = scan.nextLine();
        System.out.println("What account do you want? Saving or checking");
        String tempType = scan.nextLine();
        System.out.println("Please make a password for this account: ");
        String tempPass = scan.nextLine();
        System.out.println("It will start with 0 dollars");
        bank = new Bank(tempName, tempType, tempPass);
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
        System.out.println("4. View accounts and info");
        System.out.println("5. Transfer from accounts");
        System.out.println("6. Exit");
        System.out.println("7. Surprise!");
        choice = scan.nextInt();
    }
    public void doStuff(){
        if (choice == 1) {
            System.out.println("What would you like to name it?");
            String tempName = scan.nextLine();
            System.out.println("What account do you want? Saving or checking");
            String tempType = scan.nextLine();
            System.out.println("Please add a password: ");
            String pass = scan.nextLine();
            System.out.println("It will start with 0 dollars");
            bank2 = new Bank(tempName, tempType, pass);
            bankList.add(bank2);

            System.out.println("__________________________");
            System.out.println(bank.getInfo());
        }
        else if (choice == 2){
            System.out.println("What account would you like to withdraw from?");
            getBank();
            System.out.println("How much do you want to withdraw?");
            double amt = scan.nextDouble();
            bank.withdraw(amt);
            System.out.println("You have " + bank.getBalance() + "$ in your account");
        }
        else if (choice == 3) {
            System.out.println("Which account do you want to deposit into?");
            getBank();
            System.out.println("How much would you like to deposit?");
            double amt = scan.nextDouble();
            bank.deposit(amt);
            System.out.println("You have " + bank.getBalance() + "$ in your account");
        }
        else if (choice == 4) {
            for (int i = 0; i < bankList.size(); i++) {
                System.out.println("_____________");
                System.out.println(i + 1 + ". " + bankList.get(i).getInfo());
            }
        }
        else if (choice == 5){
            Bank withdrawB;
            Bank depositB;

            int choiceB = 0;
            System.out.println("Which account do you want to transfer from?\n");
            for (int i = 0; i < bankList.size(); i++){
                System.out.println("___________________");
                System.out.println(i + 1 + ". " + bankList.get(i).getInfo());
            }
            choiceB = scan.nextInt();
            withdrawB = bankList.get(choiceB - 1);

            int choiceD = 0;
            System.out.println("Which account do you want to transfer into?\n");
            for (int i = 0; i < bankList.size(); i++){
                System.out.println("___________________");
                System.out.println(i + 1 + ". " + bankList.get(i).getInfo());
            }
            choiceD = scan.nextInt();
            depositB = bankList.get(choiceD -1);

            System.out.println("How much do you want to transfer?");
            int amt = scan.nextInt();

            if (depositB.transferFrom(withdrawB, amt)){
                System.out.println("The transfer is complete!");
                System.out.println(withdrawB.getInfo());
                System.out.println(depositB.getInfo());
            }
            else {
                System.out.println("The transfer didn't work, please check balance");
            }
        }
        else if (choice == 7){
            int wOrD = (int) (Math.random() * 2) + 1;
            int amt = (int) (Math.random() * 150) + 1;
            getBank();
            if (wOrD == 1){
                bank.withdraw(amt);
            }
            else if (wOrD == 2){
                bank.deposit(amt);
            }

        }
    }
}
