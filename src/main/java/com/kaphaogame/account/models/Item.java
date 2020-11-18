package com.kaphaogame.account.models;

public class Item {
    private String itemNo;
    private String itemName;
    private String itemPrice;
    private int itemQuality;

    public Item() {
    }

    public Item(String itemNo, String itemName, String itemPrice, int itemQuality) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuality = itemQuality;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuality() {
        return itemQuality;
    }

    public void setItemQuality(int itemQuality) {
        this.itemQuality = itemQuality;
    }
}
