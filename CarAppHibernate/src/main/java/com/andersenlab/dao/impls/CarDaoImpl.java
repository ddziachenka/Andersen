package com.andersenlab.dao.impls;

import com.andersenlab.dao.interfaces.DaoCar;
import com.andersenlab.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CarDaoImpl implements DaoCar <Car> {

    private SessionFactory sessionFactory;

    @Override
    public void setSessionCar(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(Car obj) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeCarById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = (Car) session.load(Car.class, new Long(id));
        if (car != null) {
            session.delete(car);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public Car getCarById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = (Car) session.load(Car.class, new Long(id));
        transaction.commit();
        session.close();
        return car;
    }

    @Override
    public void updateCarById(Car obj, int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Car car = (Car) session.load(Car.class, new Long(id));
        car.setFactory(obj.getFactory());
        car.setName(obj.getName());
        car.setProductionYear(obj.getProductionYear());
        session.saveOrUpdate(car);
        transaction.commit();
        session.close();
    }
}
