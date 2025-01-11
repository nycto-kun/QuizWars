import java.util.*;

public class head {

  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);

    //MESSAGE DISPLAY
    System.out.println(" \r\n" + //
        " __        __   _                            _           ___        _    __        __             _ \r\n" + //
        " \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___    / _ \\ _   _(_)___\\ \\      / /_ _ _ __ ___| |\r\n"
        + //
        "  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | | | | | | | |_  /\\ \\ /\\ / / _` | '__/ __| |\r\n"
        + //
        "   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |_| | |_| | |/ /  \\ V  V / (_| | |  \\__ \\_|\r\n" + //
        "    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/   \\__\\_\\\\__,_|_/___|  \\_/\\_/ \\__,_|_|  |___(_)\r\n"
        + //
        "                                                                                                    \r\n" + //
        "");

    // Prompt user to select difficulty
    String difficulty = "";
    boolean validDifficulty = false;
    while (!validDifficulty) {
      System.out.println("Select difficulty: Easy, Medium, or Hard");
      System.out.print("Your choice: ");
      difficulty = userInput.nextLine().trim().toLowerCase();
      if (difficulty.equals("easy") || difficulty.equals("medium") || difficulty.equals("hard")) {
        validDifficulty = true;
      } else {
        System.out.println("Invalid choice. Please enter Easy, Medium, or Hard.");
      }
    }

    // Load questions based on difficulty
    String filePath = "resources/" + difficulty + ".txt";
    List<Question> questions = QuestionLoader.loadQuestion(filePath);

    int score = 0;
    int questionNumber = 1;

    for (Question question : questions) {
      System.out.println("========================================");
      System.out.println("            Question " + questionNumber);
      System.out.println("========================================");
      System.out.println(question.getQuestionText());
      System.out.println("A: " + question.getOptionA());
      System.out.println("B: " + question.getOptionB());
      System.out.println("C: " + question.getOptionC());
      System.out.println("D: " + question.getOptionD());
      System.out.println("========================================");

      String userAnswer = "";
      boolean validInput = false;

      // Input validation loop
      while (!validInput) {
        System.out.print("Your answer (A/B/C/D): ");
        userAnswer = userInput.nextLine().trim().toUpperCase();
        if (userAnswer.matches("[ABCD]")) {
          validInput = true;
        } else {
          System.out.println("Invalid input. Please enter A, B, C, or D.");
        }
      }

      // Check answer and update score
      if (userAnswer.equals(question.getCorrectAnswer().toUpperCase())) {
        System.out.println("Correct!\n");
        score++;
      } else {
        System.out.println("Wrong! The correct answer was: " + question.getCorrectAnswer() + "\n");
      }

      questionNumber++;
    }

    // Display final score
    System.out.println("========================================");
    System.out.println("              Quiz Complete!            ");
    System.out.println("========================================");
    System.out.println("Your final score: " + score + " / " + questions.size());
    System.out.println("========================================");

    userInput.close();
  }
}
