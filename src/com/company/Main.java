package com.company;

public class Main {

    public static void main(String[] args) {
	var myaccount = new BankAccount();
	var youraccount = new BankAccount(10000, 0.04f);
	myaccount.deposit(1000);
	myaccount.addInterest();
	youraccount.addInterest();
	var succeeded = myaccount.withdraw(2000);
	if (succeeded)
	    System.out.println("Yes! I withdrew 2000");
	else
	    System.out.println("couldn't withdraw 2000 when you only have" +myaccount.checkBalance()+  "  in your account");
	System.out.println("Your account has "+ youraccount.checkBalance());
	youraccount.withdraw(5000);
	System.out.println("After paying the bills you have "+youraccount.checkBalance());
    }
}
