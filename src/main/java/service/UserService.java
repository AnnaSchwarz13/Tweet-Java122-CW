package service;

import Entity.Tweet;
import Entity.User;
import authentication.Authentication;
import database.Database;

import static database.Database.loggedInUser;
import static database.Database.userList;


public class UserService {
    private static int counter = 1;
    public static int tweetCounter = 1;
    private Authentication auth = new Authentication();

    public void userSignup(String firstName, String lastName, String userName, String password) {

        // Create user
        User signingUser = new User();
        signingUser.setFirstName(firstName);
        signingUser.setLastName(lastName);
        signingUser.setUsername(userName);
        signingUser.setPassword(password);
        signingUser.setId(counter);
        // Save to database

        auth.addUserToDatabase(signingUser);
        counter++;
    }


    public boolean userLogin(String username,
                             String password) {

        for (int i = 0; i < userList.getIndex(); i++) {
            User checkingUser = userList.getUsers(i);

            if (checkingUser.getUsername().equals(username)) {

                // Check password
                if (checkingUser.getPassword().equals(password)) {
                    // Set the logged User
                    auth.login(checkingUser);

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
        auth.logout();
    }

    public void addTweet(String tweetText) {
        Tweet tweet = new Tweet(tweetText, loggedInUser, tweetCounter);
        Database.tweetList.add(tweet);
        tweetCounter++;
    }
}
