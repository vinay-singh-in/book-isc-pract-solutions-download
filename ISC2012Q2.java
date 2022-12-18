import java.util.*;

class Sentence {
    private String sentence, output;
    private int length;

    public Sentence(String sentence) {
        this.sentence = sentence.substring(0, sentence.length() - 1);
        process();
    }

    private void process() {
        String word[] = sentence.split(" ");
        length = word.length;
        sort(word);
        output = "";
        for (String w : word) {
            output += w + " ";
        }
        output = output.trim();
    }

    private void sort(String word[]) {
        String temp;
        boolean swapped;
        for (int pass = 0; pass < word.length - 1; pass++) {
            swapped = false;
            for (int pos = 0; pos < word.length - 1 - pass; pos++) {
                if (word[pos + 1].compareTo(word[pos]) < 0) {
                    temp = word[pos + 1];
                    word[pos + 1] = word[pos];
                    word[pos] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        return output;
    }
}

public class ISC2012Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\n\t");
        String sentence = in.nextLine();
        Sentence obj = new Sentence(sentence);
        System.out.println("OUTPUT:\n\tLENGTH IS: " + obj.getLength());
        System.out.println("\tREARRANGED SENTENCE");
        System.out.println("\t" + obj);
        in.close();
    }
}
