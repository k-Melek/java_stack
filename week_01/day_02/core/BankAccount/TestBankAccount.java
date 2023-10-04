public class TestBankAccount{
  public static void main(String[] args){


        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        account1.deposit("checking",30.5); // depositing 30.5 into checking

        account1.deposit("savings", 200.5); // deposit 200.5 into savings


        System.out.println("Account 1:");

        System.out.printf("Depositing $%.2f into %s\n", 30.5, "checking");
        
        account1.withdraw("savings", 50.2);


        System.out.printf("Checking Balance: $%.2f\n", account1.getCheckingBalance());
        System.out.printf("Savings Balance: $%.2f\n", account1.getSavingsBalance());
        System.out.printf("Total Balance: $%.2f\n", account1.getTotalMoney());
  }
}