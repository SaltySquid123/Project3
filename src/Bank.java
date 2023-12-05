/**
 * This class represents a bank
 *
 * @author Markus
 */
public class Bank {
    /** The name of the account */
    private String name;

    /** The type of the account */
    private String type;

    /** The balance for the account */
    private double balance = 0;

    /** Password to access the account */
    private String password;

    /**
     * Initiates a bank object
     *
     * @param name Name of account
     * @param type Type of account
     * @param balance Balance of account
     * @param password Password for account
     */
    public Bank(String name, String type, double balance, String password){
        this.name = name;
        this.type = type;
        this.balance = balance;
        this.password = password;
    }

    /**
     * Initiates a bank object with a default balance of 0
     *
     * @param name Name of account
     * @param type Type of account
     * @param password Password for account
     */
    public Bank(String name, String type, String password){
        this.name = name;
        this.type = type;
        balance = 0;
        this.password = password;
    }

    /**
     * Sets new password for account
     *
     * @param newPass New password
     */
    public void setPassword(String newPass){
        password = newPass;
    }

    /** Returns the current password
     *
     * @return The password
     */
    public String getPassword(){
        return password;
    }

    /** Returns the balance of the account
     *
     * @return Balance
     */
    public double getBalance(){
        return balance;
    }

    /** Gets all the useful info from the account
     * Such as the name, type, and balance.
     * @return Name, type, balance
     */
    public String getInfo(){
        return "_______________________\nName: " + name + "\nType: " + type + "\nBalance: " + balance;
    }

    /** Deposits set amount
     *
     * @param amount Amount to deposit
     */
    public void deposit(double amount){
        balance += amount;
    }

    /** Withdraws set amount, only if the account has enough money
     *
     * @param amount Amount to withdraw
     */
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
        else {
        System.out.println("Error! You don't have enough money");
        }
    }

    /** Transfers money from accounts
     *
     * @param otherBank The account to withdraw from
     * @param amt Amount to withdraw
     * @return Returns if the transaction was successful.
     */
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
    public boolean checkPassword(String tempPass){
        return password.equals(tempPass);
    }
}
