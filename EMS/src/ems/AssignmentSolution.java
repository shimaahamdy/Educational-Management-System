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
    private ASSIGNMENT assignment; //realtion with assignment belong to
    private final String answer;         // student answer to assignment
    private int student_grade;     // grade of student of this assignemtn
    private final int student_id;   //realtion with student that assignment belong
    private String comment;   // doctor comment to student answers
    private boolean grade_seted;  // test if grade is set or not
    
    /* constructor for creation a new solution */
    public AssignmentSolution(String answer,int student_id)
    {
        this.answer=answer;
        this.student_id=student_id;
    }
    
    /* retuen assignment that answer belong to */
    public ASSIGNMENT get_assignment()
    {
        return this.assignment;
    }
    /* test if doctor set grade or not */
    public boolean is_grade_set()
    {
        return this.grade_seted;
    }
    /* set grade of student in assignmnet */
    public void set_student_grade(int student_grade)
    {
        this.student_grade=student_grade;
        this.grade_seted=true;
    }
    /* set doctor comment to student grade */
    public void set_comment(String comment)
    {
        this.comment=comment;
    }
    /* return grade of assignemt to student */ 
    public int get_student_grade()
    {
        return this.student_grade;
    }
    /* return student name of this solution */ 
    public String get_student_name()
    {
        return systemControl.students_list.get(this.student_id).getName();
    }
   
    
    /* overview on public solution information */ 
    @Override
    public String toString()
    {
        String info = ("assignment num: "+this.assignment.get_assignment_num());
        info+= ("\nstudent id: "+this.student_id);
        info+=("\nstudent name: "+ systemControl.students_list.get(this.student_id).getName());
        info+=("\nthe grade is: "+this.student_grade);
        info+=("\nthe sloution:\n"+this.answer);
        info+=("\ndoctor's comment: "+this.comment);
        return info;
    }
    
    
    
}
