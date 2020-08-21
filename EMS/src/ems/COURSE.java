/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

/**
 *
 * @author Leader
 */
public class COURSE {
    private String name;
    private int code;
    private int student_num;
    private STUDENT[]student_list;          // realtion with student
    private int  doctor_id;                //realtion with doctor
    private int []TAS_list_ID;             //realtion with techinacal assistant
    private int TAS_counter;
    private int assignment_num;
    private ASSIGNMENT []assignment_list;   //realtion with assignments
    
    
    {
        this.TAS_list_ID = new int [10];
    }
    
    COURSE(String name)
    {
        this.name=name;
        this.code=systemControl.courses_list.size();
    }
    public ASSIGNMENT [] get_assignment_list()
    {
        return this.assignment_list;
    }
    public int get_code()
    {
        return this.code;
    }
    public ASSIGNMENT get_assignment(int assignment_num)
    {
        return this.assignment_list[assignment_num];
    }
    
    public String get_doctor_name()
    {
        return systemControl.doctors_list.get(this.doctor_id).getName();
    }
    
    public void addTAS(int id)
    {
        this.TAS_list_ID[TAS_counter++]=id;
        systemControl.TAS_list.get(id).add_course(this.code);
    }
   
    public void add_assignment(ASSIGNMENT assignment)
    {
        this.assignment_list[this.assignment_num++]=assignment;
    }
    public int get_assignment_num()
    {
        return this.assignment_num;
    }
    public void add_student(STUDENT student)
    {
        this.student_list[this.student_num++]=student;
    }
    public int get_student_num()
    {
        return this.student_num;
    }
    @Override
    public String toString()
    {
        return ("Course "+ name+"  -   Code "+code);
    }
    
    
}
