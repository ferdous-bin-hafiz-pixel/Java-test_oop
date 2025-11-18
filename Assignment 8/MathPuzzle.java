import java.io.*;
import java.util.*;

public class MathPuzzle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter difficulty level (EASY/MEDIUM/HARD): ");
            String level = sc.nextLine().toUpperCase();

            File file = new File("questions.txt");
            Scanner fileReader = new Scanner(file);

            List<String> selectedQuestions = new ArrayList<>();

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();

                if (line.startsWith(level)) {
                    selectedQuestions.add(line.split(":")[1]); 
                }
            }
            fileReader.close();

            if (selectedQuestions.isEmpty()) {
                System.out.println("No questions found for this difficulty level!");
                return;
            }

            int score = 0;

            System.out.println("\n Math Puzzle Started ");

            for (String question : selectedQuestions) {
                System.out.print(question + " = ");

                int answer = sc.nextInt();
                int correct = evaluate(question);

                if (answer == correct) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! Correct answer is: " + correct);
                }
            }

            FileWriter fw = new FileWriter("scores.txt", true); 
            fw.write(name + " (" + level + ") : " + score + " points\n");
            fw.close();

            System.out.println("\n Game Complete");
            System.out.println("Player: " + name);
            System.out.println("Difficulty: " + level);
            System.out.println("Score: " + score);
            System.out.println("Score saved to scores.txt");

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        sc.close();
    }

    public static int evaluate(String exp) {
        if (exp.contains("+")) {
            String[] parts = exp.split("\\+");
            return Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
        } else if (exp.contains("-")) {
            String[] parts = exp.split("-");
            return Integer.parseInt(parts[0]) - Integer.parseInt(parts[1]);
        }
        return 0; 
    }
}
