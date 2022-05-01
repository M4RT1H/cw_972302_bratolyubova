package by.bsuir.gamestore.ws.service.impl;

import by.bsuir.gamestore.ws.dao.UserDao;
import by.bsuir.gamestore.ws.entity.User;
import by.bsuir.gamestore.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super(userDao);
    }

    @Transactional
    @Override
    public User authorization(User unknownUser) {
        return ((UserDao)getDao()).authorization(unknownUser);
    }

    @Transactional
    @Override
    public boolean registration(User user) {
        return ((UserDao)getDao()).registration(user);
    }
}