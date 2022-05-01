package by.bsuir.gamestore.ws.controller;

import by.bsuir.gamestore.ws.entity.Game;
import by.bsuir.gamestore.ws.entity.Genre;

import by.bsuir.gamestore.ws.service.CommentService;
import by.bsuir.gamestore.ws.service.GameService;
import by.bsuir.gamestore.ws.service.GenreService;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GameController extends GenericController<Game, Integer> {

    private final GenreService genreService;
    private final CommentService commentService;


    @Autowired
    GameController(GameService gameService, GenreService genreService, CommentService commentService) {
        super(gameService, LogManager.getLogger());
        this.genreService = genreService;
        this.commentService = commentService;

    }

    @RequestMapping(value = "/get/comments/{gameId}", method = RequestMethod.GET)
    public ResponseEntity<List> getComments(@PathVariable int gameId) {
        Game game = getService().find(gameId);
        if (game != null) {
            return new ResponseEntity<>(commentService.findAllForGame(game), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/set/genre/{genreId}", method = RequestMethod.POST)
    public ResponseEntity<Game> setGenre(@PathVariable("genreId") int genreId, @RequestParam("gameId") int gameId) {
        Game game = getService().find(gameId);
        Genre genre = genreService.find(genreId);
        if (game != null && genre != null) {
            game.getGenres().add(genre);
            getService().update(game);
            return new ResponseEntity<>(game, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/delete/genres/{gameId}", method = RequestMethod.POST)
    public ResponseEntity<Game> deleteAllGenres(@PathVariable("gameId") int gameId) {
        Game game = ((GameService) getService()).deleteAllGenres(gameId);
        if (game != null) {
            return new ResponseEntity<>(game, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }



}
