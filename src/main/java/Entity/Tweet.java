package Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Tweet {

    private UserList likedUsers;
    private String text;
    private User user;
    private int id;

    public Tweet(String text, User user , int id) {
        this.text = text;
        this.user = user;
        this.likedUsers = new UserList();
        this.id = id;
    }
}
