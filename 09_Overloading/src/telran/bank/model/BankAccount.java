package telran.bank.model;

public class BankAccount {
    private long account;
    private String owner = "Anonymous";
    private double balance;
    private String bank;
    private String branch;

    public BankAccount() {
    }

    public BankAccount(long account, String owner, double balance, String bank, String branch) {
        this.account = account;
        this.owner = owner;
        this.balance = balance;
        this.bank = bank;
        this.branch = branch;
    }

    public BankAccount(long account, String bank, String branch) {
        this.account = account;
        this.bank = bank;
        this.branch = branch;
    }

    public BankAccount(long account, String owner, double balance) {
        this.bank = "Bank#1";
        this.branch = "Branch#1";
        this.account = account;
        this.owner = owner;
        this.balance = balance;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public long getAccount() {
        return account;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean deposit (double sum){
        boolean res = false;
        if(sum >= 0) {
            balance += sum;
            res = true;
        }

        return res;
    }

    public boolean withdrew (double sum) {
       if(sum <= balance) {
           balance -= sum;
           return true;
       }
       return false;
    }

    public void display() {
        System.out.println("Acc.: " + account + ", Owner: " + owner + ", balance: " + balance);
    }

    public void display(String greeting) {
        System.out.println("Acc.: " + account + ", Owner: " + greeting + owner + ", balance: " + balance);
    }

    public static void display_all(BankAccount[] bankAccounts) {
        for(var bankaccount : bankAccounts) {
            bankaccount.display();
        }
    }
}
