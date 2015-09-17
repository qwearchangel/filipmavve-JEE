/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import com.filipmavve.domain.Course;
import com.filipmavve.services.SuperInterfaceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Filip
 */
@ManagedBean
@ViewScoped
public class CourseBean {

    @EJB
    SuperInterfaceLocal superInterface;
    
    private int courseId;
    private String courseName;
    private int points;
    private String level;
    private String period;
    private String teacher;
    private int maxStudents;
    private String info;
    private boolean editable;

    public CourseBean() {
    }
    
    public List<Course> getCourses() {
        return superInterface.getCourseSession().getAllCourses();
    }
    
    public void editAction(Course course) {
        superInterface.getCourseSession().editCourse(course);
    }
    
    public void saveAction(Course course) {
        //todo
    }

    public void saveAllAction() {
        //todo
    }
    
    public void deleteAction(Course course) {
        superInterface.getCourseSession().removeCourse(course);
    }

    public void addCourse() {
        superInterface.getCourseSession().addCourse(courseId, courseName, points, level, period, teacher, maxStudents, info);
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
