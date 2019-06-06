package com.apiit.eeashoppingapplication.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderItem {


    @Id
    @GeneratedValue
    private String itemId;

    @ManyToOne
    @JoinColumn
    private Product product;

    @ManyToOne
    @JoinColumn
    private Sales sales;


    private int prodQty;


}
