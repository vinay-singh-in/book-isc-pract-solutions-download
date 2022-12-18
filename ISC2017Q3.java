import java.util.*;

class CaesarCipher {
    private String L, msg;

    public CaesarCipher(String L) {
        this.L = L;
    }

    public void encode() {
        msg = "";
        for (int position = 0; position < L.length(); position++) {
            msg += rot13(L.charAt(position));
        }
    }

    private static char rot13(char ch) {
        if (Character.isLetter(ch)) {
            if (ch >= 'A' && ch <= 'M') {
                ch = (char) (ch + 13);
            } else if (ch >= 'N' && ch <= 'Z') {
                ch = (char) (ch - 13);
            } else if (ch >= 'a' && ch <= 'm') {
                ch = (char) (ch + 13);
            } else if (ch >= 'n' && ch <= 'z') {
                ch = (char) (ch - 13);
            }
        }
        return ch;
    }

    public String toString() {
        return "\t" + msg;
    }
}

public class ISC2017Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\t");
        String L = in.nextLine();
        if (L.length() > 3 && L.length() < 100) {
            System.out.println("OUTPUT:\tThe cipher text is:");
            CaesarCipher cipher = new CaesarCipher(L);
            cipher.encode();
            System.out.println(cipher);
        } else {
            System.out.println("OUTPUT:\tINVALID LENGTH");

        }
        in.close();
    }
}
