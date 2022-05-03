package by.bsuir.gamestore.ws.service;

import by.bsuir.gamestore.ws.controller.GameController;
import by.bsuir.gamestore.ws.dao.UserDao;
import by.bsuir.gamestore.ws.entity.Comment;
import by.bsuir.gamestore.ws.entity.Game;
import by.bsuir.gamestore.ws.entity.Genre;
import by.bsuir.gamestore.ws.service.impl.UserServiceImpl;
import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameControllerTest {

    GameController gameController;
    GameService gameServiceMock;
    GenreService genreServiceMock;
    CommentService commentServiceMock;

    @BeforeEach
    void setUp() {
        gameServiceMock = Mockito.mock(GameService.class);
        genreServiceMock = Mockito.mock(GenreService.class);
        commentServiceMock = Mockito.mock(CommentService.class);
        gameController = new GameController(gameServiceMock, genreServiceMock, commentServiceMock);

    }

    @Test
    void TestGameController_SetGenre() throws ServiceException {
        // Arrange
        Game game = new Game();
        game.setGenres(new HashSet<Genre>());
        Mockito.when(gameServiceMock.find(2)).thenReturn(game);

        Genre genre = new Genre();
        genre.setId(1);
        Mockito.when(genreServiceMock.find(1)).thenReturn(genre);

        // Act
        ResponseEntity<Game> result = gameController.setGenre(1, 2);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(1, result.getBody().getGenres().iterator().next().getId());
    }

    @Test
    void TestGameController_GetComments() throws ServiceException {
        // Arrange
        Game game = new Game();
        List list = new ArrayList();
        list.add(new Comment());

        Mockito.when(commentServiceMock.findAllForGame(game)).thenReturn(list);
        Mockito.when(gameServiceMock.find(2)).thenReturn(game);

        // Act
        ResponseEntity<List> result = gameController.getComments(2);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(list.get(0), result.getBody().get(0));
    }

    @Test
    void TestGameController_DeleteAllGenres() throws ServiceException {
        // Arrange
        Game game = new Game();

        Mockito.when(gameServiceMock.deleteAllGenres(2)).thenReturn(game);

        // Act
        ResponseEntity<Game> result = gameController.deleteAllGenres(2);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());

    }
}
