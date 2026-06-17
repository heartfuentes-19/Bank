
// java
package firstpackage;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new SavingsAccount("Heart Fuentes");

        System.out.println("Account Owner: " + ((SavingsAccount) account).getOwner());

        System.out.println("2");
        try {
            account.deposit(1000.13);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("3");
        try {
            account.deposit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("4");
        try {
            account.deposit(-500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("5");
        try {
            account.withdraw(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("6");
        try {
            account.withdraw(1500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("7");
        try {
            account.withdraw(-100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("8");
        account.freeze();
        try {
            account.deposit(11500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("9");
        try {
            account.withdraw(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("10");
        account.unfreeze();
        try {
            account.withdraw(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("-----------------------------------");

        BankAccountManager accM1 = new BankAccountManager();

        accM1.addAccount(account);

        accM1.addAccount(new SavingsAccount("Juan Dela Cruz"));

        System.out.println("\n--- Final Account List ---");
        accM1.listAccounts();
    }
}
