package ObserverPattern;

/**
 * The Observer class demonstrates the usage of car rentals.
 */
public class Observer {
	  /**
     * The main method creates instances of different car rental services and processes the rentals.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        CarRental economyCarRental = new EconomyCarRental();
        economyCarRental.processRental();

        CarRental luxuryCarRental = new LuxuryCarRental();
        luxuryCarRental.processRental();

        CarRental suvCarRental = new SUVCarRental();
        suvCarRental.processRental();

        // Additional operations for managing car rentals
    }

	public void processCarRental(CarRental economyCarRental) {
		// TODO Auto-generated method stub
		
	}
}