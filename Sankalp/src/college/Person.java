/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college;

/**
 *
 * @author Nehal Kalnad
 */
abstract public class Person{
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
//    birthday = new Date();
    }
    Person(String name,int age,String gender , Date bday)
    {     
    this.name=name;
    this.age=age;
    this.gender=gender;
    bday = birthday;
    }
}