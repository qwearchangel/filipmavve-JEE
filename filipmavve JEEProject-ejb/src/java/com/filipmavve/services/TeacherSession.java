/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Teacher;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mavve
 */
@Stateless
public class TeacherSession implements TeacherSessionLocal {

    @PersistenceContext(name = "filipmavve_JEEProject-ejbPU")
    EntityManager em;

    @Override
    public void addTeacher(String firstname, String lastName, int phoneNr, String email, String passWord) {
        Teacher newTeacher = new Teacher(firstname, lastName, phoneNr, email, passWord);
        em.persist(newTeacher);
    }

    @Override
    public void editTeacher(String firstname, String lastName, int phoneNr, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Teacher getTeacherById(int id) {
        return em.createNamedQuery("Teacher.findById", Teacher.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        TypedQuery<Teacher> query = em.createNamedQuery("Teacher.findAll", Teacher.class);
        List<Teacher> result = query.getResultList();
        return result;
    }

    @Override
    public List<Teacher> getTeacherByFirstName(String firstName) {
        TypedQuery<Teacher> query = em.createNamedQuery("Teacher.findByFirstName", Teacher.class).setParameter("firstName", firstName);
        List<Teacher> result = query.getResultList();
        return result;
    }
}
