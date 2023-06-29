import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTests {

    @Test
    public void testCheckout1() {
        // arrange
        RentalDetails toolRental = new RentalDetails("JAKR",
                5,
                101,
                "9/3/15");

        // act / assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Checkout.processToolRental(toolRental));
        assertEquals("Uh oh! An invalid discount percent was received! The discount percent must be between 0 and 100!", exception.getMessage());
    }

    @Test
    public void testCheckout2() {
        // arrange
        RentalDetails toolRental = new RentalDetails("LADW",
                3,
                10,
                "7/2/20");

        // act
        // TODO

        // assert
    }

    @Test
    public void testCheckout3() {
        // arrange
        RentalDetails toolRental = new RentalDetails("CHNS",
                5,
                25,
                "7/2/15");

        // act
        // TODO

        // assert
    }

    @Test
    public void testCheckout4() {
        // arrange
        RentalDetails toolRental = new RentalDetails("JAKD",
                6,
                0,
                "9/3/15");

        // act
        // TODO

        // assert
    }

    @Test
    public void testCheckout5() {
        // arrange
        RentalDetails toolRental = new RentalDetails("JAKR",
                9,
                0,
                "7/2/15");

        // act
        // TODO

        // assert
    }

    @Test
    public void testCheckout6() {
        // arrange
        RentalDetails toolRental = new RentalDetails("JAKR",
                4,
                50,
                "7/2/20");

        // act
        // TODO

        // assert
    }
}