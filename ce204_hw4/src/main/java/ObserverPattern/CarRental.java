package ObserverPattern;
/**
 * The CarRental class is an abstract class representing a car rental service.
 */
public abstract class CarRental {
	/**
     * Factory method that creates a car.
     * @return the created car.
     */
    // Factory method
    public abstract Car createCar();
    /**
     * Processes the car rental.
     */
    public void processRental() {
        Car car = createCar();
        car.rent();
        // Other rental process logic
    }
    
}
