package com.apiit.eeashoppingapplication.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String prodId;

    private String prodName;
    private String prodDescription;
    private String prodCategoryId;
    private Double prodPrice;
    private String prodImage;

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

    public String getProdDiscription() {
        return prodDescription;
    }

    public void setProdDiscription(String prodDiscription) {
        this.prodDescription = prodDiscription;
    }

    public String getProdCategory() {
        return prodCategoryId;
    }

    public void setProdCategory(String prodCategory) {
        this.prodCategoryId = prodCategory;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdImage() {
        return prodImage;
    }

    public void setProdImage(String prodImage) {
        this.prodImage = prodImage;
    }
}
