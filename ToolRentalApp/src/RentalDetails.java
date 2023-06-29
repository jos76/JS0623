import java.time.LocalDate;

/**
 * Class which contains details for renting a tool.
 */
public class RentalDetails {
    public final String toolCode;

    /**
     * The number of days for which the customer wants to rent the tool. (e.g. 4
     * days)
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
     * Initializes a new RentalDetails object with the specified parameters.
     * @param toolCode the code of the tool to rent.
     * @param rentalDayCount the number of days to rent the tool.
     * @param discountPercent the discount percentage.
     * @param checkoutDate the checkout date.
     */
    public RentalDetails(String toolCode, int rentalDayCount, int discountPercent, LocalDate checkoutDate) {
        this.toolCode = toolCode;
        this.rentalDayCount = rentalDayCount;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
    }

    /**
     * Initializes a new RentalDetails object with the specified parameters.
     * @param toolCode the code of the tool to rent.
     * @param rentalDayCount the number of days to rent the tool.
     * @param discountPercent the discount percentage.
     * @param checkoutDateString the checkout date string representation.
     */
    public RentalDetails(String toolCode, int rentalDayCount, int discountPercent, String checkoutDateString) {
        this(toolCode, rentalDayCount, discountPercent, DateUtils.parseLocalDate(checkoutDateString));
    }
}
