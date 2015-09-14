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
import javax.faces.event.ActionEvent;

/**
 *
 * @author Filip
 */
@ManagedBean
@RequestScoped
public class LoginBean {
    
    @EJB
    SuperInterfaceLocal superInterface;
    private String userName;
    private String password;
    
    public LoginBean() {
    }
    
    public String loginAction() {
       return superInterface.getLoginSession().validate(userName, password);
    }
    
    public void loginUser(ActionEvent event) {
        System.out.println("Logged in as: " + userName + " on button: " + 
                event.getComponent().getId());
    }
    
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
