/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Student;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Filip
 */
@Stateless
public class AttendenceSession implements AttendenceSessionLocal {
    
    @PersistenceContext (name = "filipmavve_JEEProject-ejbPU")
    EntityManager em;
    
    @Override
    public void addAttendence(Date date, List<Student> students) {
    }

}
