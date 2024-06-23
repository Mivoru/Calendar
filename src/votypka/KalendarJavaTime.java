
package votypka;

/**
 *
 * @author promi
 */
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class KalendarJavaTime {
    private LocalDate currentDate;

    public KalendarJavaTime(int day, int month, int year) {
        this.currentDate = LocalDate.of(year, month, day);
    }

    public static boolean isLeapYear(int year) {
        return YearMonth.of(year, 1).isLeapYear();
    }

    public String getMonthCalendar() {
        StringBuilder calendar = new StringBuilder();
        calendar.append("Sun Mon Tue Wed Thu Fri Sat\n");

        YearMonth yearMonth = YearMonth.of(currentDate.getYear(), currentDate.getMonth());
        LocalDate firstOfMonth = currentDate.withDayOfMonth(1);
        DayOfWeek dayOfWeek = firstOfMonth.getDayOfWeek();
        int daysInMonth = yearMonth.lengthOfMonth();

        int currentDayOfWeek = dayOfWeek.getValue() % 7;

        for (int i = 0; i < currentDayOfWeek; i++) {
            calendar.append("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            if ((day + currentDayOfWeek - 1) % 7 == 0 && day != 1) {
                calendar.append("\n");
            }
            calendar.append(String.format("%3d ", day));
        }
        return calendar.toString();
    }

    public void nextMonth() {
        currentDate = currentDate.plusMonths(1).withDayOfMonth(1);
    }

    public void previousMonth() {
        currentDate = currentDate.minusMonths(1).withDayOfMonth(1);
    }

    public String getCurrentMonthYear() {
        return currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + currentDate.getYear();
    }
}
