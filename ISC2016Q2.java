import java.util.*;

class Matrix {
    private int M, A[][];

    public Matrix(int M) {
        this.M = M;
        A = new int[M][M];
    }

    public void input() {
        Scanner in = new Scanner(System.in);
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < M; col++) {
                A[row][col] = in.nextInt();
            }
        }
        in.close();
    }

    public void display() {
        for (int row = 0; row < M; row++) {
            System.out.print("\t");
            for (int col = 0; col < M; col++) {
                System.out.print(A[row][col]);
                if (col < M - 1)
                    System.out.print("\t");
            }
            System.out.println();
        }
    }

    public void displayDiagonals() {
        for (int row = 0; row < M; row++) {
            System.out.print("\t");
            for (int col = 0; col < M; col++) {
                if (row == col || row + col == M - 1) {
                    System.out.print(A[row][col]);
                }
                if (col < M - 1)
                    System.out.print("\t");
            }
            System.out.println();
        }
    }

    public void displaySumOfDiagonals() {
        System.out.println("SUM OF THE DIAGONAL ELEMENTS = " + getSumOfDiagonals(A));
    }

    private static int getSumOfDiagonals(int A[][]) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i][i] + A[i][A.length - 1 - i];
        }
        return (A.length % 2 == 1) ? sum - A[A.length / 2][A.length / 2] : sum;
    }

    public void sort() {
        int temp[] = new int[(M - 2) * (M - 2)], index = 0, buffer;
        for (int row = 1; row < M - 1; row++) {
            for (int col = 1; col < M - 1; col++) {
                temp[index++] = A[row][col];
            }
        }
        boolean swapped;
        for (int pass = 0; pass < temp.length - 1; pass++) {
            swapped = false;
            for (int x = 0; x < temp.length - 1 - pass; x++) {
                if (temp[x + 1] < temp[x]) {
                    buffer = temp[x + 1];
                    temp[x + 1] = temp[x];
                    temp[x] = buffer;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }

        index = 0;
        for (int row = 1; row < M - 1; row++) {
            for (int col = 1; col < M - 1; col++) {
                A[row][col] = temp[index++];
            }
        }
    }

}

public class ISC2016Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tM = ");
        int M = in.nextInt();
        if (M <= 3 || M >= 10) {
            System.out.println("OUTPUT:\tTHE MATRIX IS OUT OF RANGE");
        } else {
            Matrix A = new Matrix(M);
            A.input();
            System.out.println("OUTPUT:");
            System.out.println("ORIGINAL MATRIX");
            A.display();
            System.out.println("REARRANGED MATRIX");
            A.sort();
            A.display();
            System.out.println("DIAGONAL ELEMENTS");
            A.displayDiagonals();
            A.displaySumOfDiagonals();

        }

        in.close();
    }
}
