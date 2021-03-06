package com.revature.p2backend.beans.repositories;


import java.util.List;

public interface HibernateRepository<T> {
    public void save(T t);
    public List<T> getAll();
    public T getById(Integer id);
    public void update(T t);
    public void delete(T t);

}
