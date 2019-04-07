package com.andersenlab.dao.impls;

import com.andersenlab.dao.interfaces.DaoFerrari;
import com.andersenlab.model.Ferrari;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FerrariDaoImpl implements DaoFerrari <Ferrari> {

    private SessionFactory sessionFactory;

    @Override
    public void setSessionFerrari(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addFerrari(Ferrari obj) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeFerrariById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Ferrari ferrari = (Ferrari) session.load(Ferrari.class, new Long(id));
        if (ferrari != null) {
            session.delete(ferrari);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public Ferrari getFerrariById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Ferrari ferrari = (Ferrari) session.load(Ferrari.class, new Long(id));
        transaction.commit();
        session.close();
        return ferrari;
    }

    @Override
    public void updateFerrariById(Ferrari obj, int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Ferrari ferrari = (Ferrari) session.load(Ferrari.class, new Long(id));
        ferrari.setFactory(obj.getFactory());
        ferrari.setName(obj.getName());
        ferrari.setProductionYear(obj.getProductionYear());
        ferrari.setRedColorIntensity(obj.getRedColorIntensity());
        session.saveOrUpdate(ferrari);
        transaction.commit();
        session.close();
    }
}
