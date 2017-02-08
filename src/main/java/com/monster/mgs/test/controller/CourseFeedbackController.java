package com.monster.mgs.test.controller;

import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * MVC controller for the homepage and feedback list.
 */
@Controller
public class CourseFeedbackController {


    @Autowired
    private FeedbackService feedbackService;


    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @ModelAttribute("feedbacks")
    public List<TrainingCourseFeedback>  getFeedbacks(){
        return feedbackService.list();
    }

    @RequestMapping("/list")
    public String list() {
        return "feedbacks";

    }
}
