/**
 * Class used to represent a tool
 */
public class Tool {
    /**
     * Unique identifier for a tool instance
     */
    public final String toolCode;

    /**
     * The type of tool. The type also specifies the daily rental charge, and the days for which the
     * daily rental charge applies.
     */
    public final ToolType toolType;

    /**
     * The brand of the ladder, chain saw or jackhammer.
     */
    public final String brand;

    /**
     * Initializes a new Tool object with the specified parameters.
     *
     * @param toolCode the tool code.
     * @param toolType the tool type.
     * @param brand the tool brand.
     */
    public Tool(String toolCode, ToolType toolType, String brand) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
    }
}
