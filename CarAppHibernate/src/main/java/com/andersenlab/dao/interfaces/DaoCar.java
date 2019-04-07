package com.andersenlab.dao.interfaces;

import org.hibernate.SessionFactory;

public interface DaoCar<T> {

    void setSessionCar(SessionFactory sessionFactory);

    void addCar(T obj);

    void removeCarById(int id);

    T getCarById(int id);

    void updateCarById(T obj, int id);

}