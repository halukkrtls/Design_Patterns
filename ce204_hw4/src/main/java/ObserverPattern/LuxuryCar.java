package ObserverPattern;

/**
 * The LuxuryCar class represents a luxury car.
 */
public class LuxuryCar implements Car {
	 /**
     * Rents a luxury car.
     */
    @Override
    public void rent() {
        System.out.println("Renting a Luxury Car");
    }
    /**
     * Checks if the luxury car is rented.
     * @return true if the luxury car is rented, false otherwise.
     */
	@Override
	public boolean isRented() {
		// TODO Auto-generated method stub
		return false;
	}
}