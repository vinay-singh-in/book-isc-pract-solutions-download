import java.util.*;

class Unique {
    private int m, n, frequency;
    private String output;

    public Unique(int m, int n) {
        this.m = m;
        this.n = n;
        findUniqueDigitNumbers();
    }

    public void findUniqueDigitNumbers() {
        frequency = 0;
        output = "THE UNIQUE-DIGIT INTEGERS ARE:-\n\t";
        for (int i = m; i <= n; i++) {
            if (isUniqeNumber(i)) {
                frequency++;
                output += i + ", ";
            }
        }
        output = output.substring(0, output.length() - 2) + ".";
    }

    private boolean isUniqeNumber(int n) {
        boolean unique[] = new boolean[10];
        int digit;
        for (int temp = n; temp > 0; temp /= 10) {
            digit = temp % 10;
            if (unique[digit])
                return false;
            unique[digit] = true;
        }
        return true;
    }

    public String toString() {
        return output;
    }

    public int getFrequency() {
        return frequency;
    }
}

class ISC2007Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tm = ");
        int m = in.nextInt();
        System.out.print("\tn = ");
        int n = in.nextInt();
        Unique obj = new Unique(m, n);
        System.out.println("OUTPUT:" + obj);
        System.out.println("FREQUENCY OF UNIQUE-DIGIT IN INTEGERS IS : " + obj.getFrequency());
        in.close();
    }
}