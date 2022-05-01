package by.bsuir.gamestore.ws.dao.impl;

import by.bsuir.gamestore.ws.dao.RatingDao;
import by.bsuir.gamestore.ws.entity.Rating;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RatingDaoImpl extends GenericDaoImpl<Rating, Integer> implements RatingDao {

    @Autowired
    public RatingDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Rating saveOrUpdate(Rating newRating) {
        Criteria criteria = getSession().createCriteria(Rating.class);
        criteria.add(Restrictions.eq("user", newRating.getUser()));
        criteria.add(Restrictions.eq("game", newRating.getGame()));
        Rating rating = (Rating) criteria.uniqueResult();
        if (rating == null) {
            rating = add(newRating);
        } else {
            rating.setValue(newRating.getValue());
            update(rating);
        }
        return rating;
    }

    @Override
    public boolean isAlreadyExist(Rating rating) {
        Criteria criteria = getSession().createCriteria(Rating.class);
        criteria.add(Restrictions.eq("user", rating.getUser()));
        criteria.add(Restrictions.eq("game", rating.getGame()));
        return criteria.uniqueResult() != null;
    }
}
