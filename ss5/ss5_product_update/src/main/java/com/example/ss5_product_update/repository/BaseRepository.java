package com.example.ss5_product_update.repository;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import javax.persistence.EntityManager;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class BaseRepository {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    public static EntityManager getEntityManager() {
        return entityManager;
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
