/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Filip
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),
    @NamedQuery(name = "Course.findByCourseName", query = "SELECT c FROM Course c WHERE c.courseName = :courseName"),
    @NamedQuery(name = "Course.findByPoints", query = "SELECT c FROM Course c WHERE c.points = :points"),
    @NamedQuery(name = "Course.findByLevel", query = "SELECT c FROM Course c WHERE c.level = :level"),
    @NamedQuery(name = "Course.findByMaxStudents", query = "SELECT c FROM Course c WHERE c.maxStudents = :maxStudents")})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "COURSE_NAME")
    private String courseName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POINTS")
    private int points;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LEVEL")
    private String level;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAX_STUDENTS")
    private int maxStudents;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "INFO")
    private String info;
    @ManyToMany(mappedBy = "courseCollection")
    private Collection<Student> studentCollection;
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Teacher teacherId;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course(Integer id, String courseName, int points, String level, int maxStudents) {
        this.id = id;
        this.courseName = courseName;
        this.points = points;
        this.level = level;
        this.maxStudents = maxStudents;
    }

    public Course(String courseName, int points, String level, int maxStudents, String info) {
        this.courseName = courseName;
        this.points = points;
        this.level = level;
        this.maxStudents = maxStudents;
        this.info = info;
    }

    public Course(String courseName, int points, String level, int maxStudents, String info, Teacher teacherId) {
        this.courseName = courseName;
        this.points = points;
        this.level = level;
        this.maxStudents = maxStudents;
        this.info = info;
        this.teacherId = teacherId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipmavve.domain.Course[ id=" + id + " ]";
    }
    
}
