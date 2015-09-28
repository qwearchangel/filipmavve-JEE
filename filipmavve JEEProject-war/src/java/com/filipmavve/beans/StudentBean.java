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
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Filip
 */
@ManagedBean
@ViewScoped
public class StudentBean {

    @EJB
    SuperInterfaceLocal superInterface;

    int id;
    String firstName, lastName, course;
    String email;
    String idNumber;

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
    }

    public void deleteAction(Student student) {
        superInterface.getStudentSession().removeStudent(student);
    }

    public void saveAction() {
        Student student = new Student(firstName, lastName, email, idNumber);
        student.setId(id);
        superInterface.getStudentSession().saveStudent(student);
    }

    public String saveAllAction() {

        return null;
    }

    public void editAction(Student student) {
        id = student.getId();
        firstName = student.getFirstName();
        lastName = student.getLastName();
        email = student.getEmail();
        idNumber = student.getSsn();
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
