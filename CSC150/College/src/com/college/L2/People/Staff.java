/**
 * @author xmartin
 * @createdOn 1/17/2023 at 10:15 AM
 * @projectName College
 * @packageName com.college.L2;
 */
package com.college.L2.People;

import java.time.LocalDate;
import java.util.ArrayList;

public class Staff extends Person {
    private String jobTitle = "";
    private ArrayList<Student> studentsAdvised = new ArrayList<>();
    private boolean advisesStudents = false;

    public boolean isAdvisingStudents() {
        return advisesStudents;
    }
    public void setAdvisesStudents(boolean advisesStudents) {
        this.advisesStudents = advisesStudents;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public ArrayList<Student> getStudentsAdvised() {
        return studentsAdvised;
    }
    public void setStudentsAdvised(ArrayList<Student> studentsAdvised) {
        this.studentsAdvised = studentsAdvised;
    }
    @Override
    public String toString(){
        String advising = this.advisesStudents ? "This person advises students." : "This person doesn't advise students";
        String message = String.format("This is a Staff memeber named %s. Their Title is %s. " + advising, this.name, this.jobTitle);
        return message;
    }
    public Staff(String name, LocalDate bDay, String title, boolean advisor){
        super(name, bDay);
        this.advisesStudents = advisor;
        this.jobTitle = title;
    }
}
