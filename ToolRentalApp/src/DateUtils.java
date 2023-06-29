import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * Utility class used to convert dates to/from strings and perform certain checks for specified dates.
 */
public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");

    /**
     * Parses a string to a LocalDate instance
     *
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
     *
     * @param localDate the date to be formatted to string.
     * @return the formatted date string.
     */
    public static String localDateToString(LocalDate localDate) {
        if (localDate != null) {
            return formatter.format(localDate);
        }
        return null;
    }

    /**
     * Determines the day type for the specified date.
     *
     * @param localDate the date for which to determine the day type.
     * @return the day type of the specified date.
     */
    public static DayType getDayTypeForDate(LocalDate localDate) {
        if (localDate == null) {
            throw new IllegalArgumentException("Unable to determine day type, date must be specified!");
        }

        // saturday and sunday are always weekends, observed holidays only fall on weekdays
        if (isSatOrSun(localDate)) {
            return DayType.WEEKEND;
        }

        // if the month is July, check for the holiday
        if (localDate.getMonth() == Month.JULY) {
            return getWeekdayTypeForJuly(localDate);
        }

        // if the month is September, check for the holiday
        if (localDate.getMonth() == Month.SEPTEMBER) {
            return getWeekdayTypeForSeptember(localDate);
        }

        // all days that don't fall in July/September and aren't a weekend are a weekday
        return DayType.WEEKDAY;
    }

    private static boolean isSatOrSun(LocalDate localDate) {
        return localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private static DayType getWeekdayTypeForJuly(LocalDate localDate) {
        // if the 4th falls on a saturday, friday the 3rd is a holiday
        if (localDate.getDayOfMonth() == 3 && localDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
            return DayType.HOLIDAY;
        }
        // if the 4th falls on a sunday, monday the 5th is a holiday
        if (localDate.getDayOfMonth() == 5 && localDate.getDayOfWeek() == DayOfWeek.MONDAY) {
            return DayType.HOLIDAY;
        }
        // otherwise the 4th is a holiday
        if (localDate.getDayOfMonth() == 4) {
            return DayType.HOLIDAY;
        }
        // this must be a weekday
        return DayType.WEEKDAY;
    }

    private static DayType getWeekdayTypeForSeptember(LocalDate localDate) {
        // labor day is the first monday of the month, so it can fall on days 1 - 7
        if (localDate.getDayOfWeek() == DayOfWeek.MONDAY && localDate.getDayOfMonth() < 8) {
            return DayType.HOLIDAY;
        }
        // this must be a weekday
        return DayType.WEEKDAY;
    }
}
