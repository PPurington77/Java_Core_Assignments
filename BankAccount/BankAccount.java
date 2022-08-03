public class BankAccount {
    //attributes: double checking balance, double savings balance
    private double checkingBalance;
    private double savingsBalance;
    //static for num of accounts created
    private static int numberOfAccounts = 0;
    //static for total amount of money stored in every account created
    private static double totalMoney = 0;

    //constructor
    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numberOfAccounts++; 
        totalMoney += checkingBalance + savingsBalance;
    }

    //getter to check user's checking balance
    public double getCheckingBalance() {
        return checkingBalance;
    }
    //getter to check user's savings balance
    public double getSavingsBalance() {
        return savingsBalance;
    }
    //getter to check number of accounts
    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }
    //getter to check total money
    public static double getTotalMoney() {
        return totalMoney;
    }

    //method to deposit money into checkings
    public void depositChecking(double amount) {
        this.checkingBalance += amount;
        totalMoney += amount;
    }
    //method to deposit money into savings
    public void depositSavings(double amount) {
        this.savingsBalance += amount;
        totalMoney += amount;
    }
    //method to withdraw money from checkings if funds available
    public void withdrawChecking(double amount) {
        if(this.checkingBalance < amount) {
            System.out.println("Insufficient Funds");
        }
        else {
            this.checkingBalance -= amount; 
            totalMoney -= amount;
            System.out.println(getCheckingBalance());
        }
    }
    //method to withdraw money from savings if funds available
    public void withdrawSavings(double amount) {
        if(this.savingsBalance < amount) {
            System.out.println("Insufficient Funds");
        }
        else {
            this.savingsBalance -= amount;
            totalMoney -= amount;
            System.out.println(getSavingsBalance());
        }
    }

}