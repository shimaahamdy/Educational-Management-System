
package ems;

import java.util.ArrayList;

/**
 *
 * @shimaahamdy
 */
public class ASSIGNMENT {
    
    private int assigment_num;
    private int course_code; //realtion with course
    private String content;
    private int max_grade;
    private String assignment_exact_answer;
    private ArrayList<AssignmentSolution>solutions_list;
   
    
    ASSIGNMENT (int assignment_num,int course_code,String content,int max_grade)
    {
        this.solutions_list=new ArrayList<>();
        this.course_code=course_code;
        this.content=content;
        this.max_grade=max_grade;
    }
    
    public void add_assignment_solution(AssignmentSolution solution)
    {
        this.solutions_list.add(solution);
    }
    
    public int get_assignment_num()
    {
        return this.assigment_num;
    }
  public void set_assignment_exact_answer(String assignment_exact_answer)
  {
      this.assignment_exact_answer=assignment_exact_answer;
  }
  public String get_assignment_solution()
  {
      return this.assignment_exact_answer;
  }
   public ArrayList<AssignmentSolution> get_assignment_solutions_list()
  {
      return this.solutions_list;
  }
  public int get_course_code()
  {
      return this.course_code;
  }
  
 public int get_max_grade()
 {
     return this.max_grade;
 }
    
    @Override
     public String toString()
    {
        String info = ("assignment num: "+this.assigment_num);
        info+= ("\ncourse code: "+this.course_code);
        info+=("\nmax grade: "+this.max_grade);
        info+=("\nthe assignment questions:\n"+this.content);
        return info;
    }
    
}
