

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
}
class Services{
    int l;
    int b;
}
class Cells{
    // cell a for high level etc etc
    // cells have gaurds and prisoners
}
class Person{
    // will contain for prisoners etc
    // name, age,gender
    String name;
    int age;
    String gender;
    Person(String name,int age,String gender){     
    this.name=name;
    this.age=age;
    this.gender=gender;
}
}
class Prisoner extends Person{
    // level of crime acc level to crime they will be assigned a cell
    // crime date of relaease
    // date of joining ,services assigned

}
class Guards extends Person{
    // level of posting
    // experience in years
    
    
}
class Cooking extends Services{
    
}
class Construction extends Services{
    
}
class Carpentry extends Services{
    
}
public class Police_PrisonDept {
 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Mumbai Police Prison Department");
        while(true){
            System.out.println("1.Prison Section 2.Guard Section 3.Services Section 4.Exit");//Three sections for 3 things so things dont become haazy
            int section=sc.nextInt();
            while(true){
                if(section==1){
                    System.out.println("1.Add Prisoner 2.Remove Prisoner 3.Grant Parole 4.Display 5.Exit");
                    int input=sc.nextInt();
                    if(input==1){
                }
                    else if(input==2){
                        
                    }
                    else if(input==3){
                        
                    }
                    else if(input==4){
                        
                    }
                    else 
                        break;
                }
                else if(section==2){
                     System.out.println("1.Assign Guard 2.Display 3.Exit");
                   int input=sc.nextInt();
                    if(input==1){
                }
                    else if(input==2){
                        
                    }
                    else 
                        break; 
                }else if(section==3){
                     System.out.println("1.Assign Prisoner Job 2.Check Jobs 3.Display 4.Exit");
                     int input=sc.nextInt();
                    if(input==1){
                }
                    else if(input==2){
                        
                    }
                    else if(input==3){
                        
                    }
                    else 
                        break;
                    
                }
                else
                    break;
            }
        }
    }
 }