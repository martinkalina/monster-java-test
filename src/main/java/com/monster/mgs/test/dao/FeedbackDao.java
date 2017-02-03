package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourseFeedback;
import com.monster.mgs.test.model.Visitor;

public interface FeedbackDao {

    void create(TrainingCourseFeedback feedback);

    TrainingCourseFeedback findByVisitor(Visitor visitor);

    void update(TrainingCourseFeedback feedback);
}
