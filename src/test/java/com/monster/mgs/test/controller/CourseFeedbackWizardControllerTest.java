package com.monster.mgs.test.controller;

import com.monster.mgs.test.TestUtils;
import com.monster.mgs.test.dao.CourseDao;
import com.monster.mgs.test.dao.SectionDao;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@WebAppConfiguration
@DirtiesContext()
public class CourseFeedbackWizardControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

    private MockMvc mockMvc;

    @Autowired
    private SectionDao sectionDao;

    @Autowired
    private CourseDao courseDao;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup((WebApplicationContext) applicationContext).build();
    }


    @Test
    public void testWizard() throws Exception {

        // because some problems with session attribute feedback,
        // the only way to test wizard controller is in one method
        TrainingCourseFeedback feedback = TestUtils.createTestFeedback(sectionDao, courseDao);
        final HashMap sessionAttributes = new HashMap();
        sessionAttributes.put("feedback", feedback);

        mockMvc.perform(get("/").sessionAttrs(sessionAttributes))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));


        mockMvc.perform(get("/init").sessionAttrs(sessionAttributes))
                .andExpect(status().isOk())
                .andExpect(view().name("step1"))
                .andExpect(model().attribute("courses", is(not(empty()))));


        MockHttpServletRequestBuilder postBuilder = post("/submit1")
                .sessionAttrs(sessionAttributes);
        mockMvc.perform(
                postBuilder.param("submit", "< Back"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
        mockMvc.perform(
                postBuilder.param("submit", "Continue >").param("course", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("step2"))
                .andExpect(model().attribute("sections", is(not(empty()))))
                .andExpect(model().attribute("ratings", is(new int[]{1,2,3,4,5})));


        postBuilder = post("/submit2")
                .sessionAttrs(sessionAttributes);
        mockMvc.perform(
                postBuilder.param("submit", "< Back"))
                .andExpect(status().isOk())
                .andExpect(view().name("step1"));
        mockMvc.perform(
                postBuilder.param("submit", "Continue >").param("favoriteSection", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("step3"));


        postBuilder = post("/submit3")
                .sessionAttrs(sessionAttributes);
        mockMvc.perform(
                postBuilder.param("submit", "< Back"))
                .andExpect(status().isOk())
                .andExpect(view().name("step2"));
        mockMvc.perform(
                postBuilder.param("submit", "Continue >"))
                .andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/success"));

    }


}