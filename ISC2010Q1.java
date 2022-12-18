import java.util.*;

class Amount {
    private int amount;
    private String output;
    private static String digit[] = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
    private static int notes[] = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };

    public Amount(int amount) {
        this.amount = amount;
        output = "";
        digitsToWord();
    }

    public String toString() {
        return output;
    }

    public void digitsToWord() {
        for (int temp = amount; temp > 0; temp /= 10) {
            output = digit[temp % 10] + " " + output;
        }
        output = output.trim();
    }

    public void showDenomination() {
        System.out.println("\tDENOMINATION");
        int quantity, amt = amount, noteCount = 0;
        for (int note : notes) {
            quantity = amt / note;
            if (quantity > 0) {
                System.out.printf("\t%-8d x %-13d = %9d\n", note, quantity, (note * quantity));
                noteCount += quantity;
            }
            amt %= note;
        }
        System.out.printf("\tTOTAL                   =  %9d\n", amount);
        System.out.printf("\tTOTAL NUMBER OF NOTES   =  %9d\n", noteCount);
    }
}

class ISC2010Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\t");
        int amount = in.nextInt();
        Amount amt = new Amount(amount);
        System.out.println("OUTPUT:\t" + amt);
        amt.showDenomination();
        in.close();
    }
}