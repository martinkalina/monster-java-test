package com.monster.mgs.test;

import com.monster.mgs.test.dao.CourseDao;
import com.monster.mgs.test.dao.SectionDao;
import com.monster.mgs.test.model.TrainingCourse;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.Visitor;

import java.util.Date;

public class TestUtils {
    public static TrainingCourseFeedback createTestFeedback(SectionDao sectionDao, CourseDao courseDao) {
        final TrainingCourseFeedback feedback = new TrainingCourseFeedback();
        final TrainingCourse course = courseDao.findAll().iterator().next();
        feedback.setCourse(course);
        Visitor visitor = new Visitor();
        visitor.setFirstName("John");
        visitor.setLastName("Doe");
        visitor.setEmailAddress("aa@bb.cz");
        feedback.setVisitor(visitor);
        feedback.setComment("No Comment");
        feedback.setRating(1);
        feedback.setDate(new Date(System.currentTimeMillis() - 24 * 3600 * 1000));
        feedback.setFavoriteSection(sectionDao.findByCourseId(course.getId()).iterator().next());
        return feedback;
    }
}
