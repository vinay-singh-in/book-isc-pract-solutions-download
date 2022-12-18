import java.util.*;

class Matrix {
    private int A[][];
    private int M;

    public Matrix(int M) {
        this.M = M;
        A = new int[M][M];
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
                if (col < M - 1)
                    output += "\t";
            }
            output += "\n";
        }
        return output;
    }

    public void mirror() {
        int temp;
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < M / 2; col++) {
                temp = A[row][col];
                A[row][col] = A[row][M - 1 - col];
                A[row][M - 1 - col] = temp;
            }
        }
    }
}

public class ISC2013Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tM = ");
        int M = in.nextInt();
        if (M > 2 && M < 20) {
            Matrix objMatrix = new Matrix(M);
            objMatrix.getInput();
            System.out.println("OUTPUT:\tORIGINAL MATRIX");
            System.out.println(objMatrix);
            objMatrix.mirror();
            System.out.println("\tMIRROR IMAGE MATRIX");
            System.out.println(objMatrix);
        } else {
            System.out.println("OUTPUT:\tSIZE OUT OF RANGE");
        }
        in.close();
    }
}
