package by.bsuir.gamestore.ws.controller;

import by.bsuir.gamestore.ws.entity.Rating;
import by.bsuir.gamestore.ws.service.RatingService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rating")
public class RatingController extends GenericController<Rating, Integer> {

    @Autowired
    public RatingController(RatingService ratingService){
        super(ratingService, LogManager.getLogger());
    }

    @RequestMapping(value = "/saveupdate", method = RequestMethod.POST)
    public ResponseEntity<Rating> saveOrUpdate(@RequestBody Rating rating) {
        Rating newRating = getService().saveOrUpdate(rating);
        if(newRating != null){
            return new ResponseEntity<>(newRating, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
