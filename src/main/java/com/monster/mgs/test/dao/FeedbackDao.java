package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourseFeedback;

import java.util.List;

public interface FeedbackDao {

    void create(TrainingCourseFeedback feedback);

    List<TrainingCourseFeedback> findAll();
}
