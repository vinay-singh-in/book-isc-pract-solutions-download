import java.util.*;

class Matrix {
    private int A[][], M;

    public Matrix(int M) {
        A = new int[M][M];
        this.M = M;
    }

    public void getInput() {
        Scanner in = new Scanner(System.in);
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < M; col++) {
                A[row][col] = in.nextInt();
            }
        }
        in.close();
    }

    public String toString() {
        String output = "";
        for (int row = 0; row < M; row++) {
            output += "\t";
            for (int col = 0; col < M; col++) {
                output += A[row][col];
                if (col < M)
                    output += "\t";
            }
            output += "\n";
        }
        return output;
    }

    public void rotate() {
        int half = M / 2, temp;
        for (int i = 0; i < half; i++) {
            for (int x = i; x < M - i - 1; x++) {
                temp = A[M - x - 1][i];
                A[M - x - 1][i] = A[M - i - 1][M - x - 1];
                A[M - i - 1][M - x - 1] = A[x][M - i - 1];
                A[x][M - i - 1] = A[i][x];
                A[i][x] = temp;
            }
        }
    }

    public int getCornerSum() {
        return A[0][0] + A[0][M - 1] + A[M - 1][M - 1] + A[M - 1][0];
    }
}

public class ISC2015Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tM = ");
        int M = in.nextInt();
        if (M > 2 && M < 10) {
            Matrix objMatrix = new Matrix(M);
            objMatrix.getInput();
            System.out.println("OUTPUT:");
            System.out.println("ORIGINAL MATRIX");
            System.out.println(objMatrix);
            objMatrix.rotate();
            System.out.println("MATRIX AFTER ROTATION");
            System.out.println(objMatrix);
            System.out.println("Sum of the corner elements = " + objMatrix.getCornerSum());
        } else {
            System.out.println("OUTPUT: SIZE OUT OF RANGE");
        }
        in.close();
    }
}
