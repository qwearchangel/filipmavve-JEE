/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.beans;

import com.filipmavve.domain.Course;
import com.filipmavve.domain.Student;
import com.filipmavve.services.SuperInterfaceLocal;
import java.util.ArrayList;
import java.util.Date;
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
public class AttendenceBean {

    @EJB
    SuperInterfaceLocal superInterface;

    private Date date;
    private int courseId;
    private List<Student> students;

    public AttendenceBean() {
        students = new ArrayList<>();
    }

    public Iterable getCourses() {
        return superInterface.getCourseSession().getAllCourses();
    }
    
    public void applyStudentsByCourseId() {
        Course course = superInterface.getCourseSession().getCourseById(courseId);
        students = (List<Student>) course.getStudentCollection();
    }
    //Getter and Setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
