package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourseSection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
@Repository
public class SectionDaoImpl implements SectionDao {

    @Autowired()
    private SessionFactory sessionFactory;

    public Collection<TrainingCourseSection> findByCourseId(Long courseId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(TrainingCourseSection.class).add(Restrictions.eq("trainingCourseId", courseId)).list();

    }

    public TrainingCourseSection findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (TrainingCourseSection) session.createCriteria(TrainingCourseSection.class).add(Restrictions.idEq(id)).uniqueResult();
    }
}
