package com.revature.p2backend.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="transaction_table" , schema="public")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private Integer id;

    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    private Cart cartId;

    @Column(name="username")
    private String username;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="created_at")
    private Timestamp createAt;

    //add product here as the way group P2 add User in orders
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", referencedColumnName = "product_id")
    //@Column(name="product_name")
    //@ManyToOne(fetch=FetchType.LAZY)
    private Product product;

    @JoinColumn(name="total" , referencedColumnName = "total")
    private Double total;

    @Column(name="paid")
    private Boolean paid;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="email_address")
    private String email;

    @Column(name="credit_card")
    private String creditCard;

    @Column(name="phone_number")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    public Transactions() {
    }

    public Transactions(Integer id, String username, Integer userId, Timestamp createAt, Double total, Boolean paid, String firstname, String lastname, String email, String creditCard, String phone, String address, String city, String state, String country) {
        this.id = id;
        this.username = username;
        this.userId = userId;
        this.createAt = createAt;
        this.total = total;
        this.paid = paid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.creditCard = creditCard;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Transactions(Cart cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
