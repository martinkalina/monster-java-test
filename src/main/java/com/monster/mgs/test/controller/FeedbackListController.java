package com.monster.mgs.test.controller;

import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Feedbacks List page controller.
 */
@Controller
public class FeedbackListController {


    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/list")
    public ModelAndView list() {
        final List<TrainingCourseFeedback> list = feedbackService.list();
        return new ModelAndView("feedbacks", "feedbacks", list);

    }
}
