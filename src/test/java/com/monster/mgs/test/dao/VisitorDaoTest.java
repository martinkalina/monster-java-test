package com.monster.mgs.test.dao;

import com.monster.mgs.test.TestUtils;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.Visitor;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Test for {@link VisitorDao}
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class VisitorDaoTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private VisitorDao visitorDao;

    @Autowired
    private SectionDao sectionDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private FeedbackDao feedbackDao;


    @Test
    public void testFindByEmail() throws Exception {
        final TrainingCourseFeedback testFeedback = TestUtils.createTestFeedback(sectionDao, courseDao);
        feedbackDao.create(testFeedback);
        final Visitor visitor = testFeedback.getVisitor();
        final Visitor visitor1 = visitorDao.findByEmail(visitor.getEmailAddress());
        Assert.assertThat(visitor1, Matchers.samePropertyValuesAs(visitor));
    }
}
