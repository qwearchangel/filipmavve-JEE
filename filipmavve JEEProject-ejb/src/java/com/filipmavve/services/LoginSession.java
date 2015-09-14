/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Login;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Filip
 */
@Stateless
public class LoginSession implements LoginSessionLocal {

    private List<Login> logins;

    public LoginSession() {
        logins = new ArrayList<>();
        logins.add(new Login("admin", "admin"));
        logins.add(new Login("user1", "user1"));
        logins.add(new Login("user2", "user2"));
        logins.add(new Login("user3", "user3"));
    }
    
    @Override
    public String validate(String userName, String password) { 
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
}
