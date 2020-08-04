
package ems;

/**
 *
 * @author Leader
 */
public class DOCTOR {
    private final String name;
    private final int iD;
    private final int nationalNumber;
    private String email;
    private String password;
    private COURSE [] courseList; //realtion with courses
    private int course_counter;
    
    {
        courseList=new COURSE[100];
    }
    DOCTOR(String name,int nationalNumber,String email,String password)
    {
        this.name=name;
        this.nationalNumber=nationalNumber;
        this.email=email;
        this.password=password;
        this.iD=systemControl.doctors_list.size()+1;
        
    }
   
    public void set_email(String email)
    {
        this.email=email;
    }
    public String get_email()
    {
        return this.email;
    }
    public void set_password(String password)
    {
        this.password=password;
    }
    
    public String get_password()
    {
        return password;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int get_iD()
    {
        return this.iD;
    }
    public void createCourse(String courseName)
    {
           
          courseList[course_counter]= new COURSE(courseName);
          systemControl.courses_list.add(courseList[course_counter]);
          ++course_counter;
     }
    
    public void addTAS(int course_code,int TASID)
    {
        courseList[course_counter].addTAS(TASID);
    }
    public void create_assignment (int assignment_num,int course_code,String content,int max_grade)
    {
        systemControl.courses_list.get(course_code).add_assignment(new ASSIGNMENT(assignment_num,course_code,content,max_grade));
    }
    
    
    
    
}
