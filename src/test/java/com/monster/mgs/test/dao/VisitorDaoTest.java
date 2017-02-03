package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.Visitor;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
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
    private Visitor visitor;

    @Before
    public void setUp() throws Exception {
        visitor = new Visitor();
        visitor.setFirstName("John");
        visitor.setLastName("Doe");
        visitor.setEmailAddress("aa@bb.cz");
    }

    @Test
    public void testCreate() throws Exception {
        visitorDao.create(visitor);
        Assert.assertNotNull(visitor.getId());
    }

    @Test
    public void testFindByEmail() throws Exception {
        visitorDao.create(visitor);
        final Visitor visitor1 = visitorDao.findByEmail(visitor.getEmailAddress());
        Assert.assertThat(visitor1, Matchers.samePropertyValuesAs(visitor));
    }
}
