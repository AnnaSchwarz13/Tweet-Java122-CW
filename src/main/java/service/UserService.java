package service;

import Entity.User;
import database.Database;
import org.w3c.dom.css.Counter;

import java.util.Random;

import static database.Database.loggedInUser;
import static database.Database.userList;


public class UserService {
  private static int Counter;
    public void userSignup(String firstName, String lastName, String userName, String password) {

        // Create user
        User signingUser = new User();
        signingUser.setFirstName(firstName);
        signingUser.setLastName(lastName);
        signingUser.setUsername(userName);
        signingUser.setPassword(password);

        // Save to database

        Database.userList.add(signingUser);
    }


    public boolean userLogin(String username,
                             String password) {

        for (int i = 0; i < userList.getIndex(); i++) {
            User checkingUser = userList.getUsers(i);

            if (checkingUser.getUsername().equals(username)) {

                // Check password
                if (checkingUser.getPassword().equals(password)) {
                    // Set the logged User
                    Database.loggedInUser = checkingUser;

                    System.out.println("User logged in successfully...");
                    return false;
                }
                break;
            }
        }
        System.out.println("Username or password is wrong!");
        return true;
    }

    public void userLogout() {
        loggedInUser = null;
    }
}
