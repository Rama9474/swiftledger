package main;

import model.User;
import java.util.Scanner;
import service.UserService;
import service.TransactionService;

public class Main {

        public static void main(String[] args) {

                UserService userService = new UserService();
                TransactionService transactionService = new TransactionService();
                Scanner scanner = new Scanner(System.in);

                // Create Users
                User user1 = new User("U101","Rama","9876543210",5000.0,1234);
                User user2 = new User("U102", "Neha","9999999999",3000.0,5678);

                // Register Users
                userService.registerUser(user1);
                userService.registerUser(user2);

                while (true) {
                        System.out.println("\n===== SwiftLedger Menu =====");
                        System.out.println("1. View Users");
                        System.out.println("2. Search User");
                        System.out.println("3. Login Test");
                        System.out.println("4. Send Money");
                        System.out.println("5. View Transactions");
                        System.out.println("6. Transaction Analytics");
                        System.out.println("7. Exit");
                        System.out.print("Enter Choice: ");
                        int choice = scanner.nextInt();
                        switch (choice) {
                                case 1:
                                        userService.displayUsers();
                                        break;
                                case 2:
                                        System.out.print("Enter Phone Number: ");
                                        String phoneNumber = scanner.next();
                                        User foundUser = userService.searchUser(phoneNumber);

                                        if (foundUser != null) {
                                                System.out.println(foundUser);
                                        } else {
                                                System.out.println("User Not Found");
                                        }
                                        break;

                                case 3:

                                System.out.print("Enter Phone Number: ");
                                String loginPhone =scanner.next();
                                System.out.print("Enter PIN: ");
                                int loginPin =scanner.nextInt();
                                boolean loginResult =userService.authenticateUser(loginPhone, loginPin);
                                if(loginResult) {
                                        System.out.println("Login Successful");
                                } else {
                                        System.out.println("Invalid Credentials");
                                }
                                break;
                                case 4:
                                        System.out.print("Enter Sender Phone Number: ");
                                        String senderPhone =scanner.next();
                                        System.out.print("Enter Receiver Phone Number: ");
                                        String receiverPhone =scanner.next();
                                        System.out.print("Enter Amount: ");
                                        double amount =scanner.nextDouble();
                                        System.out.print("Enter PIN: ");
                                        int pin =scanner.nextInt();
                                        User sender =userService.searchUser(senderPhone);
                                        User receiver =userService.searchUser(receiverPhone);
                                        if(sender == null || receiver == null) {
                                                System.out.println("User Not Found");
                                        break;
                                        }
                                        try {
                                                transactionService.sendMoney(sender,receiver,amount,pin);
                                        }catch(Exception e) {
                                                System.out.println(e.getMessage());
                                        }
                                        break;
                                case 5:
                                        System.out.println("\nTransaction History:");
                                        transactionService.showTransactions();
                                        break;
                                
                                case 6:
                                        System.out.print("Enter User Name: ");
                                        String name = scanner.next();
                                        System.out.println("\nTransactions Sent By " + name + ":");
                                        transactionService.searchBySender(name);
                                        System.out.println("\nTransactions Received By " + name + ":");
                                        transactionService.searchByReceiver(name);
                                        System.out.println("\nTotal Transactions: "+ transactionService.getTotalTransactions());
                                        System.out.println("Total Amount Transferred: "+ transactionService.getTotalTransactionAmount());
                                        System.out.println("Highest Transaction Amount: "+ transactionService.getHighestTransactionAmount());
                                        System.out.println("Average Transaction Amount: "+ transactionService.getAverageTransactionAmount());
                                        break;
                                case 7:
                                        System.out.println( "Thank You For Using SwiftLedger");
                                        scanner.close();
                                        return;
                                default:
                                        System.out.println("Invalid Choice");
                        }
                }

        }
}