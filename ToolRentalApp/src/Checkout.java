/**
 * Class used to handle and process the business logic of renting a tool.
 */
public class Checkout {
    public static RentalAgreement processToolRental(RentalDetails rentalDetails) {
        validateRentalDetails(rentalDetails);
        // TODO: update this
        return null;
    }

    /**
     * Validates the rental details are valid, will throw an exception if any details are invalid.
     * @param rentalDetails the rental details to validate.
     */
    private static void validateRentalDetails(RentalDetails rentalDetails) {
        if (rentalDetails == null) {
            throw new IllegalArgumentException("Uh oh! The rental details could not be found!");
        }
        if (rentalDetails.toolCode == null) {
            throw new IllegalArgumentException("Uh oh! The tool code could not be found!");
        }
        if (rentalDetails.checkoutDate == null) {
            throw new IllegalArgumentException("Uh oh! The checkout date could not be found!");
        }
        if (rentalDetails.rentalDayCount < 1) { // not in the spec, but likely we should set a max number of rental days
            throw new IllegalArgumentException("Uh oh! The rental day count must be greater than or equal to 1!");
        }
        if (rentalDetails.discountPercent < 0 || rentalDetails.discountPercent > 100) {
            throw new IllegalArgumentException("Uh oh! An invalid discount percent was received! The discount percent must be between 0 and 100!");
        }
    }
}
