package com.monster.mgs.test.controller;

import com.monster.mgs.test.dao.CourseDao;
import com.monster.mgs.test.dao.SectionDao;
import com.monster.mgs.test.model.TrainingCourse;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.TrainingCourseSection;
import com.monster.mgs.test.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;


/**
 * MVC controller for the main Wizard of the application.
 */
@Controller
@SessionAttributes({"feedback"})
public class CourseFeedbackWizardController {

    public static final String DATE_PATTERN = "dd.MM.yyyy";
    public static final Integer[] RATINGS = {1, 2, 3, 4, 5};

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private SectionDao sectionDao;

    @Autowired
    private FeedbackService feedbackService;


    /**
     * Initializer of feedback model bean.
     */
    @ModelAttribute("feedback")
    @Valid
    public TrainingCourseFeedback createFeedback() {
        return new TrainingCourseFeedback();
    }


    /**
     * @return reference data courses
     */
    @ModelAttribute("courses")
    public Collection<TrainingCourse> getCourses() {
        return courseDao.findAll();
    }

    /**
     * @param feedback
     * @return sections for selected course
     */
    @ModelAttribute("sections")
    public Collection<TrainingCourseSection> getSections(@ModelAttribute("feedback") TrainingCourseFeedback feedback) {
        if (feedback.getCourse() == null) {
            return null;
        }
        return sectionDao.findByCourseId(feedback.getCourse().getId());
    }

    /**
     * @return reference data for ratings.
     */
    @ModelAttribute("ratings")
    public Integer[] getRatings() {
        return RATINGS;
    }

    @RequestMapping("/init")
    public String prepare1(@ModelAttribute("feedback") TrainingCourseFeedback feedback) {
        return "step1";
    }

    @RequestMapping("/submit1")
    public String submit1(@Valid @ModelAttribute("feedback") TrainingCourseFeedback feedback,
                          BindingResult bindingResult,
                          @RequestParam() String submit,
                          SessionStatus sessionStatus) {
        if (isBack(submit)) {
            sessionStatus.setComplete();
            return "home";
        }
        if (bindingResult.hasErrors()) {
            return "step1";
        }
        return "step2";
    }


    @RequestMapping("/submit2")
    public String submit2(@ModelAttribute("feedback") TrainingCourseFeedback feedback,
                          BindingResult bindingResult, @RequestParam() String submit) {
        if (isBack(submit)) {
            return "step1";
        }
        if (bindingResult.hasErrors()) {
            return "step2";
        }

        return "step3";
    }

    @RequestMapping("/submit3")
    public String submit3(@ModelAttribute("feedback") TrainingCourseFeedback feedback,
                          @RequestParam() String submit,
                          SessionStatus sessionStatus) {
        if (isBack(submit)) {
            return "step2";
        }

        feedbackService.send(feedback);
        sessionStatus.setComplete();
        return "redirect:/success";
    }

    @RequestMapping("/success")
    public String success() {
        return "success1";
    }

    private boolean isBack(@RequestParam() String submit) {
        return submit.equals("< Back");
    }


    /**
     * Binder for reference data.
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

        binder.registerCustomEditor(TrainingCourse.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {

                TrainingCourse course = courseDao.findById(Long.valueOf(text));
                setValue(course);
            }

            @Override
            public String getAsText() {
                final TrainingCourse course = (TrainingCourse) getValue();
                if (course == null) {
                    return null;
                }
                return course.getId().toString();
            }
        });
        binder.registerCustomEditor(TrainingCourseSection.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                TrainingCourseSection course = sectionDao.findById(Long.valueOf(text));
                setValue(course);
            }

            @Override
            public String getAsText() {
                final TrainingCourseSection section = (TrainingCourseSection) getValue();
                if (section == null) {
                    return null;
                }
                return section.getId().toString();
            }
        });
    }

}
