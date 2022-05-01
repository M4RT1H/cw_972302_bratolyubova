package by.bsuir.gamestore.ws.service.impl;

import by.bsuir.gamestore.ws.dao.GenreDao;
import by.bsuir.gamestore.ws.entity.Genre;
import by.bsuir.gamestore.ws.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl extends GenericServiceImpl<Genre, Integer> implements GenreService {

    @Autowired
    public GenreServiceImpl(GenreDao genreDao) {
        super(genreDao);
    }

}