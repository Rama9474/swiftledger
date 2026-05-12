package main;

import model.User;
import service.UserService;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService();


        // Create Users
        User user1 = new User(
                "U101",
                "Rama",
                "9876543210",
                5000.0,
                1234
        );

        User user2 = new User(
                "U102",
                "Neha",
                "9999999999",
                3000.0,
                5678
        );


        // Register Users
        userService.registerUser(user1);

        userService.registerUser(user1);


        // Display Users
        System.out.println("\nAll Users:");

        userService.displayUsers();


        // Search User
        System.out.println("\nSearch Result:");

        User foundUser = userService.searchUser("9876543210");

        System.out.println(foundUser);
    }
}