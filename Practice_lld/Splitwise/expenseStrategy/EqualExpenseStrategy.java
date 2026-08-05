package Splitwise.expenseStrategy;
import java.util.*;

import Splitwise.enums.SplitType;
import Splitwise.models.Split;
import Splitwise.models.User;
public class EqualExpenseStrategy implements ExpenseStrategy {
    @Override
    public List<Split> calculateExpense(double amount, User paidByUserId, SplitType splitType, List<User> users, Map<User, Double> metadata) {
        // Logic to calculate equal expense
        return new ArrayList<>(); // Placeholder return statement
    }
    
}
