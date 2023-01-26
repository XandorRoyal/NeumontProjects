/**
 * @author xmartin
 * @createdOn 1/17/2023 at 10:22 AM
 * @projectName College
 * @packageName com.college.L2;
 */
package com.college.L2.course;

import com.college.L2.People.Faculty;
import com.college.L2.People.Student;

import java.util.ArrayList;

public class Class {
    private String className = "";
    private ArrayList<Student> students = new ArrayList<>();
    private Faculty professor;

    public Faculty getProfessor() {
        return professor;
    }
    public void setProfessor(Faculty professor) {
        this.professor = professor;
    }
    public void removeProfessor() {
        this.professor = null;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void addStudent(Student student) {
        if (students.contains(student)) return;
        this.students.add(student);
        student.addClass(this);
    }
    public void removeStudent(Student student){
        if (!students.contains(student)) return;
        this.students.remove(student);
        student.removeClass(this);
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString(){
        String professor = this.professor == null ? "" : String.format("It is taught by %s",this.professor.getName());
        String message = String.format("This class is %s. "+professor, this.className);
        return message;
    }

    Class(String className){
        this.className = className;
    }
}
