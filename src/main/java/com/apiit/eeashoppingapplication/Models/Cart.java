package com.apiit.eeashoppingapplication.Models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String cartId;
    private String prodId;
    private String prodName;
    private String prodQty;
    private Double prodPrice;
    private Double cartTotal;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdQty() {
        return prodQty;
    }

    public void setProdQty(String prodQty) {
        this.prodQty = prodQty;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public Double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(Double cartTotal) {
        this.cartTotal = cartTotal;
    }
}
