import java.util.*;

class Frequency {
    private String word[];
    private int frequency[];
    private String output;

    public Frequency(String paragraph) {
        output = "";
        word = paragraph.split("[.?, ]");
        frequency = new int[word.length];
        prepareFrequencyTable();
    }

    private void prepareFrequencyTable() {
        // Populating the arrays
        int limit = word.length;
        for (int i = 0; i < limit; i++) {
            frequency[i] = 1;
            for (int j = i + 1; j < limit; j++) {
                if (word[i].equals(word[j])) {
                    word[j] = word[limit - 1];
                    frequency[i]++;
                    limit--;
                    j--;
                }
            }
        }
        // Sorting the arrays
        int tempFreq;
        String tempWord;
        boolean swapped;
        for (int pass = 0; pass < limit - 1; pass++) {
            swapped = false;
            for (int position = 0; position < limit - 1 - pass; position++) {
                if (frequency[position + 1] < frequency[position]) {
                    tempFreq = frequency[position + 1];
                    frequency[position + 1] = frequency[position];
                    frequency[position] = tempFreq;

                    tempWord = word[position + 1];
                    word[position + 1] = word[position];
                    word[position] = tempWord;

                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        output = "\tWORD\t\tFREQUENCY\n";
        for (int i = 0; i < limit; i++) {
            output += "\t" + word[i] + "\t\t" + frequency[i] + "\n";
        }
    }

    public String toString() {
        return output;
    }

    public int getLength() {
        return word.length;
    }
}

class ISC2010Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("INPUT:");
        System.out.print("\tEnter number of sentences: ");
        int n = in.nextInt();
        in.nextLine();
        if (n >= 1 && n < 4) {
            System.out.print("\tEnter sentences:\n\t");
            String paragraph = in.nextLine();
            Frequency obj = new Frequency(paragraph);
            System.out.println("\tTotal number of words: " + obj.getLength());
            System.out.println(obj);
        } else {
            System.out.println("OUTPUT:\nINVALID ENTRY");
        }
        in.close();
    }
}