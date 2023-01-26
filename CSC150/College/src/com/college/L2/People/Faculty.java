/**
 * @author xmartin
 * @createdOn 1/17/2023 at 10:15 AM
 * @projectName College
 * @packageName com.college.L2;
 */
package com.college.L2.People;

import com.college.L2.Status;
import com.college.L2.course.Class;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Faculty extends Person {
    private int officeNumber = 0;
    private LocalTime[] officeHours = new LocalTime[2];
    private Status status;
    private ArrayList<Class> classesTaught = new ArrayList<>();

    public int getOfficeNumber(){
        return this.officeNumber;
    }
    public void setOfficeNumber(int officeNumber){
        this.officeNumber = officeNumber;
    }
    public LocalTime[] getOfficeHours(){
        return this.officeHours;
    }
    public void setOfficeHours(LocalTime[] times){
        this.officeHours = times;
    }
    public Status getEmploymentStatus(){
        return this.status;
    }
    public void setEmploymentStatus(Status status) {this.status = status;}
    public ArrayList<Class> getClassesTaught(){
        return this.classesTaught;
    }

    @Override
    public String toString(){
        String message = String.format("This is a professor named %s. Their office is %s and their office hours are %s - %s. They are an %s employee.", this.name, this.officeNumber, this.officeHours[0],this.officeHours[1], this.status);
        return message;
    }

    public Faculty(String name, LocalDate bday, Status status, int officeNumber, LocalTime[] officeHours){
        super(name, bday);
        this.status = status;
        this.officeNumber = officeNumber;
        this.officeHours = officeHours;
    }
}
