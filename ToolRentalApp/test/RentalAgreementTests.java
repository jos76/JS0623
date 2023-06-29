import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalAgreementTests {

    @Test
    public void testConstructorNullParamsShouldThrow() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new RentalAgreement(null, null, null));
        assertEquals("Rental agreement details cannot be null!", exception.getMessage());
    }

    @Test
    public void testToStringSmallValues() {
        // arrange
        Tool tool = ToolFactory.retrieveToolFromCode("CHNS");
        RentalDetails rentalDetails = new RentalDetails("CHNS",
                5,
                25,
                "7/2/15");
        ChargeDetails chargeDetails = new ChargeDetails(3, 4.47f, 1.12f, 3.35f);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, rentalDetails, chargeDetails);

        // act
        String string = rentalAgreement.toString();

        // assert
        assertNotNull(string);
        assertEquals("Tool code: CHNS\n" +
                "Tool type: Chainsaw\n" +
                "Tool brand: Stihl\n" +
                "Rental days: 5\n" +
                "Checkout date: 7/2/15\n" +
                "Due date: 7/7/15\n" +
                "Daily rental charge: $1.49\n" +
                "Charge days: 3\n" +
                "Pre discount charge: $4.47\n" +
                "Discount percent: 25%\n" +
                "Discount amount: $1.12\n" +
                "Final charge: $3.35", string);
    }

    @Test
    public void testToStringLargeValues() {
        // arrange
        Tool tool = ToolFactory.retrieveToolFromCode("CHNS");
        RentalDetails rentalDetails = new RentalDetails("CHNS",
                5,
                0,
                "7/2/15");
        ChargeDetails chargeDetails = new ChargeDetails(3, 9999.99f, 0f, 9999.99f);
        RentalAgreement rentalAgreement = new RentalAgreement(tool, rentalDetails, chargeDetails);

        // act
        String string = rentalAgreement.toString();

        // assert
        assertNotNull(string);
        assertEquals("Tool code: CHNS\n" +
                "Tool type: Chainsaw\n" +
                "Tool brand: Stihl\n" +
                "Rental days: 5\n" +
                "Checkout date: 7/2/15\n" +
                "Due date: 7/7/15\n" +
                "Daily rental charge: $1.49\n" +
                "Charge days: 3\n" +
                "Pre discount charge: $9,999.99\n" +
                "Discount percent: 0%\n" +
                "Discount amount: $0.00\n" +
                "Final charge: $9,999.99", string);
    }
}