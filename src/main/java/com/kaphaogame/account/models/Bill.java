package com.kaphaogame.account.models;

public class Bill {
    private String billNo;
    private String billAddress;
    private String billStatus;
    private String billTotalPrice;
    private String billDate;
    private String billTime;
    private String senderName;
    private String recipientName;
    private String paymentMethod;
    private String billOrderNo;

    public Bill() {
    }

    public Bill(String billNo, String billAddress, String billStatus, String billTotalPrice,
                String billDate, String billTime, String senderName, String recipientName,
                String paymentMethod, String billOrderNo) {
        this.billNo = billNo;
        this.billAddress = billAddress;
        this.billStatus = billStatus;
        this.billTotalPrice = billTotalPrice;
        this.billDate = billDate;
        this.billTime = billTime;
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.paymentMethod = paymentMethod;
        this.billOrderNo = billOrderNo;
    }

    public String getBillOrderNo() {
        return billOrderNo;
    }

    public void setBillOrderNo(String billOrderNo) {
        this.billOrderNo = billOrderNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(String billAddress) {
        this.billAddress = billAddress;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getBillTotalPrice() {
        return billTotalPrice;
    }

    public void setBillTotalPrice(String billTotalPrice) {
        this.billTotalPrice = billTotalPrice;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillTime() {
        return billTime;
    }

    public void setBillTime(String billTime) {
        this.billTime = billTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
