package com.monster.mgs.test.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "TRAINING_COURSE")
public class TrainingCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRAINING_COURSE_ID")
    private Long id;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingCourse course = (TrainingCourse) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TrainingCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
