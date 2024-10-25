package authentication;

import Entity.User;

import static database.Database.loggedInUser;
import static database.Database.userList;

public class Authentication {

    public void addUserToDatabase(User user) {
        userList.add(user);
    }

    public void login(User signingUser) {
        if(loggedInUser ==null) {
        loggedInUser =signingUser;
        return;
        }
        System.out.println("you are not logged in");
    }

    public void logout() {
        if(loggedInUser != null) {
            loggedInUser = null;
            return;
        }
        System.out.println("you are logged out");
    }

    public static boolean isUsernameNew(String username) {
        for (int i = 0; i < userList.getIndex(); i++) {
            User user = userList.getUsers(i);
            if (username.equals(user.getUsername()))
                return false;
        }
        return true;
    }
}
