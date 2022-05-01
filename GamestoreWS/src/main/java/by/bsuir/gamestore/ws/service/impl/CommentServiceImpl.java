package by.bsuir.gamestore.ws.service.impl;

import by.bsuir.gamestore.ws.dao.CommentDao;
import by.bsuir.gamestore.ws.entity.Comment;
import by.bsuir.gamestore.ws.entity.Game;
import by.bsuir.gamestore.ws.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl extends GenericServiceImpl<Comment, Integer> implements CommentService {

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        super(commentDao);
    }

    @Transactional
    @Override
    public List findAllForGame(Game game) {
        return ((CommentDao) getDao()).findAllForGame(game);
    }
}
