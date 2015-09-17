/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.domain;

/**
 *
 * @author Filip
 */
public class Course {

    private int courseId;
    private String courseName;
    private int points;
    private String level;
    private String period;
    private String teacher;
    private int maxStudents;
    private String info;
    private boolean editable;

    public Course() {
    }
    
    public Course(Course course) {
        this.courseId = course.courseId;
        this.courseName = course.courseName;
        this.points = course.points;
        this.level = course.level;
        this.period = course.period;
        this.teacher = course.teacher;
        this.maxStudents = course.maxStudents;
        this.info = course.info;
    }
    
    public Course(int courseId, String courseName, int points, String level, String period, String teacher, int maxStudents, String info) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.points = points;
        this.level = level;
        this.period = period;
        this.teacher = teacher;
        this.maxStudents = maxStudents;
        this.info = info;
    }
    
    
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
