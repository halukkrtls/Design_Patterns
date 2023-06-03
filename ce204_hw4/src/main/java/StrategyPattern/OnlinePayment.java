package StrategyPattern;
/**
 * The OnlinePayment class is a concrete implementation of the PaymentStrategy interface
 * for processing online payments.
 */
public class OnlinePayment implements PaymentStrategy {
    private String accountId;
    private String password;

    /**
     * Constructs an OnlinePayment object with the specified account information.
     * @param accountId the account ID for online payment
     * @param password the password for the online payment account
     */
    public OnlinePayment(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }
    /**
     * Pays the specified amount using online payment.
     * @param amount the payment amount
     */
    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using online payment.");
        // Payment process using online payment system
    }
}
