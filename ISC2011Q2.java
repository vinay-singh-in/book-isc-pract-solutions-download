import java.util.*;

class Encrypt {
    private String sentence[], answer;

    public Encrypt(String sentence[]) {
        this.sentence = sentence.clone();
        answer = "";
        encrypt();
    }

    private void encrypt() {
        int lineCount = 0;
        char ch;
        String output, words[];
        for (String line : sentence) {
            output = "";
            lineCount++;
            line = line.substring(0, line.length() - 1);
            if (lineCount % 2 == 1) {
                // odd line
                for (int position = 0; position < line.length(); position++) {
                    ch = line.charAt(position);
                    if (Character.isLetter(ch)) {
                        ch = (char) (ch + 2);
                        if (ch > 'Z')
                            ch = (char) (ch - 26);

                    }
                    output += ch;
                }

            } else {
                // even line
                words = line.split(" ");
                for (String word : words) {
                    output = word + " " + output;
                }
            }
            output = output.trim();
            output += ".";
            answer += output + "\n";
        }
    }

    public String toString() {
        return answer;
    }
}

class ISC2011Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT:\tn = ");
        int n = in.nextInt();
        in.nextLine();
        if (n > 1 && n < 10) {
            String sentence[] = new String[n];
            for (int i = 0; i < n; i++) {
                sentence[i] = in.nextLine();
            }
            Encrypt obj = new Encrypt(sentence);
            System.out.println("OUTPUT:");
            System.out.println(obj);
        } else {
            System.out.println("OUTPUT\t:INVALID ENTRY");
        }
        in.close();
    }
}