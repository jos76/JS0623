import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RentalDetailsTests {

    @Test
    public void testRentalDetailsZeroRentalDayCountShouldThrow() {
        // arrange / act / assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new RentalDetails("JAKR",
                0,
                50,
                "7/2/20"));
        assertEquals("Uh oh! The rental day count must be greater than or equal to 1 and less than or equal to 365!", exception.getMessage());
    }

    @Test
    public void testRentalDetailsMinRentalDayCountShouldThrow() {
        // arrange / act / assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new RentalDetails("JAKR",
                Integer.MIN_VALUE,
                50,
                "7/2/20"));
        assertEquals("Uh oh! The rental day count must be greater than or equal to 1 and less than or equal to 365!", exception.getMessage());
    }

    @Test
    public void testRentalDetailsMaxRentalDayCountShouldNotThrow() {
        // arrange / act / assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new RentalDetails("JAKR",
                Integer.MAX_VALUE,
                50,
                "7/2/20"));
        assertEquals("Uh oh! The rental day count must be greater than or equal to 1 and less than or equal to 365!", exception.getMessage());
    }

    @Test
    public void testRentalDetailsNullDateShouldThrow() {
        // arrange / act / assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new RentalDetails("JAKR",
                4,
                50,
                (LocalDate) null));
        assertEquals("Uh oh! The checkout date could not be found!", exception.getMessage());
    }
}