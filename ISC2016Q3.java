import java.util.*;

class Sentence {
    private String sentence, answer;
    private static String vowels = "AEIOUaeiou";

    public Sentence(String sentence) {
        this.sentence = sentence;
        answer = "";
    }

    private static boolean isVowel(char ch) {
        return vowels.indexOf(ch) >= 0;
    }

    public int countWordsLeadingAndTrailingVowels() {
        int count = 0;
        String sentenceCopy = sentence.substring(0, sentence.length() - 1);
        String wordList[] = sentenceCopy.split(" ");
        String beginingPart = "", endingPart = "";
        for (String word : wordList) {
            if (word.length() == 0)
                continue;
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                beginingPart += word + " ";
                count++;
            } else {
                endingPart += word + " ";
            }
        }
        answer = beginingPart + endingPart;
        return count;
    }

    public boolean isValid() {
        String terminators = ".?!";
        return terminators.indexOf(sentence.charAt(sentence.length() - 1)) >= 0;
    }

    public String toString() {
        return answer.trim();
    }
}

class ISC2016Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\t");
        String source = in.nextLine();
        Sentence sentence = new Sentence(source);
        if (sentence.isValid()) {
            int count = sentence.countWordsLeadingAndTrailingVowels();
            System.out.println("OUTPUT:\tNUMBER OF WORDS BEGINNING AND ENDING WITH A VOWEL = " + count);
            System.out.println("\t" + sentence);
        } else {
            System.out.println("OUTPUT:\tINVALID INPUT");
        }
        in.close();
    }
}
