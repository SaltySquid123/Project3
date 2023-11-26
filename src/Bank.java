public class Bank {
    private String name;
    private String type;
    private int balance = 0;
    private String password;


    public int getBalance(){
        return balance;
    }
    public String getInfo(){
        return "_______________________\nName: " + name + "\nType: " + type + "\nBalance: " + balance;
    }
    public Bank(String name, String type, int balance){
        this.name = name;
        this.type = type;
        this.balance = balance;
    }
    public Bank(String name, String type){
        this.name = name;
        this.type = type;
        balance = 0;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void deposit(){
        balance = balance;
    }
    public void withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
        }
        else {
        System.out.println("Error! You don't have enough money");
        }
    }
    public boolean transferFrom(Bank otherBank, int amt) {
        if (otherBank.balance > amt || otherBank.balance == amt) {
            otherBank.withdraw(amt);
            deposit(amt);
            return true;
        }
        else {
            return false;
        }
    }
}
