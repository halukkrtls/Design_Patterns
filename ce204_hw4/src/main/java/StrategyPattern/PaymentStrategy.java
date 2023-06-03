package StrategyPattern;
/**
 * The PaymentStrategy interface defines the contract for different payment strategies.
 * Classes implementing this interface should provide an implementation for the pay method.
 */
public interface PaymentStrategy {
	 /**
     * Pays the specified amount.
     * @param amount the payment amount
     */
    void pay(double amount);
}