package com.apiit.eeashoppingapplication.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class User {
    @Id
    @NotNull
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String userId;

    public String userName;


    @Column(unique = true)
    @Email
    public String email;

    public String password;
    public String address;
    public String contact;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_type", joinColumns = @JoinColumn(name = "user_name"), inverseJoinColumns = @JoinColumn(name = "userType_id"))
    public Set<Usertype> usertype;

    public String image;


    public User() {

    }

    public User(User user) {
        this.userName = user.userName;
        this.password = user.password;
        this.email = user.email;
        this.address = user.address;
        this.contact = user.contact;
        this.usertype = user.usertype;
        this.image = user.image;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Set<Usertype> getUsertype() {
        return usertype;
    }

    public void setUsertype(Set<Usertype> usertype) {
        this.usertype = usertype;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
