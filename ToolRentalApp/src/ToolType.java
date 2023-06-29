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

    /**
     * The friendly name of this tool type.
     */
    public final String name;

    /**
     * The daily charge of this tool type.
     */
    public final float dailyCharge;

    /**
     * True if this tool has a weekday charge, otherwise false.
     */
    public final boolean weekdayCharge;

    /**
     * True if this tool has a weekend charge, otherwise false.
     */
    public final boolean weekendCharge;

    /**
     * True if this tool has a holiday charge, otherwise false.
     */
    public final boolean holidayCharge;

    ToolType(String name, float dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.name = name;
        this.dailyCharge = dailyCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }
}
