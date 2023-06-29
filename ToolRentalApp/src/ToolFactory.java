import java.util.Map;

/**
 * Class used to retrieve tool info given a tool code.
 */
public class ToolFactory {

    /**
     * Map of tool codes to tool instances.
     */
    private static final Map<String, Tool> toolMap = Map.of(
            "CHNS", new Tool("CHNS", ToolType.CHAINSAW, "Stihl"),
            "LADW", new Tool("LADW", ToolType.LADDER, "Werner"),
            "JAKD", new Tool("JADK", ToolType.JACKHAMMER, "DeWalt"),
            "JAKR", new Tool("JAKR", ToolType.JACKHAMMER, "Ridgid"));

    /**
     * Attempts to retrieve a tool instance for the given code.
     *
     * @param toolCode the code for which to retrieve the tool instance.
     * @return the tool instance or null if one could not be found.
     */
    public static Tool retrieveToolFromCode(String toolCode) {
        if (toolCode == null) {
            return null;
        }
        return toolMap.getOrDefault(toolCode, null);
    }
}
