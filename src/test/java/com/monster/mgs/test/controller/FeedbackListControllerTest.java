package com.monster.mgs.test.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ContextConfiguration(locations = "classpath:applicationContext.xml")
@WebAppConfiguration
@DirtiesContext
public class FeedbackListControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup((WebApplicationContext) applicationContext).build();
    }

    @Test
    public void list() throws Exception {
       mockMvc.perform(get("/list"))
               .andExpect(status().isOk())
               .andExpect(view().name("feedbacks"))
               .andExpect(model().hasNoErrors());
    }

}