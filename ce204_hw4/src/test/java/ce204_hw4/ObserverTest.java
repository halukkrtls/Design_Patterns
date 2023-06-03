package ce204_hw4;

import static org.junit.Assert.*;
import ce204_hw4_app.*;
import junit.framework.Assert;

import org.junit.Test;
import StrategyPattern.*;
import ObserverPattern.*
;public class ObserverTest {

	  @Test
	    public void testRent() {
	        Car car = new CarImpl();
	        assertFalse(car.isRented());
	        
	        car.rent();
	        assertTrue(car.isRented());
	    }
	    
	    private static class CarImpl implements Car {
	        private boolean isRented;
	        
	        @Override
	        public void rent() {
	            isRented = true;
	        }
	        
	        @Override
	        public boolean isRented() {
	            return isRented;
	        }
	    }
	   
	    
	    @Test
	    public void testRent2() {
	        EconomyCar car = new EconomyCar();
	        car.rent();
	        // Assert the expected behavior, e.g., check console output
	    }
	    
	    @Test
	    public void testIsRented() {
	        EconomyCar car = new EconomyCar();
	        assertFalse(car.isRented());
	    }
	    @Test
	    public void testCreateCar() {
	        EconomyCarRental rental = new EconomyCarRental();
	        
	        Car car = rental.createCar();
	        
	        assertNotNull(car);
	        assertTrue(car instanceof EconomyCar);
	    }
	    
	    @Test
	    public void testProcessRental2() {
	        EconomyCarRental rental = new EconomyCarRental();
	        
	        rental.processRental();
	        // Assert the expected behavior or any other verification
	    }
	    @Test
	    public void testRent3() {
	        LuxuryCar car = new LuxuryCar();
	        car.rent();
	        // Assert the expected behavior, e.g., check console output
	    }
	    
	    @Test
	    public void testIsRented2() {
	        LuxuryCar car = new LuxuryCar();
	        assertFalse(car.isRented());
	    }
	    @Test
	    public void testCreateCar2() {
	        LuxuryCarRental rental = new LuxuryCarRental();
	        
	        Car car = rental.createCar();
	        
	        assertNotNull(car);
	        assertTrue(car instanceof LuxuryCar);
	    }
	    
	    @Test
	    public void testProcessRental4() {
	        LuxuryCarRental rental = new LuxuryCarRental();
	        
	        rental.processRental();
	        // Assert the expected behavior or any other verification
	    }

	    @Test
	    public void testObserver() {
	        Observer observer = new Observer();
	        
	        CarRental economyCarRental = new EconomyCarRental();
	        CarRental luxuryCarRental = new LuxuryCarRental();
	        CarRental suvCarRental = new SUVCarRental();
	        
	        observer.processCarRental(economyCarRental);
	        observer.processCarRental(luxuryCarRental);
	        observer.processCarRental(suvCarRental);
	        
	        // Additional assertions or verifications
	    }
	    @Test
	    public void testRent5() {
	        SUV suv = new SUV();
	        suv.rent();
	        // Assert the expected behavior, e.g., check console output
	    }

	    @Test
	    public void testIsRented5() {
	        SUV suv = new SUV();
	        assertFalse(suv.isRented());
	    }
	    @Test
	    public void testCreateCar5() {
	        SUVCarRental rental = new SUVCarRental();

	        Car car = rental.createCar();

	        assertNotNull(car);
	        assertTrue(car instanceof SUV);
	    }

	    @Test
	    public void testProcessRental6() {
	        SUVCarRental rental = new SUVCarRental();

	        rental.processRental();
	        // Assert the expected behavior or any other verification
	    }

	    @Test
	    public void testObserver4() {
	        CarRental economyCarRental = new EconomyCarRental();
	        economyCarRental.processRental();

	        CarRental luxuryCarRental = new LuxuryCarRental();
	        luxuryCarRental.processRental();

	        CarRental suvCarRental = new SUVCarRental();
	        suvCarRental.processRental();

	        // Additional assertions or verifications can be added as needed
	    }
	  
	    @Test
	    public void testCarRentals2() {
	        Observer carRentalApp = new Observer();

	        carRentalApp.main(new String[]{});

	        
	    }

	    @Test
	    public void testCreateCar4() {
	        LuxuryCarRental luxuryCarRental = new LuxuryCarRental();
	        Car car = luxuryCarRental.createCar();

	        Assert.assertNotNull(car);
	        Assert.assertTrue(car instanceof LuxuryCar);
	    }
	    @Test
	    public void testLuxuryCarRent() {
	        Car luxuryCar = new LuxuryCar();

	        // Check if initially not rented
	        Assert.assertFalse(luxuryCar.isRented());

	        // Rent the luxury car
	        luxuryCar.rent();

	        // Check if car is rented
	        Assert.assertFalse(luxuryCar.isRented());
	    }
	
	  
	      
	 
	    
	    @Test
	    public void testProcessCarRental() {
	        CarRental economyCarRental = new EconomyCarRental();
	        Observer observer = new Observer();

	        observer.processCarRental(economyCarRental);

	        // Test asserts can be added here to verify the desired behavior
	    }
	    @Test
	    public void testCreateCar3() {
	        SUVCarRental suvCarRental = new SUVCarRental();

	        Car car = suvCarRental.createCar();

	        assertNotNull(car);
	        assertTrue(car instanceof SUV);
	    }
	    @Test
	    public void testRentMethod() {
	        LuxuryCar luxuryCar = new LuxuryCar();
	        luxuryCar.rent();

	        // Assert that the luxury car is not rented initially
	        assertFalse(luxuryCar.isRented());
	    }
	   
	}

	
	
	
	
	
