/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Filip
 */
@Stateless
public class CourseSession implements CourseSessionLocal {
    
    @PersistenceContext (name = "filipmavve_JEEProject-ejbPU")
    EntityManager em;
    
    public CourseSession() {
    }

    @Override
    public void removeCourse(Course course) {
        Course delete = em.find(Course.class, course.getId());
        em.remove(delete);
    }

    @Override
    public List<Course> getAllCourses() {
        TypedQuery<Course> query = em.createNamedQuery("Course.findAll", Course.class);
        List<Course> result = query.getResultList();
        return result;
    }

    @Override
    public void saveCourse(Course course) {
        em.merge(course);    }

    @Override
    public void addCourse(String courseName, int points, String level, String teacher, int maxStudents, String info) {
        Course add = new Course(courseName, points, level, maxStudents, info);
        em.persist(add);
    }
}
