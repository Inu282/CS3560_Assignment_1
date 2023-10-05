package Assignment_1;

import java.util.ArrayList;
import java.util.List;

public class MCQ implements Question {
    private String questionText;
    private List<String> answers;

    public MCQ(String questionText, List<String> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public List<String> getAnswers() {
        return answers;
    }

    @Override
    public void submitAnswers(Student student, List<String> answers) {
        System.out.println("Student " + student.getId() + " submitted answers: " + answers);
    }
}

