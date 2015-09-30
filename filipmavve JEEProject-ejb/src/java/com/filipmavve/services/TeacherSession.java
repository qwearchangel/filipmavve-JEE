/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Teacher;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        Teacher newTeacher = new Teacher(firstname, lastName, phoneNr, email,passWord);
        em.persist(newTeacher);
    }

    @Override
    public void editTeacher(String firstname, String lastName, int phoneNr, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        public void persist(Object object) {
        em.persist(object);
    }
}
