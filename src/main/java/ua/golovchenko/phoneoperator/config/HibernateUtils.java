package ua.golovchenko.phoneoperator.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.golovchenko.phoneoperator.entities.Abonent;
import ua.golovchenko.phoneoperator.entities.Device;
import ua.golovchenko.phoneoperator.entities.SMS;

import ua.golovchenko.phoneoperator.entities.Tariff;

import static jakarta.persistence.Persistence.createEntityManagerFactory;


public class HibernateUtils {
    private static SessionFactory factory;
    private static EntityManager entityManager;

    private static void configureFactory() {
        try {
            factory = new Configuration()
                    .addAnnotatedClass(Abonent.class)
                    .addAnnotatedClass(Tariff.class)
                    .addAnnotatedClass(SMS.class)
                    .addAnnotatedClass(Device.class)
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static void configureEntityManager() {
        EntityManagerFactory factory = createEntityManagerFactory("moduleDB");
        entityManager = factory.createEntityManager();
    }

    public static SessionFactory getFactory() {
        if (factory == null) {
            configureFactory();
        }
        return factory;
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            configureEntityManager();
        }
        return entityManager;
    }


}