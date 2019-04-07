package com.andersenlab.dao.interfaces;

import org.hibernate.SessionFactory;

public interface DaoMacLaren<T> {

    void setSessionMcLaren(SessionFactory sessionFactory);

    void addMcLaren(T obj);

    void removeMcLarenById(int id);

    T getMcLarenById(int id);

    void updateMcLarenById(T obj, int id);

}
