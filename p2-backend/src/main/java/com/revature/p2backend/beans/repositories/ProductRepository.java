package com.revature.p2backend.beans.repositories;

import com.revature.p2backend.entities.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
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
        TypedQuery<Product> query = session.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }

    @Override
    public Product getById(Integer id) {
        TypedQuery<Product> query = session.createQuery("FROM Product WHERE id = :product_id", Product.class);
        query.setParameter("id", id);

        return query.getSingleResult();

    }

    @Override
    public void update(Product product) {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("UPDATE Product SET " +
                "product_name = :name, price = :price, description = :description, inventory_amount = :inventoryAmount " +
                "WHERE id = :id");
        query.setParameter("name", product.getName());
        query.setParameter("price", product.getPrice());
        query.setParameter("description", product.getDescription());
        query.setParameter("inventory", product.getInventoryAmount());
        query.setParameter("id", product.getId());
        query.executeUpdate();
        tx.commit();
    }

    @Override
    public void delete(Product product) {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("Delete Product WHERE id = :id");
        query.setParameter("productId", product.getId());
        query.executeUpdate();
        tx.commit();
    }

    public Product getByProductName(String name){
        TypedQuery<Product> query = session.createQuery("FROM Product WHERE name = :productName", Product.class);
        query.setParameter("productName", name);
        Product product = query.getSingleResult();

        return product;
    }


    //need to look into it more with the lower and upper
    public List<Product> getByPriceRange(Double lower, Double upper){
        TypedQuery<Product> query = session.createQuery("FROM Product WHERE price between :lower and :upper");
        query.setParameter("lower", lower);
        query.setParameter("upper", upper);
        List<Product> products = query.getResultList();

        return products;
    }

    public List<Product> getProductWithSubstring(String substring){
        String newString = "%" + substring + "%";
        TypedQuery<Product> query = session.createQuery("FROM Product WHERE name LIKE :substring", Product.class);
        query.setParameter("substring", newString);
        List<Product> products = query.getResultList();

        return products;
    }
}
