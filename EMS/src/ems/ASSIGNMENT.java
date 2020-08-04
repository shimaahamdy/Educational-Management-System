
package ems;

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
    private AssignmentSolution []solutions_list;  //relation with solutions
    private int solutions_num;
    
    ASSIGNMENT (int assignment_num,int course_code,String content,int max_grade)
    {
        this.assigment_num=assignment_num;
        this.course_code=course_code;
        this.content=content;
        this.max_grade=max_grade;
    }
    
    public void add_assignment_solution(AssignmentSolution solution)
    {
        this.solutions_list[this.solutions_num++]=solution;
    }
  public void set_assignment_exact_answer(String assignment_exact_answer)
  {
      this.assignment_exact_answer=assignment_exact_answer;
  }
  public String get_assignment_solution()
  {
      return this.assignment_exact_answer;
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
