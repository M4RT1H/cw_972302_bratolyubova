package by.bsuir.gamestore.ws.service;

import by.bsuir.gamestore.ws.entity.Comment;
import by.bsuir.gamestore.ws.entity.Game;

import java.util.List;

public interface CommentService extends GenericService<Comment, Integer> {

    List findAllForGame(Game game);

}