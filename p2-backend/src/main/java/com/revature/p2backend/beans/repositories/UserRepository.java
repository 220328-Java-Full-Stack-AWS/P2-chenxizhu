package com.revature.p2backend.beans.repositories;

import com.revature.p2backend.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepository implements HibernateRepository<User> {
    private Session session;
    String tableName;

    public UserRepository(Session session, String tableName) {
        this.session = session;
        this.tableName = "user_table";//make connection to the table users
    }

    @Override
    public void save(User u) {
        Transaction tx = session.beginTransaction();
        session.save(u);
        tx.commit();
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> query = session.createQuery("FROM User", User.class);
        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public User getById(Integer id) {
        TypedQuery<User> query = session.createQuery("FROM User where id = :user_id");
        query.setParameter("user_id", id);
        User user = query.getSingleResult();
        return user;
    }

    @Override
    public void update(User user) {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("UPDATE User SET " +
                "username = :username, password = :password, firstname = :first_name, lastname = :lastname, email = :email, createCard = :credit_card, phone = :phone_number "
                + "where id = :user_id"
                );
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        query.setParameter("first_name", user.getFirstname());
        query.setParameter("last_name", user.getLastname());
        query.setParameter("email", user.getEmail());
        query.setParameter("credit_card", user.getCreditCard());
        query.setParameter("phone", user.getPhone());
        query.setParameter("user_id", user.getId());
        query.executeUpdate();
        tx.commit();
    }

    @Override
    public void delete(User user) {
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("DELETE User where id = :user_id");
        query.setParameter("user_id", user.getId());
        query.executeUpdate();
        tx.commit();
    }

    public User getUserByUsername(String username) {
        TypedQuery<User> query = session.createQuery("FROM User WHERE username = :username ", User.class);
        query.setParameter("username", username);
        User user = query.getSingleResult();

        return user;
    }

}
