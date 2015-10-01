/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import com.filipmavve.domain.Course;
import com.filipmavve.domain.Teacher;
import com.filipmavve.services.SuperInterfaceLocal;
import java.util.Iterator;
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
    private Teacher teacherId;
    private int maxStudents;
    private String info;

    public CourseBean() {
    }

    public Iterable getCourses() {
        List<Course> courses = superInterface.getCourseSession().getAllCourses();
        return courses;
    }

    public void editAction(Course course) {
        id = course.getId();
        courseName = course.getCourseName();
        points = course.getPoints();
        level = course.getLevel();
        maxStudents = course.getMaxStudents();
        info = course.getInfo();
        teacherId = course.getTeacherId();
    }

    public Iterable getTeachers() {
        return superInterface.getTeacherSession().getAllTeachers();
    }
    
    public void saveEdit() {
        Course course = new Course(courseName, points, level, maxStudents, info, teacherId);
        course.setId(id);
        superInterface.getCourseSession().saveCourse(course);
    }

    public void deleteAction(Course course) {
        superInterface.getCourseSession().removeCourse(course);
    }

    public void addCourse() {
        Teacher addTeacher = teacherId;
        superInterface.getCourseSession().addCourse(courseName, points, level, addTeacher, maxStudents, info);
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

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
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
