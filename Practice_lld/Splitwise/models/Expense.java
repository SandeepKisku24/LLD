package Splitwise.models;
import Splitwise.enums.SplitType;
import java.util.List;
import java.util.Map;


public class Expense {
    private String id;
    private String description;
    private double amount;
    private User paidBy;
    private SplitType splitType;
    private List<Split> splits;
    private Map<User, Double> metadata;
    public Expense(String id, String description, double amount, User paidBy, SplitType splitType, List<Split> splits, Map<User, Double> metadata) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.splits = splits;
        this.metadata = metadata;
    }
    // getter and setter methods for all fields
    public String getId() {
        return id;
    }       
    public User getPaidBy() {
        return paidBy;
    }
    public double getAmount() {
        return amount;
    }   
    public List<Split> getSplits() {
        return splits;
    }   
    public SplitType getSplitType() {
        return splitType;
    }   
      
    public String getDescription() {
        return description;
    }

}
