package com.kaphaogame.account.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
    @Column
    private String orderNo;

    @Column
    private String orderName;

    @Column
    private String orderTotalPrice;

    @Column
    private String orderAddress;

    @Column
    private String orderTime;

    @Column
    private String orderStatus;

    @Column
    private String orderDate;

    @Column
    private String deliveryFee;

    public Order() {
    }

    public Order(String orderNo, String orderName, String orderTotalPrice, String orderAddress, String orderTime, String orderStatus, String orderDate, String deliveryFee) {
        this.orderNo = orderNo;
        this.orderName = orderName;
        this.orderTotalPrice = orderTotalPrice;
        this.orderAddress = orderAddress;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.deliveryFee = deliveryFee;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(String orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
}
