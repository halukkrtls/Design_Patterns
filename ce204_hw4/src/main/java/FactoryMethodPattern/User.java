package FactoryMethodPattern;
/**
 * The User class represents a user who is subscribed to receive notifications about reservations.
 */
import java.time.LocalDate;

public class User implements Observer {
	/**
     * Constructs a User object with the given name.
     * @param name The name of the user.
     */
    private String name;
    private boolean notified;

    public User(String name) {
        this.name = name;
        this.notified = false;
    }
    /**
     * Checks if the user has been notified about a reservation.
     * @return true if the user has been notified, false otherwise.
     */
    @Override
    public void update(Reservation reservation) {
        if (reservation.getDate().minusDays(7).isBefore(LocalDate.now())) {
            notified = true;
        }
    }
    /**
     * Gets the notification count for the user.
     * @return The notification count.
     */
    public boolean isNotified() {
        return notified;
    }

	public Object getNotificationCount() {
		// TODO Auto-generated method stub
		return null;
	
}


	}
