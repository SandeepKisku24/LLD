package Splitwise.models;
import java.util.*;
public class Group {
    private String id;
    private String name;
    private List<User> users;
    private List<Expense> expenses;
    public Group(String id, String name) {
        this.id = id;
        this.name = name;
        this.users = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void addExpenseToGroup(Expense expense) {
        expenses.add(expense);  
    }
    public List<User> getUsers() {
        return users;
    }
    public List<Expense> getExpenses() {
        return expenses;
    }
    

}
