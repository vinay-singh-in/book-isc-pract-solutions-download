import java.util.*;

public class ISC2019Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("INPUT");
        String sentence = in.nextLine();
        MyString str = new MyString(sentence);
        System.out.println("OUPUT");
        if (str.isValid()) {
            System.out.println(sentence);
            str.convertToPalindrome();
            System.out.println(str);
        } else {
            System.out.println("INVALID INPUT");
        }
        in.close();
    }
}

class MyString {
    private String sentence, words[];

    public MyString(String sentence) {
        this.sentence = sentence;
    }

    public boolean isValid() {
        return ".?!".indexOf(sentence.charAt(sentence.length() - 1)) >= 0;
    }

    public void convertToPalindrome() {
        String reverse = "";
        int delta;
        sentence = sentence.substring(0, sentence.length() - 1);
        words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (!isPalindrome(words[i])) {
                reverse = "";
                if (words[i].length() > 2
                        && words[i].charAt(words[i].length() - 1) == words[i].charAt(words[i].length() - 2)) {
                    delta = 1;
                } else {
                    delta = 0;
                }
                for (int position = 0; position < words[i].length() - 1 - delta; position++) {
                    reverse = words[i].charAt(position) + reverse;
                }
                words[i] = words[i] + reverse;
            }
        }
    }

    public static boolean isPalindrome(String source) {
        int half = source.length() / 2;
        for (int position = 0; position <= half; position++) {
            if (source.charAt(position) != source.charAt(source.length() - 1 - position))
                return false;
        }
        return true;
    }

    public String toString() {
        String output = "";
        for (String word : words) {
            output += word + " ";
        }
        return output;
    }
}
