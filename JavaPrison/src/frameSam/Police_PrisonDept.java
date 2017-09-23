/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameSam;

import project.*;
import java.util.Scanner;

/**
 *
 * @author Nehal Kalnad
 */
public class Police_PrisonDept {
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Welcome to Mumbai Police Prison Department");
        Prison maleP = new Prison(0 );//Male Prisoners
        Prison femaleP = new Prison(500 ); //Female Prisoners      
        Prison guard =new Prison(11);//Guard
        Prisoner[] p = new Prisoner[10]; //Our Jail can hold 10 Prisoners
        Guards g ; //Only 5 Guards
        Services s = new Services();
        int pC = 5 , gC = 0;
        Prisoner temp;
        int tempC;
        Date defaul = new Date(12 , 11 , 1998);
        p[0] = new Prisoner("Ashley" , 17 , "Male" , defaul);
        maleP.addPrisoner(p[0]);
        p[1] = new Prisoner("Nehal" , 18 , "Male" , defaul);
        femaleP.addPrisoner(p[1]);
        p[2] = new Prisoner("Karry" , 19 , "Male" , defaul);
        maleP.addPrisoner(p[2]);
        p[3] = new Prisoner("Sheena" , 28 , "Female" , defaul);
        p[4] = new Prisoner("Maya" , 31 , "Female" , defaul);
        while(true){
            System.out.println("1.Prison Section 2.Guard Section 3.Services Section 4.Exit");//Three sections for 3 things so things dont become haazy
            int section=sc.nextInt();
            if(section == 4)
                break;
            OUTER:
            while (true) {
                switch (section) {
                    case 1:
                        {
                            System.out.println("1.Add Prisoner 2.Remove Prisoner 3.Grant Parole 4.Display 5.Exit");
                            int input=sc.nextInt();
                    switch (input)
                    {
                        case 1:
                            System.out.println("Enter Name , Age and Gender");
                            String name = sc.next();
                            int age = sc.nextInt();
                            String gender = sc.next();
                            p[pC] = new Prisoner(name , age , gender);
                            if(gender.equals("Male"))
                                maleP.addPrisoner(p[pC]);
                             else
                                femaleP.addPrisoner(p[pC]);
                            pC++;
                            break;
                        case 2:
                            System.out.println("Male or Female?");
                            String res = sc.next();
                            System.out.println("Enter Prisoner Unique ID number");
                            int idOut = sc.nextInt();
                            switch(res)
                            {
                                case "Male":
                                    maleP.removePrisoner(idOut);
                                    break;
                                default:
                                    femaleP.removePrisoner(idOut);
                            }
                            break;
                        case 3:System.out.println("Enter Prisoner Unique ID");
                            int id = sc.nextInt();
                            if(id < 1500)
                            {
                                 temp = maleP.getPrisoner(id);
                                 maleP.parole(temp, id);
                            }
                            else
                               {
                                  temp = femaleP.getPrisoner(id);
                                  femaleP.parole(temp, id);
                               }
                            break;
                        case 4:
                            System.out.println("Male Prison");
                             maleP.displayPrisoner();
                            System.out.println("Female Prison");
                            femaleP.displayPrisoner();
                            break;
                        default:
                            break OUTER;
                    }
                            break;
                        }
                    case 2:
                        {
                            System.out.println("1.Add Guard 2.Display 3.Exit");
                            int input=sc.nextInt();
                    switch (input)
                    {
                        case 1:
                            System.out.println("Enter Name , Age and Gender");
                            String name = sc.next();
                            int age = sc.nextInt();
                            String gender = sc.next();
                            int year=sc.nextInt();
                            Date d = new Date(0 , 0 , 0);
                            g = new Guards(name , age , gender , year , d);
                            guard.addGuard(g);
                                    break;
                        case 2:
                            System.out.println("Guards are");
                             guard.displayGuard();
                            break;
                        default:
                            break OUTER;
                    }
                            break;
                        }
                    case 3:
                        {
                            System.out.println("1.Assign Prisoner Job 2.Display Workers 3.Exit");
                            int input=sc.nextInt();
                    switch (input)
                    {
                        case 1:
                            System.out.println("Enter Prisoner Unique ID");
                            int id = sc.nextInt();
                            if(id < 1500)
                               temp = maleP.getPrisoner(id);
                            else
                                temp = femaleP.getPrisoner(id);
                            System.out.println("Select Job");
                            System.out.println("1:Cooking 2:Construction 3:Carpentry");
                            tempC = sc.nextInt();
                            s.giveJob(temp,tempC);
                            break;
                        case 2:
                            System.out.println("1:Cooking 2:Construction 3:Carpentry");
                            tempC = sc.nextInt();
                            s.displayJobs(tempC);
                            break;
                        default:
                            break OUTER;
                    }
                            break;
                        }
                    default:
                        break OUTER; 
                }
            }
        }
    }
 }