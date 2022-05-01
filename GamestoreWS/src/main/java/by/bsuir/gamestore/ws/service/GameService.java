package by.bsuir.gamestore.ws.service;

import by.bsuir.gamestore.ws.entity.Game;

public interface GameService extends GenericService<Game, Integer> {

    Game deleteAllGenres(int gameId);

}
