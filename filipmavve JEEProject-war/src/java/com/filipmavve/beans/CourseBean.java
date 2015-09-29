/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import com.filipmavve.domain.Course;
import com.filipmavve.domain.Teacher;
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
    
    private int id;
    private String courseName;
    private int points;
    private String level;
    private String period;
    private Teacher teacher;
    private int maxStudents;
    private String info;

    public CourseBean() {
    }
    
    public List<Course> getCourses() {
        return superInterface.getCourseSession().getAllCourses();
    }
    
    public void editAction(Course course) {
        id = course.getId();
        courseName = course.getCourseName();
        points = course.getPoints();
        level = course.getLevel();
        teacher = null;
        maxStudents = course.getMaxStudents();
        info = course.getInfo();
    }
    
    public void saveAction() {
        Course course = new Course(courseName, points, level, maxStudents, info);
        course.setId(id);
        superInterface.getCourseSession().saveCourse(course);
    }

    public void deleteAction(Course course) {
        superInterface.getCourseSession().removeCourse(course);
    }

    public void addCourse() {
        superInterface.getCourseSession().addCourse(courseName, points, level, level, maxStudents, info);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
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
}
