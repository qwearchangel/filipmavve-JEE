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
public interface SuperInterfaceLocal {
    
    public CourseSessionLocal getCourseSession();
    public LoginSessionLocal getLoginSession();
    public StudentSessionLocal getStudentSession();
    public TeacherSessionLocal getTeacherSession();

}
