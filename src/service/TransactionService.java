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
        public void sendMoney(User sender,User receiver,double amount,int pin) throws InsufficientBalance {
                // PIN Validation
                if (sender.getPin() != pin) {
                System.out.println("Invalid PIN");
                return;
                }

                // Balance validation
                if (sender.getWalletBalance() < amount) {
                throw new InsufficientBalance("Insufficient Balance");
                }

                // Deduct sender balance
                sender.setWalletBalance(sender.getWalletBalance() - amount);

                // Add receiver balance
                receiver.setWalletBalance(receiver.getWalletBalance() + amount);

                // Create transaction object
                String transactionId ="T" + (transactions.size() + 101);
                Transaction transaction =new Transaction(transactionId,sender.getName(),receiver.getName(),amount);
                // Store transaction
                transactions.add(transaction);

                // Save transaction to file
                fileService.writeTransaction(transaction.toString());
                System.out.println("Transaction Successful");
        }

        // Display all transactions
        public void showTransactions() {

                for (Transaction transaction : transactions) {
                System.out.println(transaction);
                }

        }

        // Search transactions by sender
        public void searchBySender(String sender) {

                for (Transaction transaction : transactions) {
                        if (transaction.getSender().equals(sender)) {
                                System.out.println(transaction);
                        }
                }
        }

        // Search transactions by receiver
        public void searchByReceiver(String receiver) {

                for (Transaction transaction : transactions) {

                        if (transaction.getReceiver().equals(receiver)) {

                                System.out.println(transaction);
                        }
                }
        }

        // Total transactions count
        public int getTotalTransactions() {

                return transactions.size();
        }

        // Total amount transferred
        public double getTotalTransactionAmount() {

                double total = 0;

                for (Transaction transaction : transactions) {

                        total += transaction.getAmount();
                }

                return total;
        }

        // Highest transaction amount
        public double getHighestTransactionAmount() {

                double highest = 0;
                for (Transaction transaction : transactions) {
                        if (transaction.getAmount() > highest) {
                                highest = transaction.getAmount();
                        }
                }
                return highest;
        }

        // Average transaction amount
        public double getAverageTransactionAmount() {
                if (transactions.size() == 0) {
                        return 0;
                }
                return getTotalTransactionAmount()/ transactions.size();
        }

}