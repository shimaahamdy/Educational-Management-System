/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ems;

/**
 *
 * @author Leader
 */
public class DOCFLOW {
   private static DOCTOR current_doctor;
   private static COURSE current_course;
   private static ASSIGNMENT current_assignment;
   private static AssignmentSolution current_sol;
     
    public static boolean is_vaild_docotor(int id,String password)
    {
        return systemControl.get_user_doctor(id, password)!=null;
    }
    
    public static void docotor_in(int id,String password)
    {
       current_doctor = systemControl.get_user_doctor(id, password);
        System.out.println("welcome DR: "+current_doctor.get_name()+"you are in");
        
        show_main_menu();
    }
    
    private static void show_main_menu()
    {
       String arr[]={"List Courses", "Create course", "View Course", "Log out" };
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
    private static void create_course()
    {
        System.out.println("enter course name");
        // take input 
        String course_name="";
        int course_code=current_doctor.createCourse(course_name);
        System.out.println("course code id"+course_code);
    }
    private static void  list_courses()
    {
         System.out.println("courses list: ");
        int choice_number=0;
        for(COURSE course:current_doctor.get_courses_list())
        {
           System.out.print(choice_number+"- ");
           choice_number++;
           System.out.println(course.toString());
        }
    }
    public static void view_courses()
    {
          if(current_doctor.get_courses_num()==0)
            System.out.println("no courses you teach");
        else 
        {
        list_courses();
        System.out.print("what course to view: ");
        // take input
        int choice=0;
        current_course=systemControl.courses_list.get(choice);
        System.out.println(current_course.toString());
        System.out.println("course has "+current_course.get_assignment_num()+" assignments and ");
        System.out.println(current_course.get_student_num()+" registerd students");
        show_course_menu();
        }
         
    }
     private static void show_course_menu()
   {
       String arr[]= { "Add TAs", "List Assignments", "Create Assignment", "View Assignment", "Back" };
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
         int TAS_ID=0;
         if(current_course.addTAS(TAS_ID))System.out.println("adding successfuly");
         else System.out.print("problem has habbened");
         
     }
     private static void list_assignments()
     {
         System.out.print("list of course "+current_course.get_code()+" assignments: ");
         int choice_number=0;
         for(ASSIGNMENT assignment:current_course.get_assignment_list())
         {
             System.out.print(choice_number+"- ");
             choice_number++;
            System.out.print("assignment number: "+assignment.get_assignment_num());
            System.out.print("max grade: "+assignment.get_max_grade());
         }
     }
     private static void create_assignemtn()
     {
         // take assignment data
         String assignment_content="";
         int assignment_code=0;
         int max_grade=0;
         current_doctor.create_assignment(assignment_code, current_course.get_code(), assignment_content, max_grade);
         System.out.print("assignment has been added successfuly");
     }
     private static void view_assignemnt()
     {
         if(current_course.get_assignment_num()==0)
             System.out.println("no assignemtns has been added");
         else
         {
             list_assignments();
             System.out.print("which assignemtns to be viewd");
             // take input 
             int assignment_num=0;
             current_assignment=current_course.get_assignment(assignment_num);
             assignment_options();
         }
     }
     private static void assignment_options()
     {
         String arr[]= {"Show Info", "Show Grades Report", "List Solutions", "View Solution", "Back" };
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
         int choice=0;
         current_sol=current_assignment.get_assignment_solutions_list().get(choice);
         show_solution_list();
      }
     private static void show_solution_list()
     {
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
         int student_grade=0;
         current_sol.set_student_grade(student_grade);
     }
     private static void set_comment()
     {
         // take input
         String comment="";
         current_sol.set_comment(comment);
     }
     
    
                
}
