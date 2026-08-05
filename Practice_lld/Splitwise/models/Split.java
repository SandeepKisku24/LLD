package Splitwise.models;
import Splitwise.enums.SplitType;
public class Split {
    private User user;
    private double amount;
    private SplitType splitType;

    public Split(User user, double amount, SplitType splitType) {
        this.user = user;
        this.amount = amount;
        this.splitType = splitType;
    }
    public User getUser() {
        return user;
    }
    public double getAmount() {
        return amount;
    }
    public SplitType getSplitType() {
        return splitType;
    }
   
}
