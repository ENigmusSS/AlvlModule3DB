package ua.golovchenko.phoneoperator.repo.Hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import ua.golovchenko.phoneoperator.config.HibernateUtils;
import ua.golovchenko.phoneoperator.entities.Abonent;
import ua.golovchenko.phoneoperator.repo.AbonentRepository;

import java.util.List;

public class AbonentRepositoryImpl extends GenericRepositoryImpl<Abonent> implements AbonentRepository {
    protected void init() {
        aClass = Abonent.class;
    }

    @Override
    public List<Abonent> getTop5Callers() {
        return getTop5("callsLength");
    }

    @Override
    public List<Abonent> getTop5Traffic() {
        return getTop5("trafficConsumed");
    }

    @Override
    public List<Abonent> getTop5Texters() {
        return getTop5("count(smsLog)");
    }

    @Override
    public void compareServicePopularity() {
        long callLengthSum = getFieldSum("callsLength");
        long trafficConsumedSum = getFieldSum("trafficConsumed");
        long smsSent = SMSRepositoryImpl.getSMSStorageSize();
        System.out.println(callLengthSum + "mins of calls performed");
        System.out.println(trafficConsumedSum + "mb of internet traffic consumed");
        System.out.println(smsSent + "short messeges sent");
    }

    private long getFieldSum(String fieldName) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            TypedQuery<Long> query = entityManager.createQuery("select sum(:fieldName) from Abonents", Long.class);
            query.setParameter("fieldName", fieldName);
            return query.getSingleResult();
        }
    }


    private List<Abonent> getTop5(String order) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            TypedQuery<Abonent> query = entityManager.createQuery("from Abonents order by :order desc ", aClass);
            query.setParameter("order", order);
            query.setMaxResults(5);
            return query.getResultList();
        }
    }

    @Override
    public Abonent getById(String id) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Abonent> query = criteriaBuilder.createQuery(aClass);
            Root<Abonent> from = query.from(aClass);
            query.select(from).where(criteriaBuilder.equal(from.get("number"), id));
            return entityManager.createQuery(query).getSingleResult();
        }
    }
}
