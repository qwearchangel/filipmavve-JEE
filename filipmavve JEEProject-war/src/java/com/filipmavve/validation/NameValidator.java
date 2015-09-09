/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author mavve
 */
@FacesValidator ("nameValidator")
public class NameValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        if (value.toString().isEmpty()){
            FacesMessage fmsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "name validation failed!", "invalid input!");
            throw new ValidatorException(fmsg);
        }
        
    }
    
}
