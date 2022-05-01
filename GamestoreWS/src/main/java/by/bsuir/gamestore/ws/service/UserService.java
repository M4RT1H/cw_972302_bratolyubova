package by.bsuir.gamestore.ws.service;

import by.bsuir.gamestore.ws.entity.User;

public interface UserService extends GenericService<User, Integer> {

    User authorization(User unknownUser);

    boolean registration(User user);

}
