/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Course;
import javax.ejb.Local;

/**
 *
 * @author Filip
 */
@Local
public interface CourseSessionLocal {

    void addCourse(Course Course);

    void removeCourse(Course Course);

    void editCourse(Course Course);
    
}
