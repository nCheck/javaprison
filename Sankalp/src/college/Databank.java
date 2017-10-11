/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college;

import java.util.ArrayList;

/**
 *
 * @author Nehal Kalnad
 */
public class Databank
{
    ArrayList<Student> s;
    Databank()
    {
        s = new ArrayList<>();
    }
    void AddStudent(Student stu)
    {
        s.add(stu);
    }
    void addMarks(int ch , double m , int rollno)
    {
        for(int i = 0 ; i < s.size() ; i++)
        {
            if(s.get(i).rollNo == rollno)
            {
                s.get(i).addMarks(ch, m);
                break;
            }
        }
    }
    int attend(int roll, int total, int attendance){
        int flag=-1;
        for(int i=0;i<s.size();i++){
            if(s.get(i).getRoll()==roll){
                flag=1;
               s.get(i).addAttendance(total, attendance);
             break;
            }
            return flag;
        }
        return flag;
    }
    String displayParticularCourseStudents(String course)
    {
        String ans = "";
        for(int i = 0 ; i < s.size() ; i++)
        {
            if(s.get(i).course.equals(course))
                ans+=s.get(i).name+"\n";
        }
        return ans;
    }
    String displaySemwise(int c){
        String t="";
        for(int i=0;i<s.size();i++)
            t+=s.get(i).name+"\t"+s.get(i).getMarks(c)+"\n";
        return t;
    }
    String displayDefaulter()
    {
        String ans = "";
        for(int i = 0 ; i < s.size() ; i++)
        {
            if(s.get(i).getAttendance() < 40)
                ans+=s.get(i).name+"\t"+s.get(i).getAttendance()+"\n";
        }
        return ans;
    }
}
