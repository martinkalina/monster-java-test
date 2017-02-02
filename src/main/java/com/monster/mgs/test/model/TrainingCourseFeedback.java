package com.monster.mgs.test.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "TRAINING_COURSE_FEEDBACK")
public class TrainingCourseFeedback {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "TRAINING_COURSE_FEEDBACK_ID")
    private Long id;
    private Date date;
    private String comment;
    private int rating;

    @ManyToOne
    private TrainingCourseSection favouriteSection;

    @ManyToOne
    private TrainingCourse course;

    @ManyToOne
    private Visitor visitor = new Visitor();

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public TrainingCourse getCourse() {
        return course;
    }

    public void setCourse(TrainingCourse course) {
        this.course = course;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TrainingCourseSection getFavouriteSection() {
        return favouriteSection;
    }

    public void setFavouriteSection(TrainingCourseSection favouriteSection) {
        this.favouriteSection = favouriteSection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingCourseFeedback that = (TrainingCourseFeedback) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
