package com.yakumo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Author cho1r
 * 2022/01/09 下午 12:54
 */
public class User implements Serializable {

    private long userId;
    private String userName;
    private char userSex;
    private Date userBirthday;
    private String userAddress;

    // 一对多关系映射
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public void setUserSex(char userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "userId=" + userId +
//                ", userName='" + userName + '\'' +
//                ", userSex=" + userSex +
//                ", userBirthday=" + userBirthday +
//                ", userAddress='" + userAddress + '\'' +
//                '}';
//    }
}
