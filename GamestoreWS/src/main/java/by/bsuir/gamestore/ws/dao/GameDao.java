package by.bsuir.gamestore.ws.dao;

import by.bsuir.gamestore.ws.entity.Game;

public interface GameDao extends GenericDao<Game,Integer> {

    Game deleteAllGenres(int gameId);

}
