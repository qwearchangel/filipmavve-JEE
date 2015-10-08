/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import com.filipmavve.domain.Course;
import com.filipmavve.domain.Student;
import com.filipmavve.domain.Teacher;
import com.filipmavve.services.SuperInterfaceLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DualListModel;

/**
 * A ManagedBean for the student page
 *
 * @author Filip
 */
@ManagedBean
@ViewScoped
public class StudentBean {

    @EJB
    SuperInterfaceLocal superInterface;

    int id;
    String firstName, lastName;
    List<Course> course;
    String email;
    String ssn;
    int phone;

    private DualListModel<Course> pickCourses;

    public StudentBean() {
        course = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return superInterface.getCourseSession().getAllCourses();
    }

    public List<Student> getStudentsList() {
        return superInterface.getStudentSession().getAllStudents();
    }

    public void addStudent() {
        superInterface.getStudentSession().addStudent(firstName, lastName, ssn, email, phone, pickCourses.getTarget());
    }
    
    public void deleteAction(Student student) {
        superInterface.getStudentSession().removeStudent(student);
    }
    
    /**
     * The student data is temporarly saved in this bean when edit button is pressed.
     * 
     * @param student 
     */
    public void editAction(Student student) {
        id = student.getId();
        firstName = student.getFirstName();
        lastName = student.getLastName();
        email = student.getEmail();
        ssn = student.getSsn();
        course.clear();
        course.addAll(student.getCourseCollection());
    }
    
    /**
     * Saves the edited data.
     */
    public void saveEditAction() {
        course = pickCourses.getTarget();
        Student student = new Student(firstName, lastName, email, ssn, phone);
        student.setId(id);
        student.setCourseCollection(course);
        List<Teacher> teachers = new ArrayList<>();
        for (Course c : course) {
            Teacher teach = c.getTeacherId();
            if (!teachers.contains(teach)) {
                teachers.add(teach);
            }
        }
        student.setTeacherCollection(teachers);
        superInterface.getStudentSession().saveStudent(student);
    }
    
    // EDITED SETTER AND GETTER
    /**
     * Picklist DualListModel of courses.
     * 
     * @return pickCourses
     */
    public DualListModel<Course> getPickCourses() {

        List<Course> source = getCourses();
        List<Course> target = new ArrayList<>();
        pickCourses = new DualListModel<>(source, target);
        return pickCourses;
    }

    // SETTERS AND GETTERS
    public void setPickCourses(DualListModel<Course> pickCourses) {
        this.pickCourses = pickCourses;
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

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}
