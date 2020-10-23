
package ems;

import java.util.ArrayList;

/**
 *
 * @author Leader
 */
public class DOCTOR {
    private final  String name;                    // doctor name 
    private final int iD;                    // docotr id in the system
    private String email;                    // docotr mail 
    private String password;                 // doctor password
    private ArrayList<COURSE> courses_list;  //realtion with courses that doctor teaches
    
    
    /* constructor that create new doctor 
      system create new id atomaticaly for new doctor
      add doctor that created to doctor list in system
    */
    DOCTOR(String name,String password)
    {
        this.name=name;
        this.password=password;
        this.courses_list = new ArrayList<>();
        this.iD=systemControl.doctors_list.size();
        systemControl.doctors_list.add(this);
    }
    /* retuen courses that doctor teaches */
    public ArrayList<COURSE> get_courses_list()
    {
        return this.courses_list;
    }
    /* return number of courses that docotor teaches */
    public int get_courses_num()
    {
        return this.courses_list.size();
    }
    
    /* set email */
    public void set_email(String email)
    {
        this.email=email;
    }
    /* return email */
    public String get_email()
    {
        return this.email;
    }
    /* change password */
    public void change_password(String password)
    {
        this.password=password;
    }
    /* return password */
    public String get_password()
    {
        return password;
    }
    /* return doctor name */
    public String get_name()
    {
        return this.name;
    }
    /* return password id */ 
    public int get_iD()
    {
        return this.iD;
    }
    /* docotor can create course 
       send name and code to create course object
       
    */
    public void createCourse(String courseName,String code)
    {
           COURSE course=new COURSE(courseName,code);
          this.courses_list.add(course);
      
    }
    /* check if password enterd by that user belong to this docotr */
     public boolean is_owner(String password)
     {
        return(this.password.equals(password));
     }
     
     /* add TAS to course supervised */
    
    public void addTAS(int course_code,int TASID)
    {
        this.courses_list.get(course_code).addTAS(TASID);
    }
    /* create new assignment */
    public void create_assignment (int assignment_num,int course_code,String content,int max_grade)
    {
        systemControl.courses_list.get(course_code).add_assignment(new ASSIGNMENT(assignment_num,course_code,content,max_grade));
    }
    
    
    
    
}
