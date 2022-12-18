import java.util.*;

class ISC2018Q1 {
    private static int primes[] = { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT: N = ");
        int N = in.nextInt();
        System.out.println("OUTPUT: ");

        if (N > 9 && N < 50) {
            if (N % 2 == 0) {
                System.out.println("PRIME PAIRS ARE:");
                int half = N / 2;
                for (int i = 0; primes[i] <= half; i++) {
                    if (isPrime(N - primes[i])) {
                        System.out.println(primes[i] + ", " + (N - primes[i]));
                    }
                }
            } else {
                System.out.println("INVALID INPUT. NUMBER IS ODD");
            }
        } else {
            System.out.println("INVALID INPUT. NUMBER OUT OF RANGE.");

        }
        in.close();
    }

    public static boolean isPrime(int number) {

        // for( int i=0;i<primes.length;i++){
        //     if(number==primes[i]) return true;
        // }
        for (int prime : primes) {
            if (number == prime)
                return true;
        }

        return false;
    }
}