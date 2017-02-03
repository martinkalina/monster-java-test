package com.monster.mgs.test.dao;

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

import static org.hamcrest.CoreMatchers.hasItems;
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

  private TrainingCourseFeedback feedback;
  private Visitor visitor;

  @Before
  public void setUp() throws Exception {
    feedback = new TrainingCourseFeedback();
    final TrainingCourse course = courseDao.findAll().iterator().next();
    feedback.setCourse(course);
    visitor = new Visitor();
    visitor.setFirstName("John");
    visitor.setLastName("Doe");
    visitor.setEmailAddress("aa@bb.cz");
    visitorDao.create(visitor);
    feedback.setVisitor(visitor);
    feedback.setComment("No Comment");
    feedback.setRating(1);
    feedback.setDate(new Date());
    feedback.setFavoriteSection(sectionDao.findByCourseId(course.getId()).iterator().next());
  }

  @Test
  public void testCreate( ) throws Exception {
    feedbackDao.create(feedback);
    Assert.assertNotNull(feedback.getId());

  }

  @Test
  public void testFindByVisitor() throws Exception {
    feedbackDao.create(feedback);
    final TrainingCourseFeedback byVisitor = feedbackDao.findByVisitor(feedback.getVisitor());
    assertNotNull(byVisitor);
  }

  @Test
  public void testUpdate() throws Exception {
    feedbackDao.create(feedback);
    final TrainingCourseFeedback byVisitor = feedbackDao.findByVisitor(feedback.getVisitor());
    assertNotNull(byVisitor);
    final String comment = "My Comment";
    byVisitor.setComment(comment);
    feedbackDao.update(feedback);
    Assert.assertEquals(feedbackDao.findByVisitor(visitor).getComment(), comment);
  }
}
