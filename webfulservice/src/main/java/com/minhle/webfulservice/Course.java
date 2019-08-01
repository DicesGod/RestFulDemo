package com.minhle.webfulservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Course {
    @Id
    @GeneratedValue
    private long id;
    private String courseTitle;
    private String courseID;
    private int credits;

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Course() {
    }

    public Course(long id, String courseTitle, String courseID, int credits) {
        this.id = id;
        this.courseTitle = courseTitle;
        this.courseID = courseID;
        this.credits = credits;
    }

    

}