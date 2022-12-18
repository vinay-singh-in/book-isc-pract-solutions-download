import java.util.*;

class Fascinating {
    private int m, n, frequency;
    private static int digits[];
    private String output;

    public Fascinating(int m, int n) {
        this.m = m;
        this.n = n;
        frequency = 0;
        process();
    }

    private void process() {
        output = "";
        for (int i = m; i <= n; i++) {
            if (isFascinating(i)) {
                frequency++;
                output += i + " ";
            }
        }
        output = output.trim();
    }

    private static boolean isFascinating(int num) {
        digits = new int[9];
        boolean status = inspectDigits(num) && inspectDigits(num * 2) && inspectDigits(num * 3);
        if (status == false)
            return false;
        for (int count : digits) {
            if (count != 1)
                return false;
        }
        return true;
    }

    private static boolean inspectDigits(int product) {
        int digit;
        for (int temp = product; temp > 0; temp /= 10) {
            digit = temp % 10;
            if (digit > 0) {
                if (digits[digit - 1] == 1)
                    return false;
                digits[digit - 1] = 1;
            }
        }
        return true;
    }

    public int getFrequency() {
        return frequency;
    }

    public String toString() {
        String header = "THE FASCINATING NUMBERS ARE:\n";
        if (output == "")
            return header + "NIL";
        else
            return header + output;
    }
}

class ISC2021Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tm = ");
        int m = in.nextInt();
        System.out.print("\tn = ");
        int n = in.nextInt();
        if (m > n || m <= 99 || n <= 99 || m >= 10000 || n >= 10000) {
            System.out.println("OUTPUT:\tInvalid Range");
        } else {
            Fascinating obj = new Fascinating(m, n);
            System.out.println("OUPUT:\t" + obj);
            System.out.println("THE FREQUENCY OF FASCINATING NUMBER IS: " + obj.getFrequency());
        }
        in.close();
    }
}