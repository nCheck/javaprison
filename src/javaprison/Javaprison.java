/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprison;

/**
 *
 * @author Nehal Kalnad
 */

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
            System.out.println("1.Add Prisoner 2.ChangeGuard 3.ChangePrisoners Service 4. Give Parole 5.Remove Prisoner 6.Exit");
            
            
            
        }
        
    }
    
}
