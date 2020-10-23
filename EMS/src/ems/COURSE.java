/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

import java.util.ArrayList;

/**
 *
 * @author Leader
 */
public class COURSE {
    private String name;                   // course name 
    private String code;                   // course code in colleage
    private final int number;              // course number in courses list in colleage 
    ArrayList<STUDENT> student_list;       // students that rolled in course (realtion with students)
    private int  doctor_id;                //realtion with doctor
    ArrayList<TAS>TAS_list;                // which assistant supervise to that course           
    ArrayList<ASSIGNMENT> assignment_list; // number of assignment has bee upload to this course(realtion with assignments)
    
    /* constructor in creating new course 
    course number is created atomiacally by the system 
    */
    public COURSE(String name,String code)
    {
        this.name=name;
        this.code=code;
        this.number=systemControl.courses_list.size();   // automatic generation 
        student_list=new ArrayList<>();
        TAS_list=new ArrayList<>();
        systemControl.courses_list.add(this);
    }
    /*return assignments of this course */
    public ArrayList<ASSIGNMENT> get_assignment_list()
    {
        return this.assignment_list;
    }
    /* retuen course number */
    public int get_course_number()
    {
        return this.number;
    }
    /* reurn specific assignment in the course */
    public ASSIGNMENT get_assignment(int assignment_num)
    {
        return this.assignment_list.get(assignment_num);
    }
    /* return doctor that responsible of that course */
    public String get_doctor_name()
    {
        return systemControl.doctors_list.get(this.doctor_id).get_name();
    }
    
    /* add techinical assistant will work with course
    test if id of tecinical assistant vaild, checking in  TAS list saved in system 
    if -->true -->add id to tas list belong to this course 
               -->add course to tas courses that work in         
    */ 
    public boolean addTAS(int tas)
    {
        if(tas<systemControl.TAS_list.size() && tas>=systemControl.TAS_list.size()) 
        {
        this.TAS_list.add(systemControl.TAS_list.get(tas)); 
        systemControl.TAS_list.get(tas).add_course(this.number); 
        return true;
        }
        else return false;
    }
   
    /* add new assignemnt to the list */
    public void add_assignment(ASSIGNMENT assignment)
    {
        this.assignment_list.add(assignment);
    }
    /* return number of assignments in that course */
    public int get_assignment_num()
    {
        return this.assignment_list.size();
    }
    /* add new student that enrolled in course */
    public void add_student(STUDENT student)
    {
        this.student_list.add(student);
    }
    /* return number of students that enrolled in that course */
    public int get_student_num()
    {
        return this.student_list.size();
    }
    /* information about course */
    @Override
    public String toString()
    {
        return ("Course "+ this.name+"  -   Code "+this.code);
    }
    
    
}
