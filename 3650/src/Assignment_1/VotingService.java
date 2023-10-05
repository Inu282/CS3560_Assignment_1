package Assignment_1;

import java.util.*;

public class VotingService {
    private Question question;
    private Map<String, List<String>> answerMap;

    public VotingService(Question question) {
        this.question = question;
        this.answerMap = new HashMap<>();
    }

    public void submitAnswers(Student student, List<String> answers) {
        if (answersAreValid(answers)) {
            answerMap.put(student.getId(), answers);
        } else {
            System.out.println("Invalid answers submitted by student " + student.getId());
        }
    }

    public void displayResults() {
        System.out.println(question.getQuestionText());
        for (String candidateAnswer : question.getAnswers()) {
            int count = countAnswer(candidateAnswer);
            System.out.println(candidateAnswer + " : " + count);
        }
    }

    private boolean answersAreValid(List<String> answers) {
        for (String answer : answers) {
            if (!question.getAnswers().contains(answer)) {
                return false;
            }
        }
        return true; 
    }

    private int countAnswer(String answer) {
        int count = 0;
        for (List<String> studentAnswers : answerMap.values()) {
            if (studentAnswers.contains(answer)) {
                count++;
            }
        }
        return count;
    }
}

