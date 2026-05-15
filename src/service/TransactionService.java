package service;

import model.Transaction;
import model.User;

import java.util.ArrayList;
import exception.InsufficientBalance;

import util.FileService;


public class TransactionService {

    // Store all transactions
    ArrayList<Transaction> transactions = new ArrayList<>();
    FileService fileService = new FileService();


    // Send Money
    public void sendMoney(User sender, User receiver, double amount) throws InsufficientBalance
    {

        // Balance validation
        if(sender.getWalletBalance() < amount) {
            throw new InsufficientBalance("Insufficient Balance");
        }

        // Deduct sender balance
        sender.setWalletBalance(sender.getWalletBalance() - amount);


        // Add receiver balance
        receiver.setWalletBalance(receiver.getWalletBalance() + amount);


        // Create transaction object
        Transaction transaction = new Transaction("T101",sender.getName(), receiver.getName(), amount);


        // Store transaction
        transactions.add(transaction);
        fileService.writeTransaction(transaction.toString());


        System.out.println("Transaction Successful");
    }


    // Display all transactions
    public void showTransactions() {

        for(Transaction transaction : transactions) {

            System.out.println(transaction);
        }
    }
}