import java.util.*;

class MyDate {
    private int dd, mm, yyyy;
    private static int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public MyDate(int dd, int mm, int yyyy) {
        this.dd = dd;
        this.mm = mm;
        this.yyyy = yyyy;
        if (isLeap())
            days[1] = 29;
    }

    public boolean isLeap() {
        int divisor = (yyyy % 100 == 0) ? 400 : 4;
        return yyyy % divisor == 0;
    }

    public boolean isValidDate() {
        if (yyyy < 0)
            return false;
        if (mm < 0 || mm > 12)
            return false;
        if (dd < 1 || dd > days[mm - 1])
            return false;
        return true;
    }

    public int getDayNumber() {
        int dayNumber = dd;
        for (int i = 0; i < mm - 1; i++) {
            dayNumber += days[i];
        }
        return dayNumber;
    }

}

class ISC2011Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("INPUT:\tEnter your date of birth in dd mm yyyy format");
        int dd, mm, yyyy;
        System.out.print("\t");
        dd = in.nextInt();
        System.out.print("\t");
        mm = in.nextInt();
        System.out.print("\t");
        yyyy = in.nextInt();
        MyDate obj = new MyDate(dd, mm, yyyy);
        if (obj.isValidDate()) {
            System.out.println("OUTPUT:\n\tVALID DATE\n\t" + obj.getDayNumber());
        } else {
            System.out.println("Output:\n\tINVALID DATE");
        }
        in.close();
    }
}