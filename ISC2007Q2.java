import java.util.*;

class Sentence {
    private String sentence, output;

    public Sentence(String lines) {
        this.sentence = lines;
        output = "";
        reverseWords();
    }

    private void reverseWords() {
        String words[] = sentence.split("[',;:.\n\t ]+");
        output = words[0];
        for (int i = 1; i < words.length; i++) {
            output = words[i] + " " + output;
        }
    }

    public String toString() {
        return output;
    }
}

class ISC2007Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String lines = "";
        System.out.print("INPUT:\t");
        int N = in.nextInt();
        in.nextLine();
        for (int i = 0; i < N; i++) {
            lines += in.nextLine();
        }
        Sentence obj = new Sentence(lines);
        System.out.println("OUTPUT:\n" + obj);

        in.close();
    }
}