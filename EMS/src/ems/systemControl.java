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
import java.util.Random;
public class systemControl {
    public static ArrayList <DOCTOR> doctors_list = new ArrayList<>();
    public static ArrayList <COURSE> courses_list = new ArrayList<>();
    public static ArrayList <TAS> TAS_list = new ArrayList<>();
    public static ArrayList <STUDENT> students_list = new ArrayList<>();
    private static Random rand = new Random();
    
    
    
    public static void run()
    {
        add_doctors_dummy_data();
        add_student_dummy_data();
        
        System.out.println("please make a choice\n1- Login/n2- Sign up\n3- shut down system");
        System.out.print("enter your choice: ");
        // take input 
    }
  
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
    
    private static void add_student_dummy_data()
    {
        String names[]={ "Ali", "Mostafa", "Hani", "Mohamed", "Ashraf", "Samy", "Morad", "Sayed", "Hussien" };
       
        for(int i=0;i<30;++i)
        {
            STUDENT student = new STUDENT();
            student.set_name(names[rand.nextInt(names.length)]);
            student.set_last_name(names[rand.nextInt(names.length)]);
            student.set_email(student.getName()+"@gmail.com");
            student.set_password("s"+student.get_id());
            student.register_in_course(rand.nextInt(10));
            
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
                if(course.get_course_number()==registerd_course)
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
    private static void add_doctors_dummy_data()
    {
        String names[]={ "Ali", "Mostafa", "Hani", "Mohamed", "Ashraf", "Samy", "Morad", "Sayed", "Hussien" };
        String course_name[]={"prog1","prog2","circits1","circuits2","opp","design patters","algorithms","data structure","computer organziation","advanced algorithms"};
        String course_code[]={"CS111","CS123","CS122","CS333","CS133","CS240","CS350","CS344","CE244","CS254"};
        for(int i=0,j=0;i<5;++i,j++)
        {
            DOCTOR doctor = new DOCTOR();
            doctor.createCourse(course_name[j], course_code[j]);
            j++;
            doctor.createCourse(course_name[j], course_code[j]);
            doctor.set_name(names[rand.nextInt(names.length)]);
            doctor.set_email(doctor.get_name()+"@gmail.com");
            doctor.set_password("d"+doctor.get_id());
        }
    }
    
}
    

