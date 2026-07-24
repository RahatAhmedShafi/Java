package LabCT01;

public class Lab {
    int x=200;

}
class  Overloading{
   void add(int a, int b,int c){
        System.out.println(a+b+c);
    }
    void add(int a,int b){
        System.out.println(a+b);
    }
    void add(double a, double b){
        System.out.println(a+b);
    }

}

class Overriding{
    String name;
    int age;

    void Overriding(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }


}
class OverridingTest extends Overriding{
    int money;

    @Override
    void Overriding() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Money: " + money);
    }
}

                        // Abstract

 abstract class MobileUser{
    abstract void sendmessage();
}
class Rahim extends MobileUser{
    @Override
    void sendmessage() {
        System.out.println("Hi, I am Rahim");
    }
}

class Karim extends MobileUser{
    @Override
    void sendmessage() {
        System.out.println("Hi, I am Karim");
    }
}

//Write a Java program to create an abstract class Shape with abstract methods calculateArea()
// and calculatePerimeter(). Create subclasses Circle and Triangle that extend the Shape class and
// implement the respective methods to calculate the area and perimeter of each shape.

abstract class Shape{
    abstract void calculateArea();
    abstract void calculatePerimeter();
}
class Circle extends Shape{
    double radius;
    Circle(double radius){
        this.radius=radius;
    }
    @Override
    void calculatePerimeter() {
        double perimeter = 2 * Math.PI * radius;
        System.out.println("Circle Perimeter = " + perimeter);


    }

    @Override
    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Circle Area = " + area);
    }
}
class Triangle extends Shape{
    double side1,side2,side3;
    double base, height;
    Triangle(double side1,double side2,double side3,double base, double height){
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
        this.base=base;
        this.height=height;
    }
    @Override
    void calculatePerimeter() {
        double perimeter = side1 + side2 + side3;
        System.out.println("Triangle Perimeter = " + perimeter);

    }

    @Override
    void calculateArea() {
        double area = 0.5 * base * height;
        System.out.println("Triangle Area = " + area);

    }
}

                            // Interface
interface  Animal{

    void eat();

}
class cat implements Animal{
    @Override
    public void eat() {
        System.out.println("I eat Fish");
    }
}

class student{
    static void main(String[] args) {
        Lab obj= new Lab();
        Overloading obj1=new Overloading();
        OverridingTest obj2=new OverridingTest();
        Animal a;
        a=new cat();
        a.eat();

//        MobileUser mu;
//        mu= new Karim();
//        mu.sendmessage();
//        mu=new Rahim();
//        mu.sendmessage();
//        Shape s;
//        s=new Circle(7);
//        s.calculateArea();
//        s.calculatePerimeter();
//        s=new Triangle(3, 4, 5, 4, 3);
//        s.calculateArea();
//        s.calculatePerimeter();



        //obj2.name="Shafi";
//        obj2.age=25;
//        obj2.money=100;
//        obj2.Overriding();

//        System.out.println(obj.x);
//        obj1.add(4,5);
//        obj1.add(5.9,9.8);
    }
}


