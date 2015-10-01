/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import javax.ejb.Local;

/**
 *
 * @author Filip
 */
@Local
public interface LoginSessionLocal {

    public boolean validate(String userName, String password);
    
}
