package com.apiit.eeashoppingapplication.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Promotions {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String promId;
    private String promName;
    private String promDiscription;
    private Double prodPrecentage;

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
        return prodPrecentage;
    }

    public void setProdPrecentage(Double prodPrecentage) {
        this.prodPrecentage = prodPrecentage;
    }
}
