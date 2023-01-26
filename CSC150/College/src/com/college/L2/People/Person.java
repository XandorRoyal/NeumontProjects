/**
 * @author xmartin
 * @createdOn 1/17/2023 at 10:18 AM
 * @projectName College
 * @packageName com.college.L2;
 */
package com.college.L2.People;

import java.time.LocalDate;

public class Person {
    protected String name = "";
    protected LocalDate bDay = LocalDate.of(2000,1,1);

    public String getName() {
        return name;
    }

    public LocalDate getbDay() {
        return bDay;
    }

    public Person(String name, LocalDate bDay){
        this.name = name;
        this.bDay = bDay;
    }
}
