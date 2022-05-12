package com.revature.p2backend.beans.repositories;

import com.revature.p2backend.entities.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductRepository implements HibernateRepository<Product>{

    private Session session;
    private String tableName;

    public ProductRepository(Session session, String tableName) {
        this.session = session;
        this.tableName = "product_table";//make connection to the product_table in sql
    }

    @Override
    public void save(Product product) {
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();

    }

    @Override
    public List<Product> getAll() {
        /*
        where I left 5/11/2022 start here next day reference below
        https://github.com/220328-Java-Full-Stack-AWS/TEAM-B-P2/blob/3f82b61d1099ce2613b266c303e46ee371b4779b/p2-backend/src/main/java/com/revature/p2backend/beans/dao/ProductDao.java
         */
        return null;
    }

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
