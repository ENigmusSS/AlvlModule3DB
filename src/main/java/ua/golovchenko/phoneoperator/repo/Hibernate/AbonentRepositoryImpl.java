package ua.golovchenko.phoneoperator.repo.Hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
        return getTop5("calls_length");
    }

    @Override
    public List<Abonent> getTop5Traffic() {
        return getTop5("traffic_consumed");
    }

    @Override
    public List<Abonent> getTop5Texters() {
        return getTop5("sms_log.size");
    }

    private List<Abonent> getTop5(String order) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        TypedQuery<Abonent> query = entityManager.createQuery("from Abonents order by :order", aClass);
        query.setParameter("order", order);
        query.setMaxResults(5);
        return query.getResultList();
    }
}
