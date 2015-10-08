/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * Navigation HQ
 * (For left side of template)
 * 
 * @author Filip
 */
@ManagedBean
@ViewScoped
public class navigationBean {

    String page = "Login.xhtml";

    /**
     * Creates a new instance of navigationBean
     */
    public navigationBean() {
    }

    public void goToPage(ActionEvent event) {
        String id = event.getComponent().getId();
        switch (id) {
            case "StudentPage":
                page = "StudentPage.xhtml";
                break;
            case "CoursePage":
                page = "CoursePage.xhtml";
                break;
            case "AttPage":
                page = "AttendancePage.xhtml";
                break;
            default:
                page = "Login.xhtml";
                break;
        }
    }

    public String getPage() {
        return page;
    }

}
