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
     public ArrayList<gradesStatics> grades_statics()
     {
         ArrayList<gradesStatics> student_statics = new ArrayList<>();
         for(int num : this.courses_id_list)
         {
             String info=systemControl.courses_list.get(num).toString();
             int grades=0;
             int total=0;
             int submitted_ass=0;
           for(int ass=0;ass<systemControl.courses_list.get(num).get_assignment_num();++ass)
           {
               total+=systemControl.courses_list.get(num).get_assignment(ass).get_max_grade();
           }
          for(AssignmentSolution sol:this.solutions_list)
         {
             if(num==sol.get_course_code())
             {
                 grades+=sol.get_student_grade();
                 submitted_ass++;
             }
         }
          gradesStatics grade_static = new gradesStatics(info,submitted_ass,grades,total);
          student_statics.add(grade_static);
         }
         return student_statics;
         
     }
     
     
}
