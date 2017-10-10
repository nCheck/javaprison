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
public class Student extends Person
{
    int rollNo;
    String course;
    SemMarks s;
    Attendance a;
    public Student(String name, int age, String gender, Date bday , int rollNo)
    {
        super(name, age, gender, bday);
        this.rollNo = rollNo;
        s = new SemMarks();
        a = new Attendance();
    }
    void addCourse(String course)
    {
        this.course = course;
    }
    void addMarks(int ch , double m)
    {
        s.setMarks(ch, m);
    }
    double getMarks(int ch)
    {
        return s.getMarks(ch);
    }
    String displayMarks()
    {
        return s.displayMarks();
    }
    String dispStudentData()
    {
        return name + "\t" + age + "\t" + rollNo + "\t" + course; 
    }
    void addAttendance(int t , int ad)
    {
        a.addAttendance(t, ad);
    }
    double getAttendance()
    {
        return a.getAttendance();
    }
}
