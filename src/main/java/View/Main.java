package View;

import authentication.Authentication;
import service.UserService;

import java.util.Scanner;

import static database.Database.loggedInUser;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userInput;
        while (loggedInUser == null) {
            System.out.println("\n\nDear user please choose a option from the menu : ");
            System.out.println("1.Signup");
            System.out.println("2.login");
            userInput = scanner.nextInt();
            userLoginMenu(userInput);
        }
        while (loggedInUser != null) {
            System.out.println("1.Post a new tweet");
            System.out.println("2.View all tweets");
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
}

