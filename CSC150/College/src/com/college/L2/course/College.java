/**
 * @author xmartin
 * @createdOn 1/17/2023 at 10:14 AM
 * @projectName College
 * @packageName com.college.L2;
 */
package com.college.L2.course;

import com.college.L2.People.Faculty;
import com.college.L2.People.Staff;
import com.college.L2.People.Student;

import java.util.ArrayList;

public class College {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Faculty> faculty = new ArrayList<>();
    private ArrayList<Staff> staff = new ArrayList<>();
    private ArrayList<Class> classes = new ArrayList<>();
    private String Name;

    public ArrayList<Student> getStudents() {
        return students;
    }
    public void addStudent(Student student){
        this.students.add(student);
    }
    public void removeStudent(Student student){
        if (!this.students.contains(student)) return;
        this.students.remove(student);
    }
    public ArrayList<Faculty> getFaculty() {
        return this.faculty;
    }
    public void addFaculty(Faculty faculty){
        this.faculty.add(faculty);
    }
    public void removeFaculty(Faculty Faculty){
        if (!this.faculty.contains(faculty)) return;
        this.faculty.remove(faculty);
    }
    public ArrayList<Staff> getStaff() {
        return staff;
    }
    public void addStaff(Staff staff){
        this.staff.add(staff);
    }
    public void removeStaff(Staff staff){
        if (!this.staff.contains(staff)) return;
        this.staff.remove(staff);
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }
    public void addClass(Class c){
        this.classes.add(c);
    }
    public void removeClass(Class c){
        if (!this.classes.contains(c)) return;
        this.classes.remove(c);
    }

    @Override
    public String toString(){
        return String.format("The college is named %s.",this.Name);
    }

    College(String name){
        this.Name = name;
    }
}
