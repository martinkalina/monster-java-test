package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Transactional
@Repository
public class TrainingCourseDaoImpl implements TrainingCourseDao {

    @Autowired()
    private SessionFactory sessionFactory;


    public Collection<TrainingCourse> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<TrainingCourse>) session.createCriteria(TrainingCourse.class).list();
    }

    public TrainingCourse get(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (TrainingCourse) session.createCriteria(TrainingCourse.class).add(Restrictions.idEq(id)).uniqueResult();
    }
}
