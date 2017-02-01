package com.monster.mgs.test.controller;

import com.monster.mgs.test.dao.TrainingCourseDao;
import com.monster.mgs.test.model.TrainingCourse;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller

@SessionAttributes({"feedback"})
public class CourseFeedbackWizardController  {

    public static final String COMMAND = "command";
    @Autowired
    private TrainingCourseDao courseRepository;

    @ModelAttribute("feedback")
    @RequestMapping("/init")
    public ModelAndView init(@ModelAttribute("feedback") TrainingCourseFeedback feedback){
        final ModelAndView mv = new ModelAndView("step1", COMMAND, feedback);
        mv.addObject("courses", courseRepository.getAll());
        return mv;
    }
    @ModelAttribute("feedback")
    public TrainingCourseFeedback createFeedback() {
        final TrainingCourseFeedback feedback = new TrainingCourseFeedback();
        feedback.getVisitor().setFirstName("Martin");
        return feedback;
    }

    @RequestMapping("/next1")
    public ModelAndView submit1(@ModelAttribute("feedback") TrainingCourseFeedback feedback, @RequestParam() String submit) {
        if (isBack(submit)) {
            return new ModelAndView("index");
        }

        return new ModelAndView("step2", COMMAND, feedback);
    }

    private boolean isBack(@RequestParam() String submit) {
        return submit.equals("< Back");
    }

    @RequestMapping("/next2")
    public ModelAndView next2(@ModelAttribute("feedback") TrainingCourseFeedback feedback, @RequestParam() String submit){
        if (isBack(submit)){
            return new ModelAndView("step1", COMMAND, feedback);
        }

        return new ModelAndView("step3", COMMAND, feedback);
    }

    @RequestMapping("/next3")
    public String next3(ModelMap model){
        return "list";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

        binder.registerCustomEditor(TrainingCourse.class, new PropertyEditorSupport(){
            @Override
            public Object getSource() {
                return super.getSource();
            }

            @Override
            public void setSource(Object source) {
                super.setSource(source);
            }

            @Override
            public String getAsText() {
                if (getValue() == null) return null;
                return String.valueOf(((TrainingCourse)getValue()).getId());
            }

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                TrainingCourse course = courseRepository.get(Long.valueOf(text));
                setValue(course);
            }
        });
    }

}
