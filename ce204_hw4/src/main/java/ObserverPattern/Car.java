package ObserverPattern;
/**
 * The Car interface represents a car that can be rented.
 */
public interface Car {
	/**
     * Rents the car.
     */


	void rent();
	/**
     * Checks if the car is currently rented.
     * @return true if the car is rented, false otherwise.
     */
	boolean isRented();
}
