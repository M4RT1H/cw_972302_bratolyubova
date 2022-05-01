package by.bsuir.gamestore.ws.dao.impl;

import by.bsuir.gamestore.ws.dao.GenreDao;
import by.bsuir.gamestore.ws.entity.Genre;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenreDaoImpl extends GenericDaoImpl<Genre, Integer> implements GenreDao {

    @Autowired
    public GenreDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public boolean isAlreadyExist(Genre genre) {
        Genre oldGenre = find(genre.getId());
        Criteria criteria = getSession().createCriteria(Genre.class);
        criteria.add(Restrictions.eq("name", genre.getName()));
        return criteria.uniqueResult() != null
                && (oldGenre == null || !genre.getName().equals(oldGenre.getName()));
    }

}