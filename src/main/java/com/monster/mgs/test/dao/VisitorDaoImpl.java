package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.Visitor;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class VisitorDaoImpl implements VisitorDao {

    @Autowired()
    private SessionFactory sessionFactory;

    @Override
    public void update(Visitor visitor) {
        sessionFactory.getCurrentSession().update(visitor);
    }

    @Override
    public Visitor findByEmail(String emailAddress) {
        return (Visitor) sessionFactory.getCurrentSession()
                .createCriteria(Visitor.class)
                .add(Restrictions.eq("emailAddress", emailAddress)).uniqueResult();
    }

}
