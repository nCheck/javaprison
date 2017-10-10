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
public class Attendance
{
    int totalLec , attended;
    Attendance()
    {
        totalLec = 0;
        attended = 0;
    }
    void addAttendance(int totalLec , int attended)
    {
        this.totalLec+= totalLec;
        this.attended+= attended;
    }
    double getAttendance()
    {
        return (attended*100)/totalLec;
    }
}
