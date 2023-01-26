/**
 * @author xmartin
 * @createdOn 1/17/2023 at 10:14 AM
 * @projectName College
 * @packageName com.college.L2;
 */
package com.college.L2.People;

import com.college.L2.course.Class;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Person {
    private Staff advocate;
    private double gpa = 0.0;
    private ArrayList<Class> classes = new ArrayList<>();

    public void addClass(Class collegeClass){
        if(classes.contains(collegeClass)) return;
        classes.add(collegeClass);
        collegeClass.addStudent(this);
    }

    public void removeClass(Class collegeClass){
        if(!classes.contains(collegeClass)) return;
        classes.remove(collegeClass);
        collegeClass.removeStudent(this);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public ArrayList<Class> getClasses(){
        return this.classes;
    }

    public void setAdvocate(Staff advocate){
        this.advocate = advocate;
    }

    public void removeAdvocate(){
        this.advocate = null;
    }

    @Override
    public String toString(){
        String advocateMessage = this.advocate == null ? "This Student doesn't have an advocate." : String.format("This person's advocate is %s.",this.advocate.getName());
        String message = String.format("This is a student named %s. " + advocateMessage, this.name);
        return message;
    }

    public Student(String name, LocalDate bday){
        super(name, bday);
    }
}
