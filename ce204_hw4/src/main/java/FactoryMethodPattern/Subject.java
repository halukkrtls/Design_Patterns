package FactoryMethodPattern;
/**
 * The Subject interface defines the methods for registering, removing, and notifying observers.
 */

public interface Subject {
	 /**
     * Registers an observer to receive updates from the subject.
     * @param observer The observer to register.
     */
    void registerObserver(Observer observer);
    /**
     * Removes an observer from the list of registered observers.
     * @param observer The observer to remove.
     */
    void removeObserver(Observer observer);
    /**
     * Notifies all registered observers about a change in the subject.
     */
    void notifyObservers();
}
