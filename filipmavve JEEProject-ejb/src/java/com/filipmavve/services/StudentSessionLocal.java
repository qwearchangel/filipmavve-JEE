/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Course;
import com.filipmavve.domain.Student;
import java.util.List;
import javax.ejb.Local;
import javax.servlet.http.Part;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Filip
 */
@Local
public interface StudentSessionLocal {

    void addStudent(String firstName, String lastName, String ssn, String email, int phone, List<Course> courses, UploadedFile uploadedFile);

    void removeStudent(Student student);

    List<Student> getAllStudents();
    
    void saveEditStudent(Student student);
    
    Student getStudentById(int id);
    
}
