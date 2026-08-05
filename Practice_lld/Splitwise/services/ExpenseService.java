package Splitwise.services;

import java.util.List;
import java.util.Map;


import Splitwise.enums.SplitType;
import Splitwise.expenseFactory.ExpenseFactory;
import Splitwise.expenseStrategy.ExpenseStrategy;
import Splitwise.models.Split;
import Splitwise.models.Group;
import Splitwise.models.User;
import Splitwise.models.Expense;
public class ExpenseService {
    public void addExpense(Group group, String description, double amount, User paidByUserId, SplitType splitType, List<User> users, Map<User, Double> metadata) {

        ExpenseStrategy expenseStrategy = ExpenseFactory.getExpenseStrategy(splitType);
        List<Split> splits = expenseStrategy.calculateExpense(amount, paidByUserId, splitType, users, metadata);
        String expenseId = Math.random() + ""; // Generate a unique expense ID based on the current timestamp
        Expense expense = new Expense(expenseId, description, amount, paidByUserId, splitType, splits, metadata);
        group.addExpenseToGroup(expense);
    }
}
