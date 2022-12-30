package com.driver;

public class Main {
    public static void main(String[] args) {

            SavingsAccount saveA=new SavingsAccount("ramkapoor",5000,500,4);

            System.out.println(saveA.getSimpleInterest(5));
            System.out.println(saveA.getCompoundInterest(3,8));
    }
}