package by.bsuir.gamestore.ws.dao;

import by.bsuir.gamestore.ws.entity.User;

public interface UserDao extends GenericDao<User, Integer> {

    User authorization(User unknownUser);

    boolean registration(User user);

}