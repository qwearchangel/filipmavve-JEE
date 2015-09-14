/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Student;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Filip
 */
@Local
public interface StudentSessionLocal {

    void addStudent(String firstName, String lastName, String course, Long idNumber, String email);

    void removeStudent(Student student);

    void setEdit(Student student);
    
    List<Student> getAllStudents();
    
    void saveStudent(Student student, String firstName, String lastName, String course, String email);
    
}
