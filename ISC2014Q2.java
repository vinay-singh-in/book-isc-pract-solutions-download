import java.util.*;

class Matrix {
    private int A[][], M;

    public Matrix(int M) {
        this.M = M;
        A = new int[M][M];
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

    public void getInput() {
        Scanner in = new Scanner(System.in);
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < M; col++) {
                A[row][col] = in.nextInt();
            }
        }
        in.close();
    }

    public boolean isSymmetric() {
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < row; col++) {
                if (A[row][col] != A[col][row])
                    return false;
            }
        }
        return true;
    }

    public void computeAndDisplaySumOfDiagonals() {
        int sumOfLeftDiagonal = 0, sumOfRightDiagonal = 0;
        for (int i = 0; i < M; i++) {
            sumOfLeftDiagonal += A[i][i];
            sumOfRightDiagonal += A[i][M - 1 - i];
        }
        System.out.println("The sum of the left diagonal = " + sumOfLeftDiagonal);
        System.out.println("The sum of the right diagonal = " + sumOfRightDiagonal);
    }
}

class ISC2014Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tM = ");
        int M = in.nextInt();
        if (M > 2 && M < 10) {
            Matrix objMatrix = new Matrix(M);
            objMatrix.getInput();
            System.out.println("OUTPUT:\tORIGINAL MATRIX");
            System.out.println(objMatrix);
            if (objMatrix.isSymmetric()) {
                System.out.println("THE GIVEN MATRIX IS SYMMETRIC");
            } else {
                System.out.println("THE GIVEN MATRIX IS NOT SYMMETRIC");
            }
            objMatrix.computeAndDisplaySumOfDiagonals();
        } else {
            System.out.println("OUTPUT:\tTHE MATRIX SIZE IS OUT OF RANGE");
        }
        in.close();
    }
}