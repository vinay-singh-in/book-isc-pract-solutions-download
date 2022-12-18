import java.util.*;

class CompositeMagicNumber {
    private int m, n, frequency;
    String output;

    public CompositeMagicNumber(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public void process() {
        frequency = 0;
        output = "THE COMPOSITE INTEGERS ARE:\n\t";
        for (int i = m; i <= n; i++) {
            if (isMagicNumber(i) && isCompositeNumber(i)) {
                frequency++;
                output += i + ", ";
            }
        }
        output = output.substring(0, output.length() - 2);
    }

    public String toString() {
        return output;
    }

    public int getFrequency() {
        return frequency;
    }

    private static boolean isPrimeNumber(int n) {
        if (n < 2)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        else {
            // number is odd
            int limit = (int) Math.sqrt(n);
            for (int divisor = 3; divisor <= limit; divisor += 2) {
                if (n % divisor == 0)
                    return false;
            }
        }
        return true;
    }

    private static boolean isCompositeNumber(int n) {
        return !isPrimeNumber(n);
    }

    private static boolean isMagicNumber(int n) {
        return n % 9 == 1;
    }
}

class ISC2014Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tm = ");
        int m = in.nextInt();
        System.out.print("\tn = ");
        int n = in.nextInt();
        System.out.print("OUTPUT:\t");
        if (m < n) {
            CompositeMagicNumber obj = new CompositeMagicNumber(m, n);
            obj.process();
            System.out.println(obj);
            System.out.println("FREQUENCY OF COMPOSITE MAGIC INTEGERS IS: " + obj.getFrequency());
        } else {
            System.out.println("INVALID INPUT");
        }
        in.close();
    }
}