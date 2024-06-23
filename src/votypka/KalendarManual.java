
package votypka;

/**
 *
 * @author promi
 */
public class KalendarManual {
    private int day;
    private int month;
    private int year;

    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public KalendarManual(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return DAYS_IN_MONTH[month - 1];
    }

    public int getDayOfWeek(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int K = year % 100;
        int J = year / 100;
        int h = (day + (13 * (month + 1)) / 5 + K + K / 4 + J / 4 + 5 * J) % 7;
        int d = ((h + 5) % 7) + 1; // Convert Zeller's outcome to 1 (Monday) to 7 (Sunday)
        return d;
    }

    public String getMonthCalendar() {
        StringBuilder calendar = new StringBuilder();
        calendar.append("Sun Mon Tue Wed Thu Fri Sat\n");

        int firstDayOfMonth = getDayOfWeek(1, this.month, this.year);
        int daysInMonth = getDaysInMonth(this.month, this.year);

        for (int i = 0; i < firstDayOfMonth; i++) {
            calendar.append("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            if ((day + firstDayOfMonth - 1) % 7 == 0 && day != 1) {
                calendar.append("\n");
            }
            calendar.append(String.format("%3d ", day));
        }
        return calendar.toString();
    }

    public void nextMonth() {
        if (this.month == 12) {
            this.month = 1;
            this.year++;
        } else {
            this.month++;
        }
        this.day = 1;
    }

    public void previousMonth() {
        if (this.month == 1) {
            this.month = 12;
            this.year--;
        } else {
            this.month--;
        }
        this.day = 1;
    }

    public String getCurrentMonthYear() {
        return Month.fromNumber(this.month).getMonthName() + " " + this.year;
    }
}
