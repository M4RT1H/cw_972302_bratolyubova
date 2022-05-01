package by.bsuir.gamestore.ws.dao.impl;

import by.bsuir.gamestore.ws.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class GenericDaoImpl<T, K extends Serializable> implements GenericDao<T, K> {

    private SessionFactory sessionFactory;
    private Class<? extends T> clazz;

    @Autowired
    public GenericDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T add(T entity) {
        getSession().save(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        getSession().update(entity);
        return entity;
    }

    @Override
    public T saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public boolean deleteById(K key) {
        T entity = find(key);
        if (entity != null) {
            delete(entity);
            return true;
        }
        return false;
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public T find(K key) {
        return (T) getSession().get(clazz, key);
    }

    @Override
    public List<T> findAll() {
        return getSession().createCriteria(this.clazz).list();
    }

}
