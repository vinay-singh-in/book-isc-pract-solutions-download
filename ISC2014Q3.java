import java.util.*;

class Sentence {
    private String source, wordList[], answer;
    private char terminator;

    public Sentence(String source) {
        this.source = source;
    }

    public boolean isValid() {
        terminator = source.charAt(source.length() - 1);
        return (new String(".?!")).indexOf(terminator) > -1;
    }

    public void delete(String wordToBeDeleted, int position) {
        answer = "";
        wordList = source.split(" ");
        System.out.println(Arrays.toString(wordList));
        int wordCount = 0;
        for (String word : wordList) {
            if (word.length() == 0)
                continue;
            wordCount++;
            if (wordCount == position && word.equals(wordToBeDeleted))
                continue;
            answer += word + " ";
        }
    }

    public String toString() {
        return answer.trim();
    }
}

class ISC2014Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\t");
        String source = in.nextLine();
        Sentence objSentence = new Sentence(source);

        if (objSentence.isValid()) {
            System.out.print("WORD TO BE DELETED: ");
            String wordToBeDeleted = in.nextLine();
            System.out.print("WORD POSITION IN THE SENTENCE: ");
            int position = in.nextInt();
            objSentence.delete(wordToBeDeleted, position);
            System.out.println("OUTPUT:\t" + objSentence);
        } else {
            System.out.println("OUTPUT:\tINVALID INPUT.");
        }
        in.close();
    }
}