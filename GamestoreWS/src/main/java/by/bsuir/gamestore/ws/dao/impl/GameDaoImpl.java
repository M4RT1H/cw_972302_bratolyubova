package by.bsuir.gamestore.ws.dao.impl;

import by.bsuir.gamestore.ws.dao.GameDao;
import by.bsuir.gamestore.ws.entity.Game;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GameDaoImpl extends GenericDaoImpl<Game, Integer> implements GameDao {

    @Autowired
    public GameDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void delete(Game game){
        game.getGenres().clear();
        getSession().delete(game);
    }

    @Override
    public boolean isAlreadyExist(Game game) {
        Game oldGame = find(game.getId());
        Criteria titleCriteria = getSession().createCriteria(Game.class);
        titleCriteria.add(Restrictions.eq("title", game.getTitle()));
        return (titleCriteria.uniqueResult() != null &&
                (oldGame == null || !game.getTitle().equals(oldGame.getTitle())));
    }

    @Override
    public Game deleteAllGenres(int gameId) {
        Game game = find(gameId);
        if(game != null) {
            game.getGenres().clear();
            update(game);
        }
        return game;
    }
}