package authentication;

import Entity.User;

import static database.Database.loggedInUser;
import static database.Database.userList;

public class Authentication {

    public void login(User signingUser) {
        userList.add(signingUser);
    }

    public void logout() {
        loggedInUser = null;
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
