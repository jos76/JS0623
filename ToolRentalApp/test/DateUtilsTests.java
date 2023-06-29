import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTests {

    @Test
    void getDayTypeForDate7315ShouldBeHoliday() {
        assertEquals(DayType.HOLIDAY, DateUtils.getDayTypeForDate(DateUtils.parseLocalDate("7/3/15")));
    }

    @Test
    void getDayTypeForDate7415ShouldBeWeekend() {
        assertEquals(DayType.WEEKEND, DateUtils.getDayTypeForDate(DateUtils.parseLocalDate("7/4/15")));
    }

    @Test
    void getDayTypeForDate7521ShouldBeHoliday() {
        assertEquals(DayType.HOLIDAY, DateUtils.getDayTypeForDate(DateUtils.parseLocalDate("7/5/21")));
    }

    @Test
    void getDayTypeForDate7418ShouldBeHoliday() {
        assertEquals(DayType.HOLIDAY, DateUtils.getDayTypeForDate(DateUtils.parseLocalDate("7/4/18")));
    }

    @Test
    void getDayTypeForDate9720ShouldBeHoliday() {
        assertEquals(DayType.HOLIDAY, DateUtils.getDayTypeForDate(DateUtils.parseLocalDate("9/7/20")));
    }

    @Test
    void getDayTypeForDate9114ShouldBeHoliday() {
        assertEquals(DayType.HOLIDAY, DateUtils.getDayTypeForDate(DateUtils.parseLocalDate("9/1/14")));
    }
}