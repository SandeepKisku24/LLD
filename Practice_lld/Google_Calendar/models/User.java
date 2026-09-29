package Google_Calendar.models;
import Google_Calendar.enums.UserType;
public class User {
    private String id;
    private String user_name;
    private String email;
    private UserType user_type;
    public User(String id, String user_name, String email) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.user_type = UserType.USER;
    }
    public String getId() {
        return id;
    }
}
