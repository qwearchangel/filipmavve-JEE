/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Course;
import javax.ejb.Stateless;

/**
 *
 * @author Filip
 */
@Stateless
public class CourseSession implements CourseSessionLocal {

    @Override
    public void addCourse(Course Course) {
    }

    @Override
    public void removeCourse(Course Course) {
    }

    @Override
    public void editCourse(Course Course) {
    }
}
