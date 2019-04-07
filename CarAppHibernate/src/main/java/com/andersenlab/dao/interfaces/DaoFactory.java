package com.andersenlab.dao.interfaces;

import org.hibernate.SessionFactory;

public interface DaoFactory<T> {

    void setSessionFactory(SessionFactory sessionFactory);

    void addFactory(T obj);

    void removeFactoryById(int id);

    T getFactoryById(int id);

    void updateFactoryById(T obj, int id);

}
