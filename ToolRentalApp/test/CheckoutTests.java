import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTests {

    @Test
    public void testCheckout1() {
        // arrange
        RentalDetails rentalDetails = new RentalDetails("JAKR",
                5,
                101,
                "9/3/15");

        // act / assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Checkout.processToolRental(rentalDetails));
        assertEquals("Uh oh! An invalid discount percent was received! The discount percent must be between 0 and 100!", exception.getMessage());
    }

    @Test
    public void testCheckout2() {
        // arrange
        RentalDetails rentalDetails = new RentalDetails("LADW",
                3,
                10,
                "7/2/20");

        // act
        RentalAgreement rentalAgreement = Checkout.processToolRental(rentalDetails);

        // assert
        assertNotNull(rentalAgreement);
        assertEquals(2, rentalAgreement.chargeDetails.chargeDays);
        assertEquals(3.98f, rentalAgreement.chargeDetails.preDiscountCharge);
        assertEquals(.4f, rentalAgreement.chargeDetails.discountAmount);
        assertEquals(3.58f, rentalAgreement.chargeDetails.finalCharge);
    }

    @Test
    public void testCheckout3() {
        // arrange
        RentalDetails rentalDetails = new RentalDetails("CHNS",
                5,
                25,
                "7/2/15");

        // act
        RentalAgreement rentalAgreement = Checkout.processToolRental(rentalDetails);

        // assert
        assertEquals(3, rentalAgreement.chargeDetails.chargeDays);
        assertEquals(4.47f, rentalAgreement.chargeDetails.preDiscountCharge);
        assertEquals(1.12f, rentalAgreement.chargeDetails.discountAmount);
        assertEquals(3.35f, rentalAgreement.chargeDetails.finalCharge);
    }

    @Test
    public void testCheckout4() {
        // arrange
        RentalDetails rentalDetails = new RentalDetails("JAKD",
                6,
                0,
                "9/3/15");

        // act
        RentalAgreement rentalAgreement = Checkout.processToolRental(rentalDetails);

        // assert
        assertEquals(3, rentalAgreement.chargeDetails.chargeDays);
        assertEquals(8.97f, rentalAgreement.chargeDetails.preDiscountCharge);
        assertEquals(0f, rentalAgreement.chargeDetails.discountAmount);
        assertEquals(8.97f, rentalAgreement.chargeDetails.finalCharge);
    }

    @Test
    public void testCheckout5() {
        // arrange
        RentalDetails rentalDetails = new RentalDetails("JAKR",
                9,
                0,
                "7/2/15");

        // act
        RentalAgreement rentalAgreement = Checkout.processToolRental(rentalDetails);

        // assert
        assertEquals(5, rentalAgreement.chargeDetails.chargeDays);
        assertEquals(14.95f, rentalAgreement.chargeDetails.preDiscountCharge);
        assertEquals(0f, rentalAgreement.chargeDetails.discountAmount);
        assertEquals(14.95f, rentalAgreement.chargeDetails.finalCharge);
    }

    @Test
    public void testCheckout6() {
        // arrange
        RentalDetails rentalDetails = new RentalDetails("JAKR",
                4,
                50,
                "7/2/20");

        // act
        RentalAgreement rentalAgreement = Checkout.processToolRental(rentalDetails);

        // assert
        assertEquals(1, rentalAgreement.chargeDetails.chargeDays);
        assertEquals(2.99f, rentalAgreement.chargeDetails.preDiscountCharge);
        assertEquals(1.5f, rentalAgreement.chargeDetails.discountAmount);
        assertEquals(1.49f, rentalAgreement.chargeDetails.finalCharge);
    }

    @Test
    public void testCheckoutNullDetailsShouldThrow() {
        // arrange
        RentalDetails rentalDetails = null;

        // act / assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Checkout.processToolRental(rentalDetails));
        assertEquals("Uh oh! The rental details could not be found!", exception.getMessage());
    }

    @Test
    public void testCheckoutNullToolCodeShouldThrow() {
        // arrange
        RentalDetails rentalDetails = new RentalDetails(null,
                4,
                50,
                "7/2/20");

        // act / assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Checkout.processToolRental(rentalDetails));
        assertEquals("Uh oh! The tool code could not be found!", exception.getMessage());
    }

    @Test
    public void testCheckoutInvalidDiscountPercentShouldThrow() {
        // arrange
        RentalDetails rentalDetails = new RentalDetails("ASDF",
                4,
                -50,
                "7/2/20");

        // act / assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Checkout.processToolRental(rentalDetails));
        assertEquals("Uh oh! An invalid discount percent was received! The discount percent must be between 0 and 100!", exception.getMessage());
    }

    @Test
    public void testCheckoutInvalidToolCodeShouldThrow() {
        // arrange
        RentalDetails rentalDetails = new RentalDetails("ASDF",
                4,
                50,
                "7/2/20");

        // act / assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Checkout.processToolRental(rentalDetails));
        assertEquals("Uh oh! We couldn't find the specified tool in our system with code: ASDF", exception.getMessage());
    }
}