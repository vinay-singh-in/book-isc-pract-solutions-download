import java.util.*;

class ISC2017Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT : N = ");
        int N = in.nextInt();
        if (N < 1 || N > 1000) {
            System.out.println("OUTPUT: INVALID INPUT");
        } else {
            System.out.println("OUTPUT:");
            int cartons[] = { 48, 24, 12, 6 }, count = 0, totalCartons = 0, quantity = N;
            for (int i = 0; i < cartons.length; i++) {
                count = quantity / cartons[i];
                if (count > 0) {
                    System.out.printf("\t\t\t\t%4d x %4d = %4d\n", cartons[i], count, (cartons[i] * count));
                }
                totalCartons += count;
                quantity = quantity % cartons[i];
            }
            if (quantity == 0) {
                System.out.printf("%-43s = %4d\n", "Remaining boxes", N);
            } else {
                System.out.printf("%-31s %4d x %4d = %4d\n", "Remaining boxes", quantity, 1, quantity);
            }
            System.out.printf("%-43s = %4d\n", "Total mumber of boxes", N);
            System.out.printf("%-43s = %4d\n", "Total mumber of cartons", totalCartons);
        }
        in.close();
    }
}