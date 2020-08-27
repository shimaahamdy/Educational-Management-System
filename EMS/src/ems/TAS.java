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
public class TAS {
     private String name;
     private int ID;
     private String password;
     private String email;
     private int []courses_list; // realtion with courses
     private int courses_num;
    
    public String getPassword()
    {
        return this.password;
    }
    public int get_ID()
    {
        return this.ID;
    }
     public String getName()
    {
        return this.name;
    }
     
     public void add_course(int course_code)
     {
         this.courses_list[courses_num++]=course_code;
     }
    
}
