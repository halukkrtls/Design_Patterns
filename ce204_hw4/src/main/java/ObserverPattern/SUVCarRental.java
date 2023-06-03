package ObserverPattern;
/**
 * The SUVCarRental class is a concrete implementation of the CarRental class
 * for renting SUV cars.
 */
public class SUVCarRental extends CarRental {
	 /**
     * Creates an instance of the SUV car.
     * @return a new SUV car
     */
    @Override
    public Car createCar() {
        return new SUV();
    }
}
