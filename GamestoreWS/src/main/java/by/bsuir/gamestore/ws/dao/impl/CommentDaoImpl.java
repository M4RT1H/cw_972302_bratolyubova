package by.bsuir.gamestore.ws.dao.impl;

import by.bsuir.gamestore.ws.dao.CommentDao;
import by.bsuir.gamestore.ws.entity.Comment;
import by.bsuir.gamestore.ws.entity.Game;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl extends GenericDaoImpl<Comment, Integer> implements CommentDao {

    @Autowired
    public CommentDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public boolean isAlreadyExist(Comment comment) {
        return false;
    }

    @Override
    public List findAllForGame(Game game) {
        Criteria criteria = getSession().createCriteria(Comment.class);
        criteria.add(Restrictions.eq("game", game));
        return criteria.list();
    }
}
