package com.driver;



public class BankAccount {

    private String name;

    private double balance;
    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    private double minBalance;


    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
        if(balance==0)
        {
            System.out.println(" account having zero amount ");
        }
        else
        {
            System.out.println("account showing min balance");
        }
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        for (digits = 0; digits <= 9; digits++) {
            int sums = 0;
            int digit = digits % 10;
            sums += digit;
            digits = digits / 10;

            if (sums != sum) {
                throw new Exception("Account Number can not be generated");
            }
        }
            return String.valueOf(digits);

    }
    public void deposit(double amount) {

        if(balance!=0)
        {
           this.balance+=amount;
        }
        else {
            System.out.println("no amount is avaiable");
        }
    }


    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
             double remaining = balance - minBalance;
             if(remaining<minBalance)
             {
                 throw new Exception("Insufficient Balance");
             }
             else {
                remaining=balance;
             }
             }
    }

