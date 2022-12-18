import java.util.*;

class Number {
    private int n;
    private String answer;

    public Number(int n) {
        this.n = n;
        answer = "";
        convertToWords();
    }

    public void convertToWords() {
        String arr1[] = { "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN",
                "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN" };
        String arr2[] = { "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHT", "NINETY" };
        int factor[] = { 1000000000, 10000000, 100000, 1000, 100, 1 };
        String units[] = { "ARAB", "CRORE", "LAKHS", "THOUSAND", "HUNDRED", "" };
        int quotient, number = n, ones, tens;
        for (int i = 0; i < factor.length; i++) {
            quotient = number / factor[i];
            if (quotient > 0) {
                if (quotient < 20) {
                    answer = answer + arr1[quotient - 1] + " ";
                } else {
                    ones = quotient % 10;
                    tens = quotient / 10;
                    if (ones != 0) {
                        answer += arr2[tens - 2] + " " + arr1[ones - 1] + " ";
                    } else {
                        answer += arr2[tens - 2] + " ";
                    }

                }
                answer += units[i] + " ";
            }

            number = number % factor[i];
            if (number == 0)
                break;
        }
    }

    public String toString() {
        return answer.trim();
    }
}

class ISC2011Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\t");
        int n = in.nextInt();
        if (n > 0 && n < 1000) {
            Number obj = new Number(n);
            System.out.println("OUTPUT:\t" + obj);
        } else {
            System.out.println("OUTPUT: OUT OF RANGE");
        }
        in.close();
    }
}