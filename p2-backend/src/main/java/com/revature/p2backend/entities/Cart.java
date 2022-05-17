package com.revature.p2backend.entities;

import javax.persistence.*;

@Entity
@Table(name="cart" , schema="public")
public class Cart {
    @Id
    @GeneratedValue
    private Integer cartId;

    @OneToMany
    @JoinColumn(name="product_id", referencedColumnName = "product_id")
    private Product product;

    @Column
    private Double total;

    @Column(name="product_quantity")
    private Integer productQuantity;

    @OneToOne
    @JoinColumn(name="transaction_id", referencedColumnName = "transaction_id")
    private Transactions transactions;

}
