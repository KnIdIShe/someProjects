package com.cho1r.homework;

/**
 * Author cho1r
 * 2021/12/14 下午 03:54
 */
public class hw08 {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(1000);
//        checkingAccount.deposit(100);
//        checkingAccount.withdraw(20);
//        System.out.println(checkingAccount.getBalance());

        SavingAccount savingAccount = new SavingAccount(1000);
        savingAccount.deposit(100);
        savingAccount.deposit(100);
        savingAccount.withdraw(20);
        savingAccount.withdraw(20);
        System.out.println(savingAccount.getBalance());
        savingAccount.earnMonthlyInterest();
        System.out.println(savingAccount.getBalance());

    }
}

class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

class CheckingAccount extends BankAccount {

    public CheckingAccount(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}

class SavingAccount extends BankAccount {
    private int count = 3;
    private double rate = 0.01;

    public SavingAccount(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        if (count > 0) {
            super.deposit(amount);
            count--;
        } else {
            super.deposit(amount - 1);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
            count--;
        } else {
            super.withdraw(amount + 1);
        }
    }

    public void earnMonthlyInterest() {
        super.deposit(getBalance() * rate);
        count = 3;
    }
}