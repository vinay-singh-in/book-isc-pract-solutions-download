import java.util.*;

class ISC2018Q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("INPUT: M = ");
        int M = in.nextInt();
        System.out.println("       N = ");
        int N = in.nextInt();
        if (M > 2 && M < 10 && N > 2 && N < 10) {
            int A[][] = new int[M][N];
            input(A);
            display(A, "ORIGINAL MATRIX");
            for (int row = 0; row < M; row++) {
                sort(A[row]);
            }
            display(A, "MATRIX AFTER SORTING ROWS");

        } else {
            System.out.println("OUTPUT:\nMATRIX OUT OF RANGE");
        }
        in.close();
    }

    public static void input(int A[][]) {
        System.out.println("ENTER ELEMENTS OF MATRIX");
        Scanner in = new Scanner(System.in);
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[row].length; col++) {
                A[row][col] = in.nextInt();
            }
        }
        in.close();
    }

    public static void display(int A[][], String header) {
        System.out.println(header);
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[row].length; col++) {
                System.out.print("\t" + A[row][col]);
            }
            System.out.println();
        }
    }

    // public static void sort(int A[][]){
    // int temp;
    // boolean swapped;
    // for( int row=0; row<A.length;row++){
    // for(int pass=0; pass<A[row].length-1;pass++){
    // swapped=false;
    // for(int x=0; x<A[row].length-1-pass;x++){
    // if(A[row][x+1]<A[row][x]){
    // temp=A[row][x+1];
    // A[row][x+1]=A[row][x];
    // A[row][x]=temp;
    // swapped=true;
    // }
    // }
    // if(!swapped) break;
    // }
    // }
    // }
    public static void sort(int A[]) {
        int temp;
        boolean swapped;

        for (int pass = 0; pass < A.length - 1; pass++) {
            swapped = false;
            for (int x = 0; x < A.length - 1 - pass; x++) {
                if (A[x + 1] < A[x]) {
                    temp = A[x + 1];
                    A[x + 1] = A[x];
                    A[x] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }

    }
}