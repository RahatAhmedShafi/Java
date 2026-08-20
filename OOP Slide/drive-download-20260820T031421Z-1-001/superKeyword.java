
class Animal {
    int age = -10, height, weight;
    Animal(){}
    Animal(int age, int height, int weight){
        super();
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    void printDetails(){
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("weight: " + weight);
    }
    void makeSound(){
        System.out.println("Random unknown noise");
    }
}

class Dog extends Animal{
    Boolean isVaccinated;
    Dog(int age, int height, int weight, Boolean isVaccinated){
//        super(); // Animal()
//        this.age = age;
//        this.weight = weight;
//        this.height = height;
        super(age, height, weight);
        this.isVaccinated = isVaccinated;
    }
    void printDetails(){
        super.printDetails();
//        System.out.println("Age: " + age);
//        System.out.println("Height: " + height);
//        System.out.println("weight: " + weight);
        System.out.println("Is vaccinated: " + isVaccinated);
    }
    void makeSound(){
        System.out.println("Dog barks");
    }
    public String toString(){
        return "The dogs age is " + age;
    }
}

 class Puppy extends Dog{
    Puppy(int age, int height, int weight, boolean isVaccinated){
        super(age, height, weight, isVaccinated);
    }
 }

class Cat extends Animal{
    Cat(int age, int height, int weight){
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    void makeSound(){
        System.out.println("Cat meows");
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        Dog d = new Dog(2, 10, 20, true);
//        System.out.println(d.age);
//        d.printDetails();
        Dog d2 = new Dog(2, 10, 20, true);
        Animal a = new Animal();
        Dog d3 = d;
        System.out.println(d);
        System.out.println(d3.hashCode());
        System.out.println(d.hashCode()  + " ===== " + d2.hashCode());
        System.out.println(d.toString() + " ===== " + d2.toString());
        System.out.println(d.equals(d3) + " ===== " + (d == d3));

    }

}
