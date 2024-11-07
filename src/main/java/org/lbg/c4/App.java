package org.lbg.c4;

public class App {


    public static void main(String[] args) {

        System.out.println("hii");
        BankAccount ba = new BankAccount(33.33);
        System.out.println(ba.getBalance());

        ba.debit(34);
        System.out.println(ba.getBalance());
    }
}