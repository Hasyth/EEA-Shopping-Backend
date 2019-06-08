package com.apiit.eeashoppingapplication.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private int userId;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp orderDate;
    private String diliveryAddress;
    private double totalPrice;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("sales")
    private List<OrderItem> orderItemList;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getDiliveryAddress() {
        return diliveryAddress;
    }

    public void setDiliveryAddress(String diliveryAddress) {
        this.diliveryAddress = diliveryAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
