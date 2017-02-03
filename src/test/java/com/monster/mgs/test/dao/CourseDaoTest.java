package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourse;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Collection;

/**
 * Test for {@link CourseDao}
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CourseDaoTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private CourseDao courseDao;

    @Test
    public void test() throws Exception {
        final Collection<TrainingCourse> all = courseDao.findAll();
        for (TrainingCourse course : all) {
            final TrainingCourse course2 = courseDao.findById(course.getId());
            Assert.assertThat(course2, Matchers.samePropertyValuesAs(course));

        }

    }
}