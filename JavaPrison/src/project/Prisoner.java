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
public class Prisoner extends Person{
    // level of crime acc level to crime they will be assigned a cell
    // crime date of relaease
    // date of joining ,services assigned
    int uniqueiD;
    String job;
    String status;
    public Prisoner(String name, int age, String gender)
    {
        super(name, age, gender);
    }

    Prisoner(String name, int age, String gender , Date defaul)
    {
        super(name, age, gender , defaul);
    }
    // level of crime acc level to crime they will be assigned a cell
    // crime date of relaease
    // date of joining ,services assigned
    public String getDetails(){
        return "Name: "+name+" Age: "+age+" Gender: "+gender+" UniqueId: "+uniqueiD+" Job Assigned: "+job;
    }

}
