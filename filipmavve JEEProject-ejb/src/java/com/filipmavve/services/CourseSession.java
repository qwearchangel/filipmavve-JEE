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

    /**
     * Creates a new course and adds it to the database.
     *
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
    public void addCourse(int courseId, String courseName, int points, String level, String period, String teacher, int maxStudents, String info) {
//        Course newCourse = new Course(courseId, courseName, points, level, period, teacher, maxStudents, info);
//        em.persist(newCourse);
    }

    @Override
    public void removeCourse(Course course) {
        em.remove(course);
    }

    @Override
    public void editCourse(Course course) {

//        if (!course.isEditable()) {
//            oldCourse = new Course(course);
//            courses.get(courses.indexOf(course)).setEditable(true);
//        } else {
//            courses.remove(course);
//            oldCourse.setEditable(false);
//            courses.add(oldCourse);
//        }
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
}
