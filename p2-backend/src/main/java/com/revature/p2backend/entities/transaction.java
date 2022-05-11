package com.revature.p2backend.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="transactions" , schema="public")
public class transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="created_at")
    private Timestamp createAt;

    @Column(name="total_cost")
    private Double total;

    @Column(name="paid")
    private Boolean paid;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="email_address")
    private String email;

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
}
