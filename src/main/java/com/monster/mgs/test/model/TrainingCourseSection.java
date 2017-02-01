package com.monster.mgs.test.model;

import javax.persistence.*;

@Entity
public class TrainingCourseSection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRAINING_COURSE_SECTION_ID")
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
}
