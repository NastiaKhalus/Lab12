package ua.edu.ucu.apps;

import ua.edu.ucu.apps.task1.ATM;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ATM atm = new ATM();
        atm.getMeMoney(800);
    }
}