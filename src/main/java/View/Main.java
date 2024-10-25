package View;

import Entity.Tweet;
import Entity.TweetList;
import authentication.Authentication;
import service.TweetService;
import service.UserService;
import service.impl.TwitterServiceImpl;

import java.util.Scanner;

import static database.Database.loggedInUser;
import static database.Database.tweetList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int userInput;
        while (true) {
            while (loggedInUser == null) {
                System.out.println("\n\nDear user please choose a option from the menu : ");
                System.out.println("1.Signup");
                System.out.println("2.login");
                userInput = scanner.nextInt();
                userLoginMenu(userInput);
            }
            while (loggedInUser != null) {
                System.out.println();
                System.out.println("1.Post a new tweet");
                System.out.println("2.View all tweets");
                System.out.println("3.View your tweets ");
                System.out.println("4.Log out");
                userInput = scanner.nextInt();
                loggedInUserMenu(userInput);

            }

        }
    }

    public static void userLoginMenu(int option) {
        Scanner scanner = new Scanner(System.in);
        Authentication authentication = new Authentication();
        UserService userService = new UserService();
        if (option == 1) {
            System.out.println("Enter first name:");
            String firstName = scanner.next();
            System.out.println("Enter last name:");
            String lastName = scanner.next();

            while (true) {
                System.out.println("Enter username:");
                String username = scanner.next();
                if (Authentication.isUsernameNew(username)) {
                    System.out.println("Enter your password: ");
                    String password = scanner.next();
                    userService.userSignup(firstName, lastName, username, password);
                    break;
                }
                System.out.println("this username are already taken!");
            }
        } else if (option == 2) {
            String username;
            String password;
            System.out.println("Enter username:");
            username = scanner.next();
            System.out.println("Enter password:");
            password = scanner.next();
            userService.userLogin(username, password);

        }
    }

    public static void loggedInUserMenu(int input) {
        UserService userService = new UserService();
        TwitterServiceImpl twitterService = new TwitterServiceImpl();
        TweetService tweetService = new TweetService();
        Scanner scanner = new Scanner(System.in);
        if (input == 1) {
            System.out.println("enter tweet's text");
            String tweetText = scanner.nextLine();
            userService.addTweet(tweetText);
        } else if (input == 2) {
            twitterService.displayAllTweet();
            if (tweetList.getIndex() > 0) {
                while (true) {
                    System.out.println("Please enter tweet's id to like \nif you don't wanna like anymore enter -1");
                    int id = scanner.nextInt();
                    if (id == -1) {
                        break;
                    }
                    Tweet userChoice = tweetService.getTweetById(id);
                    if (userChoice != null) {
                        twitterService.likeTweet(userChoice);
                    }
                }
            }
        }
            else if(input == 3) {
                TweetList userTweetList =tweetService.getLoggedInUserTweets();
                if(userTweetList.getIndex()>0 ) {
                    for(int i=0;i<userTweetList.getIndex();i++){
                        tweetService.showTweet(userTweetList.getTweets(i));
                        System.out.println("-----");
                    }
                }
                else{
                    System.out.println("You have no tweets yet");
                }

        } else if (input == 4) {
            userService.userLogout();
        }
    }
}

