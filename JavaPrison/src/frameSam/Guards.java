/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameSam;

import project.*;
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
    int year;
    Scanner sc = new Scanner(System.in).useDelimiter("\\n");
    public Guards(String name, int age, String gender , int year , Date bday)
    {
        super(name, age, gender , bday);
        this.year = year;
        
    }
    // level of posting
    // experience in years
        
    
}