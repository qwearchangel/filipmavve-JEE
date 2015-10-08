/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * A collection of all local sessions
 * 
 * @author Filip
 */
@Stateless
public class SuperInterface implements SuperInterfaceLocal {

    @EJB
    CourseSessionLocal courseSession;
    @EJB
    StudentSessionLocal studentSession;
    @EJB
    LoginSessionLocal loginSession;
    @EJB
    TeacherSessionLocal teacherSession;
    @EJB
    AttendenceSessionLocal attendenceSession;

    @Override
    public CourseSessionLocal getCourseSession() {
        return courseSession;
    }

    @Override
    public LoginSessionLocal getLoginSession() {
        return loginSession;
    }

    @Override
    public StudentSessionLocal getStudentSession() {
        return studentSession;
    }

    @Override
    public TeacherSessionLocal getTeacherSession() {
        return teacherSession;
    }

    @Override
    public AttendenceSessionLocal getAttendenceSession() {
        return attendenceSession;
    }


}
