package com.monster.mgs.test.service;

import com.monster.mgs.test.TestUtils;
import com.monster.mgs.test.dao.CourseDao;
import com.monster.mgs.test.dao.SectionDao;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class FeedbackServiceTest extends AbstractJUnit4SpringContextTests {


    @Autowired
    private FeedbackService service;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private SectionDao sectionDao;


    @Test
    public void test() throws Exception {
        TrainingCourseFeedback feedback0 = TestUtils.createTestFeedback(sectionDao, courseDao);
        service.send(feedback0);
        final List<TrainingCourseFeedback> feedbacks = service.list();

        Assert.assertTrue(feedbacks.size() == 1);

        TrainingCourseFeedback feedback1 = TestUtils.createTestFeedback(sectionDao, courseDao);
        Assert.assertNotEquals(feedback0.getVisitor(), feedback1.getVisitor());

        final String james = "James";
        feedback1.getVisitor().setFirstName(james);

        service.send(feedback1);
        // visitor is updated to existing
        Assert.assertEquals(feedback0.getVisitor(), feedback1.getVisitor());

        final List<TrainingCourseFeedback> feedbacks2 = service.list();
        Assert.assertEquals(2, feedbacks2.size());
        Assert.assertTrue(feedbacks2.get(0).getVisitor().getFirstName().equals(james));
        Assert.assertTrue(feedbacks2.get(1).getVisitor().getFirstName().equals(james));
    }

}