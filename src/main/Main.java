package main;

import model.User;

import service.UserService;
import service.TransactionService;

public class Main {

    public static void main(String[] args) {

        UserService userService =
                new UserService();

        TransactionService transactionService =
                new TransactionService();


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
        userService.registerUser(user2);


        // Display Users
        System.out.println("\nAll Users:");

        userService.displayUsers();


        // Search User
        System.out.println("\nSearch Result:");

        User foundUser =
                userService.searchUser(
                        "9876543210"
                );

        System.out.println(foundUser);


        // Login Test
        System.out.println("\nLogin Test:");

        boolean loginResult =
                userService.authenticateUser(
                        "9876543210",
                        1234
                );

        if(loginResult) {

            System.out.println(
                    "Login Successful"
            );

        } else {

            System.out.println(
                    "Invalid Credentials"
            );
        }


        // Money Transfer
        System.out.println("\nMoney Transfer:");

        try {

            // Correct PIN
            transactionService.sendMoney(
                    user1,
                    user2,
                    1000,
                    1234
            );


            // Correct PIN
            transactionService.sendMoney(
                    user2,
                    user1,
                    500,
                    5678
            );


            // Wrong PIN
            transactionService.sendMoney(
                    user1,
                    user2,
                    1000,
                    9999
            );

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }


        // Show Transactions
        System.out.println(
                "\nTransaction History:"
        );

        transactionService.showTransactions();


        // Updated Balances
        System.out.println(
                "\nUpdated Users:"
        );

        System.out.println(user1);

        System.out.println(user2);





        // Transaction Analytics

System.out.println(
        "\nTransactions Sent By Rama:"
);

transactionService.searchBySender(
        "Rama"
);


System.out.println(
        "\nTransactions Received By Rama:"
);

transactionService.searchByReceiver(
        "Rama"
);


System.out.println(
        "\nTotal Transactions: "
        + transactionService.getTotalTransactions()
);


System.out.println(
        "Total Amount Transferred: "
        + transactionService.getTotalTransactionAmount()
);

System.out.println(
        "Highest Transaction Amount: "
        + transactionService.getHighestTransactionAmount()
);

System.out.println(
        "Average Transaction Amount: "
        + transactionService.getAverageTransactionAmount()
);

    }
}