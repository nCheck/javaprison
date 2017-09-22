/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameSam;

import project.*;
import java.util.ArrayList;

/**
 *
 * @author Nehal Kalnad
 */
public class Prison{
// HAS A TYPE OF RELATIONSHIP POLICE CONTAINS PRISON
    /*
      add prisoner,change guard,change prisoners service,give parole,remove 
    prioner
    */
    static int piD , giD;
    String type;
    ArrayList<Prisoner> inmates;
    ArrayList<Guards> guards;
    public Prison(int code)
    {
        piD = 1000 + code;
        giD = 100+ code;
        guards = new ArrayList<>();
        inmates = new ArrayList<>();
    }
    void addPrisoner(Prisoner p)
    {
        p.status="Active";
        p.job="None";
        p.uniqueiD = piD++;
        inmates.add(p);
    }
    void addGuard(Guards g)
    {
        g.guardCode = giD++;
        guards.add(g);
    }
    String displayPrisoner(){
        String ans = "Name:\tAge:\tGender:\tUniqueId:\tJob Assigned:\tStatus:\n";
        for(Prisoner p : inmates)
        {
            ans+=(p.name+"\t"+p.age+"\t"+p.gender+"\t"+p.uniqueiD+"\t"+p.job+"\t"+p.status+"\n");
        }
        return ans;
    }
    void displayGuard(){
        for (Guards p : guards) {
            System.out.println("Name: "+p.name+" Age: "+p.age+" Gender: "+p.gender+" Post: "+p.post+" Years of Experience:"+p.yearsOfExperience );
        }//
    }
    Prisoner getPrisoner(int ID)
    {
           int get = -1;
        for(Prisoner p : inmates)
        {
            if(p.uniqueiD == ID)
            {
                get = inmates.indexOf(p);
                break;
            }
        }
        if(get!=-1)
             return inmates.get(get);
        else
            return null;
    }
    int removePrisoner(int ID)
    {
        int rem = -1;
        for(Prisoner p : inmates)
        {
            if(p.uniqueiD == ID)
            {
                rem = inmates.indexOf(p);
                break;
            }
        }
        if(rem!=-1)
        {
            inmates.remove(rem);
            return 1;
        }
        else return 0;
        
    }
    void parole(Prisoner p,int id){
        Services s =new Services();
        if(s.checkAssign(p)){
            s.removeJob(s.assignment(p),id);
            p.status="Parole";
        }
        else
            p.status="Parole";
        }
}
