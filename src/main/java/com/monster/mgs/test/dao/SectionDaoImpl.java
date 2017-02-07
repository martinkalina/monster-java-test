package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourseSection;
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
public class SectionDaoImpl implements SectionDao {

    private static final Logger LOG = LoggerFactory.getLogger(SectionDaoImpl.class);

    @Autowired()
    private SessionFactory sessionFactory;

    public Collection<TrainingCourseSection> findByCourseId(Long courseId) {
        LOG.debug("Find by course id:" + courseId);
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(TrainingCourseSection.class).add(Restrictions.eq("trainingCourseId", courseId)).list();

    }

    public TrainingCourseSection findById(Long id) {
        LOG.debug("Find by id:" + id);
        Session session = sessionFactory.getCurrentSession();
        return (TrainingCourseSection) session.createCriteria(TrainingCourseSection.class).add(Restrictions.idEq(id)).uniqueResult();
    }
}
