package com.monster.mgs.test.service;

import com.monster.mgs.test.dao.FeedbackDao;
import com.monster.mgs.test.dao.VisitorDao;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FeedbackServiceImpl implements FeedbackService {


    @Autowired
    private FeedbackDao feedbackDao;

    @Autowired
    private VisitorDao visitorDao;

    @Override
    public void send(TrainingCourseFeedback feedback) {
        final Visitor visitor = feedback.getVisitor();
        final Visitor existingVisitor = visitorDao.findByEmail(visitor.getEmailAddress());
        if (existingVisitor != null) {
            existingVisitor.setFirstName(visitor.getFirstName());
            existingVisitor.setLastName(visitor.getLastName());
            feedback.setVisitor(existingVisitor);
        }
        feedbackDao.create(feedback);
    }

    @Override
    public List<TrainingCourseFeedback> list() {
        return feedbackDao.findAll();
    }


}
