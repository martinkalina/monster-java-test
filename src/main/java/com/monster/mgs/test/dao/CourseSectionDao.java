package com.monster.mgs.test.dao;

import com.monster.mgs.test.model.TrainingCourse;
import com.monster.mgs.test.model.TrainingCourseSection;

import java.util.Collection;

public interface CourseSectionDao {
    Collection<TrainingCourseSection> findByCourseId(Long courseId);

    TrainingCourseSection get(Long aLong);
}
