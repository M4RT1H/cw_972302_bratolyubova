package by.bsuir.gamestore.ws.dao.impl;

import by.bsuir.gamestore.ws.dao.UserDao;
import by.bsuir.gamestore.ws.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void delete(User user){
        user.setDeleted(true);
        update(user);
    }

    @Override
    public boolean isAlreadyExist(User user) {
        User oldUser = find(user.getId());
        Criteria usernameCriteria = getSession().createCriteria(User.class);
        Criteria emailCriteria = getSession().createCriteria(User.class);
        usernameCriteria.add(Restrictions.eq("username", user.getUsername()));
        emailCriteria.add(Restrictions.eq("email", user.getEmail()));
        return (usernameCriteria.uniqueResult() != null &&
                (oldUser == null || !user.getUsername().equals(oldUser.getUsername())))
                || (emailCriteria.uniqueResult() != null &&
                (oldUser == null || !user.getEmail().equals(oldUser.getEmail())));
    }

    @Override
    public User authorization(User unknownUser) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", unknownUser.getUsername()));
        criteria.add(Restrictions.eq("password", unknownUser.getPassword()));
        return (User) criteria.uniqueResult();
    }

    @Override
    public boolean registration(User user) {
        if (!isAlreadyExist(user)) {
            add(user);
            return true;
        }
        return false;
    }
}