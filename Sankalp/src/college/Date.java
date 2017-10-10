/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college;

/**
 *
 * @author Nehal Kalnad
 */
public class Date
{
    int dd, mm , yy;
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
