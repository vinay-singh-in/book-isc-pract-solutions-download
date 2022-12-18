import java.util.*;

class Message {
    private String encodedMessage, decodedMessage;

    public Message(String encodedMessage) {
        this.encodedMessage = encodedMessage;
        decode();
    }

    private void decode() {
        String temp = "";
        decodedMessage = "";
        int number;
        for (int index = encodedMessage.length() - 1; index >= 0; index--) {
            temp += encodedMessage.charAt(index);
            number = Integer.parseInt(temp);
            if (number == ' ' || Character.isLetter(number)) {
                decodedMessage += (char) number;
                temp = "";
            }
        }
    }

    public String toString() {
        return decodedMessage;
    }
}

public class ISC2004Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("INPUT:\nEncoded Message:");
        String encodedMessage = in.next();
        Message msg = new Message(encodedMessage);
        System.out.println("OUTPUT:\nDecoded Message:\t" + msg);

        in.close();
    }
}
