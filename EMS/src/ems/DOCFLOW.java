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
    
     private DOCTOR []doctorsList;
     
      public void login(int id,String password)
    {
        
             if(this.doctorsList[id].getPassword().equals(password))
               Mass(id);
             else wrongMass();
         }
      
       private void Mass(int id)
    {
        System.out.println("welcome Dr"+this.doctorsList[id].getName()+". you are logged in");
    }
       
         public void wrongMass()
    {
       System.out.print("wrong password");
    }
}
