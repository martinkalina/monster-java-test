package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourseFeedback;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<TrainingCourseFeedback> findAll() {
        return (List<TrainingCourseFeedback>) sessionFactory.getCurrentSession()
                .createCriteria(TrainingCourseFeedback.class).list();
    }
}
