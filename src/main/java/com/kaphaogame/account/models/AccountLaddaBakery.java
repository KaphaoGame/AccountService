package com.kaphaogame.account.models;

public class AccountLaddaBakery {
    private String fullName;
    private String userName;
    private String password;
    private String email;
    private String tel;
    private String address;
    private String moreDetail;

    public AccountLaddaBakery(){

    }

    public AccountLaddaBakery(String fullName, String userName, String password, String email, String tel, String address, String moreDetail) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.moreDetail = moreDetail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMoreDetail() {
        return moreDetail;
    }

    public void setMoreDetail(String moreDetail) {
        this.moreDetail = moreDetail;
    }
}
