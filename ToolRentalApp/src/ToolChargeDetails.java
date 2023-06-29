/**
 * Class used to represent charges for tool types.
 */
public class ToolChargeDetails {

    public final ToolType toolType;
    public final float dailyCharge;
    public final boolean weekdayCharge;
    public final boolean weekendCharge;
    public final boolean holidayCharge;

    public ToolChargeDetails(ToolType toolType, float dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.toolType = toolType;
        this.dailyCharge = dailyCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }
}
