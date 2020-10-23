/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

import java.util.Scanner;

/**
 *
 * @author Leader
 */
public class DOCFLOW {
   private static DOCTOR current_doctor;                           // docotr who take control 
   private static COURSE current_course;                           // current course that being viewd
   private static ASSIGNMENT current_assignment;                   // current assignment that being viewd
   private static AssignmentSolution current_sol;                  // current assignment solution that being viewd
   private static Scanner scan= new Scanner(System.in); 
   /* check if doctor exist in system or not */
    public static boolean is_vaild_docotor(int id,String password)
    {
        return systemControl.get_user_doctor(id, password)!=null;
    }
    /* get doctor send requist and let him take control */
    public static void docotor_in(int id,String password)
    {
       current_doctor = systemControl.get_user_doctor(id, password);
        System.out.println("welcome DR: "+current_doctor.get_name()+"you are in");
        
        show_main_menu();  
    }
     
     
    /* show main menu for doctor */
    private static void show_main_menu()
    {
        /* output view */
       String arr[]={"List Courses", "Create course", "View Course", "Log out" };
       int choice_number=0;
       for(String option:arr){
           System.out.print(choice_number);
            System.out.println("- "+option);
            choice_number++;
       }
        System.out.print("make choice: ");
        // take user input in choice
        int choice=scan.nextInt();
        
        /* check his choice and move to what he ask to */
        outer:
        while(true)
        {
            switch(choice)
            {
                case 1:
                    list_courses();
                    break;
                case 2:
                    create_course();
                    break;
                case 3:
                    view_courses();
                    break;
                default:
                    break outer;
             }
        }
    }
    /* create course */
    private static void create_course()
    {
        System.out.println("enter course name");
        // take input 
        String course_name=scan.next();
        System.out.println("enter course code");
        String course_code=scan.next();
        current_doctor.createCourse(course_name,course_code); // call create course function on doctor 
    }
    /* list courses */
    private static void  list_courses()
    {
        // view courses 
         System.out.println("courses list: ");
        int choice_number=0;
        // loop on each course in doctor courses list
        for(COURSE course:current_doctor.get_courses_list())
        {
           System.out.print(choice_number+"- ");
           choice_number++;
           System.out.println(course.toString()); // print course data
        }
    }
    /* view courses and modify on it */
    public static void view_courses()
    {
        // check if doctor have courses first or not
          if(current_doctor.get_courses_num()==0)
            System.out.println("no courses you teach");
        else 
        {
        list_courses();         // call list courses
        System.out.print("what course to view: ");
        // take input
        int choice=scan.nextInt();
        current_course=systemControl.courses_list.get(choice); // make choisen course be the current one and take control
        // view the chosen course
        System.out.println(current_course.toString());
        System.out.println("course has "+current_course.get_assignment_num()+" assignments and ");
        System.out.println(current_course.get_student_num()+" registerd students");
        show_course_menu();  // call course options
        }
         
    }
    /* show course menu */
     private static void show_course_menu()
   {
       // view options 
       String arr[]= { "Add TAs", "List Assignments", "Create Assignment", "View Assignment", "Back" };
       int choice_number=0;
       for(String option:arr){
           System.out.print(choice_number);
            System.out.println("- "+option);
            choice_number++;
       }
        System.out.print("make choice: ");
        // take user input in choice
        int choice=scan.nextInt();
        // check choice and move to it 
        outer:
        while(true)
        {
            switch(choice)
            {
                case 1:
                    add_TAS();
                    break;
                case 2:
                    list_assignments();
                    break;
                case 3:
                    create_assignemtn();
                    break;
                case 4:
                    view_assignemnt();
                    break;
                default:
                    break outer;
             }
        }
   }
     
