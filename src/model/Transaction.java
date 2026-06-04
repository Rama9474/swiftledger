package model;

public class Transaction {

    private String transactionId;
    private String sender;
    private String receiver;
    private double amount;
    // Constructor
    public Transaction(
            String transactionId,
            String sender,
            String receiver,
            double amount) {
        this.transactionId = transactionId;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }
    // Get Transaction ID
    public String getTransactionId() {
        return transactionId;
    }
    // Get Sender
    public String getSender() {
        return sender;
    }

    // Get Receiver
    public String getReceiver() {
        return receiver;
    }

    // Get Amount
    public double getAmount() {
        return amount;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", amount=" + amount +
                '}';
    }
}