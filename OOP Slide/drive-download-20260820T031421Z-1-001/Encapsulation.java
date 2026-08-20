import org.w3c.dom.css.Rect;

class Animal{
    private int age, weight, height;
    void makeSound(){
        System.out.println("Random noise");
    }
    Animal(){
        System.out.println("hello");
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}

class Rectangle{
    private double length = 1, width = 1, area;
    Rectangle(){
        area = length * width;
    }
    public void setLength(double length){
        this.length = length;
        area = length * width;
    }
    public double getLength(){
        return length;
    }
}

class Student{
    private double []gpa;
    Student(){
        gpa = new double[12];
    }
    public void setGpa(double []gpa){
        this.gpa = new double[gpa.length];
        for(int i = 0 ; i < gpa.length ; i++){
            this.gpa[i] = gpa[i];
        }
    }
    public double[] getGpa(){
        double[] clone = new double[gpa.length];
        for(int i = 0 ; i < gpa.length ; i++){
            clone[i] = gpa[i];
        }
        return clone;
    }

}

public class Main {

    public static void main(String[] args) {
        Student s = new Student();
        double arr[] = new double[12];
        arr[0] = 4.0;
        s.setGpa(arr);
        arr[0] = 9.9;
        double obtained[] = s.getGpa();
        System.out.println(obtained[0]);

//        Animal a = new Animal();
//        //a.age = 10;
//        a.setAge(10);
//        System.out.println(a.getAge());
//        Rectangle r = new Rectangle();
////        r.length = 100;
//        r.setLength(100);
    }
}