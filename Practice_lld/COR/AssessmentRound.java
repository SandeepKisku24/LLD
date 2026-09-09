package COR;
import COR.models.Candidate;
public class AssessmentRound extends InterviewHandler {
    @Override
    public boolean hire(Candidate candidate) {
        int score = (int) (Math.random() * 100);
        if(score < 50){
            System.out.println(candidate.getName() + " has failed the assessment round with score: " + score);
            return false;
        }
        System.out.println(candidate.getName() + " has cleared the assessment round with score: " + score);
        callNext(candidate);
        return true;
    }
    
}
