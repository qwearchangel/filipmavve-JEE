/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import com.filipmavve.services.SuperInterfaceLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Filip
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    @EJB
    SuperInterfaceLocal superInterface;
    private String userName;
    private String password;
    private boolean checkLog = false;

    public LoginBean() {
    }

    public String checkLoggedin() {
        if (superInterface.getLoginSession().validate(userName, password) == true) {

            //checkLog = true;
            setCheckLog(true);
            return "Home.xhtml";

        }
        return null;

    }

    public SuperInterfaceLocal getSuperInterface() {
        return superInterface;
    }

    public void setSuperInterface(SuperInterfaceLocal superInterface) {
        this.superInterface = superInterface;
    }

    public boolean getCheckLog() {
        return checkLog;
    }

    public void setCheckLog(boolean checkLog) {
        this.checkLog = checkLog;
    }

//    public String loginAction() {
//       return superInterface.getLoginSession().validate(userName, password);
//    }
//    
//    public void loginUser(ActionEvent event) {
//        System.out.println("Logged in as: " + userName + " on button: " + 
//                event.getComponent().getId());
//    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
