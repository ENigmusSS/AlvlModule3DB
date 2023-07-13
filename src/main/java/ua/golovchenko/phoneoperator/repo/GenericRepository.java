package ua.golovchenko.phoneoperator.repo;

import java.util.List;

public interface GenericRepository<T> {
    T getById(String id);

    List<T> getAll();

    void save(T obj);
    void delete(T obj);
}