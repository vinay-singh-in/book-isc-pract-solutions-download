import java.util.*;

class Matrix {
    private int A[][], M, N, minRow, minCol, maxRow, maxCol, min, max;

    public Matrix(int M, int N) {
        A = new int[M][N];
        this.M = M;
        this.N = N;
    }

    public void getInput() {
        Scanner in = new Scanner(System.in);
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                A[row][col] = in.nextInt();
            }
        }
        in.close();
    }

    public void computeMinimumPosition(int startRow, int startCol) {
        min = A[startRow][startCol];
        minRow = startRow;
        minCol = startCol;
        for (int row = startRow; row < M; row++) {
            // startRow=0;
            for (int col = startCol; col < N; col++) {
                startCol = 0;
                if (A[row][col] < min) {
                    min = A[row][col];
                    minRow = row;
                    minCol = col;
                }
            }
        }
    }

    public void computeMaxiumPosition(int startRow, int startCol) {
        max = A[startRow][startCol];
        maxRow = startRow;
        maxCol = startCol;
        for (int row = startRow; row < M; row++) {
            // startRow=0;
            for (int col = startCol; col < N; col++) {
                startCol = 0;
                if (A[row][col] > max) {
                    max = A[row][col];
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
    }

    public String toString() {
        String output = "";
        for (int row = 0; row < M; row++) {
            output += "\t";
            for (int col = 0; col < N; col++) {
                output += A[row][col];
                if (col < N - 1)
                    output += "\t";
            }
            output += "\n";
        }
        return output;
    }

    public void showMaxDetails() {
        computeMaxiumPosition(0, 0);
        System.out.println("LARGEST NUMBER: " + max);
        System.out.println("\tROW = " + maxRow);
        System.out.println("\tCOLUMN = " + maxCol);
    }

    public void showMinDetails() {
        computeMinimumPosition(0, 0);
        System.out.println("SMALLEST NUMBER: " + min);
        System.out.println("\tROW = " + minRow);
        System.out.println("\tCOLUMN = " + minCol);
    }

    public void sortAscending() {
        int temp;
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                computeMinimumPosition(row, col);
                temp = A[minRow][minCol];
                A[minRow][minCol] = A[row][col];
                A[row][col] = temp;
            }
        }
    }
}

public class ISC2012Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tM = ");
        int M = in.nextInt();
        System.out.print("\tN = ");
        int N = in.nextInt();
        if (M > 2 && N > 2 && M < 20 && N < 20) {
            Matrix obj = new Matrix(M, N);
            obj.getInput();
            System.out.println("OUPUT:");
            System.out.println("ORIGINAL MATRIX");
            System.out.println(obj);
            obj.showMaxDetails();
            obj.showMinDetails();
            obj.sortAscending();
            System.out.println("REARRANGED MATRIX");
            System.out.println(obj);
        } else {
            System.out.println("OUTPUT:\n\tSIZE OUT OF RANGE");
        }

        in.close();
    }
}
