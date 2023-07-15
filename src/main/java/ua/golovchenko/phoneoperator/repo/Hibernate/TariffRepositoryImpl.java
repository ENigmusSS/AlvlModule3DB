package ua.golovchenko.phoneoperator.repo.Hibernate;

import ua.golovchenko.phoneoperator.entities.Tariff;
import ua.golovchenko.phoneoperator.repo.TariffRepository;

public class TariffRepositoryImpl extends GenericRepositoryImpl<Tariff> implements TariffRepository {
    @Override
    protected void init() {
        aClass = Tariff.class;
    }
}
