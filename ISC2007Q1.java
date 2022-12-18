import java.util.*;

class MyDate {
    private int dd, mm, yyyy, index;
    private String inputDay;
    private static String weekDays[] = { "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY" };
    private static int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public MyDate(String inputDate, String inputDay) {
        String part[] = inputDate.split("/");
        dd = Integer.parseInt(part[0]);
        mm = Integer.parseInt(part[1]);
        yyyy = Integer.parseInt(part[2]);
        this.inputDay = inputDay;
        if (isLeap())
            days[1] = 29;
    }

    public boolean isLeap() {
        int divisor = yyyy % 100 == 0 ? 400 : 4;
        return yyyy % divisor == 0;
    }

    public boolean validate() {
        index = -1;
        for (int i = 0; i < weekDays.length; i++) {
            if (inputDay.equals(weekDays[i])) {
                index = i;
                break;
            }
        }
        if (index == -1)
            return false; // day invalid
        if (yyyy < 0)
            return false; // checking for -ve years
        if (mm < 1 || mm > 12)
            return false; // month must be between 1-12 (inclusive)
        if (dd < 1 || dd > days[mm - 1])
            return false; // number of day check
        return true;
    }

    public int getDayNumber() {
        int dayNumber = dd;
        for (int i = 0; i < mm - 1; i++) {
            dayNumber += days[i];
        }
        return dayNumber;
    }

    private int getDayIndex() {
        return ((getDayNumber() - 1 + index) % 7);
    }

    public String toString() {
        return weekDays[getDayIndex()];
    }
}

class ISC2007Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("INPUT");
        System.out.print("Date\t\t\t\t: ");
        String inputDate = in.nextLine();
        System.out.print("Day on 1st January\t\t: ");
        String inputDay = in.nextLine();
        MyDate dt = new MyDate(inputDate, inputDay);
        if (dt.validate()) {
            System.out.println("OUTPUT:\nDAY ON " + inputDate + "\t\t: " + dt);
        } else {
            System.out.println("INVALID DATE/DAY");
        }
        in.close();
    }
}