package com.revature.p2backend.beans.repositories;

import com.revature.p2backend.entities.Product;
import org.hibernate.Session;

import java.util.LinkedList;
import java.util.List;

public class CartRepository {

    private Session session;
    private String tableName;

    public CartRepository(Session session) {
        this.session = session;
        this.tableName = "cart_table";
    }

    List<Product> cart = new LinkedList<>();

    public void addProduct(Product product){
        cart.add(product);
        System.out.println("product added.");
    }

    public void removeProduct(Product product){
        cart.remove(product);
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }
}
