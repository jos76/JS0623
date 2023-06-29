/**
 * Enumeration used to encapsulate types of tools that can be rented.
 */
public enum ToolType {
    /**
     * Ladder
     */
    LADDER("Ladder", 1.99f, true, true, false),

    /**
     * Chainsaw
     */
    CHAINSAW("Chainsaw", 1.49f, true, false, true),

    /**
     * Jackhammer
     */
    JACKHAMMER("Jackhammer", 2.99f, true, false, false);

    public final String name;
    public final float dailyCharge;
    public final boolean weekdayCharge;
    public final boolean weekendCharge;
    public final boolean holidayCharge;

    ToolType(String name, float dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.name = name;
        this.dailyCharge = dailyCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }
}
