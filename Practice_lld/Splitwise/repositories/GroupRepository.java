package Splitwise.repositories;
import Splitwise.models.Group;

public interface GroupRepository {
    Group getGroupById(String groupId);
    void save(Group group);
}
