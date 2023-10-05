package Assignment_1;

import java.util.*;

public class SimulationDriver {
    public static void main(String[] args) {
        List<String> mcqAnswers = Arrays.asList("A", "B", "C", "D");
        Question mcqQuestion = new MCQ("Multiple Choice Question Results: ", mcqAnswers);

        List<String> scqAnswers = Arrays.asList("Right", "Wrong");
        Question scqQuestion = new SCQ("Single Choice Question Results: ", scqAnswers);

        VotingService votingService1 = new VotingService(mcqQuestion);
        VotingService votingService2 = new VotingService(scqQuestion);

        Random random = new Random();
        int min = 10; 
        int max = 40; 
        int numStudents = random.nextInt(max - min + 1) + min; 
        List<Student> students = new ArrayList<>();
        System.out.println("Number of Students: "+numStudents);
        for (int i = 1; i <= numStudents; i++) {
        	Random rand = new Random();
        	
            Student student = new Student("Student " + i+rand.nextInt(1000));
            students.add(student);
            List<String> mcqRandomAnswers = new ArrayList<>();
            int numChoices = random.nextInt(mcqAnswers.size()) + 1; 
            for (int j = 0; j < numChoices; j++) {
                String mcqRandomAnswer = mcqAnswers.get(random.nextInt(mcqAnswers.size()));
                mcqRandomAnswers.add(mcqRandomAnswer);
            }
            votingService1.submitAnswers(student, mcqRandomAnswers);
            List<String> scqRandomAnswers = new ArrayList<>();
            scqRandomAnswers.add(scqAnswers.get(random.nextInt(scqAnswers.size())));
            votingService2.submitAnswers(student, scqRandomAnswers);
        }
        
        votingService1.displayResults();
        votingService2.displayResults();
        System.out.println("\nStudent IDs:");
        for (Student student : students) {
            System.out.println(student.getId());
        }
        
    }
}

