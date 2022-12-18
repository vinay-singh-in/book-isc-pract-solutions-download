import java.util.*;

class Matrix {
    private int list[][], n, largest, secondLargest;
    String largestLocation, secondLargestLocation;

    public Matrix(int n) {
        this.n = n;
        list = new int[n][n];
    }

    public void input() {
        Scanner in = new Scanner(System.in);
        System.out.println("List [] []");
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                list[row][col] = in.nextInt();
            }
        }
        in.close();
        compute();
    }

    public void compute() {
        largest = secondLargest = Integer.MIN_VALUE;
        largestLocation = secondLargestLocation = "";
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (list[row][col] > largest) {
                    secondLargest = largest;
                    secondLargestLocation = largestLocation;
                    largest = list[row][col];
                    largestLocation = "row " + (row + 1) + " and column is " + (col + 1);
                } else if (list[row][col] > secondLargest && list[row][col] != largest) {
                    secondLargest = list[row][col];
                    secondLargestLocation = "row " + (row + 1) + " and column is " + (col + 1);
                } else if (list[row][col] == largest) {
                    largestLocation += ", row " + (row + 1) + " and column is " + (col + 1);
                } else if (list[row][col] == secondLargest) {
                    secondLargestLocation += ", row " + (row + 1) + " and column is " + (col + 1);
                }
            }
        }
    }

    public void largestDetails() {
        System.out.println("The largest element " + largest + " is in " + largestLocation);
    }

    public void secondLargestDetails() {
        if (secondLargest != Integer.MIN_VALUE) {
            System.out.println("The second largest element " + secondLargest + " is in " + secondLargestLocation);
        }else{
            System.out.println("No second largest element");
        }
    }
    public void sortRows(){
        for( int row=0; row<n; row++){
            Arrays.sort(list[row]);
        }
    }
    public String toString(){
        String output="";
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                output+=list[row][col];
                if(col<n-1) output+="\t";
            }
            output+="\n";
        }
        return output;
    }
}

class ISC2008Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tN = ");
        int n = in.nextInt();
        Matrix obj = new Matrix(n);
        obj.input();
        System.out.println("OUTPUT:");
        System.out.println(obj);
        obj.largestDetails();
        obj.secondLargestDetails();
        obj.sortRows();
        System.out.println("Sorted list");
        System.out.println(obj);
        in.close();
    }
}