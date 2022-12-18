import java.util.*;

class Number {
    private int M, N;
    String output;
    private boolean status;

    public Number(int M, int N) {
        this.M = M;
        this.N = N;
        output = "";
        status = false;
    }

    public void findSolution() {
        int M = this.M;
        int sum = 0;
        do {
            sum = sumOfDigits(M);
            if (sum == N) {
                output = "OUTPUT:\tThe required number = " + M + "\n\tTotal number of digits = " + countDigits(M);
                status = true;
            }
            M++;
            if (M == Integer.MAX_VALUE) {
                status = false;
                break;
            }
        } while (sum != N);
    }

    public boolean hasSolution() {
        return status;
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        for (int temp = n; temp > 0; temp /= 10) {
            sum += temp % 10;
        }
        return sum;
    }

    private int countDigits(int n) {
        int count = 0;
        for (int temp = n; temp > 0; temp /= 10) {
            count++;
        }
        return count;
    }

    public String toString() {
        return output;
    }
}

class ISC2015Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tM = ");
        int M = in.nextInt();
        System.out.print("\tN = ");
        int N = in.nextInt();
        if (M < 100 || M > 10000 || N < 0 || N >= 100) {
            System.out.println("OUTPUT:\tINVALID INPUT");
        } else {
            Number num = new Number(M, N);
            num.findSolution();
            if (num.hasSolution()) {
                System.out.println(num);
            } else {
                System.out.println("OUTPUT:\tNo solution exists");
            }

        }
        in.close();
    }
}
