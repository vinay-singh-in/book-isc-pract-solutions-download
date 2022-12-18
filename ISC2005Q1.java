import java.util.*;

class MyString {
    private String sentence, words[], output;

    public MyString(String sentence) {
        this.sentence = sentence.toLowerCase();
        arrange();
    }

    private void arrange() {
        String temp;
        boolean swapped;
        words = sentence.split("[ .]+");
        for (int i = 0; i < words.length - 1; i++) {
            swapped = false;
            for (int x = 0; x < words.length - 1 - i; x++) {
                if (words[x + 1].length() > words[x].length()) {
                    temp = words[x + 1];
                    words[x + 1] = words[x];
                    words[x] = temp;
                    swapped = true;
                } else if (words[x + 1].length() == words[x].length()) {
                    if (words[x + 1].compareTo(words[x]) < 0) {
                        temp = words[x + 1];
                        words[x + 1] = words[x];
                        words[x] = temp;
                        swapped = true;
                    }
                }
            }
            if (!swapped)
                break;
        }
        assemble();
    }

    private void assemble() {
        output = "";
        for (String word : words) {
            output += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
        }
        output = output.trim() + ".";
    }

    public String toString() {
        return output;
    }
}

class ISC2005Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sentence;
        System.out.println("INPUT:");
        sentence = in.nextLine();
        MyString str = new MyString(sentence);
        System.out.println("OUTPUT:\n" + str);

        in.close();
    }
}