
package votypka;

/**
 *
 * @author promi
 */
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Vítejte v kalendářové aplikaci!");
            System.out.println("Zadejte den:");
            int day = scanner.nextInt();
            System.out.println("Zadejte měsíc:");
            int month = scanner.nextInt();
            System.out.println("Zadejte rok:");
            int year = scanner.nextInt();
            
            KalendarManual kalendarManual = new KalendarManual(day, month, year);
            KalendarJavaTime kalendarJavaTime = new KalendarJavaTime(day, month, year);
            
            OUTER:
            while (true) {
                System.out.println("\nAktuální kalendář (KalendarManual):");
                System.out.println(kalendarManual.getCurrentMonthYear());
                System.out.println(kalendarManual.getMonthCalendar());
                System.out.println("\nAktuální kalendář (KalendarJavaTime):");
                System.out.println(kalendarJavaTime.getCurrentMonthYear());
                System.out.println(kalendarJavaTime.getMonthCalendar());
                System.out.println("\nVyberte akci:");
                System.out.println("1. Další měsíc");
                System.out.println("2. Předchozí měsíc");
                System.out.println("3. Konec");
                int action = scanner.nextInt();
                switch (action) {
                    case 1 -> {
                        kalendarManual.nextMonth();
                        kalendarJavaTime.nextMonth();
                    }
                    case 2 -> {
                        kalendarManual.previousMonth();
                        kalendarJavaTime.previousMonth();
                    }
                    case 3 -> {
                        break OUTER;
                    }
                    default -> System.out.println("Neplatná volba.");
                }
            }
        }
    }
}
