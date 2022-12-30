package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, double minBalance, String institutionName) {
        super(name, balance, minBalance);
        this.institutionName = institutionName;
    }
}