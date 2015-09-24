/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 *
 * @author Filip
 */
@Entity(name = "COURSE")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM COURSE c")
})
public class Course implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "C_ID")
    private int id;
    private int courseId;
    private String courseName;
    private int points;
    private String c_level;
    private String c_period;
    private String teacher;
    private int maxStudents;
    private String info;
    @Transient
    private boolean editable;

    public Course() {
    }
    
    public Course(Course course) {
        this.courseId = course.courseId;
        this.courseName = course.courseName;
        this.points = course.points;
        this.c_level = course.c_level;
        this.c_period = course.c_period;
        this.teacher = course.teacher;
        this.maxStudents = course.maxStudents;
        this.info = course.info;
    }
    
    public Course(int courseId, String courseName, int points, String level, String period, String teacher, int maxStudents, String info) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.points = points;
        this.c_level = level;
        this.c_period = period;
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
        return c_level;
    }

    public void setLevel(String level) {
        this.c_level = level;
    }

    public String getPeriod() {
        return c_period;
    }

    public void setPeriod(String period) {
        this.c_period = period;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
