import java.util.*;

class Palindrome {
    private String sentence, answer;
    private int frequency;

    public Palindrome(String sentence) {
        this.sentence = sentence;
        frequency = 0;
        answer = "";
        process();
    }

    private boolean isPalindrome(String word) {
        int half = word.length() / 2;
        for (int position = 0; position < half; position++) {
            if (word.charAt(position) != word.charAt(word.length() - 1 - position))
                return false;
        }
        return true;
    }

    private void process() {
        char ch;
        String delimters = ".?! ", word = "";
        for (int position = 0; position < sentence.length(); position++) {
            ch = sentence.charAt(position);
            if (delimters.indexOf(ch) >= 0) {
                if (isPalindrome(word)) {
                    answer += word + " ";
                    frequency++;
                }
                word = "";
            } else {
                word += ch;
            }
        }
    }

    public int getFrequency() {
        return frequency;
    }

    public String toString() {
        return answer.trim();
    }
}

public class ISC2013Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\t");
        String sentence = in.nextLine();
        Palindrome objPalindrome = new Palindrome(sentence);
        System.out.print("OUTPUT:\t");
        if (objPalindrome.getFrequency() > 0) {
            System.out.println(objPalindrome);
            System.out.println("\tNUMBER OF PALINDROMIC WORDS: " + objPalindrome.getFrequency());
        } else {
            System.out.println("NO PALINDROMIC WORDS");
        }
        in.close();
    }
}
