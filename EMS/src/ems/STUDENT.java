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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        systemControl.courses_list.get(course_code).add_student(this);
        this.courses_id_list[this.courses_num++]=course_code;
    }
    public void subimt_assignmet_solution(int course_code,int assignment_num,String answer)
    {
        AssignmentSolution solution=new AssignmentSolution(course_code,assignment_num,answer,this.ID);
        systemControl.courses_list.get(course_code).get_assignment(assignment_num).add_assignment_solution(solution);
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
    public int get_courses_num()
    {
        return this.courses_num;
    }
    public int[] get_courses_id_list()
    {
        return this.courses_id_list;
    }
     public boolean is_owner(String password)
     {
        return(this.password.equals(password));
     }
     public ArrayList<gradesStatics> grades_statics()
     {
         ArrayList<gradesStatics> student_statics = new ArrayList<>();
         Map<Integer,String> code_information=new HashMap<>();
         Map<Integer,Integer> grades=new HashMap<>();
         Map<Integer,Integer> total=new HashMap<>();
         Map<Integer,Integer> submitted_assignments=new HashMap<>();
         for(AssignmentSolution sol:this.solutions_list)
         {
             int code = sol.get_assignment().get_course_code();
             code_information.put(code, systemControl.courses_list.get(code).toString());
             grades.put(code,grades.get(code)+sol.get_student_grade());
             total.put(code, total.get(code)+sol.get_assignment().get_max_grade());
             submitted_assignments.put(code, submitted_assignments.get(code)+1);
         }
         
         for (Map.Entry<Integer,Integer> entry : grades.entrySet()) 
         {
             int code = entry.getKey();
             gradesStatics grade_static = new gradesStatics(code_information.get(code),submitted_assignments.get(code),grades.get(code),total.get(code));
             student_statics.add(grade_static); 
         }
        
         return student_statics;
         
     }
     public AssignmentSolution get_assignment_solution(int assignment_num)
     {
         for(AssignmentSolution sol:this.solutions_list)
         {
             if(assignment_num==sol.get_assignment().get_assignment_num())
                 return sol;
         }
         return null;
     }
     public String get_name()
     {
         return this.name;
     }
    @Override
     public String toString ()
     {
         return ("student name: "+this.fullName+"\nstudent ID: "+this.ID+"number of registerd courses: "
                 + this.courses_num+"\n");
     }
     
     
}
