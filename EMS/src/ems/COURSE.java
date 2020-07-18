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
        this.code=System.course_num++;
    }
    public ASSIGNMENT get_assignment(int assignment_num)
    {
        return this.assignment_list[assignment_num];
    }
    
    public void addTAS(int id)
    {
        this.TAS_list_ID[TAS_counter++]=id;
        System.TAS_list[id].add_course(this.code);
    }
   
    public void add_assignment(ASSIGNMENT assignment)
    {
        this.assignment_list[this.assignment_num++]=assignment;
    }
    
    public void add_student(STUDENT student)
    {
        this.student_list[this.student_num++]=student;
    }
    @Override
    public String toString()
    {
        return ("Course "+ name+"  -   Code "+code);
    }
    
    
}
