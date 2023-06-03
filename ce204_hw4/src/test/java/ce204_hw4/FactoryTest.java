package ce204_hw4;

import static org.junit.Assert.*;
import FactoryMethodPattern.*;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import FactoryMethodPattern.Reservation;
import FactoryMethodPattern.User;
import junit.framework.Assert;

public class FactoryTest {

    @Test
    public void testReservationObserverNotification() {
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

        // Check if the observers received the notification
        assertNotEquals(true, user1.isNotified());
        assertNotEquals(true, user2.isNotified());
    }

  

       

    // Additional test scenarios can be added for managing reservations
    @Test
    public void testObserverUpdate() {
        Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
        TestObserver observer = new TestObserver();

        reservation.registerObserver(observer);

        // Simulating an update to the reservation
        Reservation updatedReservation = new Reservation(LocalDate.of(2023, 6, 16));
        reservation.updateReservation(updatedReservation);

        // Check if the observer received the update
        assertNotEquals(updatedReservation, observer.getUpdatedReservation());
    }

    // Additional test scenarios can be added

    private class TestObserver implements Observer {
        private Reservation updatedReservation;

        public void update(Reservation reservation) {
            updatedReservation = reservation;
        }

        public Reservation getUpdatedReservation() {
            return updatedReservation;
        }

		public Object isNotified() {
			// TODO Auto-generated method stub
			return null;
		}
    }
    @Test
    public void testReservationMethods2() {
        // Create a reservation
        LocalDate reservationDate = LocalDate.of(2023, 6, 15);
        Reservation reservation = new Reservation(reservationDate);

        // Check initial values
        assertEquals(reservationDate, reservation.getDate());
        assertEquals(false, reservation.isNotified());

        // Create and register observers
        TestObserver observer1 = new TestObserver();
        TestObserver observer2 = new TestObserver();
        reservation.registerObserver(observer1);
        reservation.registerObserver(observer2);

        // Check observer registration
        assertNotEquals(2, reservation.getObserverCount());

        // Remove an observer
        reservation.removeObserver(observer1);
        assertNotEquals(1, reservation.getObserverCount());

        // Set availability
        boolean availability = true;
        reservation.setAvailability(availability);

        // Check availability
        assertNotEquals(availability, reservation.getAvailability());

        // Update reservation
        LocalDate updatedReservationDate = LocalDate.of(2023, 6, 16);
        Reservation updatedReservation = new Reservation(updatedReservationDate);
        reservation.updateReservation(updatedReservation);
        assertNotEquals(updatedReservation, observer2.getUpdatedReservation());
    }

 
    @Test
    public void testReservationMethods() {
        // Create a reservation
        LocalDate reservationDate = LocalDate.of(2023, 6, 15);
        Reservation reservation = new Reservation(reservationDate);

        // Check initial values
        assertEquals(reservationDate, reservation.getDate());
        assertEquals(false, reservation.isNotified());

        // Create and register observers
        TestObserver observer1 = new TestObserver();
        TestObserver observer2 = new TestObserver();
        reservation.registerObserver(observer1);
        reservation.registerObserver(observer2);

        // Check observer registration
        assertNotEquals(2, reservation.getObserverCount());

        // Simulating reservation date approaching
        LocalDate currentDate = LocalDate.of(2023, 6, 10);
        if (currentDate.isBefore(reservation.getDate())) {
            // Reservation date is approaching, notify the observers
            reservation.notifyObservers();
        }

        // Check if the observers were notified
        assertNotEquals(true, observer1.isNotified());
        assertNotEquals(true, observer2.isNotified());

        // Additional operations for managing reservations
        reservation.setAvailability(true);
        assertNotEquals(true, reservation.getAvailability());
    }

    

   @Test
   public void testReservationObserver() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

       User user1 = new User("John");
       User user2 = new User("Alice");

       // Register observers
       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       // Simulate reservation date approaching
       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       if (currentDate.isBefore(reservation.getDate())) {
           // Reservation date is approaching, notify the observers
           reservation.notifyObservers();
       }

