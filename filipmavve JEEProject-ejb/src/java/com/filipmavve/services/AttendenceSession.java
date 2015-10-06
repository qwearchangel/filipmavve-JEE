/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;
import com.filipmavve.domain.Attendence;
import com.filipmavve.domain.Student;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class AttendenceSession implements AttendenceSessionLocal {
    
    @PersistenceContext (name = "filipmavve_JEEProject-ejbPU")
    EntityManager em;

    @Override
    public void addAttendence(List<Student> student) {
        Attendence att = new Attendence(addDate());
        att.setStudentCollection(student);
        em.persist(att);
    }
    
    public String addDate() {
        LocalDate date = LocalDate.now();
        
        
        return date.toString();
    }

    @Override
    public List<Attendence> getAllAttendence() {
        TypedQuery<Attendence> query = em.createNamedQuery("Attendence.findAll", Attendence.class);
        List<Attendence> result = query.getResultList();
        return result;
    }
    

}
