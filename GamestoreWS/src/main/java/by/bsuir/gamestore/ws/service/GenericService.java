package by.bsuir.gamestore.ws.service;

import java.util.List;

public interface GenericService<T, K> {

    T add(T entity);

    T update(T entity);

    T saveOrUpdate(T entity);

    boolean deleteById(K key);

    void delete(T entity);

    T find(K key);

    List<T> findAll();

    boolean isAlreadyExist(T entity);

}