     private static void add_TAS()
     {
         System.out.println("enter the id of techinical assistant teacher: ");
         // take input
         int TAS_ID=scan.nextInt();
         if(current_course.addTAS(TAS_ID))System.out.println("adding successfuly"); 
         else System.out.print("problem has habbened");
         
     }
     /* list assignments */
     private static void list_assignments()
     {
         System.out.print("list of course "+current_course.get_course_number()+" assignments: ");
         int choice_number=0;
         // loop in assignments list belong to current course and view assignemts 
         for(ASSIGNMENT assignment:current_course.get_assignment_list())
         {
             // view assigment data
            System.out.print(choice_number+"- ");
            choice_number++;
            System.out.print("assignment number: "+assignment.get_assignment_num());
            System.out.print("max grade: "+assignment.get_max_grade());
         }
     }
     /* create assigment */
     private static void create_assignemtn()
     {
         // take assignment data
         System.out.println("enter assignemtn content");
         String assignment_content=scan.next();
         System.out.println("enter assignemnt code");
         int assignment_code=scan.nextInt();
         System.out.println("enter max grade");
         int max_grade=scan.nextInt();
         // call create assignment 
         current_doctor.create_assignment(assignment_code, current_course.get_course_number(), assignment_content, max_grade);
         System.out.print("assignment has been added successfuly");
     }
     /* view assignment */ 
     private static void view_assignemnt()
     {
         // check number of assigments before viewd
         if(current_course.get_assignment_num()==0)
             System.out.println("no assignemtns has been added");
         else
         {
             list_assignments();  // view all assignemnts
             System.out.print("which assignemtns to be viewd");
             // take input 
             int assignment_num=scan.nextInt();
             current_assignment=current_course.get_assignment(assignment_num); // give control to chosen assigment
             assignment_options();
         }
     }
     /* assignments menue */
     private static void assignment_options()
     {
         // view assignment options
       String arr[]= {"Show Info", "Show Grades Report", "List Solutions", "View Solution", "Back" };
       int choice_number=0;
       for(String option:arr){
           System.out.print(choice_number);
            System.out.println("- "+option);
            choice_number++;
       }
        System.out.print("make choice: ");
        // take user input in choice
        int choice=scan.nextInt();
        
        outer:
        while(true)
        {
            switch(choice)
            {
                case 1:
                    show_assignment_info();
                    break;
                case 2:
                    show_grades_report();
                    break;
                case 3:
                    list_solutions();
                    break;
                case 4:
                    view_solution();
                    break;
                default:
                    break outer;
             }
        }
   }
     
     private static void show_assignment_info()
     {
         System.out.print(current_assignment.toString());
     }
     
     private static void show_grades_report()
     {
         System.out.print("assignment degree: ");
         System.out.println(current_assignment.get_max_grade());
         System.out.println("total number of students: "+current_course.get_student_num());
         System.out.println("number of solutions submitted: "+current_assignment.get_assignment_solutions_list().size());
         list_solutions();
         
     }
     private static void list_solutions()
     {
         int option=0;
         // loop in assigments solutions and view students grades
         for(AssignmentSolution sol:current_assignment.get_assignment_solutions_list())
         {
             System.out.print(option);
             System.out.print(")student name: "+sol.get_student_name());
             System.out.println("grade: "+sol.get_student_grade());
         }
     }
     private static void view_solution()
     {
         list_solutions();
         System.out.print("enter solution number to be show");
         // take input
         int choice=scan.nextInt();
         current_sol=current_assignment.get_assignment_solutions_list().get(choice); // give conrtol to solutions chosen to be viewd
         show_solution_list();
      }
     private static void show_solution_list()
     {
         // view options
         String arr[]= {"Show Info", "Set Grade", "set a comment","Back" };
       int choice_number=0;
       for(String option:arr){
           System.out.print(choice_number);
            System.out.println("- "+option);
            choice_number++;
       }
        System.out.print("make choice: ");
        // take user input in choice
        int choice=0;
        outer:
        while(true)
        {
            switch(choice)
            {
                case 1:
                    show_solution_information();
                    break;
                case 2:
                    set_grade();
                    break;
                case 3:
                    set_comment();
                    break;
                
                default:
                    break outer;
             }
        }
    
     }
     
     private static void show_solution_information()
     {
         System.out.print(current_sol);
     }
     private static void set_grade()
     {
         // take input
         int student_grade=scan.nextInt();
         current_sol.set_student_grade(student_grade);
     }
     private static void set_comment()
     {
         // take input
         String comment=scan.next();
         current_sol.set_comment(comment);
     }
     
    
                
}
