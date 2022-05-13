package com.revature.p2backend.entities;

import javax.persistence.*;
@Entity
@Table(name="product_table" , schema="public")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_name", referencedColumnName = "product_name")
    private String productName;

    @Column(name="price")
    private Double price;

    @Column(name="description")
    private String description;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="inventory_amount")
    private Integer inventoryAmount;

    public Product() {
    }

    public Product(String name, String description, Double price, Integer inventoryAmount) {
        this.productName = name;
        this.price = price;
        this.description = description;
        this.inventoryAmount = inventoryAmount;
    }

    public Product(Integer id, String name, Double price, String description, String imageUrl, Integer inventoryAmount) {
        this.id = id;
        this.productName = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.inventoryAmount = inventoryAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(Integer inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }
}
