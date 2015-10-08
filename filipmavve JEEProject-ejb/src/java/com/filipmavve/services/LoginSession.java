/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Teacher;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LoginSession implements LoginSessionLocal {

    @PersistenceContext(name = "filipmavve_JEEProject-ejbPU")
    EntityManager em;

    private String email;
    private String password;
    private boolean logedin = false;
    
    /**
     * Checks the DB for login credentials and validates
     * 
     * @param email
     * @param password
     * @return true or false
     */
    @Override
    public boolean validate(String email, String password) {
        setLogedin(false);

        Query q = em.createQuery("SELECT t FROM Teacher t WHERE t.email = :email AND t.passWord = :pass");
        q.setParameter("email", email);
        q.setParameter("pass", password);
        try {
            Teacher teacher = (Teacher) q.getSingleResult();
            if (email.equalsIgnoreCase(teacher.getEmail()) && password.equals(teacher.getPassWord())) {
                setLogedin(true);
                return logedin;
            }
        } catch (Exception e) {
            setLogedin(false);
        }
        return logedin;
    }
    //  SETTERS AND GETTERS
    public boolean isLogedin() {
        return logedin;
    }

    public void setLogedin(boolean logedin) {
        this.logedin = logedin;
    }

    public LoginSession() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
