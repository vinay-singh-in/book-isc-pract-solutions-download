import java.util.*;

class Number {
    private int n, temp;

    public Number(int n) {
        this.n = n;
    }

    private static int getSumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private int getSumOfFactors(int divisor) {
        int sumOfDigits = 0, divisiorSum = getSumOfDigits(divisor);
        while (temp % divisor == 0) {
            temp /= divisor;
            sumOfDigits += divisiorSum;
        }
        return sumOfDigits;
    }

    public boolean isSmithNumber() {
        if (n == 2)
            return false;
        temp = n;
        int divisor = 2, sumOfPrimeFactors = 0, half = n / 2;
        sumOfPrimeFactors += getSumOfFactors(divisor);
        for (divisor = 3; divisor <= half; divisor += 2) {
            sumOfPrimeFactors += getSumOfFactors(divisor);
        }
        if (temp > 1 || sumOfPrimeFactors != getSumOfDigits(n))
            return false;
        else
            return true;
    }
}

class ISC2008Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\t");
        int n = in.nextInt();
        Number obj = new Number(n);
        System.out.print("OUTPUT:\t");
        if (obj.isSmithNumber()) {
            System.out.println("SMITH Number");
        } else {
            System.out.println("NOT SMITH Number");
        }
        in.close();
    }
}