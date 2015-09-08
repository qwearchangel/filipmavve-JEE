/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import com.filipmavve.model.Login;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Filip
 */
@ManagedBean
@RequestScoped
public class LoginBean {
    
    private String userName;
    private String password;
    private List<Login> logins = new ArrayList<>();
    public LoginBean() {
        logins.add(new Login("admin", "admin"));
        logins.add(new Login("user1", "user1"));
        logins.add(new Login("user2", "user2"));
        logins.add(new Login("user3", "user3"));
    }
    
    public String loginAction() {
        boolean success = false;
        for (Login login : logins) {
            if (userName.equals(login.getPassword()) && password.equals(login.getPassword())) {
                success = true;
            }
        }
        
        if (userName == null || !success) {
            return "Error";
            
        } else {
            return "Home";
        }
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

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }
    
    
}
