package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourseSection;

import java.util.Collection;

public interface SectionDao {
    Collection<TrainingCourseSection> findByCourseId(Long courseId);

    TrainingCourseSection findById(Long id);
}
