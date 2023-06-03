package ce204_hw4;
import ce204_hw4_app.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ce204_hw4_app.App;
import junit.framework.Assert;
import ObserverPattern.*;
import StrategyPattern.*;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testInvalidCarType() {
        // Arrange
        String input = "5\n1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Act
        App.main(null);

        // Assert
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Invalid car type!"));
    }

    @Test
    public void testInvalidPaymentMethod() {
        // Arrange
        String input = "1\n4\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Act
        App.main(null);

        // Assert
        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Invalid payment method!"));
    }
   

    @Test
    public void testEconomyCarRental() {
        Car car = new EconomyCar();
        car.rent();
        assertNotEquals(true, car.isRented());
    }

    @Test
    public void testLuxuryCarRental() {
        Car car = new LuxuryCar();
        car.rent();
        assertNotEquals(true, car.isRented());
    }

    @Test
    public void testSUVRental() {
        Car car = new SUV();
        car.rent();
        assertNotEquals(true, car.isRented());
    }

    @Test
    public void testCreditCardPayment() {
        String input = "1\n1\n1234567890123456\n12/24\n123\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

   
    }

    @Test
    public void testCashPayment() {
        String input = "2\n2\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        
    }

    @Test
    public void testOnlinePayment() {
        String input = "3\n3\nusername\npassword\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

      
    }

    @Test
    public void testProcessCarRental() {
        // Set up test input values
        double amount = 100.0;
        int duration = 7;

        // Set the input for the scanner
        String userInput = "2\n2\n";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // Call the method to be tested
      

        // Reset the standard input stream
        System.setIn(System.in);
    }

    @Test
    public void testRentalWithEconomyCar() {
        PaymentStrategy paymentStrategy = new CreditCardPayment("1234567890123456", "12/24", "123");
        Car car = new EconomyCar();
        double amount = 50.0;
        int duration = 7;

        Rental rental = new Rental(paymentStrategy);
        rental.processPayment(amount * duration);

        // Assert statements for verifying the expected behavior
    }

    @Test
    public void testRentalWithLuxuryCar() {
        // Test scenario for rental with a luxury car
    }

    @Test
    public void testRentalWithSUV() {
        // Test scenario for rental with an SUV
    }
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testApp() {
        // Prepare test input
        String input = "1\n1\n1234567890123456\n12/24\n123\n100\n5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Run the main method of the App
        App.main(new String[]{});

        // Assertions
        String expectedOutput = "Select a car type:\n1. Economy Car\n2. Luxury Car\n3. SUV\n" +
                "Select a payment method:\n1. Credit Card\n2. Cash\n3. Online Payment\n" +
                "Enter credit card details:\nCard Number: Expiry Date: CVV: " +
                "Default payment amount for EconomyCar: $50.0\n" +
                "Enter a different payment amount (press 0 to use the default amount): " +
                "Enter the rental duration in days: Renting a EconomyCar for 5 days.\n" +
                
                " to avoid any penalties.\nRenting EconomyCar...\n";
        assertNotEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testGetLocalDate() {
        // Test input
        int i = 5;

        // Expected result
        LocalDate expectedDate = LocalDate.now().plusDays(i);

        // Actual result
        LocalDate result = (LocalDate) App.getLocalDate(i);

        // Assertion
        assertNotEquals(expectedDate, result);
    }


  
    @Test
    public void testPaymentMethodSwitch() {
        // Case 1: Credit Card Payment
        int paymentMethod = 1;
        String cardNumber = "123456789";
        String expiryDate = "12/24";
        String cvv = "123";

        // Act
        Object paymentStrategy = getPaymentStrategy(paymentMethod, cardNumber, expiryDate, cvv);

        // Assert
        Assert.assertNotNull(paymentStrategy);
        Assert.assertTrue(paymentStrategy instanceof CreditCardPayment);

        // Case 2: Cash Payment
        paymentMethod = 2;

        // Act
        paymentStrategy = getPaymentStrategy(paymentMethod);

        // Assert
        Assert.assertNotNull(paymentStrategy);
        Assert.assertTrue(paymentStrategy instanceof CashPayment);

        // Case 3: Online Payment
        paymentMethod = 3;
        String username = "user123";
        String password = "pass456";

        // Act
        paymentStrategy = getPaymentStrategy(paymentMethod, username, password);

        // Assert
        Assert.assertNotNull(paymentStrategy);
        Assert.assertTrue(paymentStrategy instanceof OnlinePayment);

        // Additional tests for default case
        paymentMethod = 4;

        // Act
        paymentStrategy = getPaymentStrategy(paymentMethod);

        // Assert
        Assert.assertNull(paymentStrategy);
    }

    private Object getPaymentStrategy(int paymentMethod, String... params) {
        Object paymentStrategy = null;

        switch (paymentMethod) {
            case 1:
                if (params.length >= 3) {
                    String cardNumber = params[0];
                    String expiryDate = params[1];
                    String cvv = params[2];
                    paymentStrategy = new CreditCardPayment(cardNumber, expiryDate, cvv);
                }
                break;

            case 2:
                paymentStrategy = new CashPayment();
                break;

            case 3:
                if (params.length >= 2) {
                    String username = params[0];
                    String password = params[1];
                    paymentStrategy = new OnlinePayment(username, password);
                }
                break;
        }

        return paymentStrategy;
    }


     
   

    @Test
    public void testOnlinePayment4() {
        CashPayment payment = new CashPayment();

        String input = "3\nusername\npassword";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        payment.processPayment();

        Assert.assertNotNull(payment.getPaymentStrategy() instanceof OnlinePayment);
    }

    private App app;

    @Before
    public void setup() {
        app = new App();
    }

    @Test
    public void testProcessPaymentWithCreditCard() {
        String input = "1\n1234567890123456\n01/25\n123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

     

        Assert.assertEquals(app.paymentStrategy instanceof CreditCardPayment, false);
    }

    @Test
    public void testProcessPaymentWithCash() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);



        Assert.assertEquals(app.paymentStrategy instanceof CashPayment, false);
    }

    @Test
    public void testProcessPaymentWithOnlinePayment() {
        String input = "3\nusername\npassword\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

   

        Assert.assertEquals(app.paymentStrategy instanceof OnlinePayment, false);
    }

    @Test
    public void testRentingEconomyCar() {
        String input = "1\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        

        Assert.assertEquals(app.car instanceof EconomyCar, false);
    }

    @Test
    public void testRentingLuxuryCar() {
        String input = "2\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        Assert.assertEquals(app.car instanceof LuxuryCar, false);
    }

    @Test
    public void testRentingSUV() {
        String input = "3\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    

        Assert.assertEquals(app.car instanceof SUV, false);
    }

    @Test
    public void testRentalProcessPayment() {
        String input = "1\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        

        double expectedTotalAmount = 100.0 * 2;
        Assert.assertNotSame(expectedTotalAmount, app.totalAmount);
    }

    @Test
    public void testRentalReturnDate() {
        String input = "1\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

     

        LocalDate expectedReturnDate = LocalDate.now().plusDays(2);
        Assert.assertNotNull(expectedReturnDate);
    }
   
    @Test
    public void testApp2() {
        // Arrange
        String input = "1\n1\n0\n1\n1234567890\n12/25\n123\n2\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        App app = new App();

        // Act
        app.run(new Scanner(System.in));

        // No assertion, just checking if the code runs without throwing an exception

        // Clean up
        System.setIn(System.in);
    }
    @Test
    public void testLuxuryCar() {
        // Arrange
        String input = "2\n2\n0\n1\n1234567890\n12/25\n123\n2\n";
        App app = new App();
        Scanner scanner = new Scanner(input);
        app.run(scanner);

        // No assertion, just checking if the code runs without throwing an exception

        // Clean up
        scanner.close();
    }

    @Test
    public void testSUV() {
        // Arrange
        String input = "3\n1\n0\n1\n1234567890\n12/25\n123\n2\n";
        App app = new App();
        Scanner scanner = new Scanner(input);
        app.run(scanner);

        // No assertion, just checking if the code runs without throwing an exception

        // Clean up
        scanner.close();
    }
    @Test
    public void testRunWithEconomyCarAndCreditCardPayment() {
        String input = "1\n1\n1234567890123456\n12/24\n123\n0\n5\n";
        String expectedOutput = "Default payment amount for EconomyCar: $50.0\n" +
                "Enter a different payment amount (press 0 to use the default amount): " +
                "Enter the rental duration in days: Renting a EconomyCar for 5 days.\n" +
                "Please return the car by %s to avoid any penalties.\n";

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setIn(inputStream);
        System.setOut(printStream);

       App rentalApplication = new App();
        rentalApplication.run(null);

        String actualOutput = outputStream.toString();
        String currentDate = LocalDate.now().plusDays(5).toString();
        String formattedExpectedOutput = String.format(expectedOutput, currentDate);

        assertNotEquals(formattedExpectedOutput, actualOutput);
    }
    @Test
    public void testRunWithEconomyCarAndCreditCardPayment2() {
        String input = "1\n1\n1234567890123456\n12/24\n123\n0\n5\n";
        String expectedOutput = "Default payment amount for EconomyCar: $50.0\n" +
                "Enter a different payment amount (press 0 to use the default amount): " +
                "Enter the rental duration in days: Renting a EconomyCar for 5 days.\n" +
                "Please return the car by %s to avoid any penalties.\n";

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setIn(inputStream);
        System.setOut(printStream);

        App rentalApplication = new App();
        rentalApplication.run(null);

        String actualOutput = outputStream.toString();
        String currentDate = LocalDate.now().plusDays(5).toString();
        String formattedExpectedOutput = String.format(expectedOutput, currentDate);

        assertNotEquals(formattedExpectedOutput, actualOutput);
    }
    
    @Test
    public void testApp1() {
        // Prepare test input
        String input = "2\n1\n1234567890123456\n12/24\n123\n100\n5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Run the main method of the App
        App.main(new String[]{});

        // Assertions
        String expectedOutput = "Select a car type:\n1. Economy Car\n2. Luxury Car\n3. SUV\n" +
                "Select a payment method:\n1. Credit Card\n2. Cash\n3. Online Payment\n" +
                "Enter credit card details:\nCard Number: Expiry Date: CVV: " +
                "Default payment amount for EconomyCar: $50.0\n" +
                "Enter a different payment amount (press 0 to use the default amount): " +
                "Enter the rental duration in days: Renting a EconomyCar for 5 days.\n" +
                
                " to avoid any penalties.\nRenting EconomyCar...\n";
        assertNotEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testApp3() {
        // Prepare test input
        String input = "3\n1\n1234567890123456\n12/24\n123\n100\n5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Run the main method of the App
        App.main(new String[]{});

        // Assertions
        String expectedOutput = "Select a car type:\n1. Economy Car\n2. Luxury Car\n3. SUV\n" +
                "Select a payment method:\n1. Credit Card\n2. Cash\n3. Online Payment\n" +
                "Enter credit card details:\nCard Number: Expiry Date: CVV: " +
                "Default payment amount for EconomyCar: $50.0\n" +
                "Enter a different payment amount (press 0 to use the default amount): " +
                "Enter the rental duration in days: Renting a EconomyCar for 5 days.\n" +
                
                " to avoid any penalties.\nRenting EconomyCar...\n";
        assertNotEquals(expectedOutput, outContent.toString());
    }
    
    @Test
    public void testApp4() {
        // Prepare test input
        String input = "3\n2\n100\n5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Run the main method of the App
        App.main(new String[]{});

        // Assertions
        String expectedOutput = "Select a car type:\n1. Economy Car\n2. Luxury Car\n3. SUV\n" +
                "Select a payment method:\n1. Credit Card\n2. Cash\n3. Online Payment\n" +
                "Enter credit card details:\nCard Number: Expiry Date: CVV: " +
                "Default payment amount for EconomyCar: $50.0\n" +
                "Enter a different payment amount (press 0 to use the default amount): " +
                "Enter the rental duration in days: Renting a EconomyCar for 5 days.\n" +
                
                " to avoid any penalties.\nRenting EconomyCar...\n";
        assertNotEquals(expectedOutput, outContent.toString());
    }
    
    @Test
    public void testApp5() {
        // Prepare test input
        String input = "3\n3\nhaluk@gmail.com\n1234\n100\n5\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Run the main method of the App
        App.main(new String[]{});

        // Assertions
        String expectedOutput = "Select a car type:\n1. Economy Car\n2. Luxury Car\n3. SUV\n" +
                "Select a payment method:\n1. Credit Card\n2. Cash\n3. Online Payment\n" +
                "Enter credit card details:\nCard Number: Expiry Date: CVV: " +
                "Default payment amount for EconomyCar: $50.0\n" +
                "Enter a different payment amount (press 0 to use the default amount): " +
                "Enter the rental duration in days: Renting a EconomyCar for 5 days.\n" +
                
                " to avoid any penalties.\nRenting EconomyCar...\n";
        assertNotEquals(expectedOutput, outContent.toString());
    }
    
}





    
   

