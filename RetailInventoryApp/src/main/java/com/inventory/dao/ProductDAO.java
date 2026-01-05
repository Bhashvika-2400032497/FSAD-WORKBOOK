
package com.inventory.dao;

import org.hibernate.*;
import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class ProductDAO {

    public void addProduct(Product p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(p);
        t.commit();
        s.close();
    }

    public Product getProduct(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Product p = s.get(Product.class, id);
        s.close();
        return p;
    }

    public void updateProduct(int id, double price, int qty) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Product p = s.get(Product.class, id);
        p.setPrice(price);
        p.setQuantity(qty);
        t.commit();
        s.close();
    }

    public void deleteProduct(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        Product p = s.get(Product.class, id);
        s.delete(p);
        t.commit();
        s.close();
    }
}
