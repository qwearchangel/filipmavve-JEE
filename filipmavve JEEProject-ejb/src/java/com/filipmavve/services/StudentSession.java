/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Student;
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
        em.remove(student);
    }

    @Override
    public void setEdit(Student student) {

//        if (!student.isEditable()) {
//            oldStudent = new Student(student);
//            students.get(students.indexOf(student)).setEditable(true);
//        } else {
//            students.remove(student);
//            oldStudent.setEditable(false);
//            students.add(oldStudent);
//        }
    }

    @Override
    public void addStudent(String firstName, String lastName, String course, Long idNumber, String email) {
        Student newStudent = new Student(firstName, lastName, course, idNumber, email);
        em.persist(newStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = em.createNamedQuery("Student.findAll", Student.class);
        List<Student> result = query.getResultList();
        return result;
    }

    @Override
    public void saveStudent(Student student) {
        em.merge(student);
    }

    public void persist(Object object) {
        em.persist(object);
    }

}
