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
    @Column(name = "TRAINING_COURSE_DATE")
    private Date date;
    private String comment;
    private int rating;

    @ManyToOne(optional = false)
    @JoinColumn(name="FAVORITE_SECTION_ID")
    private TrainingCourseSection favoriteSection;

    @ManyToOne(optional = false)
    @JoinColumn(name="TRAINING_COURSE_ID")
    private TrainingCourse course;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="VISITOR_ID")
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

    public TrainingCourseSection getFavoriteSection() {
        return favoriteSection;
    }

    public void setFavoriteSection(TrainingCourseSection favoriteSection) {
        this.favoriteSection = favoriteSection;
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
