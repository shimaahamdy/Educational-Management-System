
package ems;

import java.util.ArrayList;

/**
 *
 * @author Leader
 */
public class DOCTOR {
    private  String name;
    private final int iD;
    private String email;
    private String password;
    private ArrayList<COURSE> courses_list; 
    
    
    DOCTOR()
    {
        this.courses_list = new ArrayList<>();
        this.iD=systemControl.doctors_list.size();
        systemControl.doctors_list.add(this);
        
    }
    public void set_name(String name)
    {
        this.name=name;
    }
    public ArrayList<COURSE> get_courses_list()
    {
        return this.courses_list;
    }
    public int get_courses_num()
    {
        return this.courses_list.size();
    }
    public int get_id()
    {
        return this.iD;
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
    
    public String get_name()
    {
        return this.name;
    }
    
    public int get_iD()
    {
        return this.iD;
    }
    public void createCourse(String courseName,String code)
    {
           COURSE course=new COURSE(courseName,code);
          this.courses_list.add(course);
          systemControl.courses_list.add(course);
       
     }
     public boolean is_owner(String password)
     {
        return(this.password.equals(password));
     }
    
    public void addTAS(int course_code,int TASID)
    {
        this.courses_list.get(course_code).addTAS(TASID);
    }
    public void create_assignment (int assignment_num,int course_code,String content,int max_grade)
    {
        systemControl.courses_list.get(course_code).add_assignment(new ASSIGNMENT(assignment_num,course_code,content,max_grade));
    }
    
    
    
    
}
