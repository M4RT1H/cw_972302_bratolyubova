package by.bsuir.gamestore.ws.controller;

import by.bsuir.gamestore.ws.entity.Comment;
import by.bsuir.gamestore.ws.service.CommentService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comment")
public class CommentController extends GenericController<Comment, Integer> {

    @Autowired
    CommentController(CommentService commentService) {
        super(commentService, LogManager.getLogger());
    }

}
