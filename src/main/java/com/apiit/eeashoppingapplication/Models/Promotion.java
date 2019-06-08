package com.apiit.eeashoppingapplication.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Entity
public class Promotion {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "promo_id")
    private String promId;



    private String promName;
    private String promDiscription;
    private Double prodPercentage;

    private int duration;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date startDate;

    private Date endDate = handleEndDate();

    @OneToMany(mappedBy = "promotion")
    @JsonIgnoreProperties("promotion")
    private Set<Product> products;

    public String getPromId() {
        return promId;
    }

    public void setPromId(String promId) {
        this.promId = promId;
    }

    public String getPromName() {
        return promName;
    }

    public void setPromName(String promName) {
        this.promName = promName;
    }

    public String getPromDiscription() {
        return promDiscription;
    }

    public void setPromDiscription(String promDiscription) {
        this.promDiscription = promDiscription;
    }

    public Double getProdPrecentage() {
        return prodPercentage;
    }

    public void setProdPrecentage(Double prodPrecentage) {
        this.prodPercentage = prodPrecentage;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    Date handleEndDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, duration);
        return cal.getTime();
    }
}
