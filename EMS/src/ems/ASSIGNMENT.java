
package ems;

import java.util.ArrayList;

/**
 *
 * @shimaahamdy
 */
public class ASSIGNMENT {
    
    private int assigment_num;     // assigment number
    private final int course_code; //realtion with course
    private String content;        // assignment content
    private int max_grade;         //assignment grade 
    private String assignment_exact_answer; // doctors answers for assignemt
    private ArrayList<AssignmentSolution>solutions_list; // realtion with students soutions
   
      /* constructor when we docor create new assignmetn */
    ASSIGNMENT (int assignment_num,int course_code,String content,int max_grade)
    {
        this.solutions_list=new ArrayList<>();   
        this.course_code=course_code;           
        this.content=content;                    
        this.max_grade=max_grade;                
    }
    
    /* update assigment degree */ 
    public void set_degree(int grade)         
    {
        this.max_grade=grade;
    }
    /* add new content to the old one */
    public void add_new_questions(String content)
    {
        this.content+=content;
    }
    
    /*add student's solution to the students solutions list */
     void add_assignment_solution(AssignmentSolution solution)
    {
        this.solutions_list.add(solution);
    }
    
     /* return assignment number in the course*/
    public int get_assignment_num()
    {
        return this.assigment_num;
    }
    /* set doctor answers of the assignment */
  public void set_assignment_exact_answer(String assignment_exact_answer)
  {
      this.assignment_exact_answer=assignment_exact_answer;
  }
  /* return doctor answers of the assignment */
  public String get_assignment_solution()
  {
      return this.assignment_exact_answer;
  }
  
  /* retuen list of students soultions */
   public ArrayList<AssignmentSolution> get_assignment_solutions_list()
  {
      return this.solutions_list;
  }
   /* return course's code of this assignments */
  public int get_course_code()
  {
      return this.course_code;
  }
 /* retuen assignment degree*/ 
 public int get_max_grade()
 {
     return this.max_grade;
 }
    
 
 /* overview of assignment informations */
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
