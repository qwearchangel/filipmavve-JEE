/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Course;
import com.filipmavve.domain.Student;
import com.filipmavve.domain.Teacher;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.Part;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Filip
 */
@Stateless
public class StudentSession implements StudentSessionLocal {

    @PersistenceContext(name = "filipmavve_JEEProject-ejbPU")
    EntityManager em;

    public StudentSession() {
    }

    @Override
    public void removeStudent(Student student) {
        Student delete = em.find(Student.class, student.getId());
        em.remove(delete);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = em.createNamedQuery("Student.findAll", Student.class);
        List<Student> result = query.getResultList();
        return result;
    }

    @Override
    public void saveEditStudent(Student student) {
        Student save = student;
        em.merge(save);
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void addStudent(String firstName, String lastName, String ssn, String email, int phone, List<Course> courses, UploadedFile uploadedFile) {
        Student newStudent = new Student(firstName, lastName, email, ssn, phone);
        newStudent.setCourseCollection(courses);
        List<Teacher> teachers = new ArrayList<>();
        for (Course c : courses) {
            Teacher teach = c.getTeacherId();
            if (!teachers.contains(teach)) {
                teachers.add(teach);
            }
        }
        try {
            newStudent.setPicture(getFileContents(uploadedFile.getInputstream()));
        } catch (IOException ex) {
            Logger.getLogger(StudentSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        newStudent.setTeacherCollection(teachers);
        em.persist(newStudent);
    }

    private byte[] getFileContents(InputStream in) {
        byte[] bytes = null;
        try {
            // write the inputStream to a FileOutputStream            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int read = 0;
            bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                bos.write(bytes, 0, read);
            }
            bytes = bos.toByteArray();
            in.close();
            in = null;
            bos.flush();
            bos.close();
            bos = null;
            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bytes;
    }

    @Override
    public Student getStudentById(int id) {
        return em.createNamedQuery("Student.findById", Student.class).setParameter("id", id).getSingleResult();
    }
}
