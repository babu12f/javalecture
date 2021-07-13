package com.eshikhon;

import java.util.Scanner;

public class BankAccountUI {
    private Scanner scanner =  new Scanner(System.in);
    private Account[] accountList = new Account[100];
    private int accountCount = 0;

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
                    System.out.print("Enter your account ID: ");
                    scanner.nextLine();
                    String id = scanner.nextLine();

                    Account searchAccount = findAccountById(id);
                    System.out.println(searchAccount.getBalance());
                    break;
                case 3:
                    depostitTask();
                    break;
                case 4:
                    withdrawTask();
                    break;
                case 5:
                    System.out.print("Enter your account ID: ");
                    scanner.next();
                    String id1 = scanner.nextLine();

                    Account account1 = findAccountById(id1);

                    System.out.println("Last transaction Type " + account1.getLastTransactionType());
                    System.out.println("Last transaction Amount " + account1.getLastTransaction());
                    break;
                case 6:
                    return;
            }

            System.out.println("\n\n\n\n\n");
        } while (true);
    }

    private void acccoutCreateFunctionality() {
        System.out.print("Enter your account Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter your account ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter your account Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        Account account = new Account(name, id, initialBalance);
        accountList[accountCount++] = account;
    }

    private void depostitTask() {
        System.out.print("Enter your account ID: ");
        scanner.nextLine();
        String id = scanner.nextLine();

        Account account = findAccountById(id);

        System.out.print("Enter your account Deposit amount: ");
        double amount = scanner.nextDouble();

        account.deposit(amount);
    }

    private void withdrawTask() {
        System.out.print("Enter your account ID: ");
        scanner.nextLine();
        String id = scanner.nextLine();

        Account account = findAccountById(id);
        System.out.print("Enter your account Withdraw amount: ");
        double amountwd = scanner.nextDouble();

        account.withdraw(amountwd);
    }

    private Account findAccountById(String customerId) {
        for (int i = 0; i < accountList.length; i++) {
            if (accountList[i].getCustomerID().equals(customerId)) {
                return accountList[i];
            }
        }
        return null;
    }

}
