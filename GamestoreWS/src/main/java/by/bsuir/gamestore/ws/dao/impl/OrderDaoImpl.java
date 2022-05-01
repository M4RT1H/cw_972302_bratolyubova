package by.bsuir.gamestore.ws.dao.impl;

import by.bsuir.gamestore.ws.dao.OrderDao;
import by.bsuir.gamestore.ws.entity.Order;
import by.bsuir.gamestore.ws.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order, Integer> implements OrderDao {

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public boolean isAlreadyExist(Order entity) {
        return false;
    }

    @Override
    public List findAllFromUser(User user) {
        Criteria criteria = getSession().createCriteria(Order.class);
        criteria.add(Restrictions.eq("user", user));
        return criteria.list();
    }

}
