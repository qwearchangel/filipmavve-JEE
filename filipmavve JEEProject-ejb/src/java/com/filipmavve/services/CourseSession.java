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
    
    public List<Course> courses;

    public CourseSession() {
        courses = new ArrayList<>();
        courses.add(new Course(1, "abc", 10, "beginners", "Morning", "Mrs. Jellybottom", 16, "A beginner class for reading and writing."));
        courses.add(new Course(2, "Java", 100, "Advanced", "All day", "Mr. BigTheeth", 30, "A Java programming class for those that want to know more."));
    }
    
    @Override
    public void addCourse(Course Course) {
    }

    @Override
    public void removeCourse(Course Course) {
    }

    @Override
    public void editCourse(Course Course) {
    }

    @Override
    public Iterable getAllCourses() {
        return courses;
    }
}
