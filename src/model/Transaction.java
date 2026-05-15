package model;

public class Transaction {

    private String transactionId;

    private String sender;

    private String receiver;

    private double amount;


    public Transaction(
            String transactionId,
            String sender,
            String receiver,
            double amount
    ) {

        this.transactionId = transactionId;

        this.sender = sender;

        this.receiver = receiver;

        this.amount = amount;
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