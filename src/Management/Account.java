package Management;

class Account {

    int id;
    String name;
    double balance;

    // Constructor
    Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Deposit money
    void add(double amount) {
        balance = balance + amount;
        System.out.println(name + " deposited " + amount);
    }

    // Withdraw money
    void minus(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println(name + " withdrew " + amount);
        } else {
            System.out.println("Not enough balance.");
        }
    }

    // Transfer money
    void transfer(Account receiver, double amount) {

        if (balance >= amount) {

            balance = balance - amount;
            receiver.balance = receiver.balance + amount;

            System.out.println(amount + " transferred from "
                    + name + " to " + receiver.name);

        } else {
            System.out.println("Transfer failed. Insufficient balance.");
        }
    }

    // Show account information
    void show() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("------------------------");
    }
    public static void main(String[] args) {

        Account accountA = new Account(1, "Alex", 1000);
        Account accountB = new Account(2, "David", 1000);

        System.out.println("Before Transaction");
        accountA.show();
        accountB.show();

        accountA.add(500);

        accountA.minus(200);

        accountA.transfer(accountB, 300);

        System.out.println("After Transaction");
        accountA.show();
        accountB.show();
    }
}




