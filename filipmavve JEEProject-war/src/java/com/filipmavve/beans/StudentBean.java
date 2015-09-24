/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import com.filipmavve.domain.Student;
import com.filipmavve.services.SuperInterfaceLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Filip
 */
@ManagedBean
@ViewScoped
public class StudentBean {

    @EJB
    SuperInterfaceLocal superInterface;

    String firstName, lastName, course;
    String email;
    long idNumber;
    boolean editable;

    public StudentBean() {
    }

    public Iterable getCourses() {
        return superInterface.getCourseSession().getAllCourses();
    }

    public List<Student> getStudentsList() {
        return superInterface.getStudentSession().getAllStudents();
    }

    public void addStudent() {
        superInterface.getStudentSession().addStudent(firstName, lastName, course, idNumber, email);
        resetInput();
    }

    public void deleteAction(Student student) {
        superInterface.getStudentSession().removeStudent(student);
    }

    public void saveAction(Student student) {
        superInterface.getStudentSession().saveStudent(student);
    }

    public String saveAllAction() {

        return null;
    }

    public void editAction(Student student) {
        firstName = student.getFirstName();
        lastName = student.getLastName();
        email = student.getEmail();
        idNumber = student.getIdNumber();
        course = student.getEmail();
    }

    public void cancelAction(Student student) {
        superInterface.getStudentSession().setEdit(student);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    private void resetInput() {
//         RequestContext.getCurrentInstance().reset("studentForm:studentPanelGrid:studentFirstName");
//         System.out.println("reset test");
        firstName = "";
        lastName = "";
        course = "";
        idNumber = 0L;
        email = "";
    }
}
