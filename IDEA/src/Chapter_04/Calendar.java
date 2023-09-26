package Chapter_04;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calendar {
    private LocalDate date = LocalDate.now();
    private int month = date.getMonthValue();
    private final int day = date.getDayOfWeek().getValue();
    private int today = date.getDayOfMonth();

    private void printHead(){
        String[] weekList = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        for (String week : weekList){
            System.out.print(week + "\t");
        }
        System.out.println();
    }

    private void printBody(){
        date.minusDays(today - 1);
        while (date.getMonthValue() == month){

            if (date.getMonthValue() == today){
                System.out.print("*");
            } else {
                System.out.print("\t");
            }

        }
    }

    private void printAll(){
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1); // set to start of month
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 1 = Monday, . . . , 7 = Sunday

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++)
            System.out.print("    ");
        while (date.getMonthValue() == month)
        {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) System.out.println();
    }

    public static void main(String[] args) {
        Calendar calendar = new Calendar();

        calendar.printHead();

        calendar.printAll();
    }
}

