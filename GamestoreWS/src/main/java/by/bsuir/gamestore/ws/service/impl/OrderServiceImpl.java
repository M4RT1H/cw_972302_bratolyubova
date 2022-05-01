package by.bsuir.gamestore.ws.service.impl;

import by.bsuir.gamestore.ws.dao.OrderDao;
import by.bsuir.gamestore.ws.entity.Order;
import by.bsuir.gamestore.ws.entity.User;
import by.bsuir.gamestore.ws.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl extends GenericServiceImpl<Order, Integer> implements OrderService {

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        super(orderDao);
    }

    @Transactional
    @Override
    public List findAllFromUser(User user) {
        return ((OrderDao) getDao()).findAllFromUser(user);
    }
}