/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Course;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.jboss.weld.executor.IterativeWorkerTaskFactory;

/**
 *
 * @author Filip
 */
@Stateless
public class CourseSession implements CourseSessionLocal {
    
    public List<Course> courses; //temp database

    public CourseSession() {
        courses = new ArrayList<>();
        courses.add(new Course(1, "abc", 10, "beginners", "Morning", "Mrs. Jellybottom", 16, "A beginner class for reading and writing."));
        courses.add(new Course(2, "Java", 100, "Advanced", "All day", "Mr. BigTheeth", 30, "A Java programming class for those that want to know more."));
    }
    
    /**
     * Creates a new course and adds it to the database.
     * @param courseId 
     * @param courseName
     * @param points
     * @param level
     * @param period
     * @param teacher
     * @param maxStudents
     * @param info 
     */
    @Override
    public void addCourse(int courseId, String courseName,int points,String level,String period,String teacher,int maxStudents,String info) {
        Course newCourse = new Course(courseId, courseName, points, level, period, teacher, maxStudents, info); 
        courses.add(newCourse);
    }

    @Override
    public void removeCourse(Course course) {
        courses.remove(course);
    }

    @Override
    public void editCourse(Course course) {
        courses.get(courses.indexOf(course)).setEditable(true);
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
}
