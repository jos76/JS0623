import java.time.LocalDate;

/**
 * Class used to process rental details and handle the business logic of renting a tool.
 */
public class Checkout {

    /**
     * Validates rental details and generates a rental agreement.
     *
     * @param rentalDetails the rental details used to generate a rental agreement.
     * @return the rental agreement.
     * @throws IllegalArgumentException if rental details are not valid.
     */
    public static RentalAgreement processToolRental(RentalDetails rentalDetails) {
        validateRentalDetails(rentalDetails);
        Tool tool = ToolFactory.retrieveToolFromCode(rentalDetails.toolCode);
        return calculateToolCharge(tool, rentalDetails);
    }

    /**
     * Validates the rental details are valid, will throw an exception if any details are invalid.
     *
     * @param rentalDetails the rental details to validate.
     */
    private static void validateRentalDetails(RentalDetails rentalDetails) {
        if (rentalDetails == null) {
            throw new IllegalArgumentException("Uh oh! The rental details could not be found!");
        }
        if (rentalDetails.toolCode == null) {
            throw new IllegalArgumentException("Uh oh! The tool code could not be found!");
        }
        if (rentalDetails.discountPercent < 0 || rentalDetails.discountPercent > 100) {
            throw new IllegalArgumentException("Uh oh! An invalid discount percent was received! The discount percent must be between 0 and 100!");
        }
    }

    private static RentalAgreement calculateToolCharge(Tool tool, RentalDetails rentalDetails) {
        if (tool == null) { // make sure we have tool info
            throw new IllegalArgumentException(String.format("Uh oh! We couldn't find the specified tool in our system with code: %s", rentalDetails.toolCode));
        }
        ChargeDetails chargeDetails = buildChargeDetails(tool, rentalDetails, calculateChargeDays(tool.toolType, rentalDetails.checkoutDate, rentalDetails.rentalDayCount));
        return new RentalAgreement(tool, rentalDetails, chargeDetails);
    }

    private static ChargeDetails buildChargeDetails(Tool tool, RentalDetails rentalDetails, int chargeDays) {
        float preDiscountCharge = round(chargeDays * tool.toolType.dailyCharge);
        float discountPercent = rentalDetails.discountPercent / 100f;
        float discountAmount = round(preDiscountCharge * discountPercent);
        float finalCharge = preDiscountCharge - discountAmount;
        return new ChargeDetails(chargeDays,
                preDiscountCharge,
                discountAmount,
                finalCharge);
    }

    private static int calculateChargeDays(ToolType toolType, LocalDate checkoutDate, int rentalDays) {
        int chargeDays = 0;
        for (int i = 1; i <= rentalDays; ++i) { // first charge day is the day after checkout so start at 1
            LocalDate date = checkoutDate.plusDays(i);
            DayType dayType = DateUtils.getDayTypeForDate(date);
            if (isChargeDayForDayType(toolType, dayType)) {
                chargeDays++;
            }
        }
        return chargeDays;
    }

    private static boolean isChargeDayForDayType(ToolType toolType, DayType dayType) {
        return switch (dayType) {
            case WEEKDAY -> toolType.weekdayCharge;
            case WEEKEND -> toolType.weekendCharge;
            case HOLIDAY -> toolType.holidayCharge;
        };
    }

    private static float round(float value) {
        return Math.round(value * 100f) / 100f;
    }
}
