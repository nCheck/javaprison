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
public class SemMarks
{
    double Sem1 , Sem2 , Sem3 , Sem4;
    SemMarks()  //Default Constructor
    {
        Sem1 = 0.0;
        Sem2 = 0.0;
        Sem3 = 0.0;
        Sem4 = 0.0;
    }
    void setMarks(int ch , double m)
    {
        switch(ch)
        {
            case 1:
                Sem1 = m;
                break;
            case 2:
                Sem2 = m;
                break;
            case 3:
                Sem3 = m;
                break;
            case 4:
                Sem4 = m;
                break;
        }
    }
    double getMarks(int ch )
         {
            switch(ch)
            {
                case 1:
                    return Sem1;
                case 2:
                    return Sem2;
                case 3:
                    return Sem3;
                case 4:
                    return Sem4;
                default:
                    return 0.0;
            }
        }
    String displayMarks()
    {
        return "Sem1: " + Sem1 + "\n" + "Sem2: " + Sem2 + "\n" + "Sem3: " + Sem3 + "\n" + "Sem4: " + Sem4;
    }
}
