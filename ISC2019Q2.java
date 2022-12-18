import java.util.*;

class ISC2019Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("INPUT");
        System.out.print("N = ");
        int N = in.nextInt();
        if (N > 2 && N < 10) {
            int a[] = new int[N];
            System.out.print("ENTER ELEMENTS OF SINGLE DIMENSIONAL ARRAY: ");
            for (int i = 0; i < N; i++) {
                a[i] = in.nextInt();
            }
            bubbleSort(a);
            System.out.println("OUTPUT");
            System.out.print("SORTED ARRAY: \nFILLED MATRIX");
            display(a);
            int b[][] = createAndFillMatrix(a);
            display(b);
        } else {
            System.out.println("OUTPUT\nMATRIX SIZE OUT OF RANGE");
        }
        in.close();
    }

    public static int[][] createAndFillMatrix(int a[]) {
        int b[][] = new int[a.length][a.length];
        int offset = 0;
        for (int row = 0; row < b.length; row++) {
            offset = 0;
            for (int col = 0; col < b[row].length; col++) {
                if (col < b.length - row) {
                    b[row][col] = a[col];
                } else {
                    b[row][col] = a[offset++];
                }
            }
        }
        return b;
    }

    public static void bubbleSort(int a[]) {
        int temp;
        for (int pass = 0; pass < a.length - 1; pass++) {
            for (int x = 0; x < a.length - 1 - pass; x++) {
                if (a[x + 1] < a[x]) {
                    temp = a[x + 1];
                    a[x + 1] = a[x];
                    a[x] = temp;
                }
            }
        }
    }

    public static void display(int a[]) {
        for (int n : a) {
            System.out.print(n + " ");
        }
        System.out.println("\b");
    }

    public static void display(int b[][]) {
        for (int row = 0; row < b.length; row++) {
            for (int col = 0; col < b[row].length; col++) {
                System.out.print(b[row][col] + "\t");
            }
            System.out.println("\b");
        }
    }
}