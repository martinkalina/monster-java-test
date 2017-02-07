package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourseSection;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SectionDaoTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private SectionDao sectionDao;

    @Test
    public void findById_existing()  {
        final TrainingCourseSection byId = sectionDao.findById(1l);
        assertThat(byId, is(notNullValue()));
    }
    @Test
    public void findById_nonexisting()  {
        final TrainingCourseSection byId = sectionDao.findById(100l);
        assertThat(byId, is(nullValue()));
    }


    @Test
    public void findByCourseId_existing()  {
        final Collection<TrainingCourseSection> byCourseId = sectionDao.findByCourseId(1l);
        assertThat(byCourseId, is(not(empty())));
    }
    @Test
    public void findByCourseId_nonexisting()  {
        final Collection<TrainingCourseSection> byCourseId = sectionDao.findByCourseId(100l);
        assertThat(byCourseId, is(empty()));
    }
}