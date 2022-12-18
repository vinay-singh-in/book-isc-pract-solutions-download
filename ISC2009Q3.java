import java.util.*;

class Sentence {
    private String sentence, word[], output;

    public Sentence(String sentence) {
        this.sentence = sentence.toLowerCase();
        word = this.sentence.split("[ .]");
        sort();
    }

    public void sort() {
        String temp;
        boolean swapped;
        for (int pass = 0; pass < word.length - 1; pass++) {
            swapped = false;
            for (int position = 0; position < word.length - 1 - pass; position++) {
                if (word[position + 1].length() < word[position].length()) {
                    temp = word[position + 1];
                    word[position + 1] = word[position];
                    word[position] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
            beautify();
        }
    }

    public void beautify() {
        output = Character.toUpperCase(word[0].charAt(0)) + word[0].substring(1);
        for (int i = 1; i < word.length; i++) {
            output += " " + word[i];
        }
        output = output.trim() + ".";
    }

    public String toString() {
        return output;
    }
}

public class ISC2009Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\t");
        String sentence = in.nextLine();
        Sentence obj = new Sentence(sentence);
        System.out.println("OUTPUT:\t" + obj);
        in.close();
    }
}
