package ObserverPattern;
/**
 * The EconomyCarRental class represents a car rental service for economy cars.
 */
public class EconomyCarRental extends CarRental {
	/**
     * Creates an instance of an economy car.
     * @return the created economy car.
     */
    @Override
    public Car createCar() {
        return new EconomyCar();
    }
}
