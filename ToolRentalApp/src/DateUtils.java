import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Utility class used to convert dates to/from strings.
 */
public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yy");

    /**
     * Parses a string to a LocalDate instance
     * @param dateString the string to be parsed into a LocalDate instance.
     * @return a LocalDate instance representing the string if parsing was successful.
     * @throws java.time.format.DateTimeParseException if the parse fails.
     */
    public static LocalDate parseLocalDate(String dateString) {
        if (dateString != null) {
            return LocalDate.parse(dateString, formatter);
        }
        return null;
    }

    /**
     * Returns a formatted string representation of the given date.
     * @param localDate the date to be formatted to string.
     * @return the formatted date string.
     */
    public static String localDateToString(LocalDate localDate) {
        if (localDate != null) {
            return formatter.format(localDate);
        }
        return null;
    }
}
