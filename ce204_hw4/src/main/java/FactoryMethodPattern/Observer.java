package FactoryMethodPattern;
/**
 * The Observer interface represents an observer in the Factory Method Pattern.
 * Observers are notified when the state of the subject (Reservation) changes.
 */
public interface Observer {
	 /**
     * Update method called when the state of the subject (Reservation) changes.
     * @param reservation The updated Reservation object.
     */
    void update(Reservation reservation);
}