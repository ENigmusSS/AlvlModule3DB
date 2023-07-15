package ua.golovchenko.phoneoperator.repo.Hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import ua.golovchenko.phoneoperator.config.HibernateUtils;
import ua.golovchenko.phoneoperator.entities.Abonent;
import ua.golovchenko.phoneoperator.entities.SMS;
import ua.golovchenko.phoneoperator.repo.SMSRepository;

import java.util.List;

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

    @Override
    public List<SMS> searchBySignature(String signature) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()){
            TypedQuery<SMS> query = entityManager.createQuery("from SMS_Storage where text like %:signature%", aClass);
            query.setParameter("signature", signature);
            return query.getResultList();
        }
    }
    @Override
    public SMS getById(String id) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<SMS> query = criteriaBuilder.createQuery(aClass);
            Root<SMS> from = query.from(aClass);
            query.select(from).where(criteriaBuilder.equal(from.get("sms_ID"), id));
            return entityManager.createQuery(query).getSingleResult();
        }
    }
}
