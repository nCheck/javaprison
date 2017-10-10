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
    String displayDefaulter()
    {
        String ans = "";
        for(int i = 0 ; i < s.size() ; i++)
        {
            if(s.get(i).getAttendance() < 40)
                ans+=s.get(i).name+"\n";
        }
        return ans;
    }
}
