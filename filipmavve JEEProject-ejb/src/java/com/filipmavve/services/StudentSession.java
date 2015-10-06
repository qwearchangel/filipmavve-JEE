/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Course;
import com.filipmavve.domain.Student;
import com.filipmavve.domain.Teacher;
import java.util.ArrayList;
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
public class StudentSession implements StudentSessionLocal {

    @PersistenceContext(name = "filipmavve_JEEProject-ejbPU")
    EntityManager em;

    public StudentSession() {
    }

    @Override
    public void removeStudent(Student student) {
        Student delete = em.find(Student.class, student.getId());
        em.remove(delete);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = em.createNamedQuery("Student.findAll", Student.class);
        List<Student> result = query.getResultList();
        return result;
    }

    @Override
    public void saveStudent(Student student) {
        Student save = student;
        em.merge(save);
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void addStudent(String firstName, String lastName, String ssn, String email, int phone, List<Course> courses) {
        Student newStudent = new Student(firstName, lastName, email, ssn, phone);
        newStudent.setCourseCollection(courses);
        List<Teacher> teachers = new ArrayList<>();
        for (Course c : courses) {
            Teacher teach = c.getTeacherId();
            if (!teachers.contains(teach)) {
                teachers.add(teach);
            }
        }
        newStudent.setTeacherCollection(teachers);
        em.persist(newStudent);
    }

}
