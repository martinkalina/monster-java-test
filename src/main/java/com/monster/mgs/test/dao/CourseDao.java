package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourse;

import java.util.Collection;


public interface CourseDao {

    Collection<TrainingCourse> findAll();

    TrainingCourse findById(Long id);
}
