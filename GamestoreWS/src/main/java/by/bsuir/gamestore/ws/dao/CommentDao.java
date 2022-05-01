package by.bsuir.gamestore.ws.dao;

import by.bsuir.gamestore.ws.entity.Comment;
import by.bsuir.gamestore.ws.entity.Game;

import java.util.List;

public interface CommentDao extends GenericDao<Comment, Integer>{

    List findAllForGame(Game game);

}
