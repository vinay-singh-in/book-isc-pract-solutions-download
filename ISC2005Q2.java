import java.util.*;

class Square {
    private int a[][], N, sum;

    public Square(int a[][]) {
        this.a = a;
        this.N = a.length;
        sum = (int) (0.5 * N * (N * N + 1));
    }

    public boolean isWondrousSquare() {
        boolean flag[] = new boolean[N * N];
        int sumOfRows, sumOfCols;
        for (int row = 0; row < N; row++) {
            sumOfRows = sumOfCols = 0;
            for (int col = 0; col < N; col++) {
                sumOfRows += a[row][col];
                sumOfCols += a[col][row];
                if (flag[a[row][col] - 1])
                    return false;
                flag[a[row][col] - 1] = true;
            }
            if (sumOfRows != sum || sumOfCols != sum)
                return false;
        }
        return true;
    }

    public String toString() {
        String output = "PRIME\tROW INDEX\tCOLUMN INDEX\n";
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (isPrime(a[row][col])) {
                    output += a[row][col] + "\t" + row + "\t\t" + col + "\n";
                }
            }
        }
        return output;
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
            for (int i = 3; i <= limit; i += 2) {
                if (n % i == 0)
                    return false;
            }
        }
        return true;
    }
}

public class ISC2005Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\nN = ");
        int N = in.nextInt();
        int a[][] = new int[N][N];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                a[row][col] = in.nextInt();
            }
        }
        Square sq = new Square(a);

        System.out.println("OUPUT:");
        if (sq.isWondrousSquare()) {
            System.out.println("YES IT REPRESENTS A WONDROUS SQUARE.");
        } else {
            System.out.println("NOT A WONDROUS SQUARE.");
        }
        System.out.println(sq);
        in.close();
    }
}
