package com.company;
import java.util.ArrayList;
public class Customer {
    private ArrayList<BankAccount> accounts;
    private int customerID;
    private String name;

    public Customer(String name, int taxID){  //because you should not use the same name as the parameter and instance var
        this.name = name;
        accounts = new ArrayList<BankAccount>();
        customerID = taxID;
    }

    public BankAccount closeAccount(int bankAccountId){
        BankAccount accountToClose = null;
        for (var account : accounts){
            if (account.getAccountID()==bankAccountId){
                accountToClose = account;
            }
        }
        accounts.remove(accountToClose);
        return accountToClose;
    }

    public boolean openAccount(double initialDeposit){
        var newAccount = new BankAccount(initialDeposit, 0.03F);
        var success = accounts.add(newAccount);
        return success;
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return customerID;
    }
}
