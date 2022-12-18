import java.util.*;

class CircularPrime {
    private int N, copy, divisor;
    private boolean isPrime;

    public CircularPrime(int N) {
        this.N = N;
        copy = N;
        divisor = 1;
        for (int temp = N; temp > 9; temp /= 10) {
            divisor *= 10;
        }
        isPrime = true;
    }

    private void shift(int n) {
        copy = (n % divisor) * 10 + (n / divisor);
    }

    public void display() {
        do {
            System.out.println("\t" + copy);
            if (!isPrime(copy)) {
                isPrime = false;
            }
            shift(copy);
        } while (N != copy);
        if (isPrime) {
            System.out.println("\t" + N + " IS A CIRCULAR PRIME");
        } else {
            System.out.println("\t" + N + " IS NOT A CIRCULAR PRIME");
        }
    }

    private static boolean isPrime(int n) {
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
}

class ISC2016Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tN = ");
        int N = in.nextInt();
        CircularPrime obj = new CircularPrime(N);
        System.out.print("OUTPUT:");
        obj.display();
        in.close();
    }
}