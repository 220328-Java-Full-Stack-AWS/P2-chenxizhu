package com.revature.p2backend.beans.repositories;

import com.revature.p2backend.entities.Product;

import java.util.LinkedList;
import java.util.List;

public class CartRepository {
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
