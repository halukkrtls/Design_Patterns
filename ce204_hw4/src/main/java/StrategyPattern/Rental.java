package StrategyPattern;

import java.time.LocalDate;
/**
 * The Rental class represents a rental transaction.
 * It uses the PaymentStrategy interface to process payments.
 */
public class Rental {
	/**
     * Creates a new Rental instance with the specified payment strategy.
     * @param paymentStrategy the payment strategy to be used for the rental
     */
    private PaymentStrategy paymentStrategy;
    /**
     * Processes the payment for the rental.
     * @param amount the payment amount
     */
    public Rental(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
        // Additional payment process logic
    }

	public double getAmountPaid() {
		// TODO Auto-generated method stub
		return 0;
	}

	public LocalDate getReturnDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isPaymentProcessed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setReturnDate(LocalDate expectedDate) {
		// TODO Auto-generated method stub
		
	}
}
