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
    public Student(String name, int age, String gender, Date bday , int rollNo,String course)
    {
        super(name, age, gender, bday);
        this.rollNo = rollNo;
        s = new SemMarks();
        a = new Attendance();
        course=this.course;
    }
    void addCourse(String course)
    {
        this.course = course;
    }
    void addMarks(int ch , double m)
    {
        s.setMarks(ch, m);
    }
    int getRoll(){
        return rollNo;
    }
    double getMarks(int ch)
    {
        return s.getMarks(ch);
    }
    String displayMarks()
    {
        return s.displayMarks();
    }
    String displayCourse(){
        return course;
    }
    String dispStudentData()
    {
           String t;
           t="NAME:"+name+"\t AGE:"+age+"\t GENDER:"+gender+"\t BIRTHDAY:"+birthday+"\t ROLL NUMBER:"+rollNo+"\t COURSE:"+course;
        return t; 
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
