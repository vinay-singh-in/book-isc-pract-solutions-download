import java.util.*;

class Matrix {
    private int A[][], row, col, M, N, outer[], sum;

    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        A = new int[M][N];
        outer = new int[2 * N + 2 * (M - 2)];
    }

    public void input() {
        Scanner in = new Scanner(System.in);
        for (row = 0; row < M; row++) {
            for (col = 0; col < N; col++) {
                A[row][col] = in.nextInt();
            }
        }
    }

    public String toString() {
        String output = "";
        for (row = 0; row < M; row++) {
            output += "\t";
            for (col = 0; col < N; col++) {
                output += A[row][col];
                if (col < N - 1)
                    output += "\t";
            }
            output += "\n";
        }
        return output;
    }

    public void rearrangeMatrix() {
        // Populating the 1D array outer
        int index = 0, sum = 0;
        for (col = 0; col < N; col++) {
            outer[index++] = A[0][col];
            outer[index++] = A[M - 1][col];
            sum += A[0][col] + A[M - 1][col];
        }
        for (row = 1; row < M - 1; row++) {
            outer[index++] = A[row][0];
            outer[index++] = A[row][N - 1];
            sum += A[row][0] + A[row][N - 1];
        }
        // Sort 1D array outer
        Arrays.sort(outer);

        // Place back the 1D array outer into A[][]
        index = 0;
        for (col = 0; col <= N - 1; col++) { // Tol L-R
            A[0][col] = outer[index++];
        }
        for (row = 1; row <= M - 1; row++) { // Right col T-B
            A[row][N - 1] = outer[index++];
        }
        for (col = N - 2; col >= 0; col--) { // Bottom row R-L
            A[M - 1][col] = outer[index++];
        }
        for (row = M - 2; row >= 1; row--) {
            A[row][0] = outer[index++];
        }
    }

    public void displayBoundaryElements() {
        String output = "";
        for (row = 0; row < M; row++) {

            for (col = 0; col < N; col++) {
                if (row == 0 || col == 0 || row == M - 1 || col == N - 1)
                    output += "\t" + A[row][col];
                else
                    output += "\t";

            }
            output += "\n";
        }
        System.out.println(output);
    }

    public int getSumOfOuterElements() {
        return sum;
    }
}

public class ISC2009Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M, N;
        System.out.print("INPUT:\tM = ");
        M = in.nextInt();
        System.out.print("\tN = ");
        N = in.nextInt();
        Matrix obj = new Matrix(M, N);
        obj.input();
        System.out.println("OUTPUT:");
        System.out.println("\tORIGINAL MATRIX");
        System.out.println(obj);
        obj.rearrangeMatrix();
        System.out.println("\tREARRANGED  MATRIX");
        System.out.println(obj);
        System.out.println("\tBOUNDARY ELEMENTS");
        obj.displayBoundaryElements();
        System.out.println("\tSUM OF THE OUTER ROW AND COLUMN ELEMENTS  =  " + obj.getSumOfOuterElements());
        in.close();
    }
}
