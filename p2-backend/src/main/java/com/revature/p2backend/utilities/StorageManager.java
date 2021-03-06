package com.revature.p2backend.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;
import java.util.List;

public class StorageManager {

    private List<Class> annotatedEntities;
    private SessionFactory sessionFactory;
    private Session session;


    public StorageManager() {
        annotatedEntities = new LinkedList<>();
    }

    public void addAnnotatedClass(Class c){
        annotatedEntities.add(c);
    }

    public Session initializeDataSource(){
        Configuration config = new Configuration();

        for(Class c: annotatedEntities){
            config.addAnnotatedClass(c);
        }

        SessionFactory sessionFactory = config.buildSessionFactory();

        Session session = sessionFactory.openSession();
        return session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return session;
    }
}