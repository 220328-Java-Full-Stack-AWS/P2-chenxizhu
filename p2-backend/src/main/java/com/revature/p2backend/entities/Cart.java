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

    @OneToOne
    @JoinColumn(name="total", referencedColumnName = "total")
    private Double total;

    @Column(name="product_quantity")
    private Integer productQuantity;

    @OneToOne
    @JoinColumn(name="transaction_id", referencedColumnName = "transaction_id")
    private Transactions transactionsId;

    public Cart() {
    }

    public Cart(Integer cartId, Product product, Double total, Integer productQuantity, Transactions transactionsId) {
        this.cartId = cartId;
        this.product = product;
        this.total = total;
        this.productQuantity = productQuantity;
        this.transactionsId = transactionsId;
    }

    public Cart(Double total) {
        this.total = total;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Transactions getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(Transactions transactionsId) {
        this.transactionsId = transactionsId;
    }
}
