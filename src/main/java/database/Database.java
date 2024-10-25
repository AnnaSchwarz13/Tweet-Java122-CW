package database;

import Entity.User;
import Entity.UserList;

public class Database {
    public final static UserList  userList = new UserList();

    public static User loggedInUser;
}
