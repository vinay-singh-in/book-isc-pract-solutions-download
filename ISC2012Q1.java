import java.util.*;

class PrimePalindrome {
    private int m, n, frequency;
    private String output;

    public PrimePalindrome(int m, int n) {
        this.m = m;
        this.n = n;
        process();
    }

    private static boolean isPrime(int n) {
        if (n < 2)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        else {
            int limit = (int) Math.sqrt(n);
            for (int divisor = 3; divisor <= limit; divisor += 2) {
                if (n % divisor == 0)
                    return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(int n) {
        int reverse = 0;
        for (int temp = n; temp > 0; temp /= 10) {
            reverse = reverse * 10 + (temp % 10);
        }
        return n == reverse;
    }

    public void process() {
        output = "";
        frequency = 0;
        for (int number = m % 2 == 0 ? m + 1 : m; number <= n; number += 2) {
            if (isPalindrome(number) && isPrime(number)) {
                frequency++;
                output += number + ", ";
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
}

class ISC2012Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tm = ");
        int m = in.nextInt();
        System.out.print("\tn = ");
        int n = in.nextInt();
        if (m < 3000 && n < 3000) {
            PrimePalindrome obj = new PrimePalindrome(m, n);
            System.out.print("OUTPUT:\tTHE PRIME PALINDROME INTEGERS ARE:\n\t");
            System.out.println(obj);
            System.out.println("\tFREQUENCY OF PRIME PALINDROME INTEGERS: " + obj.getFrequency());
        } else {
            System.out.println("OUTPUT:\tOUT OF RANGE");
        }
        in.close();
    }
}