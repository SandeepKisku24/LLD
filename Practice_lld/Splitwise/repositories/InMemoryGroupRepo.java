package Splitwise.repositories;
import Splitwise.models.Group;
import java.util.*;
public class InMemoryGroupRepo implements GroupRepository {

    HashMap<String,Group> groupMap = new HashMap<>();
    @Override
    public Group getGroupById(String groupId) {
        // Implementation for retrieving a group by its ID from in-memory storage
        try {
            return groupMap.get(groupId);
        } catch (Exception e) {
            System.out.println("Error retrieving group: " + e.getMessage());
        }
        return null; // Placeholder return statement
    }

    @Override
    public void save(Group group) {
        // Implementation for saving a group to in-memory storage
        groupMap.put(group.getId(), group);
    }
    
}
