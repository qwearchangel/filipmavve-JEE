/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Course;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Filip
 */
@Local
public interface CourseSessionLocal {

    public void addCourse(Course course);

    public void removeCourse(Course course);

    public void editCourse(Course course);

    public Iterable getAllCourses();
}