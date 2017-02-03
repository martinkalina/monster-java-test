package com.monster.mgs.test.service;

import com.monster.mgs.test.model.TrainingCourseFeedback;

import java.util.List;

/**
 * Service for the application.
 */
public interface FeedbackService {

    /**
     * Sends completed feedback.
     * @param feedback
     */
    void send(TrainingCourseFeedback feedback);

    /**
     * Lists all stored feedbacks.
     * @return
     */
    List<TrainingCourseFeedback> list();
}
