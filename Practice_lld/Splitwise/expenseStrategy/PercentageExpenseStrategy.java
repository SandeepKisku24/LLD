package Splitwise.expenseStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Splitwise.models.User;
import Splitwise.models.Split;

import Splitwise.enums.SplitType;
public class PercentageExpenseStrategy implements ExpenseStrategy {
    @Override
    public List<Split> calculateExpense(double amount, User paidByUserId, SplitType splitType, List<User> users, Map<User, Double> metadata) {
        List<Split> splits = new ArrayList<>();
        // Logic to calculate percentage expense
        for (User user : users) {
            double percentage = metadata.get(user);
            double userShare = (percentage / 100) * amount;
            // Create a Split object for the user with their share
            Split split = new Split(user, userShare,splitType);
            splits.add(split);
        }
        return splits;
    }
}
