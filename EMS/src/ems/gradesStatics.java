/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

/**
 *
 * @author Leader Shop
 */
public class gradesStatics {
    
    private String course_Information ;
    private int submitted_asignments;
    private int student_grades_sum;
    private int total_grades_sum;
    
     gradesStatics(String info, int assigment,int grades,int total)
     {
         this.course_Information=info;
         this.submitted_asignments=assigment;
         this.student_grades_sum=grades;
         this.total_grades_sum=total;
     }
     public void set_course_information(String info)
     {
         this.course_Information=info;
     }
     public void set_submitted_asignments(int assigment)
     {
         this.submitted_asignments=assigment;
     }
     public void set_student_grades_sum(int grades)
     {
         this.student_grades_sum=grades;
     }
     public void set_total_grades_sum(int total)
     {
         this.total_grades_sum=total;
     }
    public String get_course_information()
    {
        return this.course_Information;
    }
    public int get_submitted_assignments()
    {
        return this.submitted_asignments;
    }
    public int get_total_grades()
    {
        return this.total_grades_sum;
    }
    public int get_student_grades_sum()
    {
        return this.student_grades_sum;
    }
}
