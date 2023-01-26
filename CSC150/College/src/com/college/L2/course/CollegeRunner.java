/**
 * @author xmartin
 * @createdOn 1/17/2023 at 10:14 AM
 * @projectName College
 * @packageName com.college.L2;
 */
package com.college.L2.course;

import com.college.L2.People.Faculty;
import com.college.L2.People.Staff;
import com.college.L2.Status;
import com.college.L2.People.Student;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CollegeRunner {
    ArrayList<College> colleges = new ArrayList<>();

    public void run(){

        boolean exit = false;
        System.out.println("Welcome to the college editor program!");
        College college = new College(CollegeUI.getString("Please enter a name for the college: "));
        do {
            System.out.println("What would you like to do? (Or you can ask for \"help\" to get a list of commands");
            String command = CollegeUI.getString("$ ");

            switch (command.toLowerCase()) {
                case "help", "1":
                    System.out.println(CollegeUI.help());
                    break;
                case "2":
                    List personInfo = CollegeUI.getPerson("Staff");
                    Object[] personInfoArray = personInfo.toArray();
                    String title = CollegeUI.getString("Insert job title: ");
                    boolean adv = CollegeUI.getBool("Is this staff an advocate? (Anything other than \"True\" is false.): ");
                    Staff staff = new Staff((String) personInfoArray[0], (LocalDate) personInfoArray[1], title, adv);
                    college.addStaff(staff);
                    System.out.println(staff);
                    break;
                case "2b":
                    String name = CollegeUI.getString("Please insert a name of a staff member to remove: ");
                    ArrayList<Staff> staffList = college.getStaff();
                    for (int i = 0; i < staffList.size(); i++){
                        Staff staf = staffList.get(i);
                        if (staf.getName().equalsIgnoreCase(name)) {
                            college.removeStaff(staf);
                            break;
                        }
                    }
                    break;
                case "3":
                    List Pid = CollegeUI.getPerson("Faculty");
                    Object[] PiA = Pid.toArray();
                    Status status = CollegeUI.getEmploymentStatus("Get Employment Status (ADJUNCT or FULL_TIME): ");
                    int officeNum = CollegeUI.getInt("Please input office number: ");
                    LocalTime[] officeHours = CollegeUI.getTimes("Please input a single time (format hh:mm)");
                    Faculty faculty = new Faculty((String) PiA[0], (LocalDate) PiA[1], status, officeNum, officeHours);
                    college.addFaculty(faculty);
                    System.out.println(faculty);
                    break;

                case "3b":
                    String nam = CollegeUI.getString("Please insert a name of a faculty member to remove: ");
                    ArrayList<Faculty> facultyList = college.getFaculty();
                    for (int i = 0; i < facultyList.size(); i++){
                        Faculty faculty1 = facultyList.get(i);
                        if (faculty1.getName().equalsIgnoreCase(nam)) {
                            college.removeFaculty(faculty1);
                            break;
                        }
                    }
                    break;
                case "4":
                    List personal = CollegeUI.getPerson("Student");
                    Object[] personalInfo = personal.toArray();
                    Student student = new Student((String) personalInfo[0], (LocalDate) personalInfo[1]);
                    college.addStudent(student);
                    System.out.println(student);
                    break;

                case "4b":
                    String na = CollegeUI.getString("Please insert a name of a faculty member to remove: ");
                    ArrayList<Student> studentList = college.getStudents();
                    for (int i = 0; i < studentList.size(); i++){
                        Student student1 = studentList.get(i);
                        if (student1.getName().equalsIgnoreCase(na)) {
                            college.removeStudent(student1);
                            break;
                        }
                    }
                    break;
                case "5":
                    String staffMemberName = CollegeUI.getString("Please select a Staff member: ");
                    String studentName = CollegeUI.getString("Please select a student: ");
                    Student stud = null;
                    Staff staff1 = null;
                    for (Staff staffMember : college.getStaff()){
                        if (staffMember.getName().equalsIgnoreCase(staffMemberName)){
                            staff1 = staffMember;
                        }
                    }
                    for (Student studentMember : college.getStudents()){
                        if (studentMember.getName().equalsIgnoreCase(studentName)){
                            stud = studentMember;
                        }
                    }
                    if (stud == null || staff1 == null) {System.out.println("Invalid Name(s)");break;}
                    if (!staff1.isAdvisingStudents()) {System.out.println("Please choose a staff member that advises students"); break;}
                    stud.setAdvocate(staff1);
                    break;
                case "5b":
                    String studentNameRemoved = CollegeUI.getString("Please select a student: ");
                    Student student1 = null;
                    for (Student student2 : college.getStudents()){
                        if (student2.getName().toLowerCase().equals(studentNameRemoved)){
                            student2.removeAdvocate();
                            break;
                        }
                    }
                    break;
                case "6":
                    String courseName = CollegeUI.getString("Please insert a name for a Course/Class: ");
                    Class cla = new Class(courseName);
                    college.addClass(cla);
                    System.out.println(cla);
                    break;
                case "6b":
                    String removedCourseName = CollegeUI.getString("Please insert the name of the Class/Course you want to remove: ");
                    ArrayList<Class> classes = college.getClasses();
                    for (int i=0; i < classes.size(); i++){
                        Class class1 = classes.get(i);
                        if (class1.getClassName().toLowerCase().equals(removedCourseName)){
                            college.removeClass(class1);
                            break;
                        }
                    }
                case "7":
                    String assignedCourseName = CollegeUI.getString("Please insert the name of the course: ");
                    String facultyName = CollegeUI.getString("Please insert the name of the faculty: ");
                    Faculty faculty1 = null;
                    Class class1 = null;
                    for (Faculty faculty2 : college.getFaculty()){
                        if (faculty2.getName().equalsIgnoreCase(facultyName)){
                            faculty1 = faculty2;
                        }
                    }
                    for (Class class2 : college.getClasses()){
                        if (class2.getClassName().equalsIgnoreCase(assignedCourseName)){
                            class1 = class2;
                        }
                    }
                    if (class1 == null || faculty1 == null) {System.out.println("Invalid Name(s)");break;}
                    class1.setProfessor(faculty1);
                    break;
                case "7b":
                    String classNameRemove = CollegeUI.getString("Input class name to remove professor: ");
                    Class class3 = null;
                    for (Class class4 : college.getClasses()){
                        if (class4.getClassName().equalsIgnoreCase(classNameRemove)){
                            class3 = class4;
                        }
                    }
                    if (class3 == null) {System.out.println("Inputted class name is not valid."); break;}
                    class3.removeProfessor();
                    break;
                case "8":
                    String assignedCourseName2 = CollegeUI.getString("Please insert the name of the course: ");
                    String studentName2 = CollegeUI.getString("Please insert the name of the faculty: ");
                    Student student2 = null;
                    Class class2 = null;
                    for (Student student3 : college.getStudents()){
                        if (student3.getName().equalsIgnoreCase(studentName2)){
                            student2 = student3;
                        }
                    }
                    for (Class class4 : college.getClasses()){
                        if (class4.getClassName().equalsIgnoreCase(assignedCourseName2)){
                            class2 = class4;
                        }
                    }
                    if (class2 == null || student2 == null) {System.out.println("Invalid Name(s)");break;}
                    class2.addStudent(student2);
                    break;
                case "8b":
                    String assignedCourseName3 = CollegeUI.getString("Please insert the name of the course: ");
                    String studentName3 = CollegeUI.getString("Please insert the name of the faculty: ");
                    Student student3 = null;
                    Class class4 = null;
                    for (Student student4 : college.getStudents()){
                        if (student4.getName().equalsIgnoreCase(studentName3)){
                            student3 = student4;
                        }
                    }
                    for (Class class5 : college.getClasses()){
                        if (class5.getClassName().equalsIgnoreCase(assignedCourseName3)){
                            class4 = class5;
                        }
                    }
                    if (class4 == null || student3 == null) {System.out.println("Invalid Name(s)");break;}
                    class4.removeStudent(student3);
                    break;
                case "9":
                    System.out.println(college+":");
                    for (Student student6 : college.getStudents()){
                        System.out.println(student6);
                    }
                    for (Faculty facu : college.getFaculty()){
                        System.out.println(facu);
                    }
                    for (Staff sta : college.getStaff()){
                        System.out.println(sta);
                    }
                    for (Class class5 : college.getClasses()){
                        System.out.println((class5));
                        for (Student student4 : class5.getStudents()){
                            System.out.println(String.format("%s is apart of class: %s", student4.getName(), class5.getClassName()));
                        }
                    }
                    break;
                case "10":
                    exit = true;
                    break;
            }
        }while (!exit);
    }
}
