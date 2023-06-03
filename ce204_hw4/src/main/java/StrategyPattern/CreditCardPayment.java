package StrategyPattern;
/**
 * The CreditCardPayment class is a concrete implementation of the PaymentStrategy interface
 * for processing credit card payments.
 */
public class CreditCardPayment implements PaymentStrategy {
	/**
     * Constructs a CreditCardPayment object with the specified card information.
     * @param cardNumber the credit card number
     * @param expiryDate the expiry date of the credit card
     * @param cvv the CVV number of the credit card
     */
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
    /**
     * Pays the specified amount using the credit card.
     * @param amount the payment amount
     */
    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using credit card.");
        // Payment process using credit card
    }

}