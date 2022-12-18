import java.util.*;

class ISC2020Q1 {
    // public static boolean isPrimeNumber(int n){
    //  int count=0;
    //  for( int divisor=1; divisor<=n; divisor++){
    //      if(n%divisor==0) count++;
    //  }
    //  return count==2;
    // }
    public static boolean isPrimeNumber(int n) {
        if (n < 2)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        else {
            int limit = (int) Math.sqrt(n);
            for (int divisor = 3; divisor <= limit; divisor += 2) {
                if (n % divisor == 0)
                    return false;
            }
        }
        return true;
    }

    public static int getReverse(int n) {
        int reverse = 0;
        for (int temp = n; temp > 0; temp /= 10) {
            reverse = reverse * 10 + temp % 10;
        }
        return reverse;
    }

    public static boolean isAdamNumber(int n) {
        int reverse = getReverse(n);
        return n * n == getReverse(reverse * reverse);
    }

    public static boolean isPrimeAdamNumber(int n) {
        return isAdamNumber(n) && isPrimeNumber(n);
    }

    public static void main(String[] args) {
        int m, n;
        Scanner input = new Scanner(System.in);
        System.out.println("INPUT:");
        System.out.print("m = ");
        m = input.nextInt();

        System.out.print("n = ");
        n = input.nextInt();

        System.out.println("OUTPUT:");
        if (m <= n) {
            int frequency = 0;
            System.out.println("THE PRIME-ADAM INTEGERS ARE:");
            for (int i = m; i <= n; i++) {
                if (isPrimeAdamNumber(i)) {
                    frequency++;
                    System.out.print(i + " ");
                }
            }
            if (frequency == 0) {
                System.out.println("\bNIL");
            } else {
                System.out.println("\b\nFREQUENCY OF PRIME-ADAM INTEGERS IS: " + frequency);
            }
        } else {
            System.out.println("INVALID INPUT");
        }
        input.close();
    }
}