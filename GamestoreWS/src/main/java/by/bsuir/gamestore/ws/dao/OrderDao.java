package by.bsuir.gamestore.ws.dao;

import by.bsuir.gamestore.ws.entity.Order;
import by.bsuir.gamestore.ws.entity.User;

import java.util.List;

public interface OrderDao extends GenericDao<Order, Integer> {

    List findAllFromUser(User user);

}
