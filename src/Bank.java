public class Bank {
    private String name;
    private String type;
    private int balance = 0;
    public Bank(String name, String type, int balance){
        this.name = name;
        this.type = type;
        this.balance = balance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
        }
        else {
        System.out.println("Error! You don't have enough money");
        }
    }
    public int getBalance(){
        return balance;
    }
    public String getInfo(){
        return "Name: " + name + "\nType: " + type + "\nBalance: " + balance;
    }


    public boolean transfer(Bank otherBank, int amt) {
        // if otherBanks has enough money
        otherBank.withdraw(amt);
        deposit(amt);
        return true;
        //else
    }
}
