package by.bsuir.gamestore.ws.service.impl;

import by.bsuir.gamestore.ws.dao.CountryDao;
import by.bsuir.gamestore.ws.entity.Country;
import by.bsuir.gamestore.ws.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends GenericServiceImpl<Country, Integer> implements CountryService {

    @Autowired
    public CountryServiceImpl(CountryDao countryDao) {
        super(countryDao);
    }

}