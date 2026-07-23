package Management;

public class Account2 {

    int id;
    String name;
    double balance;

    Account2(int id, String name, double balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
    }

    void add(double amount){
        balance=balance+amount;

    }
    void minus(double amount){
        if(balance>=amount){
            balance=balance-amount;
        }
        else{
            System.out.println("Not have enough money");
        }
    }

    void transfer_Money(Account2 receiver, double amount){
        if(balance>=amount){
            balance=balance-amount;
            receiver.balance=receiver.balance + amount;
        }
        else{
            System.out.println("Not have enough money to transfer");
        }
    }

    void show(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);

    }


    static void main(String[] args) {
        Account2 accountA=new Account2(1,"Rahat",2000);
        Account2 accountB=new Account2(2,"Shafi",5000);

        accountA.show();
        accountA.add(400);
        accountA.show();
        accountA.minus(100);
        accountA.show();
        accountA.transfer_Money(accountB,1000);
        accountA.show();
        accountB.show();

    }

}
