package Splitwise.expenseStrategy;
import java.util.List;
import java.util.Map;

import Splitwise.enums.SplitType;
import Splitwise.models.Split;
import Splitwise.models.User;
public interface ExpenseStrategy {
    List<Split> calculateExpense(double amount, User paidByUserId, SplitType splitType, List<User> users, Map<User, Double> metadata);
}