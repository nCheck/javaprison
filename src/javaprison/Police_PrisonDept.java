

import java.util.ArrayList;
import java.util.Scanner;

/*class Police_Dept{
    /*
      add prisoner,change guard,
}
*/
class Prison{
// HAS A TYPE OF RELATIONSHIP POLICE CONTAINS PRISON
    /*
      add prisoner,change guard,change prisoners service,give parole,remove 
    prioner
    */
    int piD , giD;
    String type;
    Prison(int code ,  String type)
    {
        piD = 1000 + code;
        giD = 100+ code;
        this.type = type;
    }
    ArrayList<Prisoner> inmates;
    ArrayList<Guards> guards;
    void addPrisoner(Prisoner p)
    {
        p.job="None";
        p.uniqueiD = piD++;
        inmates.add(p);
    }
    void addGuard(Guards g)
    {
        g.guardCode = giD++;
        guards.add(g);
    }
    void display(){
        
        for (Prisoner p : inmates) {
            System.out.println("Name: "+p.name+" Age: "+p.age+" Gender: "+p.gender+" UniqueId: "+p.uniqueiD+" Job Assigned: "+p.job);
        }
    }
    
    
}
class Services{
    int l;
    int b;
}
class Cells{
    // cell a for high level etc etc
    // cells have gaurds and prisoners
}
abstract class Person{
    // will contain for prisoners etc
    // name, age,gender
    String name;
    int age;
    String gender;
    Date birthday;
    Person(String name,int age,String gender){     
    this.name=name;
    this.age=age;
    this.gender=gender;
    birthday = new Date();
}
}
class Prisoner extends Person{
    // level of crime acc level to crime they will be assigned a cell
    // crime date of relaease
    // date of joining ,services assigned
    int uniqueiD;
    String job;
    public Prisoner(String name, int age, String gender)
    {
        super(name, age, gender);
    }
    // level of crime acc level to crime they will be assigned a cell
    // crime date of relaease
    // date of joining ,services assigned
    String getDetails(){
        return "Name: "+name+" Age: "+age+" Gender: "+gender+" UniqueId: "+uniqueiD+" Job Assigned: "+job;
    }

}
class Guards extends Person{
    // level of posting
    // experience in years
    String post;
    int yearsOfExperience;
    int guardCode;
    Scanner sc = new Scanner(System.in);
    public Guards(String name, int age, String gender)
    {
        super(name, age, gender);
        System.out.println("Enter Post & Current Experience");
        post = sc.next();
        yearsOfExperience = sc.nextInt();
    }
    // level of posting
    // experience in years
        
    
}
class Cooking extends Services
{
    
}
class Construction extends Services
{
    
}
class Carpentry extends Services
{
    
}
class Date
{
    int dd, mm , yy;
    Date() //Default Constructors
    {
        Scanner d = new Scanner(System.in);
        System.out.println("Enter day month year");
        dd = d.nextInt();
        mm = d.nextInt();
        yy = d.nextInt();
    }
    Date(int d , int m ,int y) //Parameterized Constructor
    {
        d = dd;
        m = mm;
        y = yy;
    }
    String getDate()
    {
        return dd+"-"+mm+"-"+yy;
    }
}
public class Police_PrisonDept {
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Mumbai Police Prison Department");
        Prison maleP = new Prison(0 , "Male");
        Prison femaleP = new Prison(500 , "Female");        
        Prisoner[] p = new Prisoner[10]; //Our Jail can hold 10 Prisoners
        Guards[] g = new Guards[5]; //Only 5 Guards
        int pC = 0 , gC = 0; 
        while(true){
            System.out.println("1.Prison Section 2.Guard Section 3.Services Section 4.Exit");//Three sections for 3 things so things dont become haazy
            int section=sc.nextInt();
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
                                maleP.addPrisoner(p[pC++]);
                             else
                                femaleP.addPrisoner(p[pC++]);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                              maleP.display();
                            break;
                        default:
                            break OUTER;
                    }
                            break;
                        }
                    case 2:
                        {
                            System.out.println("1.Assign Guard 2.Display 3.Exit");
                            int input=sc.nextInt();
                    switch (input)
                    {
                        case 1:
                            System.out.println("Enter Name , Age and Gender");
                            String name = sc.next();
                            int age = sc.nextInt();
                            String gender = sc.next();
                            g[gC] = new Guards(name , age , gender);
                            break;
                        case 2:
                            break;
                        default:
                            break OUTER;
                    }
                            break;
                        }
                    case 3:
                        {
                            System.out.println("1.Assign Prisoner Job 2.Check Jobs 3.Display 4.Exit");
                            int input=sc.nextInt();
                    switch (input)
                    {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
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
