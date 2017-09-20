/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;

/**
 *
 * @author Nehal Kalnad
 */
public class Guards extends Person{
    // level of posting
    // experience in years
    String post;
    int yearsOfExperience;
    int guardCode;
    Scanner sc = new Scanner(System.in).useDelimiter("\\n");
    public Guards(String name, int age, String gender)
    {
        super(name, age, gender);
        System.out.println("Enter Post & Current Experience");
        post = sc.next();
        yearsOfExperience = sc.nextInt();
    }
    // level of posting
    // experience in years
        
    
}