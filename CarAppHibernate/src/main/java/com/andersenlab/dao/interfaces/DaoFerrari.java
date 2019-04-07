package com.andersenlab.dao.interfaces;

import org.hibernate.SessionFactory;

public interface DaoFerrari<T> {

    void setSessionFerrari(SessionFactory sessionFactory);

    void addFerrari(T obj);

    void removeFerrariById(int id);

    T getFerrariById(int id);

    void updateFerrariById(T obj, int id);

}