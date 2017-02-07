package com.monster.mgs.test.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "TRAINING_COURSE_SECTION")
public class TrainingCourseSection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRAINING_COURSE_SECTION_ID")
    private Long id;
    private String name;

    @Column(name = "TRAINING_COURSE_ID")
    private Long trainingCourseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTrainingCourseId() {
        return trainingCourseId;
    }

    public void setTrainingCourseId(Long trainingCourseId) {
        this.trainingCourseId = trainingCourseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingCourseSection that = (TrainingCourseSection) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TrainingCourseSection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trainingCourseId=" + trainingCourseId +
                '}';
    }
}
