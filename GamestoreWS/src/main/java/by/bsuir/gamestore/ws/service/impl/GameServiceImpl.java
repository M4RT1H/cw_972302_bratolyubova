package by.bsuir.gamestore.ws.service.impl;

import by.bsuir.gamestore.ws.dao.GameDao;
import by.bsuir.gamestore.ws.entity.Game;
import by.bsuir.gamestore.ws.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameServiceImpl extends GenericServiceImpl<Game, Integer> implements GameService {

    @Autowired
    public GameServiceImpl(GameDao gameDao) {
        super(gameDao);
    }

    @Transactional
    @Override
    public Game deleteAllGenres(int gameId) {
        return ((GameDao) getDao()).deleteAllGenres(gameId);
    }
}