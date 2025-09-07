public class BankAccount {
    private String accountNumber;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println(amount + " withdrawn. New balance: " + balance);
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("ACC1001", 5000);
        BankAccount account2 = new BankAccount("ACC1002", 3000);

        account1.deposit(2000);
        account1.withdraw(1000);

        account2.deposit(500);
        account2.withdraw(4000);

        System.out.println("Total bank accounts created: " + BankAccount.getTotalAccounts());
    }
}