package ua.golovchenko.phoneoperator.repo.Hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ua.golovchenko.phoneoperator.config.HibernateUtils;
import ua.golovchenko.phoneoperator.entities.SMS;
import ua.golovchenko.phoneoperator.repo.SMSRepository;

public class SMSRepositoryImpl extends GenericRepositoryImpl<SMS> implements SMSRepository {
    protected void init() {
        aClass = SMS.class;
    }
    protected static long getSMSStorageSize() {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()){
            TypedQuery<Long> query = entityManager.createQuery("select count(*) from SMS_Storage ", Long.class);
            return query.getSingleResult();
        }
    }
}
