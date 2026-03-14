package com.inventory.app;

import org.hibernate.Session;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;


public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Product p = new Product();
        p.setName("Pen");
        p.setPrice(10);
        p.setQuantity(100);

        session.save(p);

        session.getTransaction().commit();
        session.close();

        System.out.println("Hibernate Skill-3 executed successfully");
    }
}
