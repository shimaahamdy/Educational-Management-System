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
public class STUDFLOW {
    
    private STUDENT [] studentList;
  
     
      public void login(int id,String password)
    {
        
             if(this.studentList[id].getPassword().equals(password))
               Mass(id);
             else wrongMass();
         }
      
       private void Mass(int id)
    {
        System.out.println("welcome "+this.studentList[id].getName()+". you are logged in");
    }
       
         private void wrongMass()
    {
       System.out.print("wrong password");
    }
         
      private void firstMenu ()  
      {
          System.out.println("please make a choice : ");
          System.out.println("1 - Register in Course ");
          System.out.println("2 - list my Courses ");
          System.out.println("3 - view Course ");
          System.out.println("4 - grades report ");
          System.out.println("5 - log out");
          System.out.println("Enter Choice : ");
         
      }
         
    
}
