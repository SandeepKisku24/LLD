package Splitwise.expenseFactory;
import Splitwise.expenseStrategy.ExpenseStrategy;
import Splitwise.expenseStrategy.EqualExpenseStrategy;
import Splitwise.expenseStrategy.ExactExpenseStrategy;
import Splitwise.expenseStrategy.PercentageExpenseStrategy;
import Splitwise.enums.SplitType;
public class ExpenseFactory {
    public static ExpenseStrategy getExpenseStrategy(SplitType splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualExpenseStrategy();
            case EXACT:
                return new ExactExpenseStrategy();
            case PERCENTAGE:
                return new PercentageExpenseStrategy();
            default:
                throw new IllegalArgumentException("Invalid split type");
        }
    }
}
