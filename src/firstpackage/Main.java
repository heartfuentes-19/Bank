package firstpackage;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new SavingsAccount("Heart Fuentes");

        System.out.println("Account Owner: " + ((SavingsAccount) account).getOwner());

        System.out.println("2");
        account.deposit(1000.13);

        System.out.println("3");
        account.deposit(0);

        System.out.println("4");
        account.deposit(-500);

        System.out.println("5");
        account.withdraw(500);

        System.out.println("6");
        account.withdraw(1500);

        System.out.println("7");
        account.withdraw(-100);

        System.out.println("8");
        account.freeze();
        account.deposit(11500);

        System.out.println("9");
        account.withdraw(500);

        System.out.println("10");
        account.unfreeze();
        account.withdraw(100);

        System.out.println("-----------------------------------");

        BankAccountManager accM1 = new BankAccountManager();

        accM1.addAccount(account);

        accM1.addAccount(new SavingsAccount("Juan Dela Cruz"));

        System.out.println("\n--- Final Account List ---");
        accM1.listAccounts();
    }
}