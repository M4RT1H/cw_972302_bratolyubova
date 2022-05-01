package by.bsuir.gamestore.ws.service.impl;

import by.bsuir.gamestore.ws.dao.CompanyDao;
import by.bsuir.gamestore.ws.entity.Company;
import by.bsuir.gamestore.ws.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends GenericServiceImpl<Company, Integer> implements CompanyService {

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        super(companyDao);
    }

}