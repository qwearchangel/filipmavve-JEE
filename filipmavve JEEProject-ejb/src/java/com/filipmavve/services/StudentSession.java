/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.services;

import com.filipmavve.domain.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Filip
 */
@Stateless
public class StudentSession implements StudentSessionLocal {

    private List<Student> students;
    private Student oldStudent;

    public StudentSession() {
        students = new ArrayList<>();
        students.add(new Student("Bob", "Bobsson", "abc", 8705021456L, "bobsson@gmail.com"));
        students.add(new Student("Torkel", "Börjesson", "Java for beginners", 8906048531L, "Torkel@gmail.com"));
    }

    @Override
    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public void setEdit(Student student) {

        if (!student.isEditable()) {
            oldStudent = new Student(student);
            students.get(students.indexOf(student)).setEditable(true);
        } else {
            students.remove(student);
            oldStudent.setEditable(false);
            students.add(oldStudent);
        }
    }

    @Override
    public void addStudent(String firstName, String lastName, String course, Long idNumber, String email) {
        Student newStudent = new Student(firstName, lastName, course, idNumber, email);
        students.add(newStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public void saveStudent(Student student) {
        Student updateStudent = new Student(student.getFirstName(), student.getLastName(), student.getCourse(), student.getIdNumber(), student.getEmail());
        students.remove(student);
        updateStudent.setEditable(false);
        students.add(updateStudent);
    }

}
