/**
 * Class used to represent charge details for tools.
 */
public class ChargeDetails {

    /**
     * The number of days the consumer should be charged.
     */
    public final int chargeDays;

    /**
     * The pre discount charge.
     */
    public final float preDiscountCharge;

    /**
     * The discount amount.
     */
    public final float discountAmount;

    /**
     * The final charge including discounts.
     */
    public final float finalCharge;

    /**
     * Initializes a new charge details instance with the specified parameters.
     * @param chargeDays the charge days.
     * @param preDiscountCharge the pre discount charge.
     * @param discountAmount the discount amount.
     * @param finalCharge the final charge
     */
    public ChargeDetails(int chargeDays, float preDiscountCharge, float discountAmount, float finalCharge) {
        this.chargeDays = chargeDays;
        this.preDiscountCharge = preDiscountCharge;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }
}
