/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author Nehal Kalnad
 */
public class Services{
    int earnings;
    int numberOfJobs;
    ArrayList<Prisoner> Cooking;
    ArrayList<Prisoner> Construction;
    ArrayList<Prisoner> Carpentry;
    Services()
    {
        Cooking =new ArrayList<>();
        Construction =new ArrayList<>();
        Carpentry =new ArrayList<>();
    }
    void giveJob(Prisoner p , int ch)
    {
        switch(ch)
        {
            case 1:
                p.job = "Cook";
                Cooking.add(p);
                break;
            case 2:
                p.job = "Constructor";
                Construction.add(p);
                break;
            case 3:
                p.job = "Carpenter";
                Carpentry.add(p);
                break;
        }
    }
    boolean checkAssign(Prisoner p){
        
        return p.job.equals("None");
    }
    public String assignment(Prisoner p){
        return p.job;
    }
    void removeJob(String s,int id){
        switch (s) {
            case "Cooking":
                for (int i=0;i<Cooking.size();i++) {
                    if(Cooking.get(i).uniqueiD==id)
                        Cooking.remove(i);
                }   break;
            case "Construction":
                for (int i=0;i<Construction.size();i++) {
                    if(Construction.get(i).uniqueiD==id)
                        Construction.remove(i);
                }   break;
            case "Carpenter":
                for (int i=0;i<Carpentry.size();i++) {
                    if(Carpentry.get(i).uniqueiD==id)
                        Carpentry.remove(i);
                }   break;
            default:
                break;
        }
    }
    void displayJobs(int ch)
    {
        switch(ch)
        {
            case 1:
                Cooking.forEach((p) -> {
                    System.out.println(p.name + " Id Number: " + p.uniqueiD);
        });
                break;
            case 2:
                Construction.forEach((p) -> {
                    System.out.println(p.name + " Id Number: " + p.uniqueiD);
        });
                break;
            case 3:
                Carpentry.forEach((p) -> {
                    System.out.println(p.name + " Id Number: " + p.uniqueiD);
        });
                break;
        }
    }
}
