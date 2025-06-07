package com.booksZone.booksZone.data.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String password;

    public List<Sellers> getSellers() {
        return sellers;
    }

    public void setSellers(List<Sellers> sellers) {
        this.sellers = sellers;
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Sellers> sellers;

    public Sellers getSeller() {
        return seller;
    }

    public void setSeller(Sellers seller) {
        this.seller = seller;
    }

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Sellers seller;
}
