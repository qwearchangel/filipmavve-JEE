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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Filip
 */
@ManagedBean
@ApplicationScoped
public class StudentBean {

    @EJB
    SuperInterfaceLocal superInterface;

    private int id;
    private String firstName, lastName;
    private List<Course> course;
    private String email;
    private String ssn;
    private int phone;
    private UploadedFile uploadedFile;

    private DualListModel<Course> pickCourses;

    public StudentBean() {
        course = new ArrayList<>();
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {

        uploadedFile = event.getFile();
        System.out.println("Running handleFileUpload()");

    }

    public List<Course> getCourses() {
        return superInterface.getCourseSession().getAllCourses();
    }

    public List<Student> getStudentsList() {
        return superInterface.getStudentSession().getAllStudents();
    }

    public void addStudent() {
        superInterface.getStudentSession().addStudent(firstName, lastName, ssn, email, phone, pickCourses.getTarget(), uploadedFile);
        uploadedFile = null;
    }

    public void deleteAction(Student student) {
        superInterface.getStudentSession().removeStudent(student);
    }

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
        superInterface.getStudentSession().saveEditStudent(student);
    }

    public void editAction(Student student) {
        id = student.getId();
        firstName = student.getFirstName();
        lastName = student.getLastName();
        email = student.getEmail();
        ssn = student.getSsn();
        course.clear();
        course.addAll(student.getCourseCollection());
    }

    public StreamedContent getStreamedImageById() {
        StreamedContent image = null;
        UIComponent component = FacesContext.getCurrentInstance().getViewRoot().
                findComponent("studentData:studentTable:studentImage");
        Object obj = component.getAttributes().get("studentId");
        System.out.println(obj);
//        byte[] photo;
//        String sid = FacesContext.getCurrentInstance().getExternalContext()
//                .getRequestParameterMap().get("studentId");
//        Student obj = superInterface.getStudentSession().getStudentById(Integer.parseInt(sid));
        if (obj != null) {
            Student student = (Student) obj;
            image = new DefaultStreamedContent(new ByteArrayInputStream(student.getPicture()), "image/jpg");
        }
        return image;
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

    public DualListModel<Course> getPickCourses() {

        List<Course> source = getCourses();
        List<Course> target = new ArrayList<>();
        pickCourses = new DualListModel<>(source, target);
        return pickCourses;
    }

    public void setPickCourses(DualListModel<Course> pickCourses) {
        this.pickCourses = pickCourses;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
}
