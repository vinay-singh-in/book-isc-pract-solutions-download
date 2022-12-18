import java.util.*;

class ISBN {
    private String isbn;
    private int sum;

    public ISBN(String isbn) {
        this.isbn = isbn;
        if (isbn.length() != 10)
            throw new IllegalArgumentException();

        for (int position = 0; position < 9; position++) {
            if (!Character.isDigit(isbn.charAt(position))) {
                throw new IllegalArgumentException();
            }
        }
        char lastCharacter = isbn.charAt(9);
        if (!(Character.isDigit(lastCharacter) || (lastCharacter == 'x' || lastCharacter == 'X'))) {
            throw new IllegalArgumentException();
        }
        computeSum();
    }

    public void computeSum() {
        int digit;
        for (int position = 0; position < isbn.length(); position++) {
            // Note that the character from 0 to 9 has codes from 48 to 57
            digit = isbn.charAt(position) - '0'; // '0' will result in subtraction of 48
            digit = (digit == 40 || digit == 72) ? 10 : digit;
            sum += digit * (10 - position);
        }
    }

    public int getSum() {
        return sum;
    }
}

class ISC2013Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT CODE:\t");
        String isbn = in.nextLine();
        try {
            ISBN objISBN = new ISBN(isbn);
            System.out.println("OUTPUT:\tSUM = " + objISBN.getSum());
            if (objISBN.getSum() % 11 == 0) {
                System.out.println("\tLEAVES NO REMAINDER – VALID ISBN CODE");
            } else {
                System.out.println("\tLEAVES REMAINDER – INVALID ISBN CODE");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("OUTPUT : INVALID INPUT");
        }
        in.close();
    }
}