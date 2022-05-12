package com.revature.p2backend.beans.repositories;

import com.revature.p2backend.entities.Transactions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

public class TransactionRepository implements HibernateRepository<Transactions>{

    private Session session;

    @Override
    public void save(Transactions transactions) {
        Transaction tx = session.beginTransaction();
        session.save(transactions);
        tx.commit();
    }

    @Override
    public List<Transactions> getAll() {
        TypedQuery<Transactions> query = session.createQuery("FROM Transactions", Transactions.class);
        return query.getResultList();
        //redundant replaced with the one liner above
//        List<Transactions> transactions = query.getResultList();
//        return transactions;
    }

    @Override
    public Transactions getById(Integer id) {
        TypedQuery<Transactions> query = session.createQuery("FROM Transactions where id = :id", Transactions.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Transactions transactions) {

    }

    @Override
    public void delete(Transactions transactions) {

    }
}
