package COR;
import COR.models.Candidate;
public abstract class InterviewHandler {
    public abstract boolean hire(Candidate candidate);

    public InterviewHandler nextHandler;

    public void setNext(InterviewHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void callNext(Candidate candidate) {
        if(nextHandler == null){
            System.out.println("The candidate has been hired!!");
        }
        else{
            nextHandler.hire(candidate);
        }
    }

}
