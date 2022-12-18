import java.util.*;

class Matrix {
    private int M, N, A[][];

    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        A = new int[M][N];
    }

    public void input() {
        Scanner in = new Scanner(System.in);
        for (int row = 0; row < M; row++) {
            System.out.print("ENTER ELEMENTS FOR ROW " + (row + 1) + ": ");
            for (int col = 0; col < N; col++) {
                A[row][col] = in.nextInt();
                if (!(A[row][col] >= 0 && A[row][col] <= 7)) {
                    System.out.println("OUTPUT\nINVALID INPUT");
                    System.exit(1);
                }
            }
        }
        in.close();
    }

    public void display() {
        int decimal;
        System.out.println("\nFILLED MATRIX\tDECIMAL EQUIVALENT");
        for (int row = 0; row < M; row++) {
            decimal = 0;
            for (int col = 0; col < N; col++) {
                System.out.print(A[row][col] + " ");
                decimal += A[row][col] * Math.pow(8, N - col - 1);
            }
            System.out.print("\b\t\t" + decimal + "\n");
        }
    }
}

public class ISC2020Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M, N;
        System.out.println("INPUT");
        System.out.print("M = ");
        M = in.nextInt();

        System.out.print("N = ");
        N = in.nextInt();

        if (M > 0 && M < 10 && N > 2 && N < 6) {
            Matrix A = new Matrix(M, N);
            A.input();
            System.out.println("OUTPUT");
            A.display();
        } else {
            System.out.println("OUTPUT\nOUT OF RANGE");
        }
        in.close();
    }
}
