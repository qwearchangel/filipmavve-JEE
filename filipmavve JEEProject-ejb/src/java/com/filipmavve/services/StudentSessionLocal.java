/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Student;
import javax.ejb.Local;

/**
 *
 * @author Filip
 */
@Local
public interface StudentSessionLocal {

    void addStudent(Student Student);

    void removeStudent(Student Student);

    void editStudent(Student Student);
    
}
