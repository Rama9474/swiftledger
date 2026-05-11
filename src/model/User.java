package model;

public class User {

    private String userId;
    private String name;
    private String phoneNumber;
    private double walletBalance;
    private int pin;

    // Constructor
    public User(String userId, String name, String phoneNumber, double walletBalance, int pin) {

        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.walletBalance = walletBalance;
        this.pin = pin;
    }

    // Getter Methods
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public int getPin() {
        return pin;
    }

    // Setter Method
    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    // Display Object Information
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", walletBalance=" + walletBalance +
                '}';
    }
}