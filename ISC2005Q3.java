import java.util.*;

class Anagram {
    private String word, output;
    private int count;

    public Anagram(String word) {
        this.word = word;
        char s[] = word.toCharArray();
        output = "";
        count = 0;
        permute(s, 0);
    }

    public void permute(char s[], int k) {
        if (k == s.length - 1) {
            output += new String(s) + "\n";
            count++;
        } else {
            char temp;
            for (int i = k; i < s.length; i++) {
                if (s[i] == s[k] && i != k)
                    continue;
                temp = s[k];
                s[k] = s[i];
                s[i] = temp;
                permute(s, k + 1);
                temp = s[k];
                s[k] = s[i];
                s[i] = temp;
            }
        }
    }

    public String toString() {
        return output;
    }

    public int length() {
        return count;
    }
}

class ISC2012Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("INPUT:");
        String word = in.next();
        Anagram obj = new Anagram(word);
        System.out.println("OUTPUT:\n" + obj);
        System.out.println("Total number of anagrams=" + obj.length());
        in.close();
    }
}
