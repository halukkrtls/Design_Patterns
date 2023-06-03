package ObserverPattern;
/**
 * The LuxuryCarRental class represents a luxury car rental service.
 */
public class LuxuryCarRental extends CarRental {
	 /**
     * Creates a luxury car.
     * @return the created luxury car.
     */
    @Override
    public Car createCar() {
        return new LuxuryCar();
    }
}