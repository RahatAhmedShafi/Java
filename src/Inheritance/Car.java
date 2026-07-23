package Inheritance;

public class Car extends Vehicle {
    static void main(String[] args) {
        Car obj =new Car();
        obj.view();
        System.out.println(obj.brand);
    }
}
