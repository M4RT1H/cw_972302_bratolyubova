package by.bsuir.gamestore.ws.service.impl;

import by.bsuir.gamestore.ws.dao.RatingDao;
import by.bsuir.gamestore.ws.entity.Rating;
import by.bsuir.gamestore.ws.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl extends GenericServiceImpl<Rating, Integer> implements RatingService{

    @Autowired
    public RatingServiceImpl(RatingDao ratingDao) {
        super(ratingDao);
    }
}
