/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

import java.util.ArrayList;

/**
 *
 * @author shimaa hamdy
 */
public class studentFlow {
    
    private static STUDENT current_student;
     
    public static boolean is_vaild_student(int id,String password)
    {
        return systemControl.get_user_student(id, password)!=null;
    }
    
    public static void student_in(int id,String password)
    {
       current_student = systemControl.get_user_student(id, password);
        System.out.println("welcome"+current_student.get_name()+"you are in");
        
        show_main_menu();
    }
    
    private static void show_main_menu()
    {
       String arr[]={"Register in Course", "List My Courses", "View Course", "Grades Report", "Log out" };
       int choice_number=0;
       for(String option:arr){
           System.out.print(choice_number);
            System.out.println("- "+option);
            choice_number++;
       }
        System.out.print("make choice: ");
        // take user input in choice
        int choice;
        outer:
        while(true)
        {
            switch(choice)
            {
                case 1:
                    register_in_course();
                    break;
                case 2:
                    list_my_courses();
                    break;
                case 3:
                    view course();
                    break;
                case 4:
                    grades_report();
                default:
                    break outer;
             }
        }
    }
    private static void register_in_course()
    {
         ArrayList <COURSE> courses_not_registerd;
        System.out.println("\n Available Courses for you: ");
        courses_not_registerd=systemControl.get_courses_not_registerd(current_student.get_courses_id_list());
        int course_num=0;
        for(COURSE course:courses_not_registerd)
        {
            System.out.print(course_num++);
            System.out.println(" "+course.toString());
        }
        System.out.print("enter course number to be registerd: ");
        // take input
        int choice;
        current_student.register_in_course(courses_not_registerd.get(choice).get_code());
        System.out.println("\nRegistered Successfully");
    }
    
    private static void list_my_courses()
    {
        System.out.println("my courses list: ");
        int choice_number=0;
        for(int course:current_student.get_courses_id_list())
        {
           System.out.print(choice_number+"- ");
           choice_number++;
           System.out.println(systemControl.courses_list.get(course).toString());
        }
    }
    private static void view_course()
    {
        if(current_student.get_courses_num()==0)
            System.out.println("not registerd in any course yet");
        else 
        {
        list_my_courses();
        System.out.print("what course to view: ");
        // take input
        int choice=0;
        COURSE current_course=systemControl.courses_list.get(choice);
        System.out.println(current_course.toString()+" taught by DR:"+current_course.get_doctor_name());
        System.out.print("course has "+current_course.get_assignment_num()+" assignments");
        for(ASSIGNMENT assignment:current_course.get_assignment_list())
        {
            System.out.print("Assignment "+assignment.get_assignment_num());
            AssignmentSolution sol = current_student.get_assignment_solution(assignment.get_assignment_num());
            if(sol!=null)
            {
                System.out.print(" submitted - ");
                if(sol.is_grade_set())
                    System.out.print(sol.get_student_grade()+" / "+sol.get_assignment().get_max_grade());
            }
        }
        }
    }
    
    
}
