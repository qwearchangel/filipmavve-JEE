/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import com.filipmavve.services.SuperInterfaceLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * The ManagedBean for teacher.
 *
 * @author mavve
 */
@ManagedBean
@ViewScoped
public class RegisterTecherBean {

    @EJB
    SuperInterfaceLocal superInterface;
    private String firstName;
    private String lastName;
    private int phoneNr;
    private String email;
    private String passWord;

    /**
     * Creates a new instance of RegisterBean
     */
    public RegisterTecherBean() {
    }

    public String registerNav(String pageID) {
        return pageID;
    }

    public void addTeacher() {
        superInterface.getTeacherSession().addTeacher(firstName, lastName, phoneNr, email, passWord);

    }

    //setter & getter methods

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
