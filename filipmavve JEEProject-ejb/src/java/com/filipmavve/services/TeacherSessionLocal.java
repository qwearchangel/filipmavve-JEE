/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import javax.ejb.Local;

/**
 *
 * @author mavve
 */
@Local
public interface TeacherSessionLocal {

    void addTeacher(String firstname, String lastName, int phoneNr, String email,String passWord);
    void editTeacher(String firstname, String lastName, int phoneNr, String email);
    
    
}
