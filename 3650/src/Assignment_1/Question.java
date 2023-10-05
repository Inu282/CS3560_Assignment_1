package Assignment_1;

import java.util.List;


public interface Question {
    String getQuestionText();
    List<String> getAnswers();
    void submitAnswers(Student student, List<String> answers);
}

