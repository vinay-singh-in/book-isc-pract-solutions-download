import java.util.*;

public class ISC2018Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT: N = ");
        int N = in.nextInt();
        in.nextLine();
        if (N > 2 && N < 9) {
            int max = 0;
            String team[] = new String[N];
            for (int i = 0; i < N; i++) {
                System.out.print("Team " + (i + 1) + ": ");
                team[i] = in.nextLine();
                if (team[i].length() > max)
                    max = team[i].length();
            }
            System.out.println("OUTPUT");
            for (int row = 0; row < max; row++) {
                for (int col = 0; col < N; col++) {
                    if (row < team[col].length()) {
                        System.out.print(team[col].charAt(row) + "\t");
                    } else {
                        System.out.print("\t");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("OUTPUT:\nINVALID INPUT");
        }
        in.close();
    }
}
