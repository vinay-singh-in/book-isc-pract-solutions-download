import java.util.*;

class CopyProtectionCode {
    private String code, output;
    private static String validCharacters = "ACEGIKacegik";
    private int N;

    public CopyProtectionCode(String code, int N) {
        this.code = code;
        this.N = N;
        validate();
    }

    private void validate() {
        if (N != code.length()) {
            output = "Invalid! String length not the same as specified!";
            return;
        }
        char ch;
        int foundAtPosition;
        for (int position = 0; position < code.length(); position++) {
            ch = code.charAt(position);
            foundAtPosition = validCharacters.indexOf(ch);
            if (foundAtPosition == -1) {
                output = "Invalid! Only alternate letters permitted!";
                return;
            }
            if (foundAtPosition > 5) {
                output = "Invalid! Only upper case letters permitted!";
                return;
            }
            if (code.lastIndexOf(ch) != position) {
                output = "Invalid! Repetition of characters not permitted!";
                return;
            }
            output = "Valid!";
        }
    }

    public String toString() {
        return output;
    }
}

public class ISC2006Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\t");
        int N = in.nextInt();
        in.nextLine();
        if (N > 6) {
            System.out.println("OUTPUT:\nError! Length of string should not exceed 6 characters!");
        } else {
            String code = in.nextLine();
            CopyProtectionCode obj = new CopyProtectionCode(code, N);
            System.out.println("OUTPUT:\n" + obj);
        }

        in.close();
    }
}
