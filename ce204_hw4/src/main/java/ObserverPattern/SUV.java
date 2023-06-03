package ObserverPattern;
/**
 * The SUV class represents an SUV car.
 */
public class SUV implements Car {
	 /**
     * Rents the SUV.
     */
    @Override
    public void rent() {
        System.out.println("Renting an SUV");
    }
    /**
     * Checks if the SUV is currently rented.
     * @return true if the SUV is rented, false otherwise
     */
	@Override
	public boolean isRented() {
		// TODO Auto-generated method stub
		return false;
	}
}
