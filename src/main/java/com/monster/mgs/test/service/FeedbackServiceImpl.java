package com.monster.mgs.test.service;

import com.monster.mgs.test.dao.FeedbackDao;
import com.monster.mgs.test.dao.VisitorDao;
import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FeedbackServiceImpl implements FeedbackService {

    private static final Logger LOG = LoggerFactory.getLogger(FeedbackService.class);

    @Autowired
    private FeedbackDao feedbackDao;

    @Autowired
    private VisitorDao visitorDao;

    @Override
    public void send(TrainingCourseFeedback feedback) {
        LOG.info("Sending feedback:" + feedback);
        final Visitor visitor = feedback.getVisitor();
        final Visitor existingVisitor = visitorDao.findByEmail(visitor.getEmailAddress());
        if (existingVisitor != null) {
            LOG.debug("Found visitor:" + existingVisitor);
            existingVisitor.setFirstName(visitor.getFirstName());
            existingVisitor.setLastName(visitor.getLastName());
            feedback.setVisitor(existingVisitor);
        }
        feedbackDao.create(feedback);
        LOG.info("Feedback send:" + feedback);
    }

    @Override
    public List<TrainingCourseFeedback> list() {
        LOG.info("Listing feedbacks");
        return feedbackDao.findAll();
    }


}
