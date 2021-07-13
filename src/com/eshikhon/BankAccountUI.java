package com.eshikhon;

import java.util.Scanner;

public class BankAccountUI {
    private Scanner scanner =  new Scanner(System.in);;
    private Account account;

    public void runBanAccount() {
        do {
            System.out.println("1. create account\n" +
                    "2. check balance\n" +
                    "3. deposit\n" +
                    "4. withdraw\n" +
                    "5. checkLast transaction\n" +
                    "6. exit\n");

            int selectedMenuItem = scanner.nextInt();

            switch (selectedMenuItem) {
                case 1:
                    acccoutCreateFunctionality();
                    break;
                case 2:
                    System.out.println(account.getBalance());
                    break;
                case 3:
                    depostitTask();
                    break;
                case 4:
                    withdrawTask();
                    break;
                case 5:
                    System.out.println("Last transaction Type " + account.getLastTransactionType());
                    System.out.println("Last transaction Amount " + account.getLastTransaction());
                    break;
                case 6:
                    return;
            }

        } while (true);
    }

    private void acccoutCreateFunctionality() {
        System.out.print("Enter your account Name: ");
        scanner.next();
        String name = scanner.nextLine();
        System.out.print("Enter your account ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter your account Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        account = new Account(name, id, initialBalance);
    }

    private void depostitTask() {
        System.out.print("Enter your account Deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdrawTask() {
        System.out.print("Enter your account Withdraw amount: ");
        double amountwd = scanner.nextDouble();
        account.withdraw(amountwd);
    }

}
