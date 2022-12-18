import java.util.*;

class Quiz {
    private int N;
    private char response[][], answer[];
    private int score[], highestScore;

    public Quiz(int N) {
        this.N = N;
        response = new char[N][5];
        answer = new char[5];
        score = new int[N];
    }

    public void input() {
        Scanner in = new Scanner(System.in);
        String input;

        for (int participant = 0; participant < N; participant++) {
            System.out.printf("%-10s %15s ", "", "Participant " + (participant + 1) + " ");
            input = in.nextLine();
            for (int question = 0; question < 5; question++) {
                response[participant][question] = input.charAt(2 * question);
            }
        }
        System.out.printf("%-10s %15s ", "", "Key: ");
        input = in.nextLine();
        for (int question = 0; question < 5; question++) {
            answer[question] = input.charAt(2 * question);
        }
        in.close();
    }

    public void display() {
        for (int row = 0; row < N; row++) {
            System.out.println(Arrays.toString(response[row]));
        }

        System.out.println(Arrays.toString(answer));

    }

    public void prepareResult() {
        int max = 0, question, participant;
        for (question = 0; question < 5; question++) {
            for (participant = 0; participant < N; participant++) {
                if (response[participant][question] == answer[question]) {
                    score[participant]++;
                }
                if (score[participant] > max) {
                    max = score[participant];
                }
            }

        }
        highestScore = max;
    }

    public void displayResult() {
        System.out.printf("%-10s %-15s \n", "OUTPUT:", "Scores");
        for (int participant = 0; participant < N; participant++) {
            System.out.printf("%-10s %15s \n", "", "Participant " + (participant + 1) + " = " + score[participant]);
        }
        String msg = "Highest score: ";
        for (int participant = 0; participant < N; participant++) {
            if (highestScore == score[participant]) {
                System.out.printf("%-10s %15s %-20s\n", "", msg, "Participant " + (participant + 1));
                msg = "";
            }
        }
    }
}

public class ISC2017Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("%-10s %15s ", "INPUT:", "N = ");
        int N = in.nextInt();
        Quiz quiz = new Quiz(N);
        quiz.input();
        //quiz.display();
        quiz.prepareResult();
        quiz.displayResult();
        in.close();
    }
}
