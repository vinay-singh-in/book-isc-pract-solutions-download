import java.util.*;

class Kaprekar {
    private int p, q, frequency;
    String output;

    public Kaprekar(int p, int q) {
        this.p = p;
        this.q = q;
        output = "";
        processRange();
    }

    private void processRange() {
        for (int i = p; i <= q; i++) {
            if (isKaprekarNumber(i)) {
                output += i + ", ";
                frequency++;
            }
        }
        output = output.substring(0, output.length() - 2);
    }

    private static boolean isKaprekarNumber(int n) {
        int square = n * n, divisor = 1;
        for (int temp = n; temp > 0; temp /= 10) {
            divisor *= 10;
        }
        return n == (square / divisor) + (square % divisor);
    }

    public String toString() {
        return output;
    }

    public int getFrequency() {
        return frequency;
    }
}

class ISC2010Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("INPUT:");
        int p, q;
        System.out.print("p = ");
        p = in.nextInt();
        System.out.print("q = ");
        q = in.nextInt();
        Kaprekar obj = new Kaprekar(p, q);
        System.out.println("OUTPUT:\nTHE KAPREKAR NUMBERS ARE:-");
        System.out.println(obj);
        System.out.println("FREQUENCY OF KAPREKAR NUMBERS IS: " + obj.getFrequency());
        in.close();
    }
}
