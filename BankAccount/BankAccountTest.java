public class BankAccountTest{
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount(1000,5000);
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        BankAccount account2 = new BankAccount(2400, 1040);
        System.out.println(BankAccount.getNumberOfAccounts());
        System.out.println(BankAccount.getTotalMoney());

        account1.depositChecking(1200);
        System.out.println(account1.getCheckingBalance());
        System.out.println(BankAccount.getTotalMoney());

        account1.withdrawChecking(5000);
        account1.withdrawChecking(500);
        account1.withdrawSavings(6000);
        account1.withdrawSavings(500);
        System.out.println(BankAccount.getTotalMoney());
        
    }
}