package com.andersenlab.dao.impls;

import com.andersenlab.dao.interfaces.DaoMacLaren;
import com.andersenlab.model.McLaren;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class McLarenDaoImpl implements DaoMacLaren <McLaren> {

    private SessionFactory sessionFactory;

    @Override
    public void setSessionMcLaren(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addMcLaren(McLaren obj) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeMcLarenById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        McLaren mcLaren = (McLaren) session.load(McLaren.class, new Long(id));
        if (mcLaren != null) {
            session.delete(mcLaren);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public McLaren getMcLarenById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        McLaren mcLaren = (McLaren) session.load(McLaren.class, new Long(id));
        transaction.commit();
        session.close();
        return mcLaren;
    }

    @Override
    public void updateMcLarenById(McLaren obj, int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        McLaren mcLaren = (McLaren) session.load(McLaren.class, new Long(id));
        mcLaren.setFactory(obj.getFactory());
        mcLaren.setName(obj.getName());
        mcLaren.setProductionYear(obj.getProductionYear());
        mcLaren.setFernandoAlonsoKarma(obj.getFernandoAlonsoKarma());
        session.saveOrUpdate(mcLaren);
        transaction.commit();
        session.close();
    }
}
