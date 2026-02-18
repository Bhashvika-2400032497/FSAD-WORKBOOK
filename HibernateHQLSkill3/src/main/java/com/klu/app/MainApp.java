package com.klu.app;

import java.util.List;
import org.hibernate.*;
import com.klu.entity.Product;
import com.klu.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        insertProducts(session);

        // 1. Sort by price ASC
        List<Product> asc =
            session.createQuery("FROM Product p ORDER BY p.price ASC", Product.class).list();

        // 2. Sort by price DESC
        List<Product> desc =
            session.createQuery("FROM Product p ORDER BY p.price DESC", Product.class).list();

        // 3. Sort by quantity DESC
        List<Product> qty =
            session.createQuery("FROM Product p ORDER BY p.quantity DESC", Product.class).list();

        // 4. Pagination
        Query<Product> q1 =
            session.createQuery("FROM Product", Product.class);
        q1.setFirstResult(0);
        q1.setMaxResults(3);

        Query<Product> q2 =
            session.createQuery("FROM Product", Product.class);
        q2.setFirstResult(3);
        q2.setMaxResults(3);

        // 5. Aggregate functions
        Long total =
            session.createQuery("SELECT COUNT(p) FROM Product p", Long.class)
                   .getSingleResult();

        Long available =
            session.createQuery(
                "SELECT COUNT(p) FROM Product p WHERE p.quantity > 0",
                Long.class
            ).getSingleResult();

        Object[] minMax =
            (Object[]) session.createQuery(
                "SELECT MIN(p.price), MAX(p.price) FROM Product p"
            ).getSingleResult();

        // 6. Group by description
        List<Object[]> group =
            session.createQuery(
                "SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description",
                Object[].class
            ).list();

        // 7. Price range
        List<Product> range =
            session.createQuery(
                "FROM Product p WHERE p.price BETWEEN 500 AND 5000",
                Product.class
            ).list();

        // 8. LIKE examples
        session.createQuery("FROM Product p WHERE p.pname LIKE 'L%'", Product.class).list();
        session.createQuery("FROM Product p WHERE p.pname LIKE '%r'", Product.class).list();
        session.createQuery("FROM Product p WHERE p.pname LIKE '%top%'", Product.class).list();
        session.createQuery("FROM Product p WHERE LENGTH(p.pname)=5", Product.class).list();

        session.close();
    }

    static void insertProducts(Session session) {
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", 55000, 10, "Electronics"));
        session.save(new Product("Mouse", 500, 50, "Electronics"));
        session.save(new Product("Keyboard", 1200, 30, "Electronics"));
        session.save(new Product("Chair", 3000, 15, "Furniture"));
        session.save(new Product("Table", 7000, 5, "Furniture"));
        session.save(new Product("Bottle", 250, 100, "Accessories"));

        tx.commit();
    }
}
