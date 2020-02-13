package com.company;

public class BankAccount {
    private double balance;
    private float interestRate;
    private int accountID;
    private static int nextID = 1000;

    public BankAccount(){    //constructors
        interestRate = 0.02f;
        accountID = nextID;
        nextID = nextID+1;
    }

    public BankAccount(double initialBalance, float initialRate){
        balance = initialBalance;
        interestRate = initialRate;
        accountID = nextID;
        nextID++;
    }


    public void deposit(double amount){
        balance= balance + amount;
    }

    public double checkBalance() {
        return balance;
    }
    public double addInterest(){
          balance = balance + balance*interestRate;
          return balance;
    }
    public boolean withdraw(double amount){
        if (amount <=balance){
            balance -=amount;
            return true;
        }
        return false; //do not need else because I would have left function already if this were true
    }
    public int getAccountID(){
        return accountID;
    }
}
