/**
 * Class which contains details for a renting agreement.
 */
public class RentalAgreement {
    /**
     * The tool info.
     */
    public final Tool tool;

    public final RentalDetails rentalDetails;

    public RentalAgreement(Tool tool, RentalDetails rentalDetails) {
        this.tool = tool;
        this.rentalDetails = rentalDetails;
    }
}
