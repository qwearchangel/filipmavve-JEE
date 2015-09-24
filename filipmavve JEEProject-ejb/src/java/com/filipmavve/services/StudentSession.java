/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        return null;
    }

    @Override
    public void saveStudent(Student student) {
        em.merge(student);
    }

}
