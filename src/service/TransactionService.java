package service;

import model.Transaction;
import model.User;

import java.util.ArrayList;

public class TransactionService {

    // Store all transactions
    ArrayList<Transaction> transactions =
            new ArrayList<>();


    // Send Money
    public void sendMoney(
            User sender,
            User receiver,
            double amount
    ) {

        // Balance validation
        if(sender.getWalletBalance() < amount) {

            System.out.println(
                    "Insufficient Balance"
            );

            return;
        }


        // Deduct sender balance
        sender.setWalletBalance(
                sender.getWalletBalance() - amount
        );


        // Add receiver balance
        receiver.setWalletBalance(
                receiver.getWalletBalance() + amount
        );


        // Create transaction object
        Transaction transaction =
                new Transaction(
                        "T101",
                        sender.getName(),
                        receiver.getName(),
                        amount
                );


        // Store transaction
        transactions.add(transaction);


        System.out.println(
                "Transaction Successful"
        );
    }


    // Display all transactions
    public void showTransactions() {

        for(Transaction transaction : transactions) {

            System.out.println(transaction);
        }
    }
}