package FactoryMethodPattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The Factory class represents the main entry point of the Factory Method Pattern example.
 * It demonstrates the creation of reservations and the notification of observers as the reservation date approaches.
 */
public class Factory {
    public static void createReservationAndNotifyObservers() {
        Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

        User user1 = new User("John");
        User user2 = new User("Alice");

        reservation.registerObserver(user1);
        reservation.registerObserver(user2);

        // Simulating reservation date approaching
        LocalDate currentDate = LocalDate.of(2023, 6, 10);
        if (currentDate.isBefore(reservation.getDate())) {
            // Reservation date is approaching, notify the observers
            reservation.notifyObservers();
        }
        // Additional operations for managing reservations
    }
}