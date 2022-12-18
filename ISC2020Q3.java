import java.util.*;

class MyString {
    private String sentence, words[];

    public MyString(String sentence) {
        this.sentence = sentence;
    }

    public boolean isValid() {
        return ".,?!".indexOf(sentence.charAt(sentence.length() - 1)) >= 0;
    }

    public void arrange() {
        String temp;
        sentence = sentence.substring(0, sentence.length() - 1); // take everything except the last character
        words = sentence.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            for (int x = 0; x < words.length - 1 - i; x++) {
                if (words[x + 1].length() < words[x].length()) {
                    temp = words[x + 1];
                    words[x + 1] = words[x];
                    words[x] = temp;
                } else if (words[x + 1].length() == words[x].length()) {
                    if (words[x + 1].compareTo(words[x]) < 0) {
                        temp = words[x + 1];
                        words[x + 1] = words[x];
                        words[x] = temp;
                    }
                }
            }
        }
    }

    public String toString() {
        String output = "";
        // for( int i=0; i<words.length;i++){
        // output+=words[i]+" ";
        // }
        for (String word : words) {
            output += word + " ";
        }
        return output.trim(); // return output+"\b"
    }
}

public class ISC2020Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sentence;
        System.out.println("INPUT");
        sentence = in.nextLine();
        System.out.println("OUTPUT");
        MyString str = new MyString(sentence);
        if (str.isValid()) {
            System.out.println(sentence);
            str.arrange();
            System.out.println(str);
        } else {
            System.out.println("INVALID INPUT");
        }
        in.close();
    }
}
