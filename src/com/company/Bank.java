package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;

public class Bank {
    private ArrayList<BankAccount> allAccounts;
    private ArrayList<Customer> allCustomers;
    private Customer currentCustomer;

    public Bank(){
        allAccounts = new ArrayList<BankAccount>();
        allCustomers = new ArrayList<Customer>();
    }

    private void printMenu(){
        System.out.println("What operation would you like next:");
        System.out.println("(enter the operation number)");
        System.out.println("[1] Add a customer");
        System.out.println("[2] select customer");
        System.out.println("[3] Open Account for Customer");
        System.out.println("[4] Quit");
    }

    private void addCustomer(Scanner inputReader){
        inputReader.nextLine(); //reading in trailing '\n\ character
        System.out.print("What is the new Customer's name:");
        var name = inputReader.nextLine();
        System.out.print("Enter new Customers tax ID");
        int taxID= inputReader.nextInt();
        currentCustomer = new Customer(name, taxID);
        allCustomers.add(currentCustomer);
        System.out.println("Successfully added new customer "+currentCustomer.getName());

    }

    private Optional<Customer> selectCustomer(int customerID){
        for(var customer: allCustomers){
            if(customer.getID() == customerID){
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public void doBanking(){
        var inputreader = new Scanner(System.in);
        while(true){
            printMenu();
            var userChoice = inputreader.nextInt();
            switch (userChoice){
                case 1:
                    addCustomer(inputreader);
                    break;
                case 2:
                    System.out.print("What is the ID of the customer to select:");
                    var id = inputreader.nextInt();
                    var oopsThatDidntWork = selectCustomer(id);
                    if (oopsThatDidntWork.isPresent())
                        System.out.println("Customer " + oopsThatDidntWork.get().getName() + " selected");
                    if (oopsThatDidntWork.isEmpty())
                        System.out.println("That customer doesn't exist, please try again");
                    break;
                case 3:
                    System.out.println("Not yet implemented");
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("That was not a choice");
            }
        }
    }
}
