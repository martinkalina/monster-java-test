package com.monster.mgs.test.dao;

import com.monster.mgs.test.controller.CourseFeedbackWizardController;
import com.monster.mgs.test.model.TrainingCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
@Repository
public class CourseDaoImpl implements CourseDao {

    private static final Logger LOG = LoggerFactory.getLogger(CourseDaoImpl.class);

    @Autowired()
    private SessionFactory sessionFactory;


    public Collection<TrainingCourse> findAll() {
        LOG.debug("Find all");
        Session session = this.sessionFactory.getCurrentSession();
        return session.createCriteria(TrainingCourse.class).list();
    }

    public TrainingCourse findById(Long id) {
        LOG.debug("Find by id:" + id);
        Session session = this.sessionFactory.getCurrentSession();
        return (TrainingCourse) session.createCriteria(TrainingCourse.class).add(Restrictions.idEq(id)).uniqueResult();
    }
}
