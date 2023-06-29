/**
 * Class which contains details for a renting agreement.
 */
public class RentalAgreement {
    /**
     * The tool info.
     */
    public final Tool tool;

    /**
     * The rental details.
     */
    public final RentalDetails rentalDetails;

    /**
     * The charge details.
     */
    public final ChargeDetails chargeDetails;

    /**
     * Initializes a new rental agreement with the specified values.
     * @param tool the tool info.
     * @param rentalDetails the rental details.
     * @param chargeDetails the charge details.
     */
    public RentalAgreement(Tool tool, RentalDetails rentalDetails, ChargeDetails chargeDetails) {
        if (tool == null || rentalDetails == null || chargeDetails == null) {
            throw new IllegalArgumentException("Rental agreement details cannot be null!");
        }
        this.tool = tool;
        this.rentalDetails = rentalDetails;
        this.chargeDetails = chargeDetails;
    }

    /**
     * Generates a string representation of this object.
     * @return a string representing this object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tool code: ");
        sb.append(tool.toolCode);
        sb.append("\nTool type: ");
        sb.append(tool.toolType.name);
        sb.append("\nTool brand: ");
        sb.append(tool.brand);
        sb.append("\nRental days: ");
        sb.append(rentalDetails.rentalDayCount);
        sb.append("\nCheckout date: ");
        sb.append(DateUtils.localDateToString(rentalDetails.checkoutDate));
        sb.append("\nDue date: ");
        sb.append(DateUtils.localDateToString(rentalDetails.dueDate));
        sb.append("\nDaily rental charge: ");
        sb.append(String.format("$%,.2f", tool.toolType.dailyCharge));
        sb.append("\nCharge days: ");
        sb.append(chargeDetails.chargeDays);
        sb.append("\nPre discount charge: ");
        sb.append(String.format("$%,.2f", chargeDetails.preDiscountCharge));
        sb.append("\nDiscount percent: ");
        sb.append(rentalDetails.discountPercent);
        sb.append("%");
        sb.append("\nDiscount amount: ");
        sb.append(String.format("$%,.2f", chargeDetails.discountAmount));
        sb.append("\nFinal charge: ");
        sb.append(String.format("$%,.2f", chargeDetails.finalCharge));
        return sb.toString();
    }
}
