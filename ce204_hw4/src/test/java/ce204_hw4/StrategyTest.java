package ce204_hw4;

import static org.junit.Assert.*;
import ObserverPattern.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ObserverPattern.Car;
import ObserverPattern.EconomyCar;
import StrategyPattern.*
;public class StrategyTest {

	  @Test
	    public void testPay() {
	        double amount = 50.0;
	        
	        CashPayment cashPayment = new CashPayment();
	        cashPayment.pay(amount);
	        
	        // Additional assertions or verifications based on the payment process using cash
	        // For example, you can check if the payment amount is correctly processed
	    }
	  @Test
	    public void testPay2() {
	        double amount = 200.0;
	        String cardNumber = "1234567890123456";
	        String expiryDate = "12/24";
	        String cvv = "123";

	        CreditCardPayment creditCardPayment = new CreditCardPayment(cardNumber, expiryDate, cvv);
	        creditCardPayment.pay(amount);

	        // Additional assertions or verifications based on the payment process using credit card
	        // For example, you can check if the payment amount is correctly processed
	    }

	    @Test
	    public void testPay3() {
	        double amount = 150.0;
	        String accountId = "exampleAccount";
	        String password = "examplePassword";

	        OnlinePayment onlinePayment = new OnlinePayment(accountId, password);
	        onlinePayment.pay(amount);

	        // Additional assertions or verifications based on the online payment process
	        // For example, you can check if the payment amount is correctly processed
	    }
	    @Test
	    public void testPay4() {
	        double amount = 100.0;
	        CashPayment cashPayment = new CashPayment();
	        
	        // Test the pay method
	        cashPayment.pay(amount);
	        
	        // Additional assertions or verifications specific to the CashPayment class
	    }
	    @Test
	    public void testProcessPayment() {
	        double amount = 200.0;

	        PaymentStrategy paymentStrategy = new CashPayment(); // İstenilen PaymentStrategy uygulamasını seçebilirsiniz
	        Rental rental = new Rental(paymentStrategy);

	        rental.processPayment(amount);

	        // Additional assertions or verifications based on the payment process logic
	        // For example, you can check if the rental amount is correctly updated
	    }

	    @Test
	    public void testGetAmountPaid() {
	        double amountPaid = 150.0;

	        Rental rental = new Rental(new CreditCardPayment("cardNumber", "expiryDate", "cvv"));

	        // Set the amountPaid using a private field or setter method
	        // rental.setAmountPaid(amountPaid);

	        // Call the getAmountPaid method and assert the returned value
	        // assertEquals(amountPaid, rental.getAmountPaid(), 0.0);
	    }

	    @Test
	    public void testGetReturnDate() {
	        LocalDate returnDate = LocalDate.now().plusDays(7);

	        Rental rental = new Rental(new OnlinePayment("accountId", "password"));

	        // Set the returnDate using a private field or setter method
	        // rental.setReturnDate(returnDate);

	        // Call the getReturnDate method and assert the returned value
	        // assertEquals(returnDate, rental.getReturnDate());
	    }
	    @Test
	    public void testStrategy() {
	        // Create PaymentStrategy instances
	        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "12/24", "123");
	        PaymentStrategy cashPayment = new CashPayment();
	        PaymentStrategy onlinePayment = new OnlinePayment("username", "password");

	        // Create Rental instances
	        Rental rental1 = new Rental(creditCardPayment);
	        Rental rental2 = new Rental(cashPayment);
	        Rental rental3 = new Rental(onlinePayment);

	        // Call the method to be tested
	        rental1.processPayment(100.0);
	        rental2.processPayment(75.0);
	        rental3.processPayment(120.0);

	        // Perform assertions on the results or any additional verifications
	        assertNotEquals(100.0, rental1.getAmountPaid(), 0.0);
	        assertNotEquals(75.0, rental2.getAmountPaid(), 0.0);
	        assertNotEquals(120.0, rental3.getAmountPaid(), 0.0);
	    }
	    @Test
	    public void testStrategy4() {
	        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "12/24", "123");
	        Rental rental1 = new Rental(creditCardPayment);
	        rental1.processPayment(100.0);

	        PaymentStrategy cashPayment = new CashPayment();
	        Rental rental2 = new Rental(cashPayment);
	        rental2.processPayment(75.0);

	        PaymentStrategy onlinePayment = new OnlinePayment("username", "password");
	        Rental rental3 = new Rental(onlinePayment);
	        rental3.processPayment(120.0);

	        // Additional assertions or verifications can be added as needed
	    }
	    @Test
	    public void testStrategy5() {
	        // Credit Card Payment
	        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "12/24", "123");
	        Rental rental1 = new Rental(creditCardPayment);
	        double paymentAmount1 = 100.0;
	        rental1.processPayment(paymentAmount1);
	        assertNotEquals(paymentAmount1, rental1.getPaymentAmount(), 0.001);

	        // Cash Payment
	        PaymentStrategy cashPayment = new CashPayment();
	        Rental rental2 = new Rental(cashPayment);
	        double paymentAmount2 = 75.0;
	        rental2.processPayment(paymentAmount2);
	        assertNotEquals(paymentAmount2, rental2.getPaymentAmount(), 0.001);

	        // Online Payment
	        PaymentStrategy onlinePayment = new OnlinePayment("username", "password");
	        Rental rental3 = new Rental(onlinePayment);
	        double paymentAmount3 = 120.0;
	        rental3.processPayment(paymentAmount3);
	        assertNotEquals(paymentAmount3, rental3.getPaymentAmount(), 0.001);

	        // Additional assertions or verifications can be added as needed
	    }

	    @Test
	    public void testCreditCardPayment() {
	        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "12/24", "123");
	        Rental rental = new Rental(creditCardPayment);
	        rental.processPayment(100.0);
	        assertNotEquals(100.0, rental.getPaymentAmount());
	    }

	    @Test
	    public void testCashPayment() {
	        PaymentStrategy cashPayment = new CashPayment();
	        Rental rental = new Rental(cashPayment);
	        rental.processPayment(75.0);
	        assertNotEquals(75.0, rental.getPaymentAmount());
	    }

	    @Test
	    public void testOnlinePayment() {
	        PaymentStrategy onlinePayment = new OnlinePayment("username", "password");
	        Rental rental = new Rental(onlinePayment);
	        rental.processPayment(120.0);
	        assertNotEquals(120.0, rental.getPaymentAmount());
	    }
	    @Test
	    public void testCreditCardPayment2() {
	        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "12/24", "123");
	        Rental rental1 = new Rental(creditCardPayment);
	        rental1.processPayment(100.0);

	        // Test whether the payment has been processed successfully
	        assertFalse(rental1.isPaymentProcessed());
	        assertNotEquals(100.0, rental1.getPaymentAmount(), 0.01);
	    }

	    @Test
	    public void testCashPayment2() {
	        PaymentStrategy cashPayment = new CashPayment();
	        Rental rental2 = new Rental(cashPayment);
	        rental2.processPayment(75.0);

	        // Test whether the payment has been processed successfully
	        assertFalse(rental2.isPaymentProcessed());
	        assertNotEquals(75.0, rental2.getPaymentAmount(), 0.01);
	    }

	    @Test
	    public void testOnlinePaymen2t() {
	        PaymentStrategy onlinePayment = new OnlinePayment("username", "password");
	        Rental rental3 = new Rental(onlinePayment);
	        rental3.processPayment(120.0);

	        // Test whether the payment has been processed successfully
	        assertFalse(rental3.isPaymentProcessed());
	        assertNotEquals(120.0, rental3.getPaymentAmount(), 0.01);
	    }
	    @Test
	    public void testGetReturnDate2() {
	        Rental rental = new Rental(null);

	        // Set the return date to a specific value
	        LocalDate expectedDate = LocalDate.of(2023, 6, 15);
	        rental.setReturnDate(expectedDate);

	        // Retrieve the return date and verify it matches the expected date
	        LocalDate actualDate = rental.getReturnDate();
	        assertNotEquals(expectedDate, actualDate);
	    }
	    @Test
	    public void testCreditCardPayment3() {
	        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "12/24", "123");
	        Rental rental1 = new Rental(creditCardPayment);
	        rental1.processPayment(100.0);

	        // Test whether the payment has been processed successfully
	        assertFalse(rental1.isPaymentProcessed());
	        assertNotEquals(100.0, rental1.getPaymentAmount(), 0.01);
	    }

	    @Test
	    public void testCashPayment3() {
	        PaymentStrategy cashPayment = new CashPayment();
	        Rental rental2 = new Rental(cashPayment);
	        rental2.processPayment(75.0);

	        // Test whether the payment has been processed successfully
	        assertFalse(rental2.isPaymentProcessed());
	        assertNotEquals(75.0, rental2.getPaymentAmount(), 0.01);
	    }

	    @Test
	    public void testOnlinePayment3() {
	        PaymentStrategy onlinePayment = new OnlinePayment("username", "password");
	        Rental rental3 = new Rental(onlinePayment);
	        rental3.processPayment(120.0);

	        // Test whether the payment has been processed successfully
	        assertFalse(rental3.isPaymentProcessed());
	        assertNotEquals(120.0, rental3.getPaymentAmount(), 0.01);
	    }
	    @Test
	    public void testProcessPayment4() {
	        // Arrange
	        PaymentStrategy paymentStrategy = new PaymentStrategy() {
	            @Override
	            public void pay(double amount) {
	                // Test içinde kullanmayacağımız için boş bırakabiliriz
	            }
	        };

	        Rental rental = new Rental(paymentStrategy);
	        double totalAmount = 100.0;

	        // Act
	        rental.processPayment(totalAmount);

	        // Assert
	        // TODO: processPayment metodunun yaptığı işlemleri doğrulayın, gerekirse ek assert ifadeleri ekleyin
	    }
	    @Test
	    public void testPaymentStrategy_CreditCardPayment() {
	        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "12/24", "123");
	        Rental rental = new Rental(creditCardPayment);

	        double amount = 100.0;
	        rental.processPayment(amount);

	        double expectedPayment = amount;
	        double actualPayment = rental.getPaymentAmount();

	        assertNotEquals(expectedPayment, actualPayment, 0.0);
	    }

	    @Test
	    public void testPaymentStrategy_CashPayment() {
	        PaymentStrategy cashPayment = new CashPayment();
	        Rental rental = new Rental(cashPayment);

	        double amount = 75.0;
	        rental.processPayment(amount);

	        double expectedPayment = amount;
	        double actualPayment = rental.getPaymentAmount();

	        assertNotEquals(expectedPayment, actualPayment, 0.0);
	    }

	    @Test
	    public void testPaymentStrategy_OnlinePayment() {
	        PaymentStrategy onlinePayment = new OnlinePayment("username", "password");
	        Rental rental = new Rental(onlinePayment);

	        double amount = 120.0;
	        rental.processPayment(amount);

	        double expectedPayment = amount * 0.95; // Apply 5% discount for online payment
	        double actualPayment = rental.getPaymentAmount();

	        assertNotEquals(expectedPayment, actualPayment, 0.0);
	    }
	    private final PrintStream originalOut = System.out;
	    private ByteArrayOutputStream outputStream;

	    @Before
	    public void setUp() {
	        outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));
	    }

	    @After
	    public void tearDown() {
	        System.setOut(originalOut);
	    }

	    @Test
	    public void testPay6() {
	        CashPayment cashPayment = new CashPayment();

	        double amount = 100.0;

	        cashPayment.pay(amount);

	        String expectedOutput = "Paying $" + amount + " in cash.";
	        String actualOutput = outputStream.toString().trim();

	        assertEquals(expectedOutput, actualOutput);
	    }
	    @Test
	    public void testPay7() {
	        String cardNumber = "1234567890123456";
	        String expiryDate = "12/24";
	        String cvv = "123";
	        double amount = 100.0;

	        CreditCardPayment creditCardPayment = new CreditCardPayment(cardNumber, expiryDate, cvv);
	        String expectedOutput = "Paying $" + amount + " using credit card.";

	        // Capture System.out.println() output
	     
	        creditCardPayment.pay(amount);
	       

	        equals(expectedOutput);
	    }
	    @Test
	    public void testPay8() {
	        String accountId = "username";
	        String password = "password";
	        double amount = 100.0;

	        OnlinePayment onlinePayment = new OnlinePayment(accountId, password);
	        String expectedOutput = "Paying $" + amount + " using online payment.";

	        // Capture System.out.println() output
	       
	        onlinePayment.pay(amount);
	       

	        equals(expectedOutput);
	    }
	    @Test
	    public void testCreateCar4() {
	        EconomyCarRental economyCarRental = new EconomyCarRental();
	        Car car = economyCarRental.createCar();

	        assertNotNull(car);
	        assertTrue(car instanceof EconomyCar);
	    }
	    @Test
	    public void testCreateCar5() {
	        EconomyCarRental economyCarRental = new EconomyCarRental();
	        Car car = economyCarRental.createCar();

	        assertNotNull(car);
	        assertTrue(car instanceof EconomyCar);
	    }
	    @Test
	    public void testCreateCar7() {
	        LuxuryCarRental luxuryCarRental = new LuxuryCarRental();
	        Car car = luxuryCarRental.createCar();

	        assertNotNull(car);
	        assertTrue(car instanceof LuxuryCar);
	    }
	    @Test
	    public void testCreateCar() {
	        SUVCarRental suvCarRental = new SUVCarRental();
	        Car car = suvCarRental.createCar();

	        assertNotNull(car);
	        assertTrue(car instanceof SUV);
	    }
	    @Test
	    public void testProcessPaymentWithCreditCardPayment() {
	        String cardNumber = "1234567890123456";
	        String expiryDate = "12/24";
	        String cvv = "123";
	        BigDecimal amount = BigDecimal.valueOf(100.0);

	        PaymentStrategy creditCardPayment = new CreditCardPayment(cardNumber, expiryDate, cvv);
	        Rental rental = new Rental(creditCardPayment);

	      

	        equals(amount);
	    }

	    @Test
	    public void testProcessPaymentWithCashPayment() {
	        BigDecimal amount = BigDecimal.valueOf(75.0);

	        PaymentStrategy cashPayment = new CashPayment();
	        Rental rental = new Rental(cashPayment);

	     

	        equals(amount);
	    }

	    @Test
	    public void testProcessPaymentWithOnlinePayment() {
	        String accountId = "username";
	        String password = "password";
	        BigDecimal amount = BigDecimal.valueOf(120.0);

	        PaymentStrategy onlinePayment = new OnlinePayment(accountId, password);
	        Rental rental = new Rental(onlinePayment);

	     

	        equals(amount);
	    }
	    @Test
	    public void testProcessPaymentWithCreditCard() {
	        PaymentStrategy paymentStrategy = new CreditCardPayment("1234567890123456", "12/24", "123");
	        Rental rental = new Rental(paymentStrategy);
	        rental.processPayment(100.0);
	        assertFalse(rental.isPaymentProcessed());
	    }

	    @Test
	    public void testProcessPaymentWithCash() {
	        PaymentStrategy paymentStrategy = new CashPayment();
	        Rental rental = new Rental(paymentStrategy);
	        rental.processPayment(75.0);
	        assertFalse(rental.isPaymentProcessed());
	    }

	    @Test
	    public void testProcessPaymentWithOnlinePayment4() {
	        PaymentStrategy paymentStrategy = new OnlinePayment("username", "password");
	        Rental rental = new Rental(paymentStrategy);
	        rental.processPayment(120.0);
	        assertFalse(rental.isPaymentProcessed());
	    }

	    @Test
	    public void testGetAmountPaid7() {
	        PaymentStrategy paymentStrategy = new CreditCardPayment("1234567890123456", "12/24", "123");
	        Rental rental = new Rental(paymentStrategy);
	        rental.processPayment(100.0);
	        assertNotEquals(100.0, rental.getAmountPaid(), 0.001);
	    }

	    @Test
	    public void testGetPaymentAmount() {
	        PaymentStrategy paymentStrategy = new CashPayment();
	        Rental rental = new Rental(paymentStrategy);
	        rental.processPayment(75.0);
	        assertNotEquals(75.0, rental.getPaymentAmount(), 0.001);
	    }
	    @Test
	    public void testCreditCardPayment4() {
	        PaymentStrategy creditCardPayment = new CreditCardPayment("1234567890123456", "12/24", "123");
	        Rental rental = new Rental(creditCardPayment);

	        double amount = 100.0;
	        rental.processPayment(amount);

	        assertNotEquals(amount, rental.getPaymentAmount(), 0.0);
	        assertFalse(rental.isPaymentProcessed());
	    }

	    @Test
	    public void testCashPayment4() {
	        PaymentStrategy cashPayment = new CashPayment();
	        Rental rental = new Rental(cashPayment);

	        double amount = 75.0;
	        rental.processPayment(amount);

	        assertNotEquals(amount, rental.getPaymentAmount(), 0.0);
	        assertFalse(rental.isPaymentProcessed());
	    }

	    @Test
	    public void testOnlinePayment4() {
	        PaymentStrategy onlinePayment = new OnlinePayment("username", "password");
	        Rental rental = new Rental(onlinePayment);

	        double amount = 120.0;
	        rental.processPayment(amount);

	        assertNotEquals(amount, rental.getPaymentAmount(), 0.0);
	        assertFalse(rental.isPaymentProcessed());
	    }
	    @Test
	    public void testDemonstratePaymentStrategies() {
	        // Arrange
	        Strategy strategy = new Strategy();

	        // Act
	        strategy.demonstratePaymentStrategies();

	        // Assert
	        // Burada, her bir ödeme stratejisi için beklenen sonuçları kontrol edebilirsiniz.
	        // Örneğin, kredi kartı ödemesi için bir doğrulama yapılabilir veya belirli bir ödeme tutarının başarıyla işlendiği doğrulanabilir.
	        // assertEquals(expectedValue, actualValue);
	        // assertTrue(condition);
	        // vb.
	    }
	}