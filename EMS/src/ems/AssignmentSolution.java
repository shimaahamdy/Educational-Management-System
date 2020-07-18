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
public class AssignmentSolution {
    private int assignment_num; //realtion with assignment 
    private String answer;
    private int student_grade;
    private int student_id;   //realtion with student
    private String comment;
    
    
    public AssignmentSolution(int assignment_num,String answer,int student_id)
    {
        this.assignment_num=assignment_num;
        this.answer=answer;
        this.student_id=student_id;
    }
    
    public void set_student_grade(int student_grade)
    {
        this.student_grade=student_grade;
    }
    public void set_comment(String comment)
    {
        this.comment=comment;
    }
    public int get_student_grade()
    {
        return this.student_grade;
    }
    @Override
    public String toString()
    {
        String info = ("assignment num: "+this.assignment_num);
        info+= ("\nstudent id: "+this.student_id);
        info+=("\nstudent name: "+System.student_list[this.student_id].getName());
        info+=("\nthe grade is: "+this.student_grade);
        info+=("\nthe sloution:\n"+this.answer);
        info+=("\ndoctor's comment: "+this.comment);
        return info;
    }
    
    
    
}
