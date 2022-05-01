package by.bsuir.gamestore.ws.controller;

import by.bsuir.gamestore.ws.entity.Country;
import by.bsuir.gamestore.ws.service.CountryService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController extends GenericController<Country, Integer> {

    @Autowired
    public CountryController(CountryService countryService) {
        super(countryService, LogManager.getLogger());
    }

}