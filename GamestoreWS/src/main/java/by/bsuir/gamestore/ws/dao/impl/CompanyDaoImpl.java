package by.bsuir.gamestore.ws.dao.impl;

import by.bsuir.gamestore.ws.dao.CompanyDao;
import by.bsuir.gamestore.ws.entity.Company;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl extends GenericDaoImpl<Company, Integer> implements CompanyDao {

    @Autowired
    public CompanyDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public boolean isAlreadyExist(Company company) {
        Company oldCompany = find(company.getId());
        Criteria criteria = getSession().createCriteria(Company.class);
        criteria.add(Restrictions.eq("companyName", company.getCompanyName()));
        return criteria.uniqueResult() != null
                && (oldCompany == null || !company.getCompanyName().equals(oldCompany.getCompanyName()));
    }
}
