package com.monster.mgs.test.dao;

import com.monster.mgs.test.TestUtils;
import com.monster.mgs.test.model.TrainingCourse;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.Visitor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Test for {@link FeedbackDao}
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class FeedbackDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

  @Autowired
  private FeedbackDao feedbackDao;

  @Autowired
  private CourseDao courseDao;

  @Autowired
  private SectionDao sectionDao;

  @Autowired
  private VisitorDao visitorDao;



  @Test
  public void create( ) throws Exception {
    TrainingCourseFeedback feedback = TestUtils.createTestFeedback(sectionDao, courseDao);
    feedbackDao.create(feedback);
    Assert.assertNotNull(feedback.getId());
  }

  @Test
  public void findAll() throws Exception {
    TrainingCourseFeedback feedback0 = TestUtils.createTestFeedback(sectionDao, courseDao);
    feedbackDao.create(feedback0);

    TrainingCourseFeedback feedback1 = TestUtils.createTestFeedback(sectionDao, courseDao);
    feedbackDao.create(feedback1);

    final List<TrainingCourseFeedback> all = feedbackDao.findAll();
    assertEquals(all.get(0), feedback0);
    assertEquals(all.get(1), feedback1);

  }
}
