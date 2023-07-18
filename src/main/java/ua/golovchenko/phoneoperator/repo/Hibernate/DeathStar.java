package ua.golovchenko.phoneoperator.repo.Hibernate;

import jakarta.persistence.EntityManager;
import ua.golovchenko.phoneoperator.config.HibernateUtils;

public class DeathStar {
    public static void destroy() {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.createQuery("delete from SMS_Storage");
            entityManager.createQuery("delete from Abonents");
            entityManager.createQuery("delete from Tariffs");
            entityManager.createQuery("delete from Devices");
        }
    }
}
