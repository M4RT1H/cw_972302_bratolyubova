package by.bsuir.gamestore.ws.dao.impl;

import by.bsuir.gamestore.ws.dao.CountryDao;
import by.bsuir.gamestore.ws.entity.Country;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDaoImpl extends GenericDaoImpl<Country, Integer> implements CountryDao {

    @Autowired
    public CountryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public boolean isAlreadyExist(Country country) {
        Criteria criteria = getSession().createCriteria(Country.class);
        criteria.add(Restrictions.eq("countryName", country.getCountryName()));
        return criteria.uniqueResult() != null;
    }

}