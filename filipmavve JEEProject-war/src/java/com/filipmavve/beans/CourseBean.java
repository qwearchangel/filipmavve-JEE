/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import com.filipmavve.domain.Course;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Filip
 */
@ManagedBean
@SessionScoped
public class CourseBean {

    private int courseId;
    private String courseName;
    private int points;
    private String level;
    private String period;
    private String teacher;
    private int maxStudents;
    private String info;
    private boolean editable;
    public List<Course> courses = new ArrayList<>();

    public CourseBean() {
        courses.add(new Course(1, "abc", 10, "beginners", "Morning", "Mrs. Jellybottom", 16, "A beginner class for reading and writing."));
        courses.add(new Course(2, "Java", 100, "Advanced", "All day", "Mr. BigTheeth", 30, "A Java programming class for those that want to know more."));
    }

    public String editAction(Course course) {
        course.setEditable(true);
        return null;
    }
    
    public String saveAction(Course course) {
        course.setEditable(false);
        return null;
    }

    public String saveAllAction() {
        for (Course course : courses) {
            course.setEditable(false);
        }
        return null;
    }
    
    public String deleteAction(Course course) {
        courses.remove(course);
        return null;
    }

    public String addCourse() {
        Course course = new Course(courseId, courseName, points, level, period, teacher, maxStudents, info);
        courses.add(course);

        courseId = 0;
        courseName = null;
        points = 0;
        level = null;
        period = null;
        teacher = null;
        maxStudents = 0;
        info = null;

        return null;
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
