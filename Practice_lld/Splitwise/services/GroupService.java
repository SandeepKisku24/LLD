package Splitwise.services;
import Splitwise.models.Expense;
import Splitwise.models.Group;
import Splitwise.models.Split;
import Splitwise.models.User;
import Splitwise.repositories.GroupRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import Splitwise.enums.SplitType;
public class GroupService {
    private GroupRepository groupRepository;
    private ExpenseService expenseService;

    public GroupService(GroupRepository groupRepository, ExpenseService expenseService) {
        this.groupRepository = groupRepository;
        this.expenseService = expenseService;
    }
    

    public String createGroup(String groupName) {
        String groupId = "group_"+ UUID.randomUUID().toString(); // Generate a unique ID for the group    
        Group group = new Group(groupId, groupName);
        groupRepository.save(group);
        return groupId;
    }

    public void addUserToGroup(String groupId, List<User> users) {
        Group group = groupRepository.getGroupById(groupId);
        if (group != null) {
            // Assuming you have a method to add a user to the group
            for (User user : users) {
                group.addUser(user);
            }
        } else {
            System.out.println("Group not found with ID: " + groupId);
        }
    }

    public void addExpenseToGroup(Group group, String id, String description, double amount, User paidBy, SplitType splitType, List<User> users, Map<User, Double> metadata) {
        expenseService.addExpense(group, description, amount, paidBy, splitType, users, metadata);
    }
    public void printGroupDetails(String groupId) {
        Group group = groupRepository.getGroupById(groupId);
        if (group != null) {
            System.out.println("Group ID: " + group.getId());
            System.out.println("Group Name: " + group.getName());
            System.out.println("Users in the Group:");
            for (User user : group.getUsers()) {
                System.out.println("- " + user.getName() + " (ID: " + user.getId() + ")");
            }
            System.out.println("Expenses in the Group:");
            for (Expense expense : group.getExpenses()) {
                System.out.println("- Expense ID: " + expense.getId() + ", Description: " + expense.getDescription() +
                        ", Amount: " + expense.getAmount() + ", Paid By: " + expense.getPaidBy().getName() +
                        ", Split Type: " + expense.getSplitType());
                System.out.println("  Splits:");
                for (Split split : expense.getSplits()) {
                    System.out.println("    - User: " + split.getUser().getName() + ", Amount: " + split.getAmount());
                }
            }
        } else {
            System.out.println("Group not found with ID: " + groupId);
        }
    }

}
