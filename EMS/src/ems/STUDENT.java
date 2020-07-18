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
public class STUDENT {
    private String name;
    private int ID;
    private String password;
    private String email;
    private String fullName;
    private int []courses_id_list; // realtion with courses
    private int courses_num;
    private AssignmentSolution []solutions_list;  //realtion with assignment solution
    private int solutions_num;
 
    
    
    public void register_in_course(int course_code)
    {
        System.courses_list[course_code].add_student(this);
        this.courses_id_list[this.courses_num++]=course_code;
    }
    public void subimt_assignmet_solution(int course_code,int assignment_num,String answer)
    {
        AssignmentSolution solution=new AssignmentSolution(assignment_num,answer,this.ID);
        System.courses_list[course_code].get_assignment(assignment_num).add_assignment_solution(solution);
        this.solutions_list[this.solutions_num++]=solution;
    }
    public String getPassword()
    {
        return this.password;
    }
     public String getName()
    {
        return this.name;
    }
     
     
}
