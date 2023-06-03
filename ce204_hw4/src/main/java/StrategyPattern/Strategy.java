package StrategyPattern;
/**
 * The Strategy class contains the main method to demonstrate the usage of the Strategy pattern.
 */
public class Strategy {
    public static void demonstratePaymentStrategies() {
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "12/24", "123");
        Rental rental1 = new Rental(creditCardPayment);
        rental1.processPayment(100.0);

        PaymentStrategy cashPayment = new CashPayment();
        Rental rental2 = new Rental(cashPayment);
        rental2.processPayment(75.0);

        PaymentStrategy onlinePayment = new OnlinePayment("username", "password");
        Rental rental3 = new Rental(onlinePayment);
        rental3.processPayment(120.0);

        // Additional operations for managing car rentals
    }
}