import java.util.*;

class Sentence {
    private String sentence;
    private static String vowels = "aeiouAEIOU";

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public boolean isValid() {
        return (new String(".?")).indexOf(sentence.charAt(sentence.length() - 1)) >= 0;
    }

    public String toString() {
        String output = "";
        String source = sentence.substring(0, sentence.length() - 1);
        String wordList[] = source.split(" ");
        for (String word : wordList) {
            output += Character.toUpperCase(word.charAt(0)) + (word.substring(1)).toLowerCase() + " ";
        }
        return output.trim();
    }

    private static boolean isVowel(char ch) {
        return vowels.indexOf(ch) >= 0;
    }

    private static boolean isConsonant(char ch) {
        return Character.isLetter(ch) && !isVowel(ch);
    }

    public void displayStats() {
        System.out.printf("%-15s %-12s %-12s\n", "Word", "Vowels", "Consonants");
        String source = sentence.substring(0, sentence.length() - 1);
        String wordList[] = source.split(" ");
        String titleCase = "";
        int vowels = 0, consonants = 0;
        char ch;
        for (String word : wordList) {
            titleCase = Character.toUpperCase(word.charAt(0)) + (word.substring(1)).toLowerCase() + " ";
            vowels = 0;
            consonants = 0;
            for (int position = 0; position < titleCase.length(); position++) {
                ch = titleCase.charAt(position);
                if (isVowel(ch))
                    vowels++;
                else if (isConsonant(ch))
                    consonants++;
            }
            System.out.printf("%-15s %-12d %-12d\n", titleCase, vowels, consonants);
        }
    }
}

class ISC2015Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\t");
        String input = in.nextLine();
        System.out.print("OUTPUT:\t");
        Sentence objSentence = new Sentence(input);
        if (objSentence.isValid()) {
            System.out.println(objSentence);
            objSentence.displayStats();
        } else {
            System.out.println("INVALID INPUT");
        }
        in.close();
    }
}