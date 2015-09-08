/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.listeners;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author Filip
 */
public class NavigationListener implements ActionListener{

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        
        String button = event.getComponent().getId();
        String sameButton = navigationMethod(button);
    }

    private String navigationMethod(String button) {
        return button;
    }
    
}
