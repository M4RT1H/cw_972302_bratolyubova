package by.bsuir.gamestore.ws.controller;

import by.bsuir.gamestore.ws.entity.Genre;
import by.bsuir.gamestore.ws.service.GenreService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/genre")
public class GenreController extends GenericController<Genre, Integer> {

    @Autowired
    GenreController(GenreService genreService) {
        super(genreService, LogManager.getLogger());
    }

}