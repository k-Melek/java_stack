public class BankAccount {

    private static int numberOfAccounts = 0;
    private static double totalMoney = 0.0;

    private int accountNumber;
    private double checkingBalance;
    private double savingsBalance;


    public BankAccount() {
        // this.accountNumber = this.numberOfAccounts;
        this.checkingBalance = 0.0;
        this.savingsBalance = 0.0;
        numberOfAccounts++;
    }

    // Checking account getter/ setter

    public double getCheckingBalance() {
        return this.checkingBalance;
    }
    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    // Savings account getter/ setter

    public double getSavingsBalance() {
        return this.savingsBalance;
    }
    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    // Total getter

    public double getTotalMoney(){
      return this.totalMoney;
    }

    // Deposit and add to total

    public void deposit(String accountType, double amount) {
    if ("checking".equals(accountType)) {
        setCheckingBalance(getCheckingBalance() + amount);
    } else if ("savings".equals(accountType)) {
        setSavingsBalance(getSavingsBalance() + amount);
    } 

    totalMoney += amount;
    }

    // Withdraw and test if sufficiant funds

    public void withdraw(String accountType, double amount) {
      if ("checking".equals(accountType)) {
        if(getCheckingBalance() >= amount) {
          setCheckingBalance(getCheckingBalance() - amount);
          totalMoney -= amount;
          System.out.printf("Withdrawn $%.2f from %s%n", amount, accountType);
        } else{
          System.out.println("Insufficient funds in the checking account!");
        }
      } else if ("savings".equals(accountType)) {
        if(getSavingsBalance() >= amount) {
          setSavingsBalance(getSavingsBalance() - amount);
          totalMoney -= amount;
          System.out.printf("Withdrawn $%.2f from %s%n", amount, accountType);
        } else {
          System.out.println("Insufficient funds in the savings account.");
        }
      }
    }
}