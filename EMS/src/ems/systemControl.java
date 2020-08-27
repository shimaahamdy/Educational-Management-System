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
import java.util.ArrayList;
public class systemControl {
    public static ArrayList <DOCTOR> doctors_list = new ArrayList<>();
    public static ArrayList <COURSE> courses_list = new ArrayList<>();
    public static ArrayList <TAS> TAS_list = new ArrayList<>();
    public static ArrayList <STUDENT> students_list = new ArrayList<>();
    
  
    /*           studnt manager */
    public static STUDENT get_student(int student_id)
    {
        return systemControl.students_list.get(student_id);
    }
    
    public static STUDENT get_user_student(int student_id,String passowrd)
    {
        if (systemControl.students_list.get(student_id).is_owner(passowrd))
            return get_student(student_id);
        else return null;
    }
    public static int get_total_system_students()
    {
        return systemControl.students_list.size();
    }
    
    public static void show_students()
    {
        for(STUDENT student:systemControl.students_list)
        {
            System.out.print(student.toString());
            if(student.get_courses_num()!=0)
                System.out.println("student courses details: ");
                for(int course_code:student.get_courses_id_list())
                {
                    System.out.println(systemControl.courses_list.get(course_code).toString());
                }
        }
    }
    
    
    
    
    /*                      course manager                */
    public static int get_total_course_students(int course_code)
    {
        return systemControl.courses_list.get(course_code).get_student_num();
    }
    
    public static ArrayList <COURSE>get_courses_not_registerd(ArrayList<Integer>courses_registerd)
    {   
           ArrayList <COURSE> courses_not_registerd = new ArrayList<>();
       
        for(COURSE course:systemControl.courses_list)
        {
            boolean is_registerd=false;
            for(int registerd_course:courses_registerd)
            {
                if(course.get_code()==registerd_course)
                {
                    is_registerd=true;
                    break;
                }
                    
            }
            if(!is_registerd)
                courses_not_registerd.add(course);
        }
        return courses_not_registerd;
    }
    
    //////////////////// docotr manager /////////////////////////
     public static DOCTOR get_doctor(int doctor_id)
    {
        return systemControl.doctors_list.get(doctor_id);
    }
    
    public static DOCTOR get_user_doctor(int doctor_id,String passowrd)
    {
        if (systemControl.doctors_list.get(doctor_id).is_owner(passowrd))
            return get_doctor(doctor_id);
        else return null;
    }
    
}
    

