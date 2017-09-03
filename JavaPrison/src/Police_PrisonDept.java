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
    static int piD , giD;
    String type;
    ArrayList<Prisoner> inmates;
    ArrayList<Guards> guards;
    Prison(int code)
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
        System.out.println("Sucefully Added with Unique ID number: " + p.uniqueiD);
        inmates.add(p);
    }
    void addGuard(Guards g)
    {
        g.guardCode = giD++;
        System.out.println("Sucefully Added with GuardCode number: " + g.guardCode);
        guards.add(g);
    }
    void displayPrisoner(){
        
        inmates.forEach((p) -> {
            System.out.println("Name: "+p.name+" Age: "+p.age+" Gender: "+p.gender+" UniqueId: "+p.uniqueiD+" Job Assigned: "+p.job+" Status:"+p.status);
        });
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
    void removePrisoner(int ID)
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
            inmates.remove(rem);
        else
            System.out.println("Wrong Index");
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

class Services{
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
    String assignment(Prisoner p){
        return p.job;
    }
    void removeJob(String s,int id){
        if(s.equals("Cooking")){
            for (int i=0;i<Cooking.size();i++) {
                if(Cooking.get(i).uniqueiD==id)
                    Cooking.remove(i);
            }
        }
        else if(s.equals("Construction")){
             for (int i=0;i<Construction.size();i++) {
                if(Construction.get(i).uniqueiD==id)
                    Construction.remove(i);
            }
        }
        else if(s.equals("Carpenter")){
             for (int i=0;i<Carpentry.size();i++) {
                if(Carpentry.get(i).uniqueiD==id)
                    Carpentry.remove(i);
            }
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
    Person(String name,int age,String gender)
    {     
    this.name=name;
    this.age=age;
    this.gender=gender;
    birthday = new Date();
    }
    Person(String name,int age,String gender , Date bday)
    {     
    this.name=name;
    this.age=age;
    this.gender=gender;
    bday = birthday;
    }
}
class Prisoner extends Person{
    // level of crime acc level to crime they will be assigned a cell
    // crime date of relaease
    // date of joining ,services assigned
    int uniqueiD;
    String job;
    String status;
    public Prisoner(String name, int age, String gender)
    {
        super(name, age, gender);
    }

    Prisoner(String name, int age, String gender , Date defaul)
    {
        super(name, age, gender , defaul);
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
    Scanner sc = new Scanner(System.in).useDelimiter("\\n");
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

class Date
{
    int dd, mm , yy;
    Date() //Default Constructors
    {
        Scanner d = new Scanner(System.in).useDelimiter("\\n");
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
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Welcome to Mumbai Police Prison Department");
        Prison maleP = new Prison(0 );//Male Prisoners
        Prison femaleP = new Prison(500 ); //Female Prisoners      
        Prison guard =new Prison(11);//Guard
        Prisoner[] p = new Prisoner[10]; //Our Jail can hold 10 Prisoners
        Guards[] g = new Guards[5]; //Only 5 Guards
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
                            g[gC] = new Guards(name , age , gender);
                            guard.addGuard(g[gC]);
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