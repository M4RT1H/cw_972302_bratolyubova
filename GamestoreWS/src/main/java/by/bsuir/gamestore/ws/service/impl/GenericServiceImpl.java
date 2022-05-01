package by.bsuir.gamestore.ws.service.impl;

import by.bsuir.gamestore.ws.dao.GenericDao;
import by.bsuir.gamestore.ws.service.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class GenericServiceImpl<T, K> implements GenericService<T, K> {

    private GenericDao<T, K> dao;

    public GenericServiceImpl(GenericDao<T, K> dao) {
        this.dao = dao;
    }

    GenericDao<T, K> getDao() {
        return dao;
    }

    @Transactional
    @Override
    public T add(T entity) {
        return dao.add(entity);
    }

    @Transactional
    @Override
    public T update(T entity) {
        return dao.update(entity);
    }

    @Transactional
    @Override
    public T saveOrUpdate(T entity) {
        return dao.saveOrUpdate(entity);
    }

    @Transactional
    @Override
    public boolean deleteById(K key) {
        return dao.deleteById(key);
    }

    @Transactional
    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Transactional
    @Override
    public T find(K key) {
        return dao.find(key);
    }

    @Transactional
    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Transactional
    @Override
    public boolean isAlreadyExist(T entity) {
        return dao.isAlreadyExist(entity);
    }

}
