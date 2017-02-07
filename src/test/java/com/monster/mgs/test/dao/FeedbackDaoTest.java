package com.monster.mgs.test.dao;

import com.monster.mgs.test.TestUtils;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
    final ArrayList<Object> expected = new ArrayList<>();
    expected.add(feedback0);
    expected.add(feedback1);
    assertEquals(expected, all);

  }
}
