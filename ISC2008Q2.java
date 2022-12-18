import java.util.*;

class Text {
    private String sentence[];
    static String vowels = "aeiouAEIOU";
    private int word[], vowel[], max;

    public Text(String paragraph) {
        sentence = paragraph.split("[.,?!]");
        word = new int[sentence.length];
        vowel = new int[sentence.length];

        System.out.println(Arrays.toString(sentence));
        computeStats();
    }

    private static boolean isVowel(char ch) {
        return vowels.indexOf(ch) >= 0;
    }

    private void computeStats() {
        char ch;
        max = 0;
        sentence[0] = " " + sentence[0];
        for (int i = 0; i < sentence.length; i++) {
            for (int j = 0; j < sentence[i].length(); j++) {
                ch = sentence[i].charAt(j);
                if (ch == ' ')
                    word[i]++;
                if (isVowel(ch))
                    vowel[i]++;
            }
            if (vowel[i] > max)
                max = vowel[i];
            if (word[i] > max)
                max = word[i];
        }
    }

    public void showStats() {
        System.out.println("Sentence\tNo. of Vowels\tNo. of words");
        for (int i = 0; i < sentence.length; i++) {
            System.out.println((i + 1) + "\t\t" + vowel[i] + "\t\t" + word[i]);
        }
    }

    private String repeat(char what, int times) {
        String output = "";
        for (int i = 1; i <= times; i++) {
            output += what;
        }
        return output;
    }

    public void plotHistogram() {
        int width = 50;
        float scalingFactor = width / max;
        System.out.println("Sentence\tNo. of vowels / words");
        for (int i = 0; i < sentence.length; i++) {
            System.out.println((i + 1) + "\t" + repeat('V', (int) (vowel[i] * scalingFactor)));
            System.out.println("\t" + repeat('W', (int) (word[i] * scalingFactor)));
        }
        System.out.println("Scale used 1:" + scalingFactor);
    }
}

public class ISC2008Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\t");
        String paragraph = in.nextLine();
        Text obj = new Text(paragraph);

        System.out.println("OUTPUT:");
        obj.showStats();
        obj.plotHistogram();
        in.close();
    }
}
