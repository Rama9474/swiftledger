package main;

import model.User;
import model.Wallet;

public class Main {

    public static void main(String[] args) {

        // Create User Object
        User user1 = new User(
                "U101",
                "Rama",
                "9876543210",
                5000.0,
                1234
        );

        // Create Wallet Object
        Wallet wallet = new Wallet();

        // Print User Details
        System.out.println(user1);

        // Check Balance
        wallet.checkBalance(user1);

        // Add Money
        wallet.addMoney(user1, 2000);

        // Check Updated Balance
        wallet.checkBalance(user1);
    }
}