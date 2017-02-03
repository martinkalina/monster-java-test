package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.Visitor;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FeedbackDaoImpl implements FeedbackDao {

    @Autowired()
    private SessionFactory sessionFactory;

    @Override
    public void create(TrainingCourseFeedback feedback) {
        sessionFactory.getCurrentSession().save(feedback);
    }

    @Override
    public TrainingCourseFeedback findByVisitor(Visitor visitor) {
        return (TrainingCourseFeedback) sessionFactory.getCurrentSession()
                .createCriteria(TrainingCourseFeedback.class)
                .add(Restrictions.eq("visitor", visitor)).uniqueResult();
    }

    @Override
    public void update(TrainingCourseFeedback feedback) {
        sessionFactory.getCurrentSession().update(feedback);
    }
}
