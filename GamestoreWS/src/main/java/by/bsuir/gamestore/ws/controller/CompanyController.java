package by.bsuir.gamestore.ws.controller;

import by.bsuir.gamestore.ws.entity.Company;
import by.bsuir.gamestore.ws.service.CompanyService;
import by.bsuir.gamestore.ws.service.GenericService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/company")
public class CompanyController extends GenericController<Company, Integer> {

    @Autowired
    CompanyController(CompanyService companyService) {
        super(companyService, LogManager.getLogger());
    }

}