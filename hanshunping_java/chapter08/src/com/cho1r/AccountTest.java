package com.cho1r;

/**
 * Author cho1r
 * 2021/12/09 下午 06:05
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("adadadd", 23, "11");
        account.info();
    }
}

class Account {
    private String name;
    private double balance;
    private String pwd;

    public Account(String name, double balance, String pwd) {
        setName(name);
        setBalance(balance);
        setPwd(pwd);
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            this.name = "";
        }
    }

    public void setBalance(double balance) {
        if (balance >= 20)
            this.balance = balance;
        else
            throw new RuntimeException("余额须大于20.");
    }

    public void setPwd(String pwd) {
        if (pwd.length() == 6)
            this.pwd = pwd;
        else
            this.pwd = String.valueOf((int) (Math.random() * 1000000));
    }

    public void info() {
        System.out.println("Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", pwd='" + pwd + '\'' +
                '}');
    }
}