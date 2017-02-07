package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.Visitor;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class VisitorDaoImpl implements VisitorDao {

    private static final Logger LOG = LoggerFactory.getLogger(VisitorDaoImpl.class);

    @Autowired()
    private SessionFactory sessionFactory;

    @Override
    public Visitor findByEmail(String emailAddress) {
        LOG.debug("Find by email:" + emailAddress);
        return (Visitor) sessionFactory.getCurrentSession()
                .createCriteria(Visitor.class)
                .add(Restrictions.eq("emailAddress", emailAddress)).uniqueResult();
    }

}
