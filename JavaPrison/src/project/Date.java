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
public class Date
{
    int dd, mm , yy;
    Date() //Default Constructors
    {
        Scanner d = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Enter day month year");
        dd = d.nextInt();
        mm = d.nextInt();
        yy = d.nextInt();
    }
    Date(int d , int m ,int y) //Parameterized Constructor
    {
        d = dd;
        m = mm;
        y = yy;
    }
    public String getDate()
    {
        return dd+"-"+mm+"-"+yy;
    }
}