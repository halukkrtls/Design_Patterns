package ObserverPattern;
/**
 * The EconomyCar class represents an economy car.
 */
public class EconomyCar implements Car {
	 /**
     * Rents the economy car.
     */
    @Override
    public void rent() {
        System.out.println("Renting an Economy Car");
    }
    /**
     * Checks if the economy car is currently rented.
     * @return true if the car is rented, false otherwise.
     */
	@Override
	public boolean isRented() {
		// TODO Auto-generated method stub
		return false;
	}
}
