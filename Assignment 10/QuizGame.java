import java.io.*;
import java.util.*;

public class QuizGame {

    static class Question {
        String question;
        String optionA, optionB, optionC, optionD;
        String correctAnswer;

        Question(String q, String a, String b, String c, String d, String ans) {
            question = q;
            optionA = a;
            optionB = b;
            optionC = c;
            optionD = d;
            correctAnswer = ans;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 1. Read player name
            System.out.print("Enter your name: ");
            String playerName = sc.nextLine();

            // 2. Load questions from file
            ArrayList<Question> questions = loadQuestions("gk_questions.txt");

            if (questions.isEmpty()) {
                System.out.println("No questions found! Check file format.");
                return;
            }

            Collections.shuffle(questions); // randomize order

            int score = 0;

            System.out.println("\n===== HIGH SCHOOL GENERAL KNOWLEDGE QUIZ =====\n");

            // 3. Ask questions
            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);

                System.out.println("Q" + (i + 1) + ": " + q.question);
                System.out.println(q.optionA);
                System.out.println(q.optionB);
                System.out.println(q.optionC);
                System.out.println(q.optionD);

                System.out.print("Your Answer (A/B/C/D): ");
                String ans = sc.nextLine().trim().toUpperCase();

                if (ans.equals(q.correctAnswer)) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong! Correct Answer: " + q.correctAnswer + "\n");
                }
            }

            // 4. Save score
            saveScore(playerName, score);

            // 5. Final summary
            System.out.println("===== QUIZ COMPLETE =====");
            System.out.println("Player: " + playerName);
            System.out.println("Score: " + score + " out of " + questions.size());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    // Method to load questions from file
    public static ArrayList<Question> loadQuestions(String filename) throws Exception {
        ArrayList<Question> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));

        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("Q:")) {
                String q = line.substring(3);
                String A = br.readLine();
                String B = br.readLine();
                String C = br.readLine();
                String D = br.readLine();
                String ansLine = br.readLine(); // ANSWER: X
                String correct = ansLine.split(":")[1].trim();
                br.readLine(); // skip empty line

                list.add(new Question(q, A, B, C, D, correct));
            }
        }
        br.close();
        return list;
    }

    // Method to save score
    public static void saveScore(String name, int score) throws Exception {
        FileWriter fw = new FileWriter("quiz_scores.txt", true);
        fw.write(name + " : " + score + " points\n");
        fw.close();
    }
}
