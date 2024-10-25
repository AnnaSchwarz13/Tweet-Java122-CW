package database;

import Entity.TweetList;
import Entity.User;
import Entity.UserList;

public class Database {
    public final static UserList  userList = new UserList();
    public final static TweetList tweetList = new TweetList();

    public static User loggedInUser;
}
