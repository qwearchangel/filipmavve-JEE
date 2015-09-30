/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Course;
import com.filipmavve.domain.Teacher;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Filip
 */
@Local
public interface CourseSessionLocal {

    public void addCourse( String courseName, int points, String level, String teacher, int maxStudents, String info);

    public void removeCourse(Course course);

    public void saveCourse(Course course);

    public List<Course> getAllCourses();
}
