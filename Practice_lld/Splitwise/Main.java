package Splitwise;
import java.util.List;
import java.util.Map;

import Splitwise.models.User;
import Splitwise.services.ExpenseService;
import Splitwise.services.GroupService;
import Splitwise.repositories.InMemoryGroupRepo;


public class Main {
    public static void main(String[] args) {

        // users
        User shubh = new User("u1", "Shubh");
        User bob   = new User("u2", "Bob");
        User tom   = new User("u3", "Tom");
        User jake  = new User("u4", "Jake");
        InMemoryGroupRepo repo  = new InMemoryGroupRepo();
        // BalanceSheetService balanceSheetService = new BalanceSheetService();
        ExpenseService expenseService = new ExpenseService();
        // DebtSimplificationService simplificationService = new DebtSimplificationService();
        GroupService groupService = new GroupService(repo, expenseService);

        String groupId1 = groupService.createGroup("Friends");
        groupService.addUserToGroup(groupId1, List.of(shubh, bob, tom, jake));
        groupService.addExpenseToGroup(repo.getGroupById(groupId1), "e1", "Dinner", 1000, shubh, Splitwise.enums.SplitType.PERCENTAGE, List.of(shubh, bob, tom, jake), Map.of(shubh, 40.0, bob, 20.0, tom, 30.0, jake, 10.0));
        groupService.printGroupDetails(groupId1);
    }
}