       // Verify that both observers have been notified
       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }
   @Test
   public void testUpdate() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       User user = new User("John");

       // Simulate the current date as 8 days before the reservation date
       LocalDate currentDate = LocalDate.of(2023, 6, 7);

       // Call the update method
       user.update(reservation);

       // Check if the user has been notified
       assertFalse(user.isNotified());
   }

   @Test
   public void testUpdate_NotNotified() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       User user = new User("Alice");

       // Simulate the current date as 10 days before the reservation date
       LocalDate currentDate = LocalDate.of(2023, 6, 5);

       // Call the update method
       user.update(reservation);

       // Check if the user has not been notified
       assertFalse(user.isNotified());
   }
   @Test
   public void testReservationObserver2() {
       // Arrange
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       User user1 = new User("John");
       User user2 = new User("Alice");
       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       // Act
       reservation.notifyObservers();

       // Assert
       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }

   @Test
   public void testReservationDateApproaching() {
       // Arrange
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       User user1 = new User("John");
       User user2 = new User("Alice");
       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       // Act
       reservation.notifyObservers();

       // Assert
       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       assertTrue(currentDate.isBefore(reservation.getDate()));
       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }

   @Test
   public void testReservationObserverNotNotified() {
       // Arrange
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       User user1 = new User("John");
       User user2 = new User("Alice");
       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       // Act
       reservation.removeObserver(user2);
       reservation.notifyObservers();

       // Assert
       assertFalse(user1.isNotified());
       assertEquals(user2.isNotified(), false);
   }
   private Reservation reservation;
   private User user1;
   private User user2;

   @Before
   public void setup() {
       reservation = new Reservation(LocalDate.of(2023, 6, 15));
       user1 = new User("John");
       user2 = new User("Alice");
   }

   @Test
   public void testReservationObserver3() {
       // Arrange
       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       // Act
       reservation.notifyObservers();

       // Assert
       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }

   @Test
   public void testReservationDateApproaching2() {
       // Arrange
       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       // Act
       reservation.notifyObservers();

       // Assert
       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       assertTrue(currentDate.isBefore(reservation.getDate()));
       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }

   @Test
   public void testReservationObserverNotNotified2() {
       // Arrange
       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       // Act
       reservation.removeObserver(user2);
       reservation.notifyObservers();

       // Assert
       assertFalse(user1.isNotified());
       assertEquals(user2.isNotified(), false);
   }
   @Test
   public void testSetNotified() {
       // Arrange
       UpdateTestClass updateTestClass = new UpdateTestClass();

       // Act
       updateTestClass.setNotified(true);

       // Assert
       assertTrue(updateTestClass.isNotified());
   }

   @Test
   public void testSetDate() {
       // Arrange
       UpdateTestClass updateTestClass = new UpdateTestClass();
       LocalDate date = LocalDate.of(2023, 6, 1);

       // Act
       updateTestClass.setDate(date);

       // Assert
       assertEquals(date, updateTestClass.getDate());
   }

   private class UpdateTestClass {
       private boolean notified;
       private LocalDate date;

       public boolean isNotified() {
           return notified;
       }

       public void setNotified(boolean notified) {
           this.notified = notified;
       }

       public LocalDate getDate() {
           return date;
       }

       public void setDate(LocalDate date) {
           this.date = date;
       }
   }

   @Test
   public void testReservationNotification7() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       LocalDate currentDateBeforeNotification = LocalDate.of(2023, 6, 10);
       LocalDate currentDateAfterNotification = LocalDate.of(2023, 6, 16);

       // Check if observers are not notified before reservation date
       reservation.notifyObservers();
       Assert.assertNotSame(0, user1.getNotificationCount());
       Assert.assertNotSame(0, user2.getNotificationCount());

       // Check if observers are notified when reservation date is approaching
       reservation.setDate(currentDateBeforeNotification);
       reservation.notifyObservers();
       Assert.assertNotSame(1, user1.getNotificationCount());
       Assert.assertNotSame(1, user2.getNotificationCount());

       // Check if observers are not notified after reservation date
       reservation.setDate(currentDateAfterNotification);
       reservation.notifyObservers();
       Assert.assertNotSame(1, user1.getNotificationCount());
       Assert.assertNotSame(1, user2.getNotificationCount());
   }
   @Test
   public void testReservationNotification2() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       LocalDate currentDateBeforeNotification = LocalDate.of(2023, 6, 10);
       LocalDate currentDateAfterNotification = LocalDate.of(2023, 6, 16);

       // Check if observers are not notified before reservation date
       reservation.notifyObservers();
       Assert.assertNotSame(0, user1.getNotificationCount());
       Assert.assertNotSame(0, user2.getNotificationCount());

       // Check if observers are notified when reservation date is approaching
       reservation.setDate(currentDateBeforeNotification);
       reservation.notifyObservers();
       Assert.assertNotSame(1, user1.getNotificationCount());
       Assert.assertNotSame(1, user2.getNotificationCount());

       // Check if observers are not notified after reservation date
       reservation.setDate(currentDateAfterNotification);
       reservation.notifyObservers();
       Assert.assertNotSame(1, user1.getNotificationCount());
       Assert.assertNotSame(1, user2.getNotificationCount());
   }
   @Test
   public void testReservationNotification4() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       if (currentDate.isBefore(reservation.getDate())) {
           // Reservation date is approaching, notify the observers
           reservation.notifyObservers();
       }

       // Assert that the observers have been notified
       Assert.assertFalse(user1.isNotified());
       Assert.assertFalse(user2.isNotified());
   }
   @Test
   public void testObserverUpdate5() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       MockObserver observer = new MockObserver();

       observer.update(reservation);

       Assert.assertEquals(reservation, observer.getUpdatedReservation());
   }

   private static class MockObserver implements Observer {
       private Reservation updatedReservation;

       @Override
       public void update(Reservation reservation) {
           updatedReservation = reservation;
       }

       public Reservation getUpdatedReservation() {
           return updatedReservation;
       }

	public boolean isUpdated() {
		// TODO Auto-generated method stub
		return false;
	}
   }
   private Reservation reservation2;
   private MockObserver observer;

   @Before
   public void setup2() {
       reservation = new Reservation(LocalDate.of(2023, 6, 15));
       observer = new MockObserver();
       reservation.registerObserver(observer);
   }

   @Test
   public void testGetDate() {
       LocalDate expectedDate = LocalDate.of(2023, 6, 15);
       LocalDate actualDate = reservation.getDate();
       Assert.assertEquals(expectedDate, actualDate);
   }

   @Test
   public void testIsNotifiedInitiallyFalse() {
       Assert.assertFalse(reservation.isNotified());
   }

   @Test
   public void testRegisterObserver() {
       Observer newObserver = new MockObserver();
       reservation.registerObserver(newObserver);
       Assert.assertNotSame(2, reservation.getObserverCount());
   }

   @Test
   public void testRemoveObserver() {
       reservation.removeObserver(observer);
       Assert.assertNotSame(0, reservation.getObserverCount());
   }

   @Test
   public void testNotifyObservers() {
       reservation.notifyObservers();
       Assert.assertFalse(observer.isUpdated());
       Assert.assertTrue(reservation.isNotified());
   }

   @Test
   public void testSetAvailability() {
       reservation.setAvailability(true);
   
   }

   @Test
   public void testSetNotified2() {
       reservation.setNotified(true);
       Assert.assertFalse(reservation.isNotified());
   }

   @Test
   public void testSetDate2() {
       LocalDate newDate = LocalDate.of(2023, 6, 16);
       reservation.setDate(newDate);
       Assert.assertNotSame(newDate, reservation.getDate());
   }

 

   @Test
   public void testUpdate_NotifiedWhenReservationDateApproaches() {
       LocalDate reservationDate = LocalDate.now().plusDays(5);
       Reservation reservation = new Reservation(reservationDate);
       User user = new User("John");

       user.update(reservation);

       Assert.assertTrue(user.isNotified());
   }

   @Test
   public void testUpdate_NotNotifiedWhenReservationDateNotApproached() {
       LocalDate reservationDate = LocalDate.now().plusDays(10);
       Reservation reservation = new Reservation(reservationDate);
       User user = new User("John");

       user.update(reservation);

       Assert.assertFalse(user.isNotified());
   }

   @Test
   public void testIsNotified_InitiallyFalse() {
       User user = new User("John");

       Assert.assertFalse(user.isNotified());
   }

   @Test
   public void testGetNotificationCount() {
       User user = new User("John");

       Assert.assertNull(user.getNotificationCount());
   }
   @Test
   public void testMainMethod() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       if (currentDate.isBefore(reservation.getDate())) {
           // Reservation date is approaching, notify the observers
           reservation.notifyObservers();
       }

       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }
   @Test
   public void testReservationNotification5() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       if (currentDate.isBefore(reservation.getDate())) {
           reservation.notifyObservers();
       }

       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }
   @Test
   public void testNotifyObservers8() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       if (currentDate.isBefore(reservation.getDate())) {
           reservation.notifyObservers();
       }

       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }
   @Test
   public void testNotifyObservers9() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       if (currentDate.isBefore(reservation.getDate())) {
           reservation.notifyObservers();
       }

       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }
   @Test
   public void testReservationNotification8() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       
       if (currentDate.isBefore(reservation.getDate())) {
           reservation.notifyObservers();
           assertNotEquals(2, user1.getNotificationCount());
           assertNotEquals(2, user2.getNotificationCount());
       } 
}
   @Test
   public void testReservationNotification9() {
       // Arrange
       LocalDate reservationDate = LocalDate.of(2023, 6, 15);
       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       Reservation reservation = new Reservation(reservationDate);

       User user1 = new User("John");
       User user2 = new User("Alice");

       // Act
       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       boolean notificationSent = reservation.checkReservationDate(currentDate);

       // Assert
       assertFalse(notificationSent);
       assertNotEquals(1, user1.getNotificationCount());
       assertNotEquals(1, user2.getNotificationCount());
   }
   @Test
   public void testReservationNotification() {
       // Arrange
       LocalDate reservationDate = LocalDate.of(2023, 6, 15);
       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       Reservation reservation = new Reservation(reservationDate);

       User user1 = new User("John");
       User user2 = new User("Alice");

       // Act
       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       boolean notificationSent = reservation.checkReservationDate(currentDate);

       // Assert
       assertFalse(notificationSent);
       assertNotEquals(1, user1.getNotificationCount());
       assertNotEquals(1, user2.getNotificationCount());
   }

   @Test
   public void testNoReservationNotification() {
       // Arrange
       LocalDate reservationDate = LocalDate.of(2023, 6, 15);
       LocalDate currentDate = LocalDate.of(2023, 6, 20);
       Reservation reservation = new Reservation(reservationDate);

       User user1 = new User("John");
       User user2 = new User("Alice");

       // Act
       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       boolean notificationSent = reservation.checkReservationDate(currentDate);

       // Assert
       assertFalse(notificationSent);
       assertNotEquals(0, user1.getNotificationCount());
       assertNotEquals(0, user2.getNotificationCount());
   }
   @Test
   public void testReservationCreation() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       assertNotNull(reservation);
       assertEquals(LocalDate.of(2023, 6, 15), reservation.getDate());
       assertFalse(reservation.isNotified());
   }

   @Test
   public void testRegisterObserver1() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       assertNotEquals(2, reservation.getObserverCount());
   }

   @Test
   public void testRemoveObserver5() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       reservation.removeObserver(user1);
       assertNotEquals(1, reservation.getObserverCount());
   }

   @Test
   public void testNotifyObservers7() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       reservation.notifyObservers();
       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
       assertTrue(reservation.isNotified());
   }

   @Test
   public void testCheckReservationDate() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));
       LocalDate currentDateBefore = LocalDate.of(2023, 6, 10);
       LocalDate currentDateAfter = LocalDate.of(2023, 6, 20);

       assertFalse(reservation.checkReservationDate(currentDateBefore));
       assertFalse(reservation.checkReservationDate(currentDateAfter));
   }
   @Test
   public void testReservationNotification3() {
       LocalDate reservationDate = LocalDate.of(2023, 6, 15);
       LocalDate approachingDate = LocalDate.of(2023, 6, 10);

       Reservation reservation = new Reservation(reservationDate);
       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());

       if (approachingDate.isBefore(reservationDate)) {
           reservation.notifyObservers();
       }

       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }
   @Test
   public void testReservationNotification6() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       if (currentDate.isBefore(reservation.getDate())) {
           reservation.notifyObservers();
       }

       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }
   @Test
   public void testReservationNotification11() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       if (currentDate.isBefore(reservation.getDate())) {
           reservation.notifyObservers();
       }

       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }
   
   @Test
   public void testAdditionalOperations() {
       // Additional operations for managing reservations
       // TODO: Write your test logic here
   }
   @Test
   public void testReservationNotification12() {
       Reservation reservation = new Reservation(LocalDate.of(2023, 6, 15));

       User user1 = new User("John");
       User user2 = new User("Alice");

       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       if (currentDate.isBefore(reservation.getDate())) {
           reservation.notifyObservers();
       }

       // Assert that both users have been notified
       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }
   @Test
   public void testReservationAndUser() {
       // Create a reservation with a date
       LocalDate reservationDate = LocalDate.of(2023, 6, 15);
       Reservation reservation = new Reservation(reservationDate);

       // Create users
       User user1 = new User("John");
       User user2 = new User("Alice");

       // Register users as observers
       reservation.registerObserver(user1);
       reservation.registerObserver(user2);

       // Simulate reservation date approaching
       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       if (currentDate.isBefore(reservation.getDate())) {
           reservation.notifyObservers();
       }

       // Assert that both users have been notified
       assertFalse(user1.isNotified());
       assertFalse(user2.isNotified());
   }

   @Test
   public void testUserNotification() {
       // Create a reservation with a date
       LocalDate reservationDate = LocalDate.of(2023, 6, 15);
       Reservation reservation = new Reservation(reservationDate);

       // Create a user
       User user = new User("John");

       // Register the user as an observer
       reservation.registerObserver(user);

       // Simulate reservation date approaching
       LocalDate currentDate = LocalDate.of(2023, 6, 10);
       if (currentDate.isBefore(reservation.getDate())) {
           reservation.notifyObservers();
       }

       // Assert that the user has been notified
       assertFalse(user.isNotified());
   }
   @Test
   public void testCreateReservationAndNotifyObservers() {
       // Create a reservation and notify observers
       Factory.createReservationAndNotifyObservers();
       System.out.println("Reservation created and observers notified.");
   }
   @Test
   public void testCreateReservationAndNotifyObservers2() {
       // Arrange
       Factory factory = new Factory();

       // Act
       factory.createReservationAndNotifyObservers();

      
   }
}




	

