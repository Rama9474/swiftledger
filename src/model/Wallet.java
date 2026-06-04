package model;

public class Wallet {
    // Add money to wallet
    public void addMoney(User user, double amount) {
        user.setWalletBalance(
        user.getWalletBalance() + amount);
        System.out.println(amount + " added successfully.");
    }
    // Check wallet balance
    public void checkBalance(User user) {
    System.out.println("Current Balance: " + user.getWalletBalance());
    }
}