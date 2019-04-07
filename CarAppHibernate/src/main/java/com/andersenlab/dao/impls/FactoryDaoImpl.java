package com.andersenlab.dao.impls;

import com.andersenlab.dao.interfaces.DaoFactory;
import com.andersenlab.model.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FactoryDaoImpl implements DaoFactory <Factory> {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addFactory(Factory obj) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeFactoryById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Factory factory = (Factory) session.load(Factory.class, new Long(id));
        if (factory != null) {
            session.delete(factory);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public Factory getFactoryById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Factory factory = (Factory) session.load(Factory.class, new Long(id));
        transaction.commit();
        session.close();
        return factory;
    }

    @Override
    public void updateFactoryById(Factory obj, int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Factory factory = (Factory) session.load(Factory.class, new Long(id));
        factory.setAddress(obj.getAddress());
        factory.setProductionMight(obj.getProductionMight());
        session.saveOrUpdate(factory);
        transaction.commit();
        session.close();
    }
}
