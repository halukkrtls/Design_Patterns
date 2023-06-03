package FactoryMethodPattern;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The Reservation class represents a reservation in the Factory Method Pattern.
 * It implements the Subject interface and manages a list of observers.
 */
public class Reservation implements Subject {
	 /**
     * Constructs a Reservation object with the specified date.
     * @param date The date of the reservation.
     */
    private List<Observer> observers;
    private LocalDate date;
    private boolean notified;
    /**
     * Gets the date of the reservation.
     * @return The date of the reservation.
     */
    public Reservation(LocalDate date) {
        this.date = date;
        this.observers = new ArrayList<>();
        this.notified = false;
    }

    public LocalDate getDate() {
        return date;
    }
    /**
     * Checks if the reservation has been notified to the observers.
     * @return true if the reservation has been notified, false otherwise.
     */
    public boolean isNotified() {
        return notified;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
        notified = true;
    }
    // Additional methods for managing reservations

    /**
     * Sets the availability of the reservation.
     * @param availability The availability of the reservation.
     */
	public void setAvailability(boolean b) {
		// TODO Auto-generated method stub
		
	}
	 /**
     * Gets the count of registered observers.
     * @return The count of registered observers.
     */
	public Object getObserverCount() {
		// TODO Auto-generated method stub
		return null;
	}
	 /**
     * Sets the notified status of the reservation.
     * @param notified The notified status of the reservation.
     */
	public void setNotified(boolean b) {
		// TODO Auto-generated method stub		
	}
	 /**
     * Updates the reservation with the information from the updated reservation.
     * @param updatedReservation The updated reservation.
     */
	public void setDate(LocalDate reservationDate) {
		// TODO Auto-generated method stub	
	}

	public void updateReservation(Reservation updatedReservation) {
		// TODO Auto-generated method stub
		
	}
	/**
     * Checks if the reservation date is valid based on the current date.
     * @param currentDate The current date.
     * @return true if the reservation date is valid, false otherwise.
     */
	public Object getAvailability() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkReservationDate(LocalDate currentDate) {
		// TODO Auto-generated method stub
		return false;
	}

    // Additional methods for managing reservations
}
