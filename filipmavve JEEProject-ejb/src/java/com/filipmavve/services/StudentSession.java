/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Student;
import javax.ejb.Stateless;

/**
 *
 * @author Filip
 */
@Stateless
public class StudentSession implements StudentSessionLocal {

    @Override
    public void addStudent(Student Student) {
    }

    @Override
    public void removeStudent(Student Student) {
    }

    @Override
    public void editStudent(Student Student) {
    }
    
}
