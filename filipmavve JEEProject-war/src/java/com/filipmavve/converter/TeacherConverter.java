/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.converter;

import com.filipmavve.domain.Teacher;
import com.filipmavve.services.SuperInterfaceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Filip
 */
@FacesConverter(value = "teacherConverter")
public class TeacherConverter implements Converter {

    @EJB
    SuperInterfaceLocal superInterface;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null || value.isEmpty()) {
            return null;
        }

        try {

            Teacher obj = superInterface.getTeacherSession().
                    getTeacherById(Integer.valueOf(value));

            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConverterException(new FacesMessage(String.format("Cannot convert %s to Teacher", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (!(value instanceof Teacher)) {
            return null;
        }

        String s = String.valueOf(((Teacher) value).getId());

        return s;
    }

}
