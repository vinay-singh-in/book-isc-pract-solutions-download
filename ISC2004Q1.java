import java.util.*;

class Base {
    private String X, Y;
    private String output;
    private boolean found;

    public Base(String X, String Y) {
        this.X = X;
        this.Y = Y;
        process();
    }

    private void process() {
        int value1, value2;
        output = "";
        found = false;
        int initial_i = maximumDigit(X) + 1;
        int initial_x = maximumDigit(Y) + 1;

        for (int i = initial_i; i <= 20; i++) {
            value1 = convertFromBaseNToDecimal(X, i);
            for (int x = initial_x; x <= 20; x++) {
                value2 = convertFromBaseNToDecimal(Y, x);
                if (value1 == value2) {
                    output += X + "(base " + i + ") = " + Y + "(base " + x + ")\n";
                    found = true;
                }
                if (found)
                    break;
            }

        }
    }

    public String toString() {
        if (found)
            return output;
        else
            return X + " is not equal to " + Y + " in any base between 2 to 20";
    }

    private static int convertFromBaseNToDecimal(String number, int baseN) {
        int answer = 0;
        number = number.toUpperCase();
        int length = number.length();
        int digit, multiplier;
        for (int i = 0; i < length; i++) {
            multiplier = (int) Math.pow(baseN, length - i - 1);
            if (Character.isDigit(number.charAt(i))) {
                digit = (number.charAt(i) - '0');
            } else {
                digit = (number.charAt(i) - 55);
            }
            answer += digit * multiplier;
        }
        return answer;
    }

    private static int maximumDigit(String strNumber) {
        int i, result = 0, l = strNumber.length();
        int digit;
        for (i = 0; i <= l - 1; i++) {
            digit = digitValue(strNumber.charAt(i));
            if (digit > result)
                result = digit;
        }
        return result;
    }

    private static int digitValue(char c) {
        int result = 0;
        if (Character.isDigit(c))
            result = c - '0';
        else
            result = c - 'A' + 10;
        return result;
    }
}

class ISC2004Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("INPUT:");
        System.out.print("X = ");
        String X = in.nextLine();
        System.out.print("Y = ");
        String Y = in.nextLine();
        Base b = new Base(X, Y);
        System.out.println("OUTPUT:\n" + b);

        in.close();
    }
}