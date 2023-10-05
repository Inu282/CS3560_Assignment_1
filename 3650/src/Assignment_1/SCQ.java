package Assignment_1;

import java.util.ArrayList;
import java.util.List;

public class SCQ implements Question {
    private String questionText;
    private List<String> answers;

    public SCQ(String questionText, List<String> candidateAnswers) {
        this.questionText = questionText;
        this.answers = candidateAnswers;
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
        if (answers.size() > 0) {
            String singleAnswer = answers.get(0);
            System.out.println("Student " + student.getId() + " submitted answer: " + singleAnswer);
        }
    }
}

