package com.eshikhon;


public class Account {
    private String customerName;
    private String customerID;
    private double balance;
    private double lastTransaction;
    private String lastTransactionType;

    public Account(String customerName, String customerID, double balance) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance = this.balance - amount;
            this.lastTransaction = amount;
            this.lastTransactionType = "WITHDRADW";
        }
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
        this.lastTransaction = amount;
        this.lastTransactionType = "DEPOSITE";
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public double getBalance() {
        return balance;
    }

    public double getLastTransaction() {
        return lastTransaction;
    }

    public String getLastTransactionType() {
        return lastTransactionType;
    }

}