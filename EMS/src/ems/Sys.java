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
public class Sys {
    
    private DOCFLOW doctor;
    private int doctorNum;
    private int studentNum;
    private int TASNum;
    
    
    public static void login(int id,String password)
    {
         if(id<=doctorNum && id>0)
         {
             doctor.login(id, password);
         }
         else if(id<=studentNum && id>0)
         { 
            
         }
         else if(id<=TASNum && id>0)
         {
             if(this.TASList[id].getPassword().equals(password))
                 TASListMass(id);
             else wrongPassMass();
         }
         else System.out.print("un vaild ID,try again");
    }
    
    public void wrongPassMass()
    {
       System.out.print("wrong password");
    }
    
    public void doctorListMass(int id)
    {
        System.out.println("welcome Dr"+this.doctorsList[id].getName()+". you are logged in");
    }
     public void studentListMass(int id)
    {
        System.out.println("welcome "+this.studentsList[id].getName()+". you are logged in");
        
    }
      public void TASListMass(int id)
    {
        System.out.println("welcome "+this.TASList[id].getName()+". you are logged in");
    }
      
    public void makeChoice(int choice)
    {
        
    }
   
    
    
    
    
}
