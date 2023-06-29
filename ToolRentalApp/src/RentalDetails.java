import java.time.LocalDate;

/**
 * Class which contains details for renting a tool.
 */
public class RentalDetails {
    public final String toolCode;

    /**
     * The number of days for which the customer wants to rent the tool. (e.g. 4 days)
     */
    public final int rentalDayCount;

    /**
     * Discount percent - As a whole number, 0-100 (e.g. 20 = 20%)
     */
    public final int discountPercent;

    /**
     * The checkout date.
     */
    public final LocalDate checkoutDate;

    /**
     * The date the tool is due back.
     */
    public final LocalDate dueDate;

    /**
     * Initializes a new RentalDetails object with the specified parameters.
     *
     * @param toolCode        the code of the tool to rent.
     * @param rentalDayCount  the number of days to rent the tool.
     * @param discountPercent the discount percentage.
     * @param checkoutDate    the checkout date.
     */
    public RentalDetails(String toolCode, int rentalDayCount, int discountPercent, LocalDate checkoutDate) {
        this.toolCode = toolCode;
        this.rentalDayCount = rentalDayCount;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
        if (checkoutDate == null) {
            throw new IllegalArgumentException("Uh oh! The checkout date could not be found!");
        }
        // not in the spec, but I'm setting a max number of rental days to 365
        if (rentalDayCount < 1 || rentalDayCount > 365) { // validate rental day count
            throw new IllegalArgumentException("Uh oh! The rental day count must be greater than or equal to 1 and less than or equal to 365!");
        }
        this.dueDate = checkoutDate.plusDays(rentalDayCount);
    }

    /**
     * Initializes a new RentalDetails object with the specified parameters.
     *
     * @param toolCode           the code of the tool to rent.
     * @param rentalDayCount     the number of days to rent the tool.
     * @param discountPercent    the discount percentage.
     * @param checkoutDateString the checkout date string representation.
     */
    public RentalDetails(String toolCode, int rentalDayCount, int discountPercent, String checkoutDateString) {
        this(toolCode, rentalDayCount, discountPercent, DateUtils.parseLocalDate(checkoutDateString));
    }
}
