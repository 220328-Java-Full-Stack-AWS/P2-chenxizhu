package com.revature.p2backend.entities;

import javax.persistence.*;
@Entity
@Table(name="product_table" , schema="public")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Integer id;


    //not working before cause has to use another entity
    // instead of just a column of the entity cascade is for sub categorizing
    //@OneToOne(cascade = CascadeType.ALL)

    //@OneToOne(fetch=FetchType.LAZY)
    @Column(name="product_name")
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

    public Product(String productName, String description, Double price, Integer inventoryAmount) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.inventoryAmount = inventoryAmount;
    }


    public Product(Integer id, String productName, Double price, String description, String imageUrl, Integer inventoryAmount) {
        this.id = id;
        this.productName = productName;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
