package by.bsuir.gamestore.ws.service;

import by.bsuir.gamestore.ws.entity.Order;
import by.bsuir.gamestore.ws.entity.User;

import java.util.List;

public interface OrderService extends GenericService<Order, Integer> {

    List findAllFromUser(User user);

}
