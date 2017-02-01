package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourse;

import java.util.Collection;


public interface TrainingCourseDao {

    Collection<TrainingCourse> getAll();

    TrainingCourse get(Long id);
}
