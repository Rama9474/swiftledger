package service;

import model.User;
import java.util.HashMap;

public class UserService {
    // Store users using phone number as key
    private HashMap<String, User> users = new HashMap<>();

    // Register User
    public void registerUser(User user) {
        if (users.containsKey(user.getPhoneNumber())) {
            System.out.println("User Already Exists");
            return;
        }
        users.put(user.getPhoneNumber(), user);
        System.out.println("User registered successfully.");
    }

    public User searchUser(String phoneNumber) {

        if (users.containsKey(phoneNumber)) {

            return users.get(phoneNumber);
        }

        return null;
    }

    // Display All Users
    public void displayUsers() {

        for (User user : users.values()) {

            System.out.println(user);
        }
    }

    public boolean authenticateUser(String phoneNumber, int pin) {
        // Check if user exists
        if (users.containsKey(phoneNumber)) {

            User user = users.get(phoneNumber);

            // Verify PIN
            if (user.getPin() == pin) {

                return true;
            }
        }

        return false;
    }

}