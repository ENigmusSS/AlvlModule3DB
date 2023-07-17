package ua.golovchenko.phoneoperator.repo;

import ua.golovchenko.phoneoperator.entities.Abonent;

import java.util.List;

public interface AbonentRepository extends GenericRepository<Abonent> {

    List<Abonent> getTop5Callers();

    List<Abonent> getTop5Traffic();

    List<Abonent> getTop5Texters();

    void compareServicePopularity();

}
