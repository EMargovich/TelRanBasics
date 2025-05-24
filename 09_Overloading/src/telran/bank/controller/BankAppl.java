package telran.bank.controller;

import telran.bank.model.BankAccount;

import java.util.Arrays;

public class BankAppl {
    public static void main(String[] args) {
        BankAccount[] bankAccounts = new BankAccount[4];

        System.out.println(bankAccounts[3]);
        bankAccounts[0] = new BankAccount(1000, "John", 10000);
        System.out.println(bankAccounts[0].deposit(-500));
        System.out.println(bankAccounts[0].getBalance());
        System.out.println(bankAccounts[0].withdrew(20000));
        bankAccounts[0].display();
        bankAccounts[1] = new BankAccount(200, "Peter", 5000);
        bankAccounts[2] = new BankAccount(300, "Mary",  5000, "Bank#2", "Branch#2");
        bankAccounts[1].display();
        bankAccounts[2].display("Hello ");
        bankAccounts[3] = new BankAccount();

        BankAccount.display_all(bankAccounts);

        double balance = totalBalance(bankAccounts);
        System.out.println("Total balance " + balance);

    }

public static double totalBalance (BankAccount[] acc) {
        double res = 0;
        for (var i : acc) {
            res += i.getBalance();
        }
        return res;
}

}
