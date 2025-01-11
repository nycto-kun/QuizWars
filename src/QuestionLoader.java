
// utility class
import java.io.*;
import java.util.*;

public class QuestionLoader {

  // Static method to load questions from a file
  public static List<Question> loadQuestion(String fileName) {
    List<Question> questions = new ArrayList<>();
    try {
      System.out.println("Loading file: " + fileName);
      InputStream inputStream = QuestionLoader.class.getClassLoader().getResourceAsStream(fileName);
      if (inputStream == null) {
        throw new FileNotFoundException("File not found: " + fileName);
      } else {
        System.out.println("File loaded successfully.");
      }

      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(","); // Assuming questions are delimited by ';'
        if (parts.length == 6) {
          // Instantiate a generic question or a specific subclass if needed
          Question question = new EasyQuestion(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
          questions.add(question);
        }
      }
      reader.close();
    } catch (IOException e) {
      System.err.println("Error loading questions: " + e.getMessage());
    }
    return questions;
  }
}
