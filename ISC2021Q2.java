import java.util.*;

class Paragraph {
    private String paragraph, sentence[], delimiters, output;

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
        delimiters = ".?!";
    }

    public boolean isValid() {
        char ch = ' ';
        int wordCount = 0;
        boolean terminatorAtEnd = false;
        for (int position = 0; position < paragraph.length(); position++) {
            ch = paragraph.charAt(position);
            if (delimiters.indexOf(ch) >= 0) { //delimiter found
                wordCount++;
                if (position == paragraph.length() - 1) {
                    terminatorAtEnd = true;
                }
            }
        }
        return wordCount == 2 && terminatorAtEnd;
    }

    public void seperate() {
        /*
         * The method split() will return an array 
         * of strings (that is the two sentences)
         * and the split will take place wherever one or 
         * more of the terminating characters are occuring.
         * Check https://youtu.be/i00OWGPu6uQ for video.
         */
        sentence = paragraph.split("[.!?,]+");
        System.out.println(sentence[0].trim());
        System.out.println(sentence[1].trim());
    }

    public static String[] getCommonWords(String wordList1[], String wordList2[]) {
        String commonWords = "";
        for (int i = 0; i < wordList1.length; i++) {
            for (int j = 0; j < wordList2.length; j++) {
                if (wordList1[i].equals(wordList2[j])) {
                    if (commonWords.indexOf(wordList1[i]) == -1) {
                        commonWords = commonWords + (commonWords.length() > 0 ? "," : "") + wordList1[i];
                    }
                }
            }
        }
        return commonWords.split(",");
    }

    public void computeFrequency() {
        String wordList1[] = sentence[0].split("[ ,]+");
        String wordList2[] = sentence[1].split("[ ,]+");
        String commonWord[] = getCommonWords(wordList1, wordList2);
        String word[] = paragraph.split("[,.!? ]+");
        int frequency[] = new int[word.length];
        // Populating the arrays
        int limit = word.length;
        for (int i = 0; i < limit; i++) {
            frequency[i] = 1;
            for (int j = i + 1; j < limit; j++) {
                if (word[i].equals(word[j])) {
                    word[j] = word[limit - 1];
                    frequency[i]++;
                    limit--;
                    j--;
                }
            }
        }

        output = "\tCOMMON WORD\t\tFREQUENCY\n";
        for (int i = 0; i < limit; i++) {
            if (Arrays.asList(commonWord).contains(word[i])) {
                output += "\t" + word[i] + "\t\t\t" + frequency[i] + "\n";
            }
        }
    }

    public void displayFrequencyTable() {
        System.out.println(output);
    }
}

public class ISC2021Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT: ");
        String text = in.nextLine();
        Paragraph para = new Paragraph(text);
        if (para.isValid()) {
            System.out.println("OUTPUT:");
            para.seperate();
            para.computeFrequency();
            para.displayFrequencyTable();
        } else {
            System.out.println("INVALID INPUT");
        }
        in.close();
    }
}