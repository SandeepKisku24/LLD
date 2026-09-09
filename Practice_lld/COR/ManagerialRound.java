package COR;
import COR.models.Candidate;
public class ManagerialRound extends InterviewHandler {
    @Override
    public boolean hire(Candidate candidate) {
        System.out.println("Managerial Round: Evaluating candidate " + candidate.getName());
        // Simulate evaluation logic
        boolean isHired = true; // Assume the candidate passes the managerial round

        if (isHired) {
            System.out.println("Candidate " + candidate.getName() + " passed the managerial round.");
            callNext(candidate);
            return true;
        } else {
            System.out.println("Candidate " + candidate.getName() + " failed the managerial round.");
            return false;
        }
    }
    
}
