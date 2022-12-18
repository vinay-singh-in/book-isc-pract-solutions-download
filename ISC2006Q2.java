import java.util.*;

class MyArray {
    private String A[], B[], C[];

    public MyArray(String A[], String B[]) {
        this.A = A;
        this.B = B;
        C = new String[A.length + B.length];
        sort();
    }

    private void sort() {
        Arrays.sort(A);
        Arrays.sort(B);
        merge();
    }

    private void merge() {
        int indexA, indexB, indexC;
        indexA = indexB = indexC = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA].compareTo(B[indexB]) < 0) {
                C[indexC++] = A[indexA++];
            } else {
                C[indexC++] = B[indexB++];
            }
        }
        if (indexA < A.length) {
            for (int i = indexA; i < A.length; i++) {
                C[indexC++] = A[indexA++];
            }
        } else if (indexB < B.length) {
            for (int i = indexB; i < B.length; i++) {
                C[indexC++] = B[indexB++];
            }
        }
    }

    public String toString() {
        String output = "";
        output += "Sorted Merged array: (C)\n";
        for (String name : C) {
            output += name + "\n";
        }

        output += "Sorted first array: (A)\n";
        for (String name : A) {
            output += name + "\n";
        }

        output += "Sorted second array: (B)\n";
        for (String name : B) {
            output += name + "\n";
        }

        return output;
    }
}

public class ISC2006Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("INPUT:");
        System.out.print("Enter number of names in Array A, N = ");
        int N = in.nextInt();
        System.out.print("Enter number of names in Array B, M = ");
        int M = in.nextInt();
        in.nextLine();

        String A[] = new String[N];
        String B[] = new String[M];

        System.out.println("First array: (A)");
        for (int i = 0; i < N; i++) {
            A[i] = in.nextLine();
        }

        System.out.println("First array: (B)");
        for (int i = 0; i < M; i++) {
            B[i] = in.nextLine();
        }

        MyArray obj = new MyArray(A, B);

        System.out.println("OUTPUT:");
        System.out.println(obj);

        in.close();
    }
}
