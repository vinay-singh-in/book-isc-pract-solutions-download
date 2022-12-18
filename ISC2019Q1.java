import java.util.*;

class Date {
    private int day, month, year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        String suffix[] = { "TH", "ST", "ND", "RD", "TH", "TH", "TH", "TH", "TH", "TH" };
        String monthName[] = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER",
                "OCTOBER", "NOVEMBER", "DECEMBER" };
        String finalSuffix;
        if (day > 9 && day < 21)
            finalSuffix = "TH";
        else
            finalSuffix = suffix[day % 10];
        return day + " " + finalSuffix + " " + monthName[month - 1] + ", " + year;
    }
}

class ISC2019Q1 {
    static int dayNumber, year, N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("INPUT");
        System.out.print("DAY NUMBER:\t\t");
        dayNumber = in.nextInt();
        System.out.print("YEAR:\t\t\t");
        year = in.nextInt();
        System.out.print("DATE AFTER (N DAYS):\t");
        N = in.nextInt();

        System.out.println("OUTPUT");
        if (dayNumber < 1 || dayNumber > 366) {
            System.out.println("DAY NUMBER OUT OF RANGE.");
        } else if (year < 1000 || year > 9999) {
            System.out.println("YEAR OUT OF RANGE.");
        } else if (N < 1 || N > 100) {
            System.out.println("DATE AFTER (N DAYS) OUT OF RANGE.");
        } else {
            Date dt = dateFromDayNumber(dayNumber, year);
            System.out.println("DATE:\t\t\t" + dt);
            int nextDayNumber = dayNumber + N, nextYear;
            if (nextDayNumber > 365) {
                nextYear = year + 1;
            } else {
                nextYear = year;
            }
            if (isLeap(year)) {
                nextDayNumber = nextDayNumber % 366;
            } else {
                nextDayNumber = nextDayNumber % 365;
            }
            Date dateAfterNDays = dateFromDayNumber(nextDayNumber, nextYear);
            System.out.println("DATE AFTER " + N + " DAYS:\t" + dateAfterNDays);
        }
        in.close();
    }

    private static Date dateFromDayNumber(int dayNumber, int year) {
        int month[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (isLeap(year))
            month[1] = 29;
        int monthNumber;
        for (monthNumber = 0; monthNumber < month.length; monthNumber++) {
            if (dayNumber <= month[monthNumber])
                break;
            dayNumber -= month[monthNumber];
        }
        return new Date(dayNumber, monthNumber + 1, year);
    }

    public static boolean isLeap(int year) {
        // int divisor;
        // if(year%100==0) divisor=400;
        // else divisor=4;
        // return year%divisor==0;
        return year % (year % 100 == 0 ? 400 : 4) == 0;
    }
}