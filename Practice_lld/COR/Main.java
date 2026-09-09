package COR;
import COR.models.Candidate;
public class Main {
    
    public static void main(String[] args) {
        Candidate candidate = new Candidate(1, "John Doe", "john.doe@example.com");
        interViewProcess(candidate);
    }
    public static void interViewProcess(Candidate candidate){
        InterviewHandler assessmentRound = new AssessmentRound();
        InterviewHandler technicalRound = new TechnicalRound();
        InterviewHandler finalRound = new ManagerialRound();

        InterviewHandler chain = assessmentRound;
        chain.setNext(technicalRound);
        technicalRound.setNext(finalRound);
        System.out.println("Starting the interview process for candidate: " + candidate.getName());
        chain.hire(candidate);
    }
}
