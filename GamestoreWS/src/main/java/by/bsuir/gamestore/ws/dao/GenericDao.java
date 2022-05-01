package by.bsuir.gamestore.ws.dao;

import java.util.List;

public interface GenericDao<T, K> {
    T add(T entity);

    T update(T entity);

    T saveOrUpdate(T entity);

    boolean deleteById(K key);

    void delete(T entity);

    T find(K key);

    List<T> findAll();

    boolean isAlreadyExist(T entity);

}
