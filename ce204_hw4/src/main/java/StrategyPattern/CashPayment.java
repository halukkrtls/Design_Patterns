package StrategyPattern;
/**
 * The CashPayment class is a concrete implementation of the PaymentStrategy interface
 * for processing cash payments.
 */
public class CashPayment implements PaymentStrategy {
	/**
     * Pays the specified amount in cash.
     * @param amount the payment amount
     */
    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " in cash.");
        // Payment process using cash
    }

	public OnlinePayment getPaymentStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	public void processPayment() {
		// TODO Auto-generated method stub
		
	}
}

