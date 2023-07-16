package ua.golovchenko.phoneoperator.repo.Hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ua.golovchenko.phoneoperator.config.HibernateUtils;
import ua.golovchenko.phoneoperator.entities.Device;
import ua.golovchenko.phoneoperator.repo.DeviceRepository;

public class DeviceRepositoryImpl extends GenericRepositoryImpl<Device> implements DeviceRepository {
    @Override
    protected void init() {
        aClass = Device.class;
    }

    @Override
    public Device findMostPopularDevice() {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()){
            TypedQuery<Device> query = entityManager.createQuery("from Devices where max(count(abonentSet) ) ", aClass);
        }
    }
}
