package com.andersenlab;

import com.andersenlab.dao.impls.CarDaoImpl;
import com.andersenlab.dao.impls.FactoryDaoImpl;
import com.andersenlab.dao.impls.FerrariDaoImpl;
import com.andersenlab.dao.impls.McLarenDaoImpl;
import com.andersenlab.dao.interfaces.DaoCar;
import com.andersenlab.dao.interfaces.DaoFactory;
import com.andersenlab.dao.interfaces.DaoFerrari;
import com.andersenlab.dao.interfaces.DaoMacLaren;
import com.andersenlab.model.Car;
import com.andersenlab.model.Factory;
import com.andersenlab.model.Ferrari;
import com.andersenlab.model.McLaren;
import com.andersenlab.service.HibernateUtil;
import org.hibernate.SessionFactory;


public class Runner {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionfactory();

        DaoFactory <Factory> daoFactory = new FactoryDaoImpl();
        daoFactory.setSessionFactory(sessionFactory);

        DaoCar <Car> daoCar = new CarDaoImpl();
        daoCar.setSessionCar(sessionFactory);

        DaoFerrari <Ferrari> daoFerrari = new FerrariDaoImpl();
        daoFerrari.setSessionFerrari(sessionFactory);

        DaoMacLaren <McLaren> daoMacLaren = new McLarenDaoImpl();
        daoMacLaren.setSessionMcLaren(sessionFactory);

        //Factory
        Factory factory1 = new Factory("Usa", 1000);
        Factory factory2 = new Factory("Canada", 2000);
        Factory factory3 = new Factory("Brazil", 3000);
        Factory factory4 = new Factory("England", 4000);

        daoFactory.addFactory(factory1);
        daoFactory.addFactory(factory2);
        daoFactory.addFactory(factory3);

        daoFactory.removeFactoryById(1);

        Factory factoryWithId2 = daoFactory.getFactoryById(2);
        System.out.println(factoryWithId2);

        daoFactory.updateFactoryById(factory4, 3);

        //Car
        Car car1 = new Car(factory2, "plant1", 500);
        Car car2 = new Car(factory3, "plant2", 700);
        Car car3 = new Car(factory4, "plant3", 800);

        daoCar.addCar(car1);
        daoCar.addCar(car2);

        daoCar.removeCarById(1);

        daoCar.updateCarById(car3, 2);

        Car carWithId2 = daoCar.getCarById(2);
        System.out.println(carWithId2);

        //Ferrari
        Ferrari ferrari1 = new Ferrari(factory3, "plant1", 500, 54634);
        daoFerrari.addFerrari(ferrari1);

        //McLaren
        McLaren mcLaren1 = new McLaren(factory4, "plant1", 500, "value");
        daoMacLaren.addMcLaren(mcLaren1);

        sessionFactory.close();


    }
}
