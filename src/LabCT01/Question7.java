package LabCT01;

//public class Question7 {
//}
interface PaymentGateway {

    void processPayment(double amount);

    String getProviderName();

    default void receipt(double amount) {
        System.out.println("--- Receipt from " + getProviderName() + ": " + amount + " ---");
    }
}

class CreditCardPayment implements PaymentGateway {

    public void processPayment(double amount) {
        System.out.println("Processing " + amount + " via Credit Card (2% fee)");
    }

    public String getProviderName() {
        return "Credit Card";
    }

    public void receipt(double amount) {
        double total = amount + amount * 0.02;
        System.out.println("--- Receipt from Credit Card: " + total + " ---");
    }
}

class UPIPayment implements PaymentGateway {

    public void processPayment(double amount) {
        System.out.println("Processing " + amount + " via UPI (no fee)");
    }

    public String getProviderName() {
        return "UPI";
    }
}

class WalletPayment implements PaymentGateway {

    public void processPayment(double amount) {
        System.out.println("Processing " + amount + " via Digital Wallet");
    }

    public String getProviderName() {
        return "Digital Wallet";
    }
}

 class Main6 {

    public static void main(String[] args) {

        double amount = 2500;

        PaymentGateway[] payments = {
                new CreditCardPayment(),
                new UPIPayment(),
                new WalletPayment()
        };

        for (PaymentGateway p : payments) {

            p.processPayment(amount);

            if (p instanceof CreditCardPayment)
                p.receipt(amount + amount * 0.02);
            else
                p.receipt(amount);

            System.out.println();
        }
    }
}