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
    private String name;
    private int code;        
    ArrayList<STUDENT> student_list;
    private int  doctor_id;                //realtion with doctor
    ArrayList<TAS>TAS_list;
    private int assignment_num;
    private ASSIGNMENT []assignment_list;   //realtion with assignments
    
    COURSE(String name)
    {
        this.name=name;
        this.code=systemControl.courses_list.size();
        student_list=new ArrayList<>();
        TAS_list=new ArrayList<>();
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
        return systemControl.doctors_list.get(this.doctor_id).get_name();
    }
    
    public boolean addTAS(int tas)
    {
        if(tas<systemControl.TAS_list.size() && tas>=systemControl.TAS_list.size())
        {
        this.TAS_list.add(systemControl.TAS_list.get(tas));
        systemControl.TAS_list.get(tas).add_course(this.code);
        return true;
        }
        else return false;
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
        this.student_list.add(student);
    }
    public int get_student_num()
    {
        return this.student_list.size();
    }
    @Override
    public String toString()
    {
        return ("Course "+ name+"  -   Code "+code);
    }
    
    
}
