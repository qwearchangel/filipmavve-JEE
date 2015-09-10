/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Login;
import javax.ejb.Stateless;

/**
 *
 * @author Filip
 */
@Stateless
public class LoginSession implements LoginSessionLocal {

    @Override
    public void checkLogin(Login Login) { //ask Hamid what is right: checkLogin or loginCheck!!!!!!
    }
}
