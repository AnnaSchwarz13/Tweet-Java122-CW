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

    public Tweet(String text, User user) {
        this.text = text;
        this.user = user;
        this.likedUsers = new UserList();
    }
}
