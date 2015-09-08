/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import com.filipmavve.model.Course;
import com.filipmavve.model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Filip
 */
@ManagedBean
@SessionScoped
public class StudentBean {

    private List<Student> students = new ArrayList<>();
    @ManagedProperty(value = "#{courseBean.courses}")
    private List<Course> courses = new ArrayList<>();
    String firstName, lastName, course;//student 
    String email;
    long idNumber;
    boolean editable;

    public StudentBean() {
        students.add(new Student("Bob", "Bobsson", "abc", 8705021456L, "bobsson@gmail.com"));
        students.add(new Student("Torkel", "Börjesson", "Java for beginners", 8906048531L, "Torkel@gmail.com"));
    }

    public List<Student> getStudentsList() {
        return students;
    }

    public String addStudent() {
        Student student = new Student(firstName, lastName, course, idNumber, email);
        students.add(student);

        firstName = null;
        lastName = null;
        course = null;
        email = null;
        idNumber = 0L;
        return null;
    }

    public String deleteAction(Student student) {
        students.remove(student);
        return null;
    }

    public String saveAction(Student student) {
        student.setEditable(false);
        return null;
    }

    public String saveAllAction() {

        for (Student student : students) {
            student.setEditable(false);
        }
        return null;
    }

    public String editAction(Student student) {
        student.setEditable(true);
        return null;
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

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
