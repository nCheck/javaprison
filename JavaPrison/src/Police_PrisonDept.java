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
            System.out.println("Name: "+p.name+" Age: "+p.age+" Gender: "+p.gender+" UniqueId: "+p.uniqueiD+" Job Assigned: "+p.job);
        });
    }
    void displayGuard(){
        for (Guards p : guards) {
            System.out.println("Name: "+p.name+" Age: "+p.age+" Gender: "+p.gender+" Post: "+p.post+" Years of Experience:"+p.yearsOfExperience );
        }//
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
    
}
class Services{
    int earnings;
    int numberOfJobs;
    Services(int earnings,int numberOfJobs){
    this.earnings=earnings;
    this.numberOfJobs=numberOfJobs;
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
class Cooking extends Services
{   
    int numberOfJobs=4;
    int earnings=300;
    int id;
    
    Cooking(int id){
        super(earnings,numberOfJobs); 
    }
}
class Construction extends Services
{
    int numberOfJobs=3;
    int earnings=350;
    Construction(int id){
        super(earnings,numberOfJobs);
    }
}
class Carpentry extends Services
{
    int numberOfJobs=3;
    int earnings=450;
    int id;
    Carpentry(int id){
        super(earnings,numberOfJobs);
        
    }
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
        int pC = 3 , gC = 0;
        Date defaul = new Date(12 , 11 , 1998);
        p[0] = new Prisoner("Ashley" , 17 , "Female" , defaul);
        femaleP.addPrisoner(p[0]);
        p[1] = new Prisoner("Nehal" , 18 , "Male" , defaul);
        maleP.addPrisoner(p[1]);
        p[2] = new Prisoner("Karry" , 19 , "Female" , defaul);
        femaleP.addPrisoner(p[2]);
        
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
                        case 3:
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