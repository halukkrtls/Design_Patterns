/**
 * @file App.java
 * @brief This file contains the main application class.
 */
package ce204_hw4_app;
import java.util.Scanner;
import StrategyPattern.*;
import ObserverPattern.*;
import FactoryMethodPattern.*;
import java.time.LocalDate;
/**
 * @class App
 * @brief The main application class for car rental management.
 */
public class App {
    public static Object paymentStrategy;
	public static Car car;
	
	/**
     * The main entry point of the application.
     * @param args The command-line arguments.
     */
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentStrategy paymentStrategy = null;
        Car car = null;
        double amount = 0.0;

        System.out.println("Select a car type:");
        System.out.println("1. Economy Car");
        System.out.println("2. Luxury Car");
        System.out.println("3. SUV");

        int carType = scanner.nextInt();

        switch (carType) {
            case 1:
                car = new EconomyCar();
                amount = 50.0;
                break;

            case 2:
                car = new LuxuryCar();
                amount = 100.0;
                break;

            case 3:
                car = new SUV();
                amount = 150.0;
                break;

            default:
                System.out.println("Invalid car type!");
                return;
        }

        System.out.println("Select a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        System.out.println("3. Online Payment");

        int paymentMethod = scanner.nextInt();

        switch (paymentMethod) {
            case 1:
                System.out.println("Enter credit card details:");
                System.out.print("Card Number: ");
                String cardNumber = scanner.next();
                System.out.print("Expiry Date: ");
                String expiryDate = scanner.next();
                System.out.print("CVV: ");
                String cvv = scanner.next();
                paymentStrategy = new CreditCardPayment(cardNumber, expiryDate, cvv);
                break;

            case 2:
                paymentStrategy = new CashPayment();
                break;

            case 3:
                System.out.println("Enter online payment details:");
                System.out.print("Username: ");
                String username = scanner.next();
                System.out.print("Password: ");
                String password = scanner.next();
                paymentStrategy = new OnlinePayment(username, password);
                break;

            default:
                System.out.println("Invalid payment method!");
                return;
        }

        Rental rental = new Rental(paymentStrategy);

        System.out.println("Default payment amount for " + car.getClass().getSimpleName() + ": $" + amount);
        System.out.print("Enter a different payment amount (press 0 to use the default amount): ");
        double customAmount = scanner.nextDouble();

        if (customAmount != 0.0) {
            amount = customAmount;
        }

        System.out.print("Enter the rental duration in days: ");
        int duration = scanner.nextInt();

        double totalAmount = amount * duration;

        rental.processPayment(totalAmount);

        System.out.println("Renting a " + car.getClass().getSimpleName() + " for " + duration + " days.");

        LocalDate returnDate = LocalDate.now().plusDays(duration);
        System.out.println("Please return the car by " + returnDate.toString() + " to avoid any penalties.");

        car.rent();

        scanner.close();
    }

    /**
     * A method that returns a LocalDate object based on the provided integer.
     * @param i The integer value.
     * @return The corresponding
     *  * LocalDate object.
     */
	public static Object getLocalDate(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public double totalAmount;
	public Object returnDate;


	 /**
     * A method that runs the application using the provided Scanner object.
     * @param scanner The Scanner object for user input.
     */

	public void run(java.util.Scanner scanner) {
		// TODO Auto-generated method stub
		
	}
	
}