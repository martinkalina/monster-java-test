package com.monster.mgs.test.controller;

import com.monster.mgs.test.dao.CourseSectionDao;
import com.monster.mgs.test.dao.TrainingCourseDao;
import com.monster.mgs.test.model.TrainingCourse;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.TrainingCourseSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller

@SessionAttributes({"feedback"})
public class CourseFeedbackWizardController {

    private static final String COMMAND = "command";

    @Autowired
    private TrainingCourseDao courseRepository;

    @Autowired
    private CourseSectionDao sectionRepository;


    @ModelAttribute("feedback")
    public TrainingCourseFeedback createFeedback() {
        final TrainingCourseFeedback feedback = new TrainingCourseFeedback();
        feedback.setCourse(courseRepository.getAll().iterator().next());
        return feedback;
    }

    @RequestMapping("/init")
    public ModelAndView init(@ModelAttribute("feedback") TrainingCourseFeedback feedback) {
        return prepare1(feedback);
    }

    private ModelAndView prepare1(TrainingCourseFeedback feedback) {
        return createModelAndViewFor(feedback, "step1")
                .addObject("courses", courseRepository.getAll());
    }

    @RequestMapping("/submit1")
    public ModelAndView submit1(@ModelAttribute("feedback") TrainingCourseFeedback feedback, @RequestParam() String submit, SessionStatus sessionStatus) {
        if (isBack(submit)) {
            sessionStatus.setComplete();
            return createModelAndViewFor(feedback, "index");
        }

        return prepare2(feedback);
    }

    private ModelAndView prepare2(TrainingCourseFeedback feedback) {
        return createModelAndViewFor(feedback, "step2")
                .addObject("sections", sectionRepository.findByCourseId(feedback.getCourse().getId()))
                .addObject("ratings", new Integer[]{1, 2, 3, 4, 5});
    }

    @RequestMapping("/submit2")
    public ModelAndView submit2(@ModelAttribute("feedback") TrainingCourseFeedback feedback, @RequestParam() String submit) {
        if (isBack(submit)) {
            return prepare1(feedback);
        }

        return createModelAndViewFor(feedback, "step3");
    }

    @RequestMapping("/submit3")
    public ModelAndView submit3(@ModelAttribute("feedback") TrainingCourseFeedback feedback, @RequestParam() String submit) {
        if (isBack(submit)) {
            return prepare2(feedback);
        }

        return createModelAndViewFor(feedback, "step4");
    }

    private ModelAndView createModelAndViewFor(@ModelAttribute("feedback") TrainingCourseFeedback feedback, String step) {
        return new ModelAndView(step, COMMAND, feedback);
    }

    private boolean isBack(@RequestParam() String submit) {
        return submit.equals("< Back");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

        binder.registerCustomEditor(TrainingCourse.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                TrainingCourse course = courseRepository.get(Long.valueOf(text));
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
                TrainingCourseSection course = sectionRepository.get(Long.valueOf(text));
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
