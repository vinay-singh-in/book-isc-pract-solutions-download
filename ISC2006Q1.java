import java.util.*;

class ConsecutiveIntegers {
    private int N;
    private String output;
    private boolean found;

    public ConsecutiveIntegers(int N) {
        this.N = N;
        found = false;
        findSum();
    }

    public void findSum() {
        output = "";
        int half = N / 2;
        for (int beg = 1, end = 1, sum = 1; beg <= half;) {
            if (sum < N) {
                end += 1;
                sum += end;
            } else if (sum > N) {
                sum -= beg;
                beg += 1;
            } else if (sum == N) {
                output += "\t";
                for (int term = beg; term <= end; term++) {
                    output += term;
                    if (term < end)
                        output += " + ";
                }
                output += "\n";
                found = true;
                sum -= beg;
                beg += 1;
            }
        }
    }

    public String toString() {
        if (found)
            return output;
        else
            return "\tNO SOLUTION EXISTS";
    }
}

class ISC2006Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tN = ");
        int N = in.nextInt();
        ConsecutiveIntegers obj = new ConsecutiveIntegers(N);
        System.out.println("OUTPUT:\n" + obj);
        in.close();
    }
